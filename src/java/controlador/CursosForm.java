/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dao.DaoUsuario;
import dao.DaoUsuarioImpl;
import dominio.Curso;
import dominio.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class CursosForm extends HttpServlet {

    private DaoCurso dao = new DaoCursoImpl();
    private DaoUsuario daoU = new DaoUsuarioImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "Buscar":
                    String nombreCurso = request.getParameter("nombreCurso");
                    String categoria = request.getParameter("categoria");
                    String idProf = request.getParameter("idProfesor");
                    int idProfesor = 0;
                    if (idProf.equals("Profesores")) {
                        //no hay idProf
                    } else {
                        idProfesor = Integer.parseInt(idProf);
                        try {
                            List<Curso> lista = (List<Curso>) dao.ListarCursosXidProf(idProfesor);
                            request.setAttribute("lista", lista);

                            List<String> cats = dao.Categorias();
                            request.setAttribute("categorias", cats);

                            List<Usuario> profs = daoU.ListarProfesores();
                            List<Usuario> profesores = new ArrayList();
                            for (Usuario profe : profs) {
                                String nombreProfesor = profe.getNombre() + " " + profe.getApellidos();
                                Usuario usr = new Usuario(profe.getId_Usuario(), nombreProfesor);
                                profesores.add(usr);
                            }
                            request.setAttribute("profesores", profesores);

                            String bus = "xNombreCurso";
                            request.setAttribute("busco", bus);
                            request.setAttribute("busqueda", nombreCurso);
                            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("cursosTodos.jsp");
                            miRequestDispatcher.forward(request, response);

                        } catch (Exception ex) {
                            Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (categoria.equals("Categorias")) {
                        //No hay categoria escogida
                    } else {
                        try {
                            List<Curso> lista = (List<Curso>) dao.BusCursoXCategoria(categoria);
                            request.setAttribute("lista", lista);

                            List<String> cats = dao.Categorias();
                            request.setAttribute("categorias", cats);

                            List<Usuario> profs = daoU.ListarProfesores();
                            List<Usuario> profesores = new ArrayList();
                            for (Usuario profe : profs) {
                                String nombreProfesor = profe.getNombre() + " " + profe.getApellidos();
                                Usuario usr = new Usuario(profe.getId_Usuario(), nombreProfesor);
                                profesores.add(usr);
                            }
                            request.setAttribute("profesores", profesores);

                            String bus = "xNombreCurso";
                            request.setAttribute("busco", bus);
                            request.setAttribute("busqueda", nombreCurso);
                            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("cursosTodos.jsp");
                            miRequestDispatcher.forward(request, response);

                        } catch (Exception ex) {
                            Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (nombreCurso != "") {
                        try {
                            List<Curso> lista = (List<Curso>) dao.BusCursoXNombre(nombreCurso);
                            request.setAttribute("lista", lista);

                            List<String> cats = dao.Categorias();
                            request.setAttribute("categorias", cats);

                            List<Usuario> profs = daoU.ListarProfesores();
                            List<Usuario> profesores = new ArrayList();
                            for (Usuario profe : profs) {
                                String nombreProfesor = profe.getNombre() + " " + profe.getApellidos();
                                Usuario usr = new Usuario(profe.getId_Usuario(), nombreProfesor);
                                profesores.add(usr);
                            }
                            request.setAttribute("profesores", profesores);

                            String bus = "xNombreCurso";
                            request.setAttribute("busco", bus);
                            request.setAttribute("busqueda", nombreCurso);
                            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("cursosTodos.jsp");
                            miRequestDispatcher.forward(request, response);

                        } catch (Exception ex) {
                            Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        request.getRequestDispatcher("CursosTodos?listar").forward(request, response);
                    }
                    break;

                default:
                    break;

            }

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
