package com.backendportfolio.portfolio.Service;

import com.backendportfolio.portfolio.Entity.Education;
import com.backendportfolio.portfolio.Repository.EducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducationService {
    
    @Autowired
    EducationRepository educationRepository;
    
    
    //devuelve todos los elementos de Education
    public List<Education> list() {
        return educationRepository.findAll();
    }
    
    //devuelve un elemento Education por id
    public Optional<Education> getOne(int id) {
        return educationRepository.findById(id);
    }
    
    //devuelve un elemento Education por titulo
    public Optional<Education> getByTitle(String title) {
        return educationRepository.findByTitle(title);
    }
    
    
    //guarda un elemento Education
    public void save(Education education) {
        educationRepository.save(education);
    }
    
    //elimina un elemento Education por id
    public void delete(int id) {
        educationRepository.deleteById(id);
    }
    
    //comprueba si existe un elemento Education por id
    public boolean existsById(int id) {
        return educationRepository.existsById(id);
    }
    
    //comprueba si existe un elemento Education por title
    public boolean existsByTitle(String title) {
        return educationRepository.existsByTitle(title);
    }
            
}
