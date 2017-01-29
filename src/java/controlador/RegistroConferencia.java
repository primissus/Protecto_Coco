/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Conferencia;

/**
 *
 * @author law
 */
public class RegistroConferencia {
    
    public static int createEvent(String nombre, String expositor, int capacidad, Date date, String descripcion, int costo, int sala, String encargado) {
        
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
        
        try {
        EntityManager em;
          EntityManagerFactory emf;
          emf = Persistence.createEntityManagerFactory("Proyecto_CocoPU");
          em = emf.createEntityManager();
          em.getTransaction().begin();
          em.persist(conferencia);
          //em.flush();
          em.getTransaction().commit();
          em.close();
          emf.close();
         }
        catch(Exception ex){
        }
        return 0;
    }
}
