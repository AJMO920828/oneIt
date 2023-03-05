package com.mx.oneIt.api.dto;

import java.io.Serializable;

/**
 *
 * @author abel_
 */
public class UsuarioRolDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer idUsuarioRol;
    private UsuarioDTO idUsuario;
    private RolDTO idRol;

    public UsuarioRolDTO() {
    }

    public UsuarioRolDTO(Integer idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public Integer getIdUsuarioRol() {
        return idUsuarioRol;
    }

    public void setIdUsuarioRol(Integer idUsuarioRol) {
        this.idUsuarioRol = idUsuarioRol;
    }

    public UsuarioDTO getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTO idUsuario) {
        this.idUsuario = idUsuario;
    }

    public RolDTO getIdRol() {
        return idRol;
    }

    public void setIdRol(RolDTO idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioRol != null ? idUsuarioRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioRolDTO)) {
            return false;
        }
        UsuarioRolDTO other = (UsuarioRolDTO) object;
        if ((this.idUsuarioRol == null && other.idUsuarioRol != null) || (this.idUsuarioRol != null && !this.idUsuarioRol.equals(other.idUsuarioRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioRolDTO[ idUsuarioRol=" + idUsuarioRol + " ]";
    }
    
}
