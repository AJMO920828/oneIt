package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.mx.oneIt.api.dto.PersonaDTO;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abel_
 */
@Getter
@Setter
@Entity
@Table(name = "persona")
public class Persona extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;
    
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

    @Column(name = "id_usuario")
    private Long idUsuario;
    
    
  

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
		
	}

	public Persona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Long idPersona, String nombre, String primerApellido, String segundoApellido, String celular, String correo, String correoInstitucional, Date fechaAlta) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.celular = celular;
        this.correo = correo;
        this.correoInstitucional = correoInstitucional;
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
