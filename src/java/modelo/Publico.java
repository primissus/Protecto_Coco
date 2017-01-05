/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author trafalgar
 */
@Entity
@Table(name = "publico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publico.findAll", query = "SELECT p FROM Publico p")
    , @NamedQuery(name = "Publico.findById", query = "SELECT p FROM Publico p WHERE p.id = :id")
    , @NamedQuery(name = "Publico.findByNombre", query = "SELECT p FROM Publico p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Publico.findByDomicilio", query = "SELECT p FROM Publico p WHERE p.domicilio = :domicilio")
    , @NamedQuery(name = "Publico.findByTelefono", query = "SELECT p FROM Publico p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Publico.findByCorreo", query = "SELECT p FROM Publico p WHERE p.correo = :correo")})
public class Publico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private int nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "domicilio")
    private int domicilio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "correo")
    private int correo;

    public Publico() {
    }

    public Publico(Integer id) {
        this.id = id;
    }

    public Publico(Integer id, int nombre, int domicilio, int telefono, int correo) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(int domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCorreo() {
        return correo;
    }

    public void setCorreo(int correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publico)) {
            return false;
        }
        Publico other = (Publico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Publico[ id=" + id + " ]";
    }
    
}
