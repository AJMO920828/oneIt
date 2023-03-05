package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author abel_
 */
public class UsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idUsuario;
    private String usuario;
    private String password;
    private int idEstatus;
    private Integer indEstatus;
    private List<UsuarioRolDTO> usuarioRolList;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDTO(Long idUsuario, String usuario, String password, int idEstatus) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.idEstatus = idEstatus;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioDTO)) {
            return false;
        }
        UsuarioDTO other = (UsuarioDTO) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioDTO[ idUsuario=" + idUsuario + " ]";
    }
    
}
