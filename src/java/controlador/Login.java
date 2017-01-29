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

public class Login {

    public static boolean validate(String username, String password) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Proyecto_CocoPU" );
        EntityManager entitymanager = emfactory.createEntityManager();

        Query query = entitymanager.createQuery("Select u From Usuario u " + "where u.username = " + "'" + username + "'");
        List<Usuario> usuarios = query.getResultList();

        entitymanager.close();
        emfactory.close();
        
        for(Usuario usuario : usuarios) {
                if(usuario.getPassword().equals(password)) {
                    return true;
                }
            }
        return false;
    }
    
}
