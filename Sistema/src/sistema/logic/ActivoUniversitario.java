/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.logic;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author leaca
 */
@Entity
@Table(name = "activo_universitario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivoUniversitario.findAll", query = "SELECT a FROM ActivoUniversitario a")
    , @NamedQuery(name = "ActivoUniversitario.findByActivosUniversitarioId", query = "SELECT a FROM ActivoUniversitario a WHERE a.activosUniversitarioId = :activosUniversitarioId")
    , @NamedQuery(name = "ActivoUniversitario.findByActivoUniversitarioCodigo", query = "SELECT a FROM ActivoUniversitario a WHERE a.activoUniversitarioCodigo = :activoUniversitarioCodigo")
    , @NamedQuery(name = "ActivoUniversitario.findByActivoUniversitarioDescripcion", query = "SELECT a FROM ActivoUniversitario a WHERE a.activoUniversitarioDescripcion = :activoUniversitarioDescripcion")
    , @NamedQuery(name = "ActivoUniversitario.findByActivoUniversitarioRegistrado", query = "SELECT a FROM ActivoUniversitario a WHERE a.activoUniversitarioRegistrado = :activoUniversitarioRegistrado")})
public class ActivoUniversitario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "activos_universitario_id")
    private Integer activosUniversitarioId;
    @Column(name = "activo_universitario_codigo")
    private String activoUniversitarioCodigo;
    @Column(name = "activo_universitario_descripcion")
    private String activoUniversitarioDescripcion;
    @Column(name = "activo_universitario_registrado")
    private Boolean activoUniversitarioRegistrado;
    @JoinColumn(name = "activo_universitario_bien", referencedColumnName = "bien_id")
    @ManyToOne
    private Bien activoUniversitarioBien;
    @JoinColumn(name = "activo_universitario_categoria", referencedColumnName = "categoria_id")
    @ManyToOne
    private Categoria activoUniversitarioCategoria;
    @JoinColumn(name = "activo_universitario_responsable", referencedColumnName = "labor_id")
    @ManyToOne
    private Labor activoUniversitarioResponsable;

    public ActivoUniversitario() {
    }

    public ActivoUniversitario(Integer activosUniversitarioId) {
        this.activosUniversitarioId = activosUniversitarioId;
    }

    public Integer getActivosUniversitarioId() {
        return activosUniversitarioId;
    }

    public void setActivosUniversitarioId(Integer activosUniversitarioId) {
        this.activosUniversitarioId = activosUniversitarioId;
    }

    public String getActivoUniversitarioCodigo() {
        return activoUniversitarioCodigo;
    }

    public void setActivoUniversitarioCodigo(String activoUniversitarioCodigo) {
        this.activoUniversitarioCodigo = activoUniversitarioCodigo;
    }

    public String getActivoUniversitarioDescripcion() {
        return activoUniversitarioDescripcion;
    }

    public void setActivoUniversitarioDescripcion(String activoUniversitarioDescripcion) {
        this.activoUniversitarioDescripcion = activoUniversitarioDescripcion;
    }

    public Boolean getActivoUniversitarioRegistrado() {
        return activoUniversitarioRegistrado;
    }

    public void setActivoUniversitarioRegistrado(Boolean activoUniversitarioRegistrado) {
        this.activoUniversitarioRegistrado = activoUniversitarioRegistrado;
    }

    public Bien getActivoUniversitarioBien() {
        return activoUniversitarioBien;
    }

    public void setActivoUniversitarioBien(Bien activoUniversitarioBien) {
        this.activoUniversitarioBien = activoUniversitarioBien;
    }

    public Categoria getActivoUniversitarioCategoria() {
        return activoUniversitarioCategoria;
    }

    public void setActivoUniversitarioCategoria(Categoria activoUniversitarioCategoria) {
        this.activoUniversitarioCategoria = activoUniversitarioCategoria;
    }

    public Labor getActivoUniversitarioResponsable() {
        return activoUniversitarioResponsable;
    }

    public void setActivoUniversitarioResponsable(Labor activoUniversitarioResponsable) {
        this.activoUniversitarioResponsable = activoUniversitarioResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activosUniversitarioId != null ? activosUniversitarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivoUniversitario)) {
            return false;
        }
        ActivoUniversitario other = (ActivoUniversitario) object;
        if ((this.activosUniversitarioId == null && other.activosUniversitarioId != null) || (this.activosUniversitarioId != null && !this.activosUniversitarioId.equals(other.activosUniversitarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sistema.logic.ActivoUniversitario[ activosUniversitarioId=" + activosUniversitarioId + " ]";
    }
    
}
