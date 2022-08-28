package com.backendportfolio.portfolio.Controller;

import com.backendportfolio.portfolio.Dto.ProfileDto;
import com.backendportfolio.portfolio.Dto.Mensaje;
import com.backendportfolio.portfolio.Entity.Profile;
import com.backendportfolio.portfolio.Service.ProfileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin(origins = "https://federicoburgosdev-8740e.web.app")
public class ProfileController {
    
    @Autowired
    ProfileService profileService;

    //busca un elemento por id
    @GetMapping("/prf-detail/{id}")
    public ResponseEntity<Profile> getById(@PathVariable("id") int id) {
        if (!profileService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Profile profile = profileService.getOne(id).get();
        return new ResponseEntity<Profile>(profile, HttpStatus.OK);
    }

    //crea un nuevo elemento
    // @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/prf-add")
    public ResponseEntity<?> create(@RequestBody ProfileDto profileDto) {
        if (StringUtils.isBlank(profileDto.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(profileDto.getName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(profileDto.getLastname())) {
            return new ResponseEntity(new Mensaje("El apellido es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(profileDto.getTitle())) {
            return new ResponseEntity(new Mensaje("El título es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(profileDto.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }

        Profile profile = new Profile(profileDto.getImg(), profileDto.getName(), profileDto.getLastname(), profileDto.getTitle(), profileDto.getDescription());
        profileService.save(profile);
        return new ResponseEntity(new Mensaje("Perfil guardado."), HttpStatus.OK);
    }

    //edita un elemento por id
    // @PostAuthorize("hasRole('ADMIN')")
    @PutMapping("/prf-update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProfileDto profileDto) {
        
        if (!profileService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        
        if (StringUtils.isBlank(profileDto.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(profileDto.getName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(profileDto.getLastname())) {
            return new ResponseEntity(new Mensaje("El apellido es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(profileDto.getTitle())) {
            return new ResponseEntity(new Mensaje("El título es obligatorio."), HttpStatus.BAD_REQUEST);
        }
                
        if (StringUtils.isBlank(profileDto.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        Profile profile = profileService.getOne(id).get();
        
        profile.setImg(profileDto.getImg());
        profile.setName(profileDto.getName());
        profile.setLastname(profileDto.getLastname());
        profile.setTitle(profileDto.getTitle());
        profile.setDescription(profileDto.getDescription());
        
        profileService.save(profile);
        return new ResponseEntity(new Mensaje("Perfil actualizado."), HttpStatus.OK);
    }

}
