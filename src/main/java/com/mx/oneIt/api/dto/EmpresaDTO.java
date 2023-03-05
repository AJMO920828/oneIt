package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abel_
 */
public class EmpresaDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idEmpresa;
    private String nombre;
    private String direccion;
    private String nombreContacto;
    private String correoContacto;
    private String telefonoContacto;
    private String rfc;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Integer indEstatus;
    private List<PersonaDTO> personaList;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;

    public EmpresaDTO() {
    }

    public EmpresaDTO(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public EmpresaDTO(Integer idEmpresa, String nombre, String direccion, String nombreContacto, String correoContacto, String telefonoContacto, String rfc, Date fechaAlta) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreContacto = nombreContacto;
        this.correoContacto = correoContacto;
        this.telefonoContacto = telefonoContacto;
        this.rfc = rfc;
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getCorreoContacto() {
        return correoContacto;
    }

    public void setCorreoContacto(String correoContacto) {
        this.correoContacto = correoContacto;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
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

    public List<PersonaDTO> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<PersonaDTO> personaList) {
        this.personaList = personaList;
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
        hash += (idEmpresa != null ? idEmpresa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpresaDTO)) {
            return false;
        }
        EmpresaDTO other = (EmpresaDTO) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmpresaDTO[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
