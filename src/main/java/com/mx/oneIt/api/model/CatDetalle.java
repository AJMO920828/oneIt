package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "cat_detalle")
public class CatDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cat_detalle")
    private Integer idCatDetalle;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "clave")
    private String clave;

    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "ind_estatus")
    private Integer indEstatus;
    
    @JoinColumn(name = "usuario_alta", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioAlta;
    
    @JoinColumn(name = "usuario_modificacion", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioModificacion;
    
    @JoinColumn(name = "id_cat_maestro", referencedColumnName = "id_cat_maestro")
    @ManyToOne
    private CatMaestro idCatMaestro;
    

    public CatDetalle() {
    }

    public CatDetalle(Integer idCatDetalle) {
        this.idCatDetalle = idCatDetalle;
    }

    public CatDetalle(Integer idCatDetalle, String descripcion, String clave, Date fechaAlta) {
        this.idCatDetalle = idCatDetalle;
        this.descripcion = descripcion;
        this.clave = clave;
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdCatDetalle() {
        return idCatDetalle;
    }

    public void setIdCatDetalle(Integer idCatDetalle) {
        this.idCatDetalle = idCatDetalle;
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

    public CatMaestro getIdCatMaestro() {
        return idCatMaestro;
    }

    public void setIdCatMaestro(CatMaestro idCatMaestro) {
        this.idCatMaestro = idCatMaestro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatDetalle != null ? idCatDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatDetalle)) {
            return false;
        }
        CatDetalle other = (CatDetalle) object;
        if ((this.idCatDetalle == null && other.idCatDetalle != null) || (this.idCatDetalle != null && !this.idCatDetalle.equals(other.idCatDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CatDetalle[ idCatDetalle=" + idCatDetalle + " ]";
    }
    
}
