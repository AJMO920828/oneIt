package com.mx.oneIt.dto;

import com.mx.oneIt.model.common.CommonResponse;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@EqualsAndHashCode(callSuper = false)
public class GenericResponseDTO<T> extends CommonResponse {/**
	 * 
	 */
	private static final long serialVersionUID = -2036700957562926978L;
	
	@Setter
	@Getter
	private transient T body;
	
	public GenericResponseDTO(boolean seccess, Integer httpStatus, String errorCode, String errorMessage, String message, T body) {
		super(seccess, httpStatus, errorCode, errorMessage, message);
		this.body = body;
	}
}
