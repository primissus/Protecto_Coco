/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
}
