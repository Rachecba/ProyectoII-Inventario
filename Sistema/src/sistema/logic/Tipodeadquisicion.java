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
@Table(name = "tipodeadquisicion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipodeadquisicion.findAll", query = "SELECT t FROM Tipodeadquisicion t")
    , @NamedQuery(name = "Tipodeadquisicion.findByTipoDeAdquisicionid", query = "SELECT t FROM Tipodeadquisicion t WHERE t.tipoDeAdquisicionid = :tipoDeAdquisicionid")
    , @NamedQuery(name = "Tipodeadquisicion.findByTipodeadquisicionNombre", query = "SELECT t FROM Tipodeadquisicion t WHERE t.tipodeadquisicionNombre = :tipodeadquisicionNombre")
    , @NamedQuery(name = "Tipodeadquisicion.findByTipodeadquisicionDespcripcion", query = "SELECT t FROM Tipodeadquisicion t WHERE t.tipodeadquisicionDespcripcion = :tipodeadquisicionDespcripcion")})
public class Tipodeadquisicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipoDeAdquisicion_id")
    private Integer tipoDeAdquisicionid;
    @Basic(optional = false)
    @Column(name = "tipodeadquisicion_nombre")
    private String tipodeadquisicionNombre;
    @Basic(optional = false)
    @Column(name = "tipodeadquisicion_despcripcion")
    private String tipodeadquisicionDespcripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comprobanteTipoDeAdquisicion")
    private Collection<Comprobante> comprobanteCollection;

    public Tipodeadquisicion() {
    }

    public Tipodeadquisicion(Integer tipoDeAdquisicionid) {
        this.tipoDeAdquisicionid = tipoDeAdquisicionid;
    }

    public Tipodeadquisicion(Integer tipoDeAdquisicionid, String tipodeadquisicionNombre, String tipodeadquisicionDespcripcion) {
        this.tipoDeAdquisicionid = tipoDeAdquisicionid;
        this.tipodeadquisicionNombre = tipodeadquisicionNombre;
        this.tipodeadquisicionDespcripcion = tipodeadquisicionDespcripcion;
    }

    public Integer getTipoDeAdquisicionid() {
        return tipoDeAdquisicionid;
    }

    public void setTipoDeAdquisicionid(Integer tipoDeAdquisicionid) {
        this.tipoDeAdquisicionid = tipoDeAdquisicionid;
    }

    public String getTipodeadquisicionNombre() {
        return tipodeadquisicionNombre;
    }

    public void setTipodeadquisicionNombre(String tipodeadquisicionNombre) {
        this.tipodeadquisicionNombre = tipodeadquisicionNombre;
    }

    public String getTipodeadquisicionDespcripcion() {
        return tipodeadquisicionDespcripcion;
    }

    public void setTipodeadquisicionDespcripcion(String tipodeadquisicionDespcripcion) {
        this.tipodeadquisicionDespcripcion = tipodeadquisicionDespcripcion;
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
        hash += (tipoDeAdquisicionid != null ? tipoDeAdquisicionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipodeadquisicion)) {
            return false;
        }
        Tipodeadquisicion other = (Tipodeadquisicion) object;
        if ((this.tipoDeAdquisicionid == null && other.tipoDeAdquisicionid != null) || (this.tipoDeAdquisicionid != null && !this.tipoDeAdquisicionid.equals(other.tipoDeAdquisicionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.Tipodeadquisicion[ tipoDeAdquisicionid=" + tipoDeAdquisicionid + " ]";
    }
    
}
