package com.mx.oneIt.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3651595223181416338L;

	@Column(name = "fecha_alta")
	@CreatedDate
	private Date fechaAlta;
	
	@Column(name = "fecha_modificacion")
	@LastModifiedDate
	private Date fechaModificacion;
	
	@Column(name = "usuario_alta")
	@CreatedBy
	private Long usuarioAlta;
	
	@Column(name = "usuario_modificacion")
	@LastModifiedBy
	private Long usuarioModificacion;
	
	@Column(name = "ind_estatus")
	private int indEstatus;
	
	
}
