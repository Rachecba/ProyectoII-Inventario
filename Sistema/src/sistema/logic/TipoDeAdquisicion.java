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
@Table(name = "tipo_de_adquisicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDeAdquisicion.findAll", query = "SELECT t FROM TipoDeAdquisicion t")})
public class TipoDeAdquisicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo_de_adquisicion_id")
    private Integer tipoDeAdquisicionId;
    @Basic(optional = false)
    @Column(name = "tipo_de_adquisicion_nombre")
    private String tipoDeAdquisicionNombre;
    @Basic(optional = false)
    @Column(name = "tipo_de_adquisicion_despcripcion")
    private String tipoDeAdquisicionDespcripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobanteTipoDeAdquisicion")
    private Collection<Comprobante> comprobanteCollection;

    public TipoDeAdquisicion() {
    }

    public TipoDeAdquisicion(Integer tipoDeAdquisicionId) {
        this.tipoDeAdquisicionId = tipoDeAdquisicionId;
    }

    public TipoDeAdquisicion(Integer tipoDeAdquisicionId, String tipoDeAdquisicionNombre, String tipoDeAdquisicionDespcripcion) {
        this.tipoDeAdquisicionId = tipoDeAdquisicionId;
        this.tipoDeAdquisicionNombre = tipoDeAdquisicionNombre;
        this.tipoDeAdquisicionDespcripcion = tipoDeAdquisicionDespcripcion;
    }

    public Integer getTipoDeAdquisicionId() {
        return tipoDeAdquisicionId;
    }

    public void setTipoDeAdquisicionId(Integer tipoDeAdquisicionId) {
        this.tipoDeAdquisicionId = tipoDeAdquisicionId;
    }

    public String getTipoDeAdquisicionNombre() {
        return tipoDeAdquisicionNombre;
    }

    public void setTipoDeAdquisicionNombre(String tipoDeAdquisicionNombre) {
        this.tipoDeAdquisicionNombre = tipoDeAdquisicionNombre;
    }

    public String getTipoDeAdquisicionDespcripcion() {
        return tipoDeAdquisicionDespcripcion;
    }

    public void setTipoDeAdquisicionDespcripcion(String tipoDeAdquisicionDespcripcion) {
        this.tipoDeAdquisicionDespcripcion = tipoDeAdquisicionDespcripcion;
    }

    @XmlTransient
    public Collection<Comprobante> getComprobanteCollection() {
        return comprobanteCollection;
    }

    public void setComprobanteCollection(Collection<Comprobante> comprobanteCollection) {
        this.comprobanteCollection = comprobanteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoDeAdquisicionId != null ? tipoDeAdquisicionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeAdquisicion)) {
            return false;
        }
        TipoDeAdquisicion other = (TipoDeAdquisicion) object;
        if ((this.tipoDeAdquisicionId == null && other.tipoDeAdquisicionId != null) || (this.tipoDeAdquisicionId != null && !this.tipoDeAdquisicionId.equals(other.tipoDeAdquisicionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return tipoDeAdquisicionNombre;
    }
    
}
