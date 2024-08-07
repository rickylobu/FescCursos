/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.Practicas;

import controlador.pruebaServletDao;
import dao.DaoPractica;
import dao.DaoPracticaImpl;
import dominio.Practica;
import dominio.Recurso;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo
 */
public class ActualizarPractica extends HttpServlet {

    private DaoPractica dao = new DaoPracticaImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("accion");
        int idPractica = Integer.parseInt(request.getParameter("idPractica"));

        switch (action) {
            case "Guardar":
                GuardarPractica(request, response);
                break;

            default:
                try {
                Practica pracTemp = dao.BusPracticaXId(idPractica);
                request.setAttribute("practicaEditar", pracTemp);
                List<Recurso> listaRecursos = dao.BusRecursosXIdPractica(idPractica);
                request.setAttribute("recursos", listaRecursos);
                RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("editarPractica.jsp");
                miRequestDispatcher.forward(request, response);

            } catch (Exception ex) {
                Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        }
    }

    private void GuardarPractica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sesion = request.getSession();
        int idPractica = Integer.parseInt(request.getParameter("idPractica"));
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        if (sesion.getAttribute("tipo") == "profesor") {
            try {
                String nombre = request.getParameter("nombrePractica");
                String descripcion = request.getParameter("descripcion");
                String urlVideo = request.getParameter("urlVideo");

                int numeroPrac = Integer.parseInt(request.getParameter("numeroPrac"));

                Practica PracticaActualizada = new Practica(idPractica, idCurso, numeroPrac, nombre, descripcion, urlVideo);
                dao.Modificar(PracticaActualizada);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String respuesta = "Usted no es profesor, No puede agregar una práctica. sorry!...";
            request.setAttribute("resp", respuesta);

        }
        try {
            Practica pracTemp = dao.BusPracticaXId(idPractica);
            request.setAttribute("practicaEditar", pracTemp);
            List<Recurso> listaRecursos = dao.BusRecursosXIdPractica(idPractica);
            request.setAttribute("recursos", listaRecursos);
            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("editarPractica.jsp");
            miRequestDispatcher.forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
