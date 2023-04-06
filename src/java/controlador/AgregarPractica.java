/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoPractica;
import dao.DaoPracticaImpl;
import dominio.Practica;
import dominio.Recurso;
import dominio.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Ricardo
 */
@MultipartConfig
public class AgregarPractica extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DaoPractica dao = new DaoPracticaImpl();
    private String pathFiles = "C:\\Users\\avata\\Documents\\NetBeansProjects\\FescCursos\\web\\recursos\\";
    private File uploads = new File(pathFiles);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("accion");

        switch (action) {
            case "Guardar":
                GuardarPractica(request, response);
                break;

            default:
                request.getRequestDispatcher("CursosTodos?listar").forward(request, response);

                break;
        }
    }

    private void GuardarPractica(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sesion = request.getSession();

        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        if (sesion.getAttribute("tipo") == "profesor") {
            try {
                int idPractica = 0;//autoincrementable en BD
                String nombre = request.getParameter("nombrePractica");
                String descripcion = request.getParameter("descripcion");
                String urlVideo = request.getParameter("urlVideo");
                
                int numeroPrac=dao.getNumeroPrac(idCurso);

                Practica nuevaPractica = new Practica(idPractica, idCurso, numeroPrac, nombre, descripcion, urlVideo);
                dao.Registrar(nuevaPractica);
                Part part = request.getPart("recurso");
                if (part != null) {
                    int idRecurso = 0;//autoincrementable en BD
                    Practica practicaCreada = dao.BusPracticaXNombre(nombre);
                    idPractica = practicaCreada.getId_Practica();
                    String nombreRecurso = request.getParameter("nombreRecurso");
                    String direccion = "recursos\\" + saveFile(part, uploads);
                    Recurso recurso = new Recurso(idRecurso,idCurso, idPractica, nombreRecurso, direccion);
                    dao.RegistrarRecurso(recurso);

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String respuesta = "Usted no es profesor, No puede agregar una práctica. sorry!...";
            request.setAttribute("resp", respuesta);

        }

        request.getRequestDispatcher("EditarCurso?id=" + idCurso).forward(request, response);

    }

    private String saveFile(Part part, File pathUploads) {
        String fileName = "";

        try {

            Path path = Paths.get(part.getSubmittedFileName());
            fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();

            if (input != null) {
                File file = new File(pathUploads, fileName);
                //pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileName;
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
