/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoPractica;
import dao.DaoPracticaImpl;
import dominio.Recurso;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
public class EliminarResurso extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private DaoPractica dao = new DaoPracticaImpl();
    private String pathFiles = "C:\\Users\\Ricardo\\Documents\\NetBeansProjects\\FescCursos\\web\\recursos\\";
    private File uploads = new File(pathFiles);

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Recurso recursoTemp = dao.BusRecursoXId(id);
            boolean delete = deleteFile(recursoTemp, uploads);
            if (delete == true) {
                dao.EliminarRecurso(recursoTemp);

                request.getRequestDispatcher("EditarPractica?id=" + recursoTemp.getIdPractica()).forward(request, response);

            } else {
                System.out.println("No se elimino el curso id_Curso: " + id);
            }

        } catch (Exception ex) {
            Logger.getLogger(pruebaServletDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean deleteFile(Recurso recurso, File pathUploads) {
        String rec = null;

        File f = null;
        boolean bool = false;

        try {
            rec = dao.BusRecursoSinRuta(recurso);
            f = new File(pathUploads, rec);

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
