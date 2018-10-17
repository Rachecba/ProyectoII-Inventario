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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author leaca
 */
@Entity
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findBySolicitudId", query = "SELECT s FROM Solicitud s WHERE s.solicitudId = :solicitudId")
    , @NamedQuery(name = "Solicitud.findBySolicitudEstado", query = "SELECT s FROM Solicitud s WHERE s.solicitudEstado = :solicitudEstado")
    , @NamedQuery(name = "Solicitud.findBySolicitudDescripcionDeRechazo", query = "SELECT s FROM Solicitud s WHERE s.solicitudDescripcionDeRechazo = :solicitudDescripcionDeRechazo")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "solicitud_id")
    private Integer solicitudId;
    @Column(name = "solicitud_estado")
    private String solicitudEstado;
    @Column(name = "solicitud_descripcion_de_rechazo")
    private String solicitudDescripcionDeRechazo;
    @JoinColumn(name = "solicitud_comprobante", referencedColumnName = "comprobante_id")
    @OneToOne
    private Comprobante solicitudComprobante;
    @JoinColumn(name = "solicitud_dependencia", referencedColumnName = "dependencia_id")
    @ManyToOne
    private Dependencia solicitudDependencia;
    @JoinColumn(name = "solicitud_registrador_de_bienes", referencedColumnName = "funcionario_id")
    @ManyToOne
    private Funcionario solicitudRegistradorDeBienes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bienSolicitud")
    private Collection<Bien> bienCollection;

    public Solicitud() {
    }

    public Solicitud(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Integer getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Integer solicitudId) {
        this.solicitudId = solicitudId;
    }

    public String getSolicitudEstado() {
        return solicitudEstado;
    }

    public void setSolicitudEstado(String solicitudEstado) {
        this.solicitudEstado = solicitudEstado;
    }

    public String getSolicitudDescripcionDeRechazo() {
        return solicitudDescripcionDeRechazo;
    }

    public void setSolicitudDescripcionDeRechazo(String solicitudDescripcionDeRechazo) {
        this.solicitudDescripcionDeRechazo = solicitudDescripcionDeRechazo;
    }

    public Comprobante getSolicitudComprobante() {
        return solicitudComprobante;
    }

    public void setSolicitudComprobante(Comprobante solicitudComprobante) {
        this.solicitudComprobante = solicitudComprobante;
    }

    public Dependencia getSolicitudDependencia() {
        return solicitudDependencia;
    }

    public void setSolicitudDependencia(Dependencia solicitudDependencia) {
        this.solicitudDependencia = solicitudDependencia;
    }

    public Funcionario getSolicitudRegistradorDeBienes() {
        return solicitudRegistradorDeBienes;
    }

    public void setSolicitudRegistradorDeBienes(Funcionario solicitudRegistradorDeBienes) {
        this.solicitudRegistradorDeBienes = solicitudRegistradorDeBienes;
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
        hash += (solicitudId != null ? solicitudId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.solicitudId == null && other.solicitudId != null) || (this.solicitudId != null && !this.solicitudId.equals(other.solicitudId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.Solicitud[ solicitudId=" + solicitudId + " ]";
    }
    
}
