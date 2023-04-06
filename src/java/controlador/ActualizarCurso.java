/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dominio.Curso;
import dominio.Usuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
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
public class ActualizarCurso extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String pathFiles = "C:\\Users\\avata\\Documents\\NetBeansProjects\\FescCursos\\web\\img\\imgCursos\\";
    private File uploads = new File(pathFiles);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
    private DaoCurso dao = new DaoCursoImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "Guardar":
        try {
                    HttpSession sesion = request.getSession();
                    int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                    Usuario prof = (Usuario) sesion.getAttribute("user");
                    int idProf = prof.getId_Usuario();
                    String nombreCur = request.getParameter("nombreCurso");
                    String categoria = request.getParameter("categoria");
                    if (categoria.equals("otra") || categoria.equals("Categorias")) {
                        categoria = request.getParameter("categoriaNueva");
                    }
                    String descripcion = request.getParameter("descripcion");
                    Part part = request.getPart("imagen");

                    if (isExtension(part.getSubmittedFileName(), extens)) {
                        Curso c = dao.BusCursoXId(idCurso);
                        boolean delete = deleteFile(c, uploads);
                        if (delete == true) {
                            String photo = "img\\imgCursos\\" + saveFile(part, uploads);
                            Curso cursoEditado = new Curso(idCurso, idProf, nombreCur, descripcion, categoria, photo);
                            dao.Modificar(cursoEditado);
                            dao.ModificarImagen(cursoEditado);
                            response.sendRedirect("/FescCursos/index.jsp");
                        } else {
                            System.out.println("borrado?" + delete);
                        }

                    } else {
                        Curso cursoEditado = new Curso(idCurso, idProf, nombreCur, descripcion, categoria, "la ruta no se actualiza");
                        dao.Modificar(cursoEditado);
                        request.getRequestDispatcher("MisCursosProfesor").forward(request, response);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

                default:
                    request.getRequestDispatcher("MisCursosProfesor").forward(request, response);
                    break;
            }
        }

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
    }// </editor-fold>

}
