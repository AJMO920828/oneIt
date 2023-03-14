package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abel_
 */
@Getter
@Setter
@Entity
@Table(name = "empresa")
public class Empresa extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    
    @Basic(optional = false)
    @Column(name = "nombre_contacto")
    private String nombreContacto;
    
    @Basic(optional = false)
    @Column(name = "correo_contacto")
    private String correoContacto;
    
    @Basic(optional = false)
    @Column(name = "telefono_contacto")
    private String telefonoContacto;
    
    @Basic(optional = false)
    @Column(name = "rfc")
    private String rfc;
    

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String nombre, String direccion, String nombreContacto, String correoContacto, String telefonoContacto, String rfc, Date fechaAlta) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreContacto = nombreContacto;
        this.correoContacto = correoContacto;
        this.telefonoContacto = telefonoContacto;
        this.rfc = rfc;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.idEmpresa == null && other.idEmpresa != null) || (this.idEmpresa != null && !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa[ idEmpresa=" + idEmpresa + " ]";
    }
    
}
