package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.mx.oneIt.api.dto.CursoImpartidoDTO;

/**
 *
 * @author abel_
 */
@Entity
@Table(name = "curso_impartido")
public class CursoImpartido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso_impartido")
    private Integer idCursoImpartido;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIME)
    private Date horaFin;
    
    @Column(name = "dias_curos")
    private String diasCurso;
    
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    
    @Column(name = "total_sesiones")
    private int totalSesiones;
    
    @Column(name = "total_horas")
    private int totalHoras;
    
    @Column(name = "id_empresa")
    private Integer idEmpresa;
    
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;
    
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
    
    @Column(name = "ind_estatus")
    private Integer indEstatus;
    
    @JoinColumn(name = "usuario_alta")
    @ManyToOne
    private Usuario usuarioAlta;
    
    @JoinColumn(name = "usuario_modificacion")
    @ManyToOne
    private Usuario usuarioModificacion;
    
    @JoinColumn(name = "id_instructor")
    @ManyToOne
    private Usuario idInstructor;
    
    @JoinColumn(name = "id_modalidad", referencedColumnName = "id_cat_detalle")
    @ManyToOne
    private CatDetalle idModalidad;
    
    @OneToMany(mappedBy="idCursoImpartido")
	private List<UsuarioCursoImpartido> usuarioCursoImpartido;

    @Transient
    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    
    public CursoImpartido() {
    }
    
    public CursoImpartido(CursoImpartidoDTO obj ) {
    	this.idCursoImpartido = obj.getIdCursoImpartido();
		this.nombre = obj.getNombre();
		try {
			this.horaInicio = formatoHora.parse(obj.getHoraInicio());
			this.horaFin = formatoHora.parse(obj.getHoraFin());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.fechaInicio = obj.getFechaInicio();
		this.fechaFin = obj.getFechaFin();
		this.totalSesiones = obj.getTotalSesiones();
		this.totalHoras = obj.getTotalHoras();
		this.idEmpresa = obj.getIdEmpresa();
		
		this.idInstructor = new Usuario(obj.getIdInstructor().getIdUsuario());
		this.idModalidad = new CatDetalle(obj.getIdModalidad().getIdCatDetalle());
		this.diasCurso = obj.getDiasCurso();
		
		this.fechaAlta = new Date();
		this.usuarioAlta = new Usuario(obj.getUsuarioAlta().getIdUsuario());
		if(this.idCursoImpartido != null) {
			this.usuarioModificacion = new Usuario(obj.getUsuarioModificacion().getIdUsuario());
			this.fechaModificacion = new Date();
		}
		this.indEstatus = obj.getIndEstatus();
		
    }

   

	public CursoImpartido(Integer idCursoImpartido) {
        this.idCursoImpartido = idCursoImpartido;
    }

    public CursoImpartido(Integer idCursoImpartido, String nombre, Date horaInicio, Date horaFin, Date fechaInicio, Date fechaFin, int totalSesiones, int totalHoras, Date fechaAlta) {
        this.idCursoImpartido = idCursoImpartido;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.totalSesiones = totalSesiones;
        this.totalHoras = totalHoras;
        this.fechaAlta = fechaAlta;
    }

    public Integer getIdCursoImpartido() {
        return idCursoImpartido;
    }

    public void setIdCursoImpartido(Integer idCursoImpartido) {
        this.idCursoImpartido = idCursoImpartido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

	public String getDiasCurso() {
		return diasCurso;
	}

	public void setDiasCurso(String diasCurso) {
		this.diasCurso = diasCurso;
	}

	public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getTotalSesiones() {
        return totalSesiones;
    }

    public void setTotalSesiones(int totalSesiones) {
        this.totalSesiones = totalSesiones;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
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

    public Usuario getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Usuario idInstructor) {
        this.idInstructor = idInstructor;
    }

    public CatDetalle getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(CatDetalle idModalidad) {
        this.idModalidad = idModalidad;
    }

    public List<UsuarioCursoImpartido> getUsuarioCursoImpartido() {
		return usuarioCursoImpartido;
	}


	public void setUsuarioCursoImpartido(List<UsuarioCursoImpartido> usuarioCursoImpartido) {
		this.usuarioCursoImpartido = usuarioCursoImpartido;
	}
	
	public UsuarioCursoImpartido removeUsuarioCursoImpartido(UsuarioCursoImpartido usuarioCursoImpartido) {
		getUsuarioCursoImpartido().remove(usuarioCursoImpartido);
		usuarioCursoImpartido.setIdCursoImpartido(null);

		return usuarioCursoImpartido;
	}
	
	public UsuarioCursoImpartido addUsuarioCursoImpartido(UsuarioCursoImpartido usuarioCursoImpartido) {
		getUsuarioCursoImpartido().add(usuarioCursoImpartido);
		usuarioCursoImpartido.setIdCursoImpartido(this);

		return usuarioCursoImpartido;
	}
	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCursoImpartido != null ? idCursoImpartido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoImpartido)) {
            return false;
        }
        CursoImpartido other = (CursoImpartido) object;
        if ((this.idCursoImpartido == null && other.idCursoImpartido != null) || (this.idCursoImpartido != null && !this.idCursoImpartido.equals(other.idCursoImpartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CursoImpartido[ idCursoImpartido=" + idCursoImpartido + " ]";
    }
    
}
