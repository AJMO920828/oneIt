package com.mx.oneIt.model.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class CommonResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4729234495968145032L;
	
	@Setter
	@Getter
	private transient StatusMessage status;
	
	public CommonResponse(boolean seccess, Integer httpStatus, String errorCode, String errorMessage, String message) {
		super();
		this.status = new StatusMessage(seccess, httpStatus, errorCode, errorMessage, message);
	}
}
