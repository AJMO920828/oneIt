package com.mx.oneIt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.oneIt.api.model.Usuario;
import com.mx.oneIt.api.model.UsuarioRol;
import com.mx.oneIt.api.repository.UserRepository;
import com.mx.oneIt.api.repository.UsuarioRolRepository;

@Service
public class UserDetailsSegServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	UsuarioRolRepository usuarioRolRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUsuario(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		List<UsuarioRol> usRol = usuarioRolRepository.findByIdUsuario(user);
		return UserDetailsSegImpl.build(user,usRol);
	}

}
