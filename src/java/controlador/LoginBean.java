/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
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
        Usuario usuario = Login.validate(username, password);
        if(usuario != null) {
            HttpSession sesion = SesionUtils.getSession();
            sesion.setAttribute("username", usuario.getUsername());
            sesion.setAttribute("tipo", usuario.getTipo());
            return 1;
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usaurio y contraseña incorrectos", "Por favor ingresa un usuario y contraseña correctos"));
        }
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
    
    public int logout() {
        HttpSession sesion = SesionUtils.getSession();
        sesion.invalidate();
        return 0;
    }
    
}
