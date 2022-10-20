/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dominio.Curso;
import java.io.File;
import java.io.IOException;
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
public class EliminarCurso extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String pathFiles = "C:\\Users\\Ricardo\\Documents\\NetBeansProjects\\FescCursos\\web\\img\\imgCursos\\";
    private File uploads = new File(pathFiles);
    private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoCurso dao = new DaoCursoImpl();

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Curso curTemp = dao.BusCursoXId(id);
            boolean delete = deleteFile(curTemp, uploads);
            if (delete == true) {
                dao.Eliminar(curTemp);

                try {
                    List<Curso> lista = dao.ListarTodos();
                    request.setAttribute("lista", lista);
                    RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("index.jsp");
                    miRequestDispatcher.forward(request, response);

                } catch (Exception ex) {
                    Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("No se elimino el curso id_Curso: " + id);
            }

        } catch (Exception ex) {
            Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean deleteFile(Curso cur, File pathUploads) {
        DaoCurso dao = new DaoCursoImpl();
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
