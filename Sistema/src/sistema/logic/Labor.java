/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "labor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Labor.findAll", query = "SELECT l FROM Labor l")})
public class Labor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "labor_id")
    private Integer laborId;
    @OneToMany(mappedBy = "activoUniversitarioResponsable")
    private Collection<ActivoUniversitario> activoUniversitarioCollection;
    //@OneToMany(mappedBy = "funcionarioLabor")
    private Collection<Funcionario> funcionarioCollection;
    @JoinColumn(name = "labor_dependencia", referencedColumnName = "dependencia_id")
    @ManyToOne
    private Dependencia laborDependencia;
    @JoinColumn(name = "labor_puesto", referencedColumnName = "puesto_id")
    @ManyToOne
    private Puesto laborPuesto;

    public Labor() {
    }

    public Labor(Integer laborId) {
        this.laborId = laborId;
    }

    public Integer getLaborId() {
        return laborId;
    }

    public void setLaborId(Integer laborId) {
        this.laborId = laborId;
    }

    @XmlTransient
    public Collection<ActivoUniversitario> getActivoUniversitarioCollection() {
        return activoUniversitarioCollection;
    }

    public void setActivoUniversitarioCollection(Collection<ActivoUniversitario> activoUniversitarioCollection) {
        this.activoUniversitarioCollection = activoUniversitarioCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
    }

    public Dependencia getLaborDependencia() {
        return laborDependencia;
    }

    public void setLaborDependencia(Dependencia laborDependencia) {
        this.laborDependencia = laborDependencia;
    }

    public Puesto getLaborPuesto() {
        return laborPuesto;
    }

    public void setLaborPuesto(Puesto laborPuesto) {
        this.laborPuesto = laborPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (laborId != null ? laborId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Labor)) {
            return false;
        }
        Labor other = (Labor) object;
        if ((this.laborId == null && other.laborId != null) || (this.laborId != null && !this.laborId.equals(other.laborId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.Labor[ laborId=" + laborId + " ]";
    }
    
}
