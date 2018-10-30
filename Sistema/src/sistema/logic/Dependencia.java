/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leaca
 */
@Entity
@Table(name = "dependencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependencia.findAll", query = "SELECT d FROM Dependencia d")})
public class Dependencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dependencia_id")
    private Integer dependenciaId;
    @Basic(optional = false)
    @Column(name = "dependencia_nombre")
    private String dependenciaNombre;
    @OneToMany(mappedBy = "solicitudDependencia")
    private Collection<Solicitud> solicitudCollection;
    @JoinColumn(name = "dependencia_administrador", referencedColumnName = "funcionario_id")
    @ManyToOne
    private Funcionario dependenciaAdministrador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laborDependencia")
    private Collection<Labor> laborCollection;

    public Dependencia() {
    }

    public Dependencia(Integer dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public Dependencia(Integer dependenciaId, String dependenciaNombre) {
        this.dependenciaId = dependenciaId;
        this.dependenciaNombre = dependenciaNombre;
    }

    public Integer getDependenciaId() {
        return dependenciaId;
    }

    public void setDependenciaId(Integer dependenciaId) {
        this.dependenciaId = dependenciaId;
    }

    public String getDependenciaNombre() {
        return dependenciaNombre;
    }

    public void setDependenciaNombre(String dependenciaNombre) {
        this.dependenciaNombre = dependenciaNombre;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    public Funcionario getDependenciaAdministrador() {
        return dependenciaAdministrador;
    }

    public void setDependenciaAdministrador(Funcionario dependenciaAdministrador) {
        this.dependenciaAdministrador = dependenciaAdministrador;
    }

    @XmlTransient
    public Collection<Labor> getLaborCollection() {
        return laborCollection;
    }

    public void setLaborCollection(Collection<Labor> laborCollection) {
        this.laborCollection = laborCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dependenciaId != null ? dependenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dependencia)) {
            return false;
        }
        Dependencia other = (Dependencia) object;
        if ((this.dependenciaId == null && other.dependenciaId != null) || (this.dependenciaId != null && !this.dependenciaId.equals(other.dependenciaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.Dependencia[ dependenciaId=" + dependenciaId + " ]";
    }
    
}
