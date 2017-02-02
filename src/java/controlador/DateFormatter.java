package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author law
 */
@ManagedBean(name = "formatter")
@ViewScoped
public class DateFormatter {
    
    private Date fecha;
    private String fechaString;
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        this.fechaString = format.format(fecha);
    }

    public String getFechaString() {
        return fechaString;
    }

    public void setFechaString(String fechaString) {
        this.fechaString = fechaString;
    }
    
    public String format(Date date){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mma");
        return format.format(date);
    }
    
}
