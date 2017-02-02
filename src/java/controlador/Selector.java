/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import modelo.Conferencia;
import modelo.Publico;
import modelo.Usuario;

/**
 *
 * @author law
 */
public class Selector {
    
    public static List<Usuario> getEncargados() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select u From Usuario u where u.tipo = 'enc'");
        List<Usuario> usuarios = query.getResultList();

        entitymanager.close();
        emfactory.close();
        
        return usuarios;
    }
    
    public static Usuario getUser(int id) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
        EntityManager entitymanager = emfactory.createEntityManager();
        
        Usuario usuario = null;
        usuario = entitymanager.find(Usuario.class, id);
        
        entitymanager.close();
        emfactory.close();
        
        return usuario;
    }
    
    public static List<Publico> getPublico(int conferenciaId) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
        EntityManager entitymanager = emfactory.createEntityManager();
        
        Conferencia conferencia;
        conferencia = entitymanager.find(Conferencia.class, conferenciaId);
        
        entitymanager.close();
        emfactory.close();
        if(conferencia == null) {
            return new ArrayList<>();
        }
        return conferencia.getPublico();
    }
    
    public static Conferencia getConferencia(int id) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
        EntityManager entitymanager = emfactory.createEntityManager();
        
        Conferencia conferencia = entitymanager.find(Conferencia.class, id);
        
        entitymanager.close();
        emfactory.close();
        return conferencia;
    }
    
    public static Publico getPublico(String correo) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
        EntityManager entitymanager = emfactory.createEntityManager();
        
        Query query = entitymanager.createQuery("Select p From Publico p Where p.correo = '" + correo + "'");
        Publico publico = null;
        List<Publico> personas = query.getResultList();
        publico = (personas.size() > 0)? personas.get(0) : null;
        
        entitymanager.close();
        emfactory.close();
        return publico;
    }

}
