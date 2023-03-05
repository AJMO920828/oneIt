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
import com.mx.oneIt.api.dto.PersonaDTO;

/**
 *
 * @author abel_
 */
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "primer_apellido")
    private String primerApellido;
    
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    
    @Column(name = "celular")
    private String celular;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "correo_institucional")
    private String correoInstitucional;
    
    @Column(name = "rfc")
    private String rfc;
    
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
    
    @JoinColumn(name = "id_empresa")
    @ManyToOne
    private Empresa idEmpresa;
    
    
  

	public Persona() {
    }

    public Persona(PersonaDTO obj) {
		super();
		this.idPersona = obj.getIdPersona();
		this.nombre = obj.getNombre();
		this.primerApellido = obj.getPrimerApellido();
		this.segundoApellido = obj.getSegundoApellido();
		this.celular = obj.getCelular();
		this.correo = obj.getCorreo();
		this.correoInstitucional = obj.getCorreoInstitucional();
		this.rfc = obj.getRfc();
		if(obj.getIdEmpresa() != null && obj.getIdEmpresa().getIdEmpresa() != null ) {
			this.idEmpresa = new Empresa(obj.getIdEmpresa().getIdEmpresa());
		}
		
		this.fechaAlta = new Date();
		this.usuarioAlta = new Usuario(obj.getUsuarioAlta().getIdUsuario());
		if(this.idPersona != null) {
			this.usuarioModificacion.setIdUsuario(obj.getUsuarioModificacion().getIdUsuario());
			this.fechaModificacion = new Date();
		}
		this.indEstatus = obj.getIndEstatus();
		
	}

	public Persona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Integer idPersona, String nombre, String primerApellido, String segundoApellido, String celular, String correo, String correoInstitucional, Date fechaAlta) {
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

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona[ idPersona=" + idPersona + " ]";
    }
    
}
