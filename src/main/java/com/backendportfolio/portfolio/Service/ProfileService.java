package com.backendportfolio.portfolio.Service;

import com.backendportfolio.portfolio.Entity.Profile;
import com.backendportfolio.portfolio.Repository.ProfileRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProfileService {
    
    @Autowired
    ProfileRepository profileRepository;

    //devuelve un elemento por id
    public Optional<Profile> getOne(int id) {
        return profileRepository.findById(id);
    }

    //guarda un elemento
    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    //comprueba si existe un elemento por id
    public boolean existsById(int id) {
        return profileRepository.existsById(id);
    }
    
}
