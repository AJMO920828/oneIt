package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author abel_
 */
@Entity
@Table(name = "cat_maestro")
public class CatMaestro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cat_maestro")
    private Integer idCatMaestro;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    @Column(name = "ind_estatus")
    private Integer indEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCatMaestro")
    private List<CatDetalle> catDetalleList;
    @JoinColumn(name = "usuario_alta", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioAlta;
    @JoinColumn(name = "usuario_modificacion", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioModificacion;

    public CatMaestro() {
    }

    public CatMaestro(Integer idCatMaestro) {
        this.idCatMaestro = idCatMaestro;
    }

    public CatMaestro(Integer idCatMaestro, String descripcion, String clave, Date fechaAlta) {
        this.idCatMaestro = idCatMaestro;
        this.descripcion = descripcion;
        this.clave = clave;
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdCatMaestro() {
        return idCatMaestro;
    }

    public void setIdCatMaestro(Integer idCatMaestro) {
        this.idCatMaestro = idCatMaestro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIndEstatus() {
        return indEstatus;
    }

    public void setIndEstatus(Integer indEstatus) {
        this.indEstatus = indEstatus;
    }

    public List<CatDetalle> getCatDetalleList() {
        return catDetalleList;
    }

    public void setCatDetalleList(List<CatDetalle> catDetalleList) {
        this.catDetalleList = catDetalleList;
    }

    public Usuario getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(Usuario usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public Usuario getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(Usuario usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatMaestro != null ? idCatMaestro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatMaestro)) {
            return false;
        }
        CatMaestro other = (CatMaestro) object;
        if ((this.idCatMaestro == null && other.idCatMaestro != null) || (this.idCatMaestro != null && !this.idCatMaestro.equals(other.idCatMaestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CatMaestro[ idCatMaestro=" + idCatMaestro + " ]";
    }
    
}
