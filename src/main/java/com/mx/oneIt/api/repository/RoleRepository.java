package com.mx.oneIt.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mx.oneIt.api.model.Rol;

@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
	Optional<Rol> findByClaveRol(String claveRol);

}
