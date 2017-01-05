/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author trafalgar
 */
@WebServlet(name = "registro_publico", urlPatterns = {"/registro_publico"})
public class registro_publico extends HttpServlet {

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
        
        
        
        
                  String nombre = request.getParameter("nombre");
                  String domicilio = request.getParameter("domicilio");
                  String  telefono_contacto = request.getParameter("telefono_contacto");
                  int  conferencia = Integer.parseInt(request.getParameter("id"));
                  String correo = request.getParameter("correo");
                              
                  
                  modelo.Publico registro = new modelo.Publico();
       

                 registro.setId(0);
                 registro.setNombre(nombre);
                 registro.setDomicilio(domicilio);
                 registro.setTelefono(telefono_contacto);
                 registro.setCorreo(correo);
                 registro.setIdConferencia(conferencia);
                 
                 
                 
                    
          EntityManager em;
          EntityManagerFactory emf;
          emf = Persistence.createEntityManagerFactory("Proyecto_CocoPU");
          em =emf.createEntityManager();
          em.getTransaction().begin();
          em.persist(registro);
          em.flush();
          em.getTransaction().commit();
          em.close();
          emf.close();
          response.sendRedirect("correcto.jsp");
  
        
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
