/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.Cursos;

import controlador.pruebaServletDao;
import dao.DaoCurso;
import dao.DaoCursoImpl;
import dominio.Curso;
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
public class EliminarMisCursos extends HttpServlet {

    private DaoCurso dao = new DaoCursoImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idCurso = Integer.parseInt(request.getParameter("id"));

        try {
            HttpSession sesion = request.getSession();
            Usuario prof = (Usuario) sesion.getAttribute("user");
            int idAlumno = prof.getId_Usuario();
            dao.EliminarMisCursos(idAlumno, idCurso);
            
            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("MisCursosAlumno");
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
