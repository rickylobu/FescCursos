/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dao.DaoPractica;
import dao.DaoPracticaImpl;
import dominio.Curso;
import dominio.Practica;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
public class EliminarPractica extends HttpServlet {

    private DaoPractica dao = new DaoPracticaImpl();
    private DaoCurso daoC = new DaoCursoImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Practica prac = dao.BusPracticaXId(id);
            int idCurso = prac.getId_Curso();
            dao.Eliminar(prac);

            Curso curTemp = daoC.BusCursoXId(idCurso);
            request.setAttribute("curEdit", curTemp);
            List<String> cats = daoC.Categorias();
            request.setAttribute("categorias", cats);
            List<Practica> listaPracticas = dao.ListarPracticasXidCurso(idCurso);
            request.setAttribute("practicas", listaPracticas);
            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("editarCurso.jsp");
            miRequestDispatcher.forward(request, response);

        } catch (Exception ex) {
            Logger.getLogger(EliminarPractica.class.getName()).log(Level.SEVERE, null, ex);
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
