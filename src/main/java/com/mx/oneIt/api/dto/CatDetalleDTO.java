package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class CatDetalleDTO implements Serializable {

    private static final long serialVersionUID = 1L;
   
    private Integer idCatDetalle;
    private String descripcion;
    private String clave;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Integer indEstatus;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;
    private CatMaestroDTO idCatMaestro;
    private List<CursoImpartidoDTO> cursoImpartidoList;

    public CatDetalleDTO() {
    }

    public CatDetalleDTO(Integer idCatDetalle) {
        this.idCatDetalle = idCatDetalle;
    }

    public CatDetalleDTO(Integer idCatDetalle, String descripcion, String clave, Date fechaAlta) {
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

    public CatMaestroDTO getIdCatMaestro() {
        return idCatMaestro;
    }

    public void setIdCatMaestro(CatMaestroDTO idCatMaestro) {
        this.idCatMaestro = idCatMaestro;
    }

    public List<CursoImpartidoDTO> getCursoImpartidoList() {
        return cursoImpartidoList;
    }

    public void setCursoImpartidoList(List<CursoImpartidoDTO> cursoImpartidoList) {
        this.cursoImpartidoList = cursoImpartidoList;
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
        if (!(object instanceof CatDetalleDTO)) {
            return false;
        }
        CatDetalleDTO other = (CatDetalleDTO) object;
        if ((this.idCatDetalle == null && other.idCatDetalle != null) || (this.idCatDetalle != null && !this.idCatDetalle.equals(other.idCatDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CatDetalleDTO[ idCatDetalle=" + idCatDetalle + " ]";
    }
    
}
