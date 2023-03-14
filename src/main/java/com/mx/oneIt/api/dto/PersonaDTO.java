package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.Date;
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
public class PersonaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long idPersona;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String celular;
    private String correo;
    private String correoInstitucional;
    private String rfc;
    
    private String telefono;
    
    private DomicilioDTO domicilio;
    private List<EmpresaDTO> empresaList;
    private List<CursoImpartidoDTO> cursoImpartidoList;
    
    private Date fechaAlta;
    private Date fechaModificacion;
    private Integer indEstatus;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;
    
    private Long idUsuario;
    private String nombreCompleto;

    public PersonaDTO(Long idPersona) {
    	this.idPersona = idPersona;
    }

    @Override
    public String toString() {
        return "PersonaDTO[ idPersona=" + idPersona + " ]";
    }
    
}
