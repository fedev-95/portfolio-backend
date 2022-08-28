package com.backendportfolio.portfolio.Service;

import com.backendportfolio.portfolio.Entity.Social;
import com.backendportfolio.portfolio.Repository.SocialRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SocialService {
    
    @Autowired
    SocialRepository socialRepository;

    //devuelve todos los elementos
    public List<Social> list() {
        return socialRepository.findAll();
    }

    //devuelve un elemento por id
    public Optional<Social> getOne(int id) {
        return socialRepository.findById(id);
    }

    //devuelve un elemento por titulo
    public Optional<Social> getBySocialName(String socialName) {
        return socialRepository.findBySocialName(socialName);
    }

    //guarda un elemento
    public void save(Social social) {
        socialRepository.save(social);
    }

    //elimina un elemento por id
    public void delete(int id) {
        socialRepository.deleteById(id);
    }

    //comprueba si existe un elemento por id
    public boolean existsById(int id) {
        return socialRepository.existsById(id);
    }

    //comprueba si existe un elemento por title
    public boolean existsBySocialName(String socialName) {
        return socialRepository.existsBySocialName(socialName);
    }

}
