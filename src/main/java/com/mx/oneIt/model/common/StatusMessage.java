package com.mx.oneIt.model.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StatusMessage {

	private boolean success;
	private Integer httpStatus;
	private String errorCode;
	private String errorMessage;
	private String message;
	
	
}
