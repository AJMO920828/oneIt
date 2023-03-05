package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author abel_
 */
public class AsistenciaCursoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idAsistenciaCurso;
    private int numAsistencia;
    private int indAsistencia;
    private Date fechaClase;
    private Date fechaAsistencia;
    private Date fechaAlta;
    private Date fechaModificacion;
    private int indEstatus;
    private CursoImpartidoDTO idCursoImpartido;
    private UsuarioDTO idUsuario;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;

    public AsistenciaCursoDTO() {
    }

    public AsistenciaCursoDTO(Integer idAsistenciaCurso) {
        this.idAsistenciaCurso = idAsistenciaCurso;
    }

    public AsistenciaCursoDTO(Integer idAsistenciaCurso, int numAsistencia, int indAsistencia, Date fechaAlta, int indEstatus) {
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

    public CursoImpartidoDTO getIdCursoImpartido() {
        return idCursoImpartido;
    }

    public void setIdCursoImpartido(CursoImpartidoDTO idCursoImpartido) {
        this.idCursoImpartido = idCursoImpartido;
    }

    public UsuarioDTO getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuarioDTO idUsuario) {
        this.idUsuario = idUsuario;
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
        hash += (idAsistenciaCurso != null ? idAsistenciaCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistenciaCursoDTO)) {
            return false;
        }
        AsistenciaCursoDTO other = (AsistenciaCursoDTO) object;
        if ((this.idAsistenciaCurso == null && other.idAsistenciaCurso != null) || (this.idAsistenciaCurso != null && !this.idAsistenciaCurso.equals(other.idAsistenciaCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AsistenciaCursoDTO[ idAsistenciaCurso=" + idAsistenciaCurso + " ]";
    }
    
}
