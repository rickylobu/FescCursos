/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.DaoCurso;
import dao.DaoCursoImpl;
import dao.DaoPractica;
import dao.DaoPracticaImpl;
import dominio.Curso;
import java.io.IOException;
import java.io.PrintWriter;
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
public class NuevaPractica extends HttpServlet {

    private DaoCurso dao = new DaoCursoImpl();
    private DaoPractica daoP = new DaoPracticaImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Curso cur = dao.BusCursoXId(id);
            request.setAttribute("CursoPractica", cur);
            int numeroPrac=daoP.getNumeroPrac(id);
            request.setAttribute("numeroPractica", numeroPrac);
            RequestDispatcher miRequestDispatcher = request.getRequestDispatcher("agregarPractica.jsp");
            miRequestDispatcher.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(NuevaPractica.class.getName()).log(Level.SEVERE, null, ex);
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
