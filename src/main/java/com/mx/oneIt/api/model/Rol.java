package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author abel_
 */
@Entity
@Table(name = "rol")
@Getter
@Setter
public class Rol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;
    
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "clave")
    private String claveRol;
    
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "ind_estatus")
    private Integer indEstatus;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol")
    private List<UsuarioRol> usuarioRolList;
    
    @JoinColumn(name = "usuario_alta")
    @ManyToOne
    private Usuario usuarioAlta;
    
    @JoinColumn(name = "usuario_modificacion")
    @ManyToOne
    private Usuario usuarioModificacion;

    public Rol() {
    }

    public Rol(Integer idRol) {
        this.idRol = idRol;
    }

    public Rol(Integer idRol, String descripcion, String claveRol, Date fechaAlta) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.claveRol = claveRol;
        this.fechaAlta = fechaAlta;
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
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rol[ idRol=" + idRol + " ]";
    }
    
}
