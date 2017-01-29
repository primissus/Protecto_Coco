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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author law
 */
@ManagedBean
@RequestScoped
public class RegistroConferenciaBean {
    
    String nombre;
    String expositor;
    int capacidad;
    Date fechaHora;
    int sala;
    String descripcion;
    int costo;
    String encargado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExpositor() {
        return expositor;
    }

    public void setExpositor(String expositor) {
        this.expositor = expositor;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getFechaHora() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        if(this.fechaHora != null) {
            return formatter.format(fechaHora);
        }
        return "";
    }

    public void setFechaHora(String fechaHora) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = null;
        if(!fechaHora.isEmpty()) {
            try {
                date = formatter.parse(fechaHora);
            } catch (ParseException ex) {
                Logger.getLogger(registro_conferencia.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.fechaHora = date;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }
    
    
    
}
