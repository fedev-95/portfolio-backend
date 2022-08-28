package com.backendportfolio.portfolio.Security.Service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendportfolio.portfolio.Security.Entity.Rol;
import com.backendportfolio.portfolio.Security.Enums.RolNombre;
import com.backendportfolio.portfolio.Security.Repository.RolRepository;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return rolRepository.findByRolNombre(rolNombre);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}
