package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mx.oneIt.api.model.Persona;

/**
 *
 * @author abel_
 */

public class PersonaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idPersona;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String celular;
    private String correo;
    private String correoInstitucional;
    private String rfc;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Integer indEstatus;
    private List<CursoImpartidoDTO> cursoImpartidoList;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;
    private EmpresaDTO idEmpresa;
    private List<UsuarioDTO> usuarioList;
    
    private Long idUsuario;
    private String nombreCompleto;

    public PersonaDTO() {
    }
    
    public PersonaDTO(Long idUsuario, Integer idPersona, String nombre, String primerApellido, String segundoApellido, String celular, String correo, String nombreCompleto) {
		super();
		this.idUsuario = idUsuario;
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.celular = celular;
		this.correo = correo;
		this.nombreCompleto = nombreCompleto;
	}

	public PersonaDTO(Integer idPersona) {
        this.idPersona = idPersona;
    }
    
    public PersonaDTO(Persona obj) {
		this.idPersona = obj.getIdPersona();
		this.nombre = obj.getNombre();
		this.primerApellido = obj.getPrimerApellido();
		this.segundoApellido = obj.getSegundoApellido();
		this.celular = obj.getCelular();
		this.correo = obj.getCorreo();
		this.correoInstitucional = obj.getCorreoInstitucional();
		this.rfc = obj.getRfc();
		if(obj.getIdEmpresa() != null && obj.getIdEmpresa().getIdEmpresa() != null ) {
			this.idEmpresa = new EmpresaDTO(obj.getIdEmpresa().getIdEmpresa());
		}
		
		this.fechaAlta = obj.getFechaAlta();
		this.usuarioAlta = new UsuarioDTO(obj.getUsuarioAlta()!=null && obj.getUsuarioAlta().getIdUsuario()!=null ? obj.getUsuarioAlta().getIdUsuario():null);
		this.usuarioModificacion= new UsuarioDTO(obj.getUsuarioModificacion()!=null && obj.getUsuarioModificacion().getIdUsuario()!=null ? obj.getUsuarioModificacion().getIdUsuario():null);
		this.fechaModificacion = obj.getFechaModificacion();
		this.indEstatus = obj.getIndEstatus();
		
	}
    

    public PersonaDTO(Integer idPersona, String nombre, String primerApellido, String segundoApellido, String celular, String correo, String correoInstitucional, Date fechaAlta) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.celular = celular;
        this.correo = correo;
        this.correoInstitucional = correoInstitucional;
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
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

    public List<CursoImpartidoDTO> getCursoImpartidoList() {
        return cursoImpartidoList;
    }

    public void setCursoImpartidoList(List<CursoImpartidoDTO> cursoImpartidoList) {
        this.cursoImpartidoList = cursoImpartidoList;
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

    public EmpresaDTO getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(EmpresaDTO idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public List<UsuarioDTO> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<UsuarioDTO> usuarioList) {
        this.usuarioList = usuarioList;
    }

    
    public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonaDTO)) {
            return false;
        }
        PersonaDTO other = (PersonaDTO) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonaDTO[ idPersona=" + idPersona + " ]";
    }
    
}
