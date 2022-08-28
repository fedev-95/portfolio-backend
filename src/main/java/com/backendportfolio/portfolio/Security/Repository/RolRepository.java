package com.backendportfolio.portfolio.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backendportfolio.portfolio.Security.Entity.Rol;
import com.backendportfolio.portfolio.Security.Enums.RolNombre;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}