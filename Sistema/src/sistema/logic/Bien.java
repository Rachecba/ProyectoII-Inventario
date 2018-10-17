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
@Table(name = "bien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bien.findAll", query = "SELECT b FROM Bien b")
    , @NamedQuery(name = "Bien.findByBienId", query = "SELECT b FROM Bien b WHERE b.bienId = :bienId")
    , @NamedQuery(name = "Bien.findByBienDescripcion", query = "SELECT b FROM Bien b WHERE b.bienDescripcion = :bienDescripcion")
    , @NamedQuery(name = "Bien.findByBienMarca", query = "SELECT b FROM Bien b WHERE b.bienMarca = :bienMarca")
    , @NamedQuery(name = "Bien.findByBienModelo", query = "SELECT b FROM Bien b WHERE b.bienModelo = :bienModelo")
    , @NamedQuery(name = "Bien.findByBienPrecio", query = "SELECT b FROM Bien b WHERE b.bienPrecio = :bienPrecio")
    , @NamedQuery(name = "Bien.findByBienCantidad", query = "SELECT b FROM Bien b WHERE b.bienCantidad = :bienCantidad")})
public class Bien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bien_id")
    private Integer bienId;
    @Column(name = "bien_descripcion")
    private String bienDescripcion;
    @Column(name = "bien_marca")
    private String bienMarca;
    @Column(name = "bien_modelo")
    private String bienModelo;
    @Basic(optional = false)
    @Column(name = "bien_precio")
    private double bienPrecio;
    @Basic(optional = false)
    @Column(name = "bien_cantidad")
    private int bienCantidad;
    @OneToMany(mappedBy = "activoUniversitarioBien")
    private Collection<ActivoUniversitario> activoUniversitarioCollection;
    @JoinColumn(name = "bien_solicitud", referencedColumnName = "solicitud_id")
    @ManyToOne(optional = false)
    private Solicitud bienSolicitud;

    public Bien() {
    }

    public Bien(Integer bienId) {
        this.bienId = bienId;
    }

    public Bien(Integer bienId, double bienPrecio, int bienCantidad) {
        this.bienId = bienId;
        this.bienPrecio = bienPrecio;
        this.bienCantidad = bienCantidad;
    }

    public Integer getBienId() {
        return bienId;
    }

    public void setBienId(Integer bienId) {
        this.bienId = bienId;
    }

    public String getBienDescripcion() {
        return bienDescripcion;
    }

    public void setBienDescripcion(String bienDescripcion) {
        this.bienDescripcion = bienDescripcion;
    }

    public String getBienMarca() {
        return bienMarca;
    }

    public void setBienMarca(String bienMarca) {
        this.bienMarca = bienMarca;
    }

    public String getBienModelo() {
        return bienModelo;
    }

    public void setBienModelo(String bienModelo) {
        this.bienModelo = bienModelo;
    }

    public double getBienPrecio() {
        return bienPrecio;
    }

    public void setBienPrecio(double bienPrecio) {
        this.bienPrecio = bienPrecio;
    }

    public int getBienCantidad() {
        return bienCantidad;
    }

    public void setBienCantidad(int bienCantidad) {
        this.bienCantidad = bienCantidad;
    }

    @XmlTransient
    public Collection<ActivoUniversitario> getActivoUniversitarioCollection() {
        return activoUniversitarioCollection;
    }

    public void setActivoUniversitarioCollection(Collection<ActivoUniversitario> activoUniversitarioCollection) {
        this.activoUniversitarioCollection = activoUniversitarioCollection;
    }

    public Solicitud getBienSolicitud() {
        return bienSolicitud;
    }

    public void setBienSolicitud(Solicitud bienSolicitud) {
        this.bienSolicitud = bienSolicitud;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bienId != null ? bienId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bien)) {
            return false;
        }
        Bien other = (Bien) object;
        if ((this.bienId == null && other.bienId != null) || (this.bienId != null && !this.bienId.equals(other.bienId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.Bien[ bienId=" + bienId + " ]";
    }
    
}
