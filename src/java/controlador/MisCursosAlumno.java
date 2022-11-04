/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dominio.Curso;
import dominio.MisCursos;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
public class MisCursosAlumno extends HttpServlet {

    private DaoCurso dao = new DaoCursoImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        Usuario prof = (Usuario) sesion.getAttribute("user");
        int idAlumno = prof.getId_Usuario();
        try {
            List<MisCursos> misCursos = dao.MisCursos(idAlumno);
            if (misCursos == null) {
                List<Curso> lista = new ArrayList();
                request.setAttribute("lista", lista);
                RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("cursosAlumno.jsp");
                miRequestDispatcher.forward(request, response);
            } else {
                List<Curso> lista = dao.BusCursosXMisCursos(misCursos);
                request.setAttribute("lista", lista);
                RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("cursosAlumno.jsp");
                miRequestDispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
