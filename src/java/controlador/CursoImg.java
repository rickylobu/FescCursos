/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dominio.Curso;
import dominio.Usuario;
import static java.awt.SystemColor.text;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ricardo
 */
@MultipartConfig
public class CursoImg extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DaoCurso dao = new DaoCursoImpl();
    private String pathFiles = "C:\\Users\\Ricardo\\Documents\\NetBeansProjects\\FescCursos\\web\\img\\imgCursos\\";
    private File uploads = new File(pathFiles);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};

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
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("accion");

        switch (action) {
            case "Guardar":
                GuardarCurso(request, response);
                break;

            default:
                request.getRequestDispatcher("pruebaServletDao?accion=Listar").forward(request, response);

                break;
        }
    }

    private void GuardarCurso(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession sesion = request.getSession();

        if (sesion.getAttribute("tipo") == "profesor") {
            try {
                int idCurso = 0;//autoincrementable en BD
                Usuario prof = (Usuario) sesion.getAttribute("user");
                int idProf = prof.getId_Usuario();
                String nombreCur = request.getParameter("nombreCurso");
                String categoria = request.getParameter("categoria");
                if (categoria.equals("otra") || categoria.equals("Categorias")){
                categoria=request.getParameter("categoriaNueva");
                }
                String descripcion = request.getParameter("descripcion");
                Part part = request.getPart("imagen");

                if (part == null) {
                    System.out.println("No ha seleccionado un archivo");
                    return;
                }

                if (isExtension(part.getSubmittedFileName(), extens)) {
                    String photo = "img\\imgCursos\\" + saveFile(part, uploads);
                    Curso nuevoCurso = new Curso(idCurso, idProf, nombreCur, descripcion, categoria, photo);
                    dao.Registrar(nuevoCurso);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            String respuesta = "Usted no es profesor, No puede agregar un curso. sorry!...";
            request.setAttribute("resp", respuesta);

        }

        RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("index.jsp");
        miRequestDispatcher.forward(request, response);
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

    private boolean isExtension(String fileName, String[] extensions) {
        for (String et : extensions) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }

        return false;
    }

    private boolean deleteFile(Curso cur, File pathUploads) {
        String img = null;

        File f = null;
        boolean bool = false;

        try {
            // create new file
            img = dao.BusImagenSinRuta(cur);
            f = new File(pathUploads, img);

            // tries to delete a non-existing file
            bool = f.delete();

            // prints
            System.out.println("File deleted: " + bool);

            // creates file in the system
            f.createNewFile();

            // createNewFile() is invoked
            System.out.println("createNewFile() method is invoked");

            // tries to delete the newly created file
            bool = f.delete();

            // print
            System.out.println("File deleted: " + bool);

        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
        }

        return bool;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>

}
