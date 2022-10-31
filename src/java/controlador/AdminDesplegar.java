/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoUsuario;
import dao.DaoUsuarioImpl;
import dominio.Usuario;
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
public class AdminDesplegar extends HttpServlet {

    private DaoUsuario dao = new DaoUsuarioImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Usuario> lista1 = dao.ListarAlumnos();
            request.setAttribute("alumnos", lista1);
            List<Usuario> lista2 = dao.ListarProfesores();
            request.setAttribute("profesores", lista2);
            List<Usuario> lista3 = dao.ListarAdministradores();
            request.setAttribute("admins", lista3);

            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("admin.jsp");
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
