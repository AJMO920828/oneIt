package com.mx.oneIt.api.dto;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mx.oneIt.api.model.CursoImpartido;

/**
 *
 * @author abel_
 */
public class CursoImpartidoDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idCursoImpartido;
    private String nombre;
    private String horaInicio;
    private String horaFin;
    private String diasCurso;
    private Date fechaInicio;
    private Date fechaFin;
    private int totalSesiones;
    private int totalHoras;
    private Integer idEmpresa;
    private Date fechaAlta;
    private Date fechaModificacion;
    private Integer indEstatus;
    private UsuarioDTO usuarioAlta;
    private UsuarioDTO usuarioModificacion;
    private UsuarioDTO idInstructor;
    private CatDetalleDTO idModalidad;
    
    private String nombreInstructor; 
    private String modalidad;
    private String fechaInicioFormat;
    private String fechaFinFormat;
    private Integer totalAlumnos;
    private Integer idCurso;

    DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
    DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    
    public CursoImpartidoDTO() {
    }

    public CursoImpartidoDTO(Integer idCursoImpartido) {
        this.idCursoImpartido = idCursoImpartido;
    }

    public CursoImpartidoDTO(Integer idCursoImpartido, String nombre, String horaInicio, String horaFin, Date fechaInicio, Date fechaFin, int totalSesiones, int totalHoras, Date fechaAlta) {
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

    
    public CursoImpartidoDTO(CursoImpartido obj) {
		super();
		this.idCursoImpartido = obj.getIdCursoImpartido();
		this.nombre = obj.getNombre();
		this.horaInicio = formatoHora.format(obj.getHoraInicio());
		this.horaFin = formatoHora.format(obj.getHoraFin());
		this.fechaInicio = obj.getFechaInicio();
		this.fechaFin = obj.getFechaFin();
		this.totalSesiones = obj.getTotalSesiones();
		this.totalHoras = obj.getTotalHoras();
		this.idEmpresa = obj.getIdEmpresa();
		
		this.idInstructor = new UsuarioDTO(obj.getIdInstructor().getIdUsuario());
		this.idModalidad = new CatDetalleDTO(obj.getIdModalidad().getIdCatDetalle());
		
		this.diasCurso = obj.getDiasCurso();
		this.fechaAlta = obj.getFechaAlta();
		this.usuarioAlta = new UsuarioDTO(obj.getUsuarioAlta()!=null && obj.getUsuarioAlta().getIdUsuario()!=null ? obj.getUsuarioAlta().getIdUsuario():null);
		this.usuarioModificacion= new UsuarioDTO(obj.getUsuarioModificacion()!=null && obj.getUsuarioModificacion().getIdUsuario()!=null ? obj.getUsuarioModificacion().getIdUsuario():null);
		this.fechaModificacion = obj.getFechaModificacion();
		this.indEstatus = obj.getIndEstatus();
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

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
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

    public UsuarioDTO getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(UsuarioDTO idInstructor) {
        this.idInstructor = idInstructor;
    }

    public CatDetalleDTO getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(CatDetalleDTO idModalidad) {
        this.idModalidad = idModalidad;
    }

    

    public String getNombreInstructor() {
		return nombreInstructor;
	}

	public void setNombreInstructor(String nombreInstructor) {
		this.nombreInstructor = nombreInstructor;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getFechaInicioFormat() {
		return fechaInicioFormat;
	}

	public void setFechaInicioFormat(Date fechaInicioFormat) {
		if(fechaInicioFormat != null) {
			this.fechaInicioFormat = formatoFecha.format(fechaInicioFormat);
		}
		
	}

	public String getFechaFinFormat() {
		return fechaFinFormat;
	}

	public void setFechaFinFormat(Date fechaFinFormat) {
		if(fechaFinFormat != null) {
			this.fechaFinFormat = formatoFecha.format(fechaFinFormat);
		}
	}

	public Integer getTotalAlumnos() {
		return totalAlumnos;
	}

	public void setTotalAlumnos(Integer totalAlumnos) {
		this.totalAlumnos = totalAlumnos;
	}


	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
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
        if (!(object instanceof CursoImpartidoDTO)) {
            return false;
        }
        CursoImpartidoDTO other = (CursoImpartidoDTO) object;
        if ((this.idCursoImpartido == null && other.idCursoImpartido != null) || (this.idCursoImpartido != null && !this.idCursoImpartido.equals(other.idCursoImpartido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CursoImpartidoDTO[ idCursoImpartido=" + idCursoImpartido + " ]";
    }
    
}
