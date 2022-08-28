
package com.backendportfolio.portfolio.Service;

import com.backendportfolio.portfolio.Entity.Experience;
import com.backendportfolio.portfolio.Repository.ExperienceRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienceService {
    
    @Autowired
    ExperienceRepository experienceRepository;
    
    //devuelve todos los elementos de Experience
    public List<Experience> list() {
        return experienceRepository.findAll();
    }
    
    //devuelve un elemento Experience por id
    public Optional<Experience> getOne(int id) {
        return experienceRepository.findById(id);
    }
    
    //devuelve un elemento Experience por rol
    public Optional<Experience> getByRol(String rol) {
        return experienceRepository.findByRol(rol);
    }
    
    //guarda un elemento Experience
    public void save(Experience experience) {
        experienceRepository.save(experience);
    }
    
    //elimina un elemento Experience por id
    public void delete(int id) {
        experienceRepository.deleteById(id);
    }
    
    //comprueba si existe un elemento Experience por id - devuelve true si existe, falso si no existe
    public boolean existsById(int id) {
        return experienceRepository.existsById(id);
    }
    
    //comprueba si existe un elemento Experience por rol - devuelve true si existe, falso si no existe
    public boolean existsByRol(String rol) {
        return experienceRepository.existsByRol(rol);
    }
    
}
