package com.mx.oneIt.api.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author abel_
 */
@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO{

    
    private Long idUsuario;
    private String usuario;
    private String password;
    private Integer idEstatus;
    private String descEstatus;
    private String roles;
    private int indEstatus;
    private List<UsuarioRolDTO> usuarioRolList;
    
    private PersonaDTO persona;

    public UsuarioDTO(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDTO(Long idUsuario, String usuario, String password, Integer idEstatus) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.idEstatus = idEstatus;
    }

    @Override
    public String toString() {
        return "UsuarioDTO[ idUsuario=" + idUsuario + " ]";
    }
    
}
