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
import modelo.Asistencia;
import modelo.Conferencia;
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
        HttpSession session = SesionUtils.getSession();
        int idUsuario = (Integer) session.getAttribute("id");
        Usuario usuario = Selector.getUser(idUsuario);
        if(usuario.getConferencias() != null && !usuario.getConferencias().isEmpty())
            conferenciaID = usuario.getConferencias().get(0).getId();
        updatePublico();
    }
    
    public int getConferenciaID() {
        return conferenciaID;
    }

    public void setConferenciaID(int conferenciaID) {
        System.out.println("setted");
        this.conferenciaID = conferenciaID;
    }

    public List<Publico> getPublico() {
        return publico;
    }

    public void setPublico(List<Publico> publico) {
        this.publico = publico;
    }
    
    public void updatePublico() {
        Conferencia conferencia = Selector.getConferencia(conferenciaID);
        publico.clear();
        if(conferencia != null) {
            for(Asistencia asistencia : conferencia.getAsistencias()) {
                if(asistencia.isAsiste())
                    publico.add(asistencia.getPublico());
            }
        }
    }
    
    public void listener(AjaxBehaviorEvent event) {
        updatePublico();
    }
    
}
