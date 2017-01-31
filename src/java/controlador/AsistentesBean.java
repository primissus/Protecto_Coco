/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.servlet.http.HttpSession;
import modelo.Publico;
import modelo.Usuario;

/**
 *
 * @author law
 */
@ManagedBean(name = "asistentes")
@ViewScoped
public class AsistentesBean {
    
    int conferenciaID;
    List<Publico> publico;

    public AsistentesBean() {
        conferenciaID = 0;
        publico = new ArrayList<>();
    }
    
    public int getConferenciaID() {
        return conferenciaID;
    }

    public void setConferenciaID(int conferenciaID) {
        this.conferenciaID = conferenciaID;
    }

    public List<Publico> getPublico() {
        return publico;
    }

    public void setPublico(List<Publico> publico) {
        this.publico = publico;
    }
    
    public void updatePublico() {
        publico = Selector.getPublico(conferenciaID);
    }
    
    public final void selectConferencia(final AjaxBehaviorEvent event){
        System.out.println(String.valueOf(conferenciaID));
        Selector.getPublico(conferenciaID);
    }
    
}
