package com.backendportfolio.portfolio.Service;

import com.backendportfolio.portfolio.Entity.Skills;
import com.backendportfolio.portfolio.Repository.SkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    
    @Autowired
    SkillsRepository skillsRepository;

    //devuelve todos los elementos
    public List<Skills> list() {
        return skillsRepository.findAll();
    }

    //devuelve un elemento por id
    public Optional<Skills> getOne(int id) {
        return skillsRepository.findById(id);
    }

    //devuelve un elemento por titulo
    public Optional<Skills> getBySkillName(String skillName) {
        return skillsRepository.findBySkillName(skillName);
    }

    //guarda un elemento
    public void save(Skills skill) {
        skillsRepository.save(skill);
    }

    //elimina un elemento por id
    public void delete(int id) {
        skillsRepository.deleteById(id);
    }

    //comprueba si existe un elemento por id
    public boolean existsById(int id) {
        return skillsRepository.existsById(id);
    }

    //comprueba si existe un elemento por title
    public boolean existsBySkillName(String skillName) {
        return skillsRepository.existsBySkillName(skillName);
    }

}
