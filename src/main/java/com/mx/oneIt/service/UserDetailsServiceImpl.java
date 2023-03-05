package com.mx.oneIt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mx.oneIt.model.User;
import com.mx.oneIt.model.UsuarioRol;
import com.mx.oneIt.repository.UserRepository;
import com.mx.oneIt.repository.UsuarioRolRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UsuarioRolRepository usuarioRolRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		List<UsuarioRol> usRol = usuarioRolRepository.findByUsuario(user);
		return UserDetailsImpl.build(user,usRol);
	}

}
