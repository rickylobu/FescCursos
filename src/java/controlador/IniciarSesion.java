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
public class IniciarSesion extends HttpServlet {

    private DaoUsuario dao = new DaoUsuarioImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("accion");

        switch (action) {
            case "IniciarSesion":

                String correo = request.getParameter("correo");
                String cont = request.getParameter("contra");
                String encContra = "";
                HttpSession sesion = request.getSession();
                try {
                    encContra = dao.GetMD5(cont);

                    try {
                        Usuario usr = dao.BusUsuarioXCorreo(correo);
                        System.out.println("usuario encontrado con exito ");
                        if (encContra.equals(usr.getContraseña())) {
                            Usuario usuario = new Usuario(usr.getId_Usuario(), usr.getCorreo(), usr.getNombre(), usr.getApellidos(), usr.getFecha_Nac(), usr.isAlumno(), usr.isProfesor(), usr.isAdmin());
                            sesion.setAttribute("log", "1");
                            sesion.setAttribute("user", usuario);
                            if (usuario.isAlumno()) {
                                sesion.setAttribute("tipo", "alumno");
                            }
                            if (usuario.isProfesor()) {
                                sesion.setAttribute("tipo", "profesor");
                            }
                            if (usuario.isAdmin()) {
                                sesion.setAttribute("tipo", "admin");
                            }
                            String respuesta = "Bienvenido " + usuario.getNombre();
                            request.setAttribute("resp", respuesta);
                            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("index.jsp");
                            miRequestDispatcher.forward(request, response);
                        } else {
                            String respuesta = "contraseña incorrecta";
                            request.setAttribute("resp", respuesta);
                            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("iniciarSesion.jsp");
                            miRequestDispatcher.forward(request, response);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Usuario no encontrado");
                        String respuesta = "Usuario no encontrado";
                        request.setAttribute("resp", respuesta);
                        RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("iniciarSesion.jsp");
                        miRequestDispatcher.forward(request, response);
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
    }// </editor-fold>

}
