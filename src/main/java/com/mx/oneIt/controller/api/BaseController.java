package com.mx.oneIt.controller.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.mx.oneIt.api.service.UserDetailsImpl;

public class BaseController {

	public UserDetailsImpl getUsuario() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		return userDetails;
	}
	
	
	public Long getIdUsuario() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		
		return userDetails.getId();
	}
	
	

}
