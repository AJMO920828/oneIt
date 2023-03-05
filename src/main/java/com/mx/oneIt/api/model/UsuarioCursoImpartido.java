package com.mx.oneIt.api.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author abel_
 */
@Entity
@Table(name = "usuario_curso_impartido")
public class UsuarioCursoImpartido implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario_curso_impartido")
    private Integer idUsuarioCursoImpartido;
    
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    
    @ManyToOne
	@JoinColumn(name="id_curso_impartido")
    private CursoImpartido idCursoImpartido;
    

    public UsuarioCursoImpartido() {
    }


	public Integer getIdUsuarioCursoImpartido() {
		return idUsuarioCursoImpartido;
	}


	public void setIdUsuarioCursoImpartido(Integer idUsuarioCursoImpartido) {
		this.idUsuarioCursoImpartido = idUsuarioCursoImpartido;
	}


	public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public CursoImpartido getIdCursoImpartido() {
		return idCursoImpartido;
	}

	public void setIdCursoImpartido(CursoImpartido idCursoImpartido) {
		this.idCursoImpartido = idCursoImpartido;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoImpartido != null ? idCursoImpartido.hashCode() : 0);
        hash += (idUsuario != null ? idUsuario.hashCode() : hash);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioCursoImpartido)) {
            return false;
        }
        UsuarioCursoImpartido other = (UsuarioCursoImpartido) object;
        if ((this.idCursoImpartido == null && other.idCursoImpartido != null) || (this.idCursoImpartido != null && !this.idCursoImpartido.equals(other.idCursoImpartido)) &&
        		(this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UsuarioRol[ idUsuarioRol=" + idUsuario + " idCursoImpartido=" + idCursoImpartido + " ]";
    }
    
}
