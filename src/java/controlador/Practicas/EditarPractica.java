/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador.Practicas;

import controlador.pruebaServletDao;
import dao.DaoPractica;
import dao.DaoPracticaImpl;
import dominio.Practica;
import dominio.Recurso;
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
public class EditarPractica extends HttpServlet {
    
    private DaoPractica daoP = new DaoPracticaImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Practica pracTemp=daoP.BusPracticaXId(id);
            request.setAttribute("practicaEditar", pracTemp);
            List<Recurso> listaRecursos=daoP.BusRecursosXIdPractica(id);
            request.setAttribute("recursos", listaRecursos);
            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("editarPractica.jsp");
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
