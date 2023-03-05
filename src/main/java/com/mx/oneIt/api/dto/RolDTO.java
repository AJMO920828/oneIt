package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abel_
 */
public class RolDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idRol;
    private String descripcion;
    private String claveRol;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Integer indEstatus;
    private List<UsuarioRolDTO> usuarioRolList;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;

    public RolDTO() {
    }

    public RolDTO(Integer idRol) {
        this.idRol = idRol;
    }

    public RolDTO(Integer idRol, String descripcion, String claveRol, Date fechaAlta) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.claveRol = claveRol;
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getClaveRol() {
        return claveRol;
    }

    public void setClaveRol(String claveRol) {
        this.claveRol = claveRol;
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

    public List<UsuarioRolDTO> getUsuarioRolList() {
        return usuarioRolList;
    }

    public void setUsuarioRolList(List<UsuarioRolDTO> usuarioRolList) {
        this.usuarioRolList = usuarioRolList;
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
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolDTO)) {
            return false;
        }
        RolDTO other = (RolDTO) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolDTO[ idRol=" + idRol + " ]";
    }
    
}
