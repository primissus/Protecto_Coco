/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Asistencia;
import modelo.Conferencia;
import modelo.Usuario;

/**
 *
 * @author trafalgar
 */
@WebServlet(name = "registro_asistencia", urlPatterns = {"/registro_asistencia"})
public class registro_asistencia extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                       
            
            if(request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                int codigo = Integer.parseInt(request.getParameter("codigo"));
                
                EntityManagerFactory emf = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
                EntityManager em = emf.createEntityManager();
                Asistencia asistencia = em.find(Asistencia.class, codigo);
                if(asistencia != null && asistencia.getConferencia().getId() == id) {
                    asistencia.setAsiste(true);
                    em.getTransaction().begin();
                    em.merge(asistencia);
                    em.getTransaction().commit();
                    
                    response.sendRedirect("correcto.jsp");
                }
                else {
                    response.sendRedirect("registro_asistencia.jsp");
                }
                  
            }    
                
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
