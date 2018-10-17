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
@Table(name = "puesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puesto.findAll", query = "SELECT p FROM Puesto p")
    , @NamedQuery(name = "Puesto.findByPuestoId", query = "SELECT p FROM Puesto p WHERE p.puestoId = :puestoId")
    , @NamedQuery(name = "Puesto.findByPuestoNombre", query = "SELECT p FROM Puesto p WHERE p.puestoNombre = :puestoNombre")})
public class Puesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "puesto_id")
    private Integer puestoId;
    @Column(name = "puesto_nombre")
    private String puestoNombre;
    @OneToMany(mappedBy = "laborPuesto")
    private Collection<Labor> laborCollection;

    public Puesto() {
    }

    public Puesto(Integer puestoId) {
        this.puestoId = puestoId;
    }

    public Integer getPuestoId() {
        return puestoId;
    }

    public void setPuestoId(Integer puestoId) {
        this.puestoId = puestoId;
    }

    public String getPuestoNombre() {
        return puestoNombre;
    }

    public void setPuestoNombre(String puestoNombre) {
        this.puestoNombre = puestoNombre;
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
        hash += (puestoId != null ? puestoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puesto)) {
            return false;
        }
        Puesto other = (Puesto) object;
        if ((this.puestoId == null && other.puestoId != null) || (this.puestoId != null && !this.puestoId.equals(other.puestoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.Puesto[ puestoId=" + puestoId + " ]";
    }
    
}
