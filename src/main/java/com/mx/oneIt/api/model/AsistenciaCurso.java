package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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

/**
 *
 * @author abel_
 */
@Entity
@Table(name = "asistencia_curso")
public class AsistenciaCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asistencia_curso")
    private Integer idAsistenciaCurso;
    
    @Basic(optional = false)
    @Column(name = "num_asistencia")
    private int numAsistencia;
    
    @Basic(optional = false)
    @Column(name = "ind_asistencia")
    private int indAsistencia;
    
    @Column(name = "fecha_clase")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaClase;
    
    @Column(name = "fecha_asistencia")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAsistencia;
    
    @JoinColumn(name = "id_curso_impartido", referencedColumnName = "id_curso_impartido")
    @ManyToOne(optional = false)
    private CursoImpartido idCursoImpartido;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    
    
    
    @Basic(optional = false)
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Basic(optional = false)
    @Column(name = "ind_estatus")
    private int indEstatus;    
    
    @JoinColumn(name = "usuario_alta", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuarioAlta;
    
    @JoinColumn(name = "usuario_modificacion", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario usuarioModificacion;

    public AsistenciaCurso() {
    }

    public AsistenciaCurso(Integer idAsistenciaCurso) {
        this.idAsistenciaCurso = idAsistenciaCurso;
    }

    public AsistenciaCurso(Integer idAsistenciaCurso, int numAsistencia, int indAsistencia, Date fechaAlta, int indEstatus) {
        this.idAsistenciaCurso = idAsistenciaCurso;
        this.numAsistencia = numAsistencia;
        this.indAsistencia = indAsistencia;
        this.fechaAlta = fechaAlta;
        this.indEstatus = indEstatus;
    }

    public Integer getIdAsistenciaCurso() {
        return idAsistenciaCurso;
    }

    public void setIdAsistenciaCurso(Integer idAsistenciaCurso) {
        this.idAsistenciaCurso = idAsistenciaCurso;
    }

    public int getNumAsistencia() {
        return numAsistencia;
    }

    public void setNumAsistencia(int numAsistencia) {
        this.numAsistencia = numAsistencia;
    }

    public int getIndAsistencia() {
        return indAsistencia;
    }

    public void setIndAsistencia(int indAsistencia) {
        this.indAsistencia = indAsistencia;
    }

    public Date getFechaClase() {
        return fechaClase;
    }

    public void setFechaClase(Date fechaClase) {
        this.fechaClase = fechaClase;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
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

    public int getIndEstatus() {
        return indEstatus;
    }

    public void setIndEstatus(int indEstatus) {
        this.indEstatus = indEstatus;
    }

    public CursoImpartido getIdCursoImpartido() {
        return idCursoImpartido;
    }

    public void setIdCursoImpartido(CursoImpartido idCursoImpartido) {
        this.idCursoImpartido = idCursoImpartido;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsistenciaCurso != null ? idAsistenciaCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaCurso)) {
            return false;
        }
        AsistenciaCurso other = (AsistenciaCurso) object;
        if ((this.idAsistenciaCurso == null && other.idAsistenciaCurso != null) || (this.idAsistenciaCurso != null && !this.idAsistenciaCurso.equals(other.idAsistenciaCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AsistenciaCurso[ idAsistenciaCurso=" + idAsistenciaCurso + " ]";
    }
    
}
