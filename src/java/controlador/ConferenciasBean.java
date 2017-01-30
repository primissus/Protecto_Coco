/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Conferencia;

/**
 *
 * @author trafalgar
 */
@ManagedBean(name = "conferencias")
@ViewScoped
public class ConferenciasBean {
    
    List<Conferencia> conferencias;

    public ConferenciasBean() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Proyecto_CocoPU");
        EntityManager em = factory.createEntityManager();
        
        Query query;
        query = em.createQuery("Select c From Conferencia c");
        conferencias = query.getResultList();
    }

    public List<Conferencia> getConferencias() {
        return conferencias;
    }

    public void setConferencias(List<Conferencia> conferencias) {
        this.conferencias = conferencias;
    }
    
}