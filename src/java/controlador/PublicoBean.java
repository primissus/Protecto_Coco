/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import modelo.Asistencia;
import modelo.Publico;

/**
 *
 * @author law
 */
@ManagedBean(name = "publico")
@ViewScoped
public class PublicoBean {
    
    String correo;
    int conferenciaID;
    Publico publico; 

    public PublicoBean() {
        conferenciaID = -1;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
        publico = Selector.getPublico(correo);
    }

    public int getConferenciaID() {
        return conferenciaID;
    }

    public void setConferenciaID(int ConferenciaID) {
        this.conferenciaID = ConferenciaID;
    }

    public Publico getPublico() {
        System.out.print("publico conferencias:");
        if(publico != null && publico.getConferencias() != null)
        System.out.println(publico.getConferencias().size());
        return publico;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }
    
    public void listener(AjaxBehaviorEvent event) {
        System.out.println("Listener");
    }
    
    public String getCode() {
        System.out.println("Click, conferenciaId = " + conferenciaID + " publico = " + publico);
        if(publico != null && conferenciaID != -1) {
            for(Asistencia asistencia : publico.getAsistencias()) {
                if(asistencia.getIdConferencia() == conferenciaID) {
                    return "Codigo: " + asistencia.getId();
                }
            }
        }
        return "No es posible obtener el código";
    }
    
    public String validate() {
        System.out.println("Validate");
        if(publico != null)
            return publico.getNombre() + " encontrado";
        return "Aun no encontrado";
    }
    
}
