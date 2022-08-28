package com.backendportfolio.portfolio.Service;

import com.backendportfolio.portfolio.Entity.Projects;
import com.backendportfolio.portfolio.Repository.ProjectsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProjectsService {
    
    @Autowired
    ProjectsRepository projectsRepository;

    //devuelve todos los elementos
    public List<Projects> list() {
        return projectsRepository.findAll();
    }

    //devuelve un elemento por id
    public Optional<Projects> getOne(int id) {
        return projectsRepository.findById(id);
    }

    //devuelve un elemento por titulo
    public Optional<Projects> getByTitle(String title) {
        return projectsRepository.findByTitle(title);
    }

    //guarda un elemento
    public void save(Projects project) {
        projectsRepository.save(project);
    }

    //elimina un elemento por id
    public void delete(int id) {
        projectsRepository.deleteById(id);
    }

    //comprueba si existe un elemento por id
    public boolean existsById(int id) {
        return projectsRepository.existsById(id);
    }

    //comprueba si existe un elemento por title
    public boolean existsByTitle(String title) {
        return projectsRepository.existsByTitle(title);
    }

}
