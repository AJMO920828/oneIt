package com.mx.oneIt;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


import com.mx.oneIt.service.UserDetailsSegImpl;

@Component
public class AuditorAwareImpl implements AuditorAware<Long> {

	@Override
	public Optional<Long> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsSegImpl userDetails = (UserDetailsSegImpl) authentication.getPrincipal();
		return Optional.ofNullable(userDetails.getId());
	}
	

}
