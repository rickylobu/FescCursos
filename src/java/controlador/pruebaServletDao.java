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
import java.time.LocalDate;
import java.util.List;
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
public class pruebaServletDao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pruebaServletDao</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pruebaServletDao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //___________________________________________________________
        //_______________PRUEBAS DE USUARIO_____________________
        //__________________prueba insertar usuario_____________________
        
        LocalDate fecha_Nac = LocalDate.of(1996,12 ,03);
        java.sql.Date fechaSql=java.sql.Date.valueOf(fecha_Nac);
        
                                //int id_Usuario, String correo, String contraseña, String nombre, String apellidos, Date fecha_Nac, Boolean alumno, boolean profesor
        Usuario usr=new Usuario(0,"correoEder@ejemploDao","4561","NombreEjemplo4","ApellidosEjemplo4",fechaSql,false,true);
                
        /*
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        dao.Registrar(usr);
        out.println("usuario agregado con exito ");
        }catch(Exception e){
            out.println(e.getMessage());
            out.println("Usuario no agregado ");
        }
        
         */
        //_________________prueba Modificar Usuario_____________________ 
        /*
        
        LocalDate fecha_Nac = LocalDate.of(1995,03 ,11);
        java.sql.Date fechaSql=java.sql.Date.valueOf(fecha_Nac);
        Usuario usr=new Usuario(1,"correomodificado@ejemploDao","1111","NombreEjemploModificado","ApellidosEjemploModificado",fechaSql,false,true);                
        
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        dao.Modificar(usr);
        out.println("usuario modificado con exito ");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("usuario no modificado");

        }
        
         */
        //_________________prueba Eliminar Usuario_____________________ 
        /*
        int id =3;
         
        LocalDate fecha_Nac = LocalDate.of(1996,12 ,03);
        java.sql.Date fechaSql=java.sql.Date.valueOf(fecha_Nac);
        
        Usuario usr=new Usuario(id,"correo4@ejemploDao","4561","NombreEjemplo4","ApellidosEjemplo4",fechaSql,false,true);
                
        
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        dao.Eliminar(usr);
        out.println("usuario eliminado con exito ");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("usuario no eliminado");

        }
        
         */
        //_________________prueba Buscar por Id Usuario_____________________ 
        /*
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        int idBus=1;
        Usuario u= dao.BusUsuarioXId(idBus);
            out.println("idUsuario;  "+u.getId_Usuario()+"<br>correo:  "+u.getCorreo()+"<br>nombre:  "+u.getNombre()+"<br>apellidos:  "+u.getApellidos()+"<br>fecha de Nac:  "+u.getFecha_Nac()+"<br>alumno:  "+u.isAlumno()+"<br>profesor:  "+u.isProfesor());
        
        out.println("<br>____Usuario encontrado con exito_____");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("<br>usuario no encontrado");

        }
        
         */
        //_________________prueba buscar por Correo Usuario_____________________ 
        /*
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        String correoBus="correomodificado@ejemploDao";
        Usuario u= dao.BusUsuarioXCorreo(correoBus);
            out.println("idUsuario;  "+u.getId_Usuario()+"<br>correo:  "+u.getCorreo()+"<br>nombre:  "+u.getNombre()+"<br>apellidos:  "+u.getApellidos()+"<br>fecha de Nac:  "+u.getFecha_Nac()+"<br>alumno:  "+u.isAlumno()+"<br>profesor:  "+u.isProfesor());
        
        out.println("<br>____Usuario encontrado con exito_____");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("<br>usuario no encontrado");

        }
        
         */
        //_________________prueba buscar por Nombre Usuario_____________________ 
        /*
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        String nombreBus="NombreEjemploModificado";
        Usuario u= dao.BusUsuarioXNombre(nombreBus);
            out.println("idUsuario;  "+u.getId_Usuario()+"<br>correo:  "+u.getCorreo()+"<br>nombre:  "+u.getNombre()+"<br>apellidos:  "+u.getApellidos()+"<br>fecha de Nac:  "+u.getFecha_Nac()+"<br>alumno:  "+u.isAlumno()+"<br>profesor:  "+u.isProfesor());
        
        out.println("<br>____Usuario encontrado con exito_____");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("<br>usuario no encontrado");

        }
        
         */
        //_________________prueba Listar Todos Usuario_____________________ 
        /*
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        for (Usuario u : dao.ListarTodos()){
            out.println("idUsuario;  "+u.getId_Usuario()+"<br>correo:  "+u.getCorreo()+"<br>nombre:  "+u.getNombre()+"<br>apellidos:  "+u.getApellidos()+"<br>fecha de Nac:  "+u.getFecha_Nac()+"<br>alumno:  "+u.isAlumno()+"<br>profesor:  "+u.isProfesor());
        }
        
        out.println("<br>____Usuarios Listados con exito_____");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("<br>usuarios no listados");

        }
         */
        //_________________prueba listar Alumnos Usuario_____________________ 
        /*
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        for (Usuario u : dao.ListarAlumnos()){
            out.println("idUsuario;  "+u.getId_Usuario()+"<br>correo:  "+u.getCorreo()+"<br>nombre:  "+u.getNombre()+"<br>apellidos:  "+u.getApellidos()+"<br>fecha de Nac:  "+u.getFecha_Nac()+"<br>alumno:  "+u.isAlumno()+"<br>profesor:  "+u.isProfesor());
        }
        
        out.println("<br>____Alumnos Listados con exito_____");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("<br>Alumnos no listados");

        }
         */
        //_________________prueba Listar Profesores Usuario_____________________ 
        /*
        try{
        DaoUsuario dao =new DaoUsuarioImpl();
        for (Usuario u : dao.ListarProfesores()){
            out.println("idUsuario;  "+u.getId_Usuario()+"<br>correo:  "+u.getCorreo()+"<br>nombre:  "+u.getNombre()+"<br>apellidos:  "+u.getApellidos()+"<br>fecha de Nac:  "+u.getFecha_Nac()+"<br>alumno:  "+u.isAlumno()+"<br>profesor:  "+u.isProfesor());
        }
        
        out.println("<br>____Profesores Listados con exito_____");

        }catch(Exception e){
            out.println(e.getMessage());
            out.println("<br>Profesores no listados");

        }
        
         */
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DaoCurso dao = new DaoCursoImpl();
        Curso cur = new Curso();

        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                    try {
                List<Curso> lista = dao.ListarTodos();
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (Exception ex) {
                Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            break;

            default:
                request.getRequestDispatcher("pruebaServletDao?accion=Listar").forward(request, response);
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
