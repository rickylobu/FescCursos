/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
public class MisCursosAgregar extends HttpServlet {

    private DaoCurso dao = new DaoCursoImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        int idCurso = Integer.parseInt(request.getParameter("id"));

        String respuesta = "";
        if (sesion.getAttribute("log") != null) {
            if (sesion.getAttribute("tipo") == "alumno") {
                Usuario alumno = (Usuario) sesion.getAttribute("user");
                int idAlumno = alumno.getId_Usuario();
                try {
                    boolean existe = dao.ExisteMisCursos(idAlumno, idCurso);
                    if (existe == true) {
                        respuesta = "ya tienes agregado este curso a Mis Cursos";
                        request.setAttribute("resp", respuesta);
                        RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("VerCurso?id=" + idCurso);
                        miRequestDispatcher.forward(request, response);
                    } else {
                        dao.AgregarMisCursos(idAlumno, idCurso);
                        respuesta = "Curso agregado con exito a Mis Cursos";
                        request.setAttribute("resp2", respuesta);
                        RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("VerCurso?id=" + idCurso);
                        miRequestDispatcher.forward(request, response);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (sesion.getAttribute("tipo") == "profesor") {
                respuesta = "como profesor no puede agregar cursos, necesita una cuenta de alumno";
                request.setAttribute("resp", respuesta);
                RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("VerCurso?id=" + idCurso);
                miRequestDispatcher.forward(request, response);
            }
            if (sesion.getAttribute("tipo") == "admin") {
                respuesta = "como administrador no puede agregar cursos, necesita una cuenta de alumno";
                request.setAttribute("resp", respuesta);
                RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("VerCurso?id=" + idCurso);
                miRequestDispatcher.forward(request, response);
            }

        } else {
            respuesta = "No ha iniciado sesión";
            request.setAttribute("resp", respuesta);
            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("VerCurso?id=" + idCurso);
            miRequestDispatcher.forward(request, response);
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
