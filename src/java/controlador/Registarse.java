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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo
 */
public class Registarse extends HttpServlet {

    private DaoUsuario dao = new DaoUsuarioImpl();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("accion");

        switch (action) {
            case "Registrarse":

                String correo = request.getParameter("correo");
                String nombre = request.getParameter("nombre");
                String apellidos = request.getParameter("apellidos");

                LocalDate fecha_Nac = LocalDate.parse(request.getParameter("fecha"));
                java.sql.Date fechaSql = java.sql.Date.valueOf(fecha_Nac);

                String cont = request.getParameter("contra");
                String encContraseña = "";
                try {
                    encContraseña = dao.GetMD5(cont);
                    Usuario usr = new Usuario(0, correo, encContraseña, nombre, apellidos, fechaSql, true, false, false);
                    try {
                        dao.Registrar(usr);
                        System.out.println("usuario agregado con exito ");
                        response.sendRedirect("index.jsp");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Usuario no agregado ");
                    }
                } catch (Exception e) {
                    System.out.println("no se pudo encriptar la contraseña");
                }

                break;

            default:
                response.sendRedirect("index.jsp");

                break;
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
    } // </editor-fold>

}
