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
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f")
    , @NamedQuery(name = "Funcionario.findByFuncionarioId", query = "SELECT f FROM Funcionario f WHERE f.funcionarioId = :funcionarioId")
    , @NamedQuery(name = "Funcionario.findByFuncionarioNombre", query = "SELECT f FROM Funcionario f WHERE f.funcionarioNombre = :funcionarioNombre")
    , @NamedQuery(name = "Funcionario.findByFuncionarioRecibeSolicitud", query = "SELECT f FROM Funcionario f WHERE f.funcionarioRecibeSolicitud = :funcionarioRecibeSolicitud")
    , @NamedQuery(name = "Funcionario.findByFuncionarioCedula", query = "SELECT f FROM Funcionario f WHERE f.funcionarioCedula = :funcionarioCedula")})
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "funcionario_id")
    private Integer funcionarioId;
    @Basic(optional = false)
    @Column(name = "funcionario_nombre")
    private String funcionarioNombre;
    @Column(name = "funcionario_recibe_solicitud")
    private Boolean funcionarioRecibeSolicitud;
    @Basic(optional = false)
    @Column(name = "funcionario_cedula")
    private String funcionarioCedula;
    @OneToMany(mappedBy = "solicitudRegistradorDeBienes")
    private Collection<Solicitud> solicitudCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioFuncionario")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "dependenciaAdministrador")
    private Collection<Dependencia> dependenciaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laborFuncionario")
    private Collection<Labor> laborCollection;

    public Funcionario() {
    }

    public Funcionario(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Funcionario(Integer funcionarioId, String funcionarioNombre, String funcionarioCedula) {
        this.funcionarioId = funcionarioId;
        this.funcionarioNombre = funcionarioNombre;
        this.funcionarioCedula = funcionarioCedula;
    }

    public Integer getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Integer funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getFuncionarioNombre() {
        return funcionarioNombre;
    }

    public void setFuncionarioNombre(String funcionarioNombre) {
        this.funcionarioNombre = funcionarioNombre;
    }

    public Boolean getFuncionarioRecibeSolicitud() {
        return funcionarioRecibeSolicitud;
    }

    public void setFuncionarioRecibeSolicitud(Boolean funcionarioRecibeSolicitud) {
        this.funcionarioRecibeSolicitud = funcionarioRecibeSolicitud;
    }

    public String getFuncionarioCedula() {
        return funcionarioCedula;
    }

    public void setFuncionarioCedula(String funcionarioCedula) {
        this.funcionarioCedula = funcionarioCedula;
    }

    @XmlTransient
    public Collection<Solicitud> getSolicitudCollection() {
        return solicitudCollection;
    }

    public void setSolicitudCollection(Collection<Solicitud> solicitudCollection) {
        this.solicitudCollection = solicitudCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Dependencia> getDependenciaCollection() {
        return dependenciaCollection;
    }

    public void setDependenciaCollection(Collection<Dependencia> dependenciaCollection) {
        this.dependenciaCollection = dependenciaCollection;
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
        hash += (funcionarioId != null ? funcionarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
        if ((this.funcionarioId == null && other.funcionarioId != null) || (this.funcionarioId != null && !this.funcionarioId.equals(other.funcionarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.Funcionario[ funcionarioId=" + funcionarioId + " ]";
    }
    
}
