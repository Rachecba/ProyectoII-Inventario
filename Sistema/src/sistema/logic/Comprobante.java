/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leaca
 */
@Entity
@Table(name = "comprobante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comprobante.findAll", query = "SELECT c FROM Comprobante c")})
public class Comprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comprobante_id")
    private Integer comprobanteId;
    @Basic(optional = false)
    @Column(name = "comprobante_fecha_de_adquisicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date comprobanteFechaDeAdquisicion;
    @Basic(optional = false)
    @Column(name = "comprobante_cant_bienes")
    private int comprobanteCantBienes;
    @Basic(optional = false)
    @Column(name = "comprobante_monto_total")
    private double comprobanteMontoTotal;
    @OneToOne(mappedBy = "solicitudComprobante")
    private Solicitud solicitud;
    @JoinColumn(name = "comprobante_tipo_de_adquisicion", referencedColumnName = "tipo_de_adquisicion_id")
    @ManyToOne(optional = false)
    private TipoDeAdquisicion comprobanteTipoDeAdquisicion;
    @OneToMany(mappedBy = "bienSolicitud")
    private Collection<Bien> bienCollection;

    public Comprobante() {
    }

    public Comprobante(Integer comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public Comprobante(Integer comprobanteId, Date comprobanteFechaDeAdquisicion, int comprobanteCantBienes, double comprobanteMontoTotal) {
        this.comprobanteId = comprobanteId;
        this.comprobanteFechaDeAdquisicion = comprobanteFechaDeAdquisicion;
        this.comprobanteCantBienes = comprobanteCantBienes;
        this.comprobanteMontoTotal = comprobanteMontoTotal;
    }

    public Integer getComprobanteId() {
        return comprobanteId;
    }

    public void setComprobanteId(Integer comprobanteId) {
        this.comprobanteId = comprobanteId;
    }

    public Date getComprobanteFechaDeAdquisicion() {
        return comprobanteFechaDeAdquisicion;
    }

    public void setComprobanteFechaDeAdquisicion(Date comprobanteFechaDeAdquisicion) {
        this.comprobanteFechaDeAdquisicion = comprobanteFechaDeAdquisicion;
    }

    public int getComprobanteCantBienes() {
        return comprobanteCantBienes;
    }

    public void setComprobanteCantBienes(int comprobanteCantBienes) {
        this.comprobanteCantBienes = comprobanteCantBienes;
    }

    public double getComprobanteMontoTotal() {
        return comprobanteMontoTotal;
    }

    public void setComprobanteMontoTotal(double comprobanteMontoTotal) {
        this.comprobanteMontoTotal = comprobanteMontoTotal;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public TipoDeAdquisicion getComprobanteTipoDeAdquisicion() {
        return comprobanteTipoDeAdquisicion;
    }

    public void setComprobanteTipoDeAdquisicion(TipoDeAdquisicion comprobanteTipoDeAdquisicion) {
        this.comprobanteTipoDeAdquisicion = comprobanteTipoDeAdquisicion;
    }

    @XmlTransient
    public Collection<Bien> getBienCollection() {
        return bienCollection;
    }

    public void setBienCollection(Collection<Bien> bienCollection) {
        this.bienCollection = bienCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comprobanteId != null ? comprobanteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comprobante)) {
            return false;
        }
        Comprobante other = (Comprobante) object;
        if ((this.comprobanteId == null && other.comprobanteId != null) || (this.comprobanteId != null && !this.comprobanteId.equals(other.comprobanteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(comprobanteId);
    }
    
}
