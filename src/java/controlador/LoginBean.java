/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Cache;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import javax.servlet.http.Cookie;
import modelo.Usuario;

/**
 *
 * @author trafalgar
 */


@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{

    String username;
    String password;
    
    /**
     * Creates a new instance of loginBean
     */
    public LoginBean() {
        
        
    }
    
    public int logIn() {
        if(username == null || password == null)
            return -2;
        if(username.isEmpty() || password.isEmpty())
            return -1;
        if(Login.validate(username, password))
            return 1;
        return 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
    
    public void logout() {
        
    }
    
}
