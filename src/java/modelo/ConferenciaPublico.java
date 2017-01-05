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
@Table(name = "conferencia_publico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConferenciaPublico.findAll", query = "SELECT c FROM ConferenciaPublico c")
    , @NamedQuery(name = "ConferenciaPublico.findById", query = "SELECT c FROM ConferenciaPublico c WHERE c.id = :id")
    , @NamedQuery(name = "ConferenciaPublico.findByIdConferencia", query = "SELECT c FROM ConferenciaPublico c WHERE c.idConferencia = :idConferencia")
    , @NamedQuery(name = "ConferenciaPublico.findByIdPublico", query = "SELECT c FROM ConferenciaPublico c WHERE c.idPublico = :idPublico")})
public class ConferenciaPublico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_conferencia")
    private int idConferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_publico")
    private int idPublico;

    public ConferenciaPublico() {
    }

    public ConferenciaPublico(Integer id) {
        this.id = id;
    }

    public ConferenciaPublico(Integer id, int idConferencia, int idPublico) {
        this.id = id;
        this.idConferencia = idConferencia;
        this.idPublico = idPublico;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdConferencia() {
        return idConferencia;
    }

    public void setIdConferencia(int idConferencia) {
        this.idConferencia = idConferencia;
    }

    public int getIdPublico() {
        return idPublico;
    }

    public void setIdPublico(int idPublico) {
        this.idPublico = idPublico;
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
        if (!(object instanceof ConferenciaPublico)) {
            return false;
        }
        ConferenciaPublico other = (ConferenciaPublico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.ConferenciaPublico[ id=" + id + " ]";
    }
    
}
