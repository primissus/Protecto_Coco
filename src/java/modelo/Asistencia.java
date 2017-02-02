/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author law
 */
@Entity
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a")
    , @NamedQuery(name = "Asistencia.findById", query = "SELECT a FROM Asistencia a WHERE a.id = :id")
    , @NamedQuery(name = "Asistencia.findByIdUsuario", query = "SELECT a FROM Asistencia a WHERE a.idUsuario = :idUsuario")
    , @NamedQuery(name = "Asistencia.findByIdConferencia", query = "SELECT a FROM Asistencia a WHERE a.idConferencia = :idConferencia")})
public class Asistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_conferencia")
    private int idConferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "asiste")
    private boolean asiste;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Publico publico;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "id_conferencia", referencedColumnName = "id")
    private Conferencia conferencia;

    public Asistencia() {
    }
    
    public Asistencia(Integer id, int idUsuario, int idConferencia, Publico publico, Conferencia conferencia) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idConferencia = idConferencia;
        this.publico = publico;
        this.conferencia = conferencia;
        this.asiste = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    public boolean isAsiste() {
        return asiste;
    }

    public void setAsiste(boolean asiste) {
        this.asiste = asiste;
    }

    public Publico getPublico() {
        return publico;
    }

    public void setPublico(Publico publico) {
        this.publico = publico;
    }

    public Conferencia getConferencia() {
        return conferencia;
    }

    public void setConferencia(Conferencia conferencia) {
        this.conferencia = conferencia;
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
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Asistencia[ id=" + id + " ]";
    }
    
}
