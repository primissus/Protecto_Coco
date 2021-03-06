/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conferencia;
import modelo.Usuario;

/**
 *
 * @author trafalgar
 */
@WebServlet(name = "registro_conferencia", urlPatterns = {"/registro_conferencia"})
public class registro_conferencia extends HttpServlet {

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
        
        String nombre = request.getParameter("nombre");
        String expositor = request.getParameter("expositor");
        int capacidad = 0;
        try {
            capacidad = Integer.parseInt(request.getParameter("capacidad"));
        }
        catch(NumberFormatException ex) {
            Logger.getLogger(registro_conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = null;
        try {
            date = formatter.parse(request.getParameter("fecha_hora"));
        } catch (ParseException ex) {
            Logger.getLogger(registro_conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        String descripcion = request.getParameter("descripcion");
        int costo = 0;
        try {
            costo = Integer.parseInt(request.getParameter("costo"));
        }
        catch(NumberFormatException ex) {
            Logger.getLogger(registro_conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        int sala = 0;
        try {
            sala = Integer.parseInt(request.getParameter("sala"));
        }
        catch(NumberFormatException ex) {
            Logger.getLogger(registro_conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        int encargadoID = -1;
        try {
            encargadoID = Integer.parseInt(request.getParameter("encargado_id"));
        }
        catch(NumberFormatException ex) {
            Logger.getLogger(registro_conferencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        EntityManager em;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("Proyecto_CocoPU");
        em =emf.createEntityManager();
        
        Usuario encargado = new Usuario(-1, "", "", "", "", "");
        if(encargadoID != -1) {
            encargado = em.find(Usuario.class, encargadoID);
        }
        
        Conferencia conferencia = new Conferencia();
        conferencia.setId(0);
        conferencia.setNombre(nombre);
        conferencia.setExpositor(expositor);
        conferencia.setDescripcion(descripcion);
        conferencia.setFechaHora(date);
        conferencia.setCapacidad(capacidad);
        conferencia.setSala(sala);
        conferencia.setCosto(costo);
        conferencia.setEncargado(encargado);
        //conferencia.setEncargadoID(encargadoID);
        //System.out.println(conferencia.toString());
        System.out.println(String.valueOf(encargadoID));
        
        try {
          em.getTransaction().begin();
          em.persist(conferencia);
          //em.flush();
          em.getTransaction().commit();
          em.close();
          emf.close();
          mensaje("Se ha creado el evento.", response.getWriter());
         }
        catch(Exception ex){
            mensaje("Ocurrió un error.", response.getWriter());
            System.out.println(ex.toString());
        }
          
        //response.sendRedirect("index.xhtml");
        
    }
    
    private void mensaje(String mensaje, PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Creacion conferencia</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>" + mensaje + "</p>");
        out.println("<a href=\"nueva_conferencia.jsp\"> regresar </a>");
        out.println("</body>");
        out.println("</html>");
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
