package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abel_
 */

public class CatMaestroDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idCatMaestro;
    private String descripcion;
    private String clave;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Integer indEstatus;
    private List<CatDetalleDTO> catDetalleList;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;

    public CatMaestroDTO() {
    }

    public CatMaestroDTO(Integer idCatMaestro) {
        this.idCatMaestro = idCatMaestro;
    }

    public CatMaestroDTO(Integer idCatMaestro, String descripcion, String clave, Date fechaAlta) {
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

    public List<CatDetalleDTO> getCatDetalleList() {
        return catDetalleList;
    }

    public void setCatDetalleList(List<CatDetalleDTO> catDetalleList) {
        this.catDetalleList = catDetalleList;
    }

    public UsuarioDTO getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(UsuarioDTO usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public UsuarioDTO getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(UsuarioDTO usuarioModificacion) {
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
        if (!(object instanceof CatMaestroDTO)) {
            return false;
        }
        CatMaestroDTO other = (CatMaestroDTO) object;
        if ((this.idCatMaestro == null && other.idCatMaestro != null) || (this.idCatMaestro != null && !this.idCatMaestro.equals(other.idCatMaestro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CatMaestroDTO[ idCatMaestro=" + idCatMaestro + " ]";
    }
    
}
