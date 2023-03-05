package com.mx.oneIt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;




/**
 * The persistent class for the cat_detalle database table.
 * 
 */
@Entity
@Table(name="cat_detalle")
@NamedQuery(name="CatDetalle.findAll", query="SELECT c FROM CatDetalle c")
public class CatDetalle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cat_detalle")
	private Long idCatDetalle;

	private String clave;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;

	@Column(name="ind_estatus")
	private String indEstatus;

	
	@Column(name="id_cat_maestro")
	private Long catMaestro;


	public Long getIdCatDetalle() {
		return idCatDetalle;
	}


	public void setIdCatDetalle(Long idCatDetalle) {
		this.idCatDetalle = idCatDetalle;
	}


	public String getClave() {
		return clave;
	}


	public void setClave(String clave) {
		this.clave = clave;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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


	public String getIndEstatus() {
		return indEstatus;
	}


	public void setIndEstatus(String indEstatus) {
		this.indEstatus = indEstatus;
	}


	public Long getCatMaestro() {
		return catMaestro;
	}


	public void setCatMaestro(Long catMaestro) {
		this.catMaestro = catMaestro;
	}

}