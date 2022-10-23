package com.backendportfolio.portfolio.Controller;

import com.backendportfolio.portfolio.Dto.ExperienceDto;
import com.backendportfolio.portfolio.Dto.Mensaje;
import com.backendportfolio.portfolio.Entity.Experience;
import com.backendportfolio.portfolio.Service.ExperienceService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio")
// local
@CrossOrigin(origins = "http://localhost:4200")
// @CrossOrigin(origins = "https://federicoburgosdev-8740e.web.app")
public class ExperienceController {
    
    @Autowired
    ExperienceService experienceService;
    
    //busca lista de elementos Experience
    @GetMapping("/exp-list")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = experienceService.list();
        return new ResponseEntity<List<Experience>>(list, HttpStatus.OK);
    }
    
    //busca un elemento por id
    @GetMapping("/exp-detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id) {
        if (!experienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity<Experience>(experience, HttpStatus.OK);
    }
    
    //busca un elemento por rol
    @GetMapping("/exp-detailrol/{rol}")
    public ResponseEntity<Experience> getByTitle(@PathVariable("rol") String rol) {
        if (!experienceService.existsByRol(rol)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Experience experience = experienceService.getByRol(rol).get();
        return new ResponseEntity<Experience>(experience, HttpStatus.OK);
    }
    
    //crea un nuevo elemento
    // @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/exp-add")
    public ResponseEntity<?> create(@RequestBody ExperienceDto experienceDto) {
        
        if (StringUtils.isBlank(experienceDto.getRol())) {
            return new ResponseEntity(new Mensaje("El puesto es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (experienceDto.getStartYear()<1900) {
            return new ResponseEntity(new Mensaje("El año tiene que se mayor a 1900."), HttpStatus.BAD_REQUEST);
        }
        
        if (experienceDto.getEndYear()<1900) {
            return new ResponseEntity(new Mensaje("El año tiene que se mayor a 1900."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(experienceDto.getCompany())) {
            return new ResponseEntity(new Mensaje("La compañia es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(experienceDto.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = new Experience(experienceDto.getRol(), experienceDto.getStartYear(), experienceDto.getEndYear(), experienceDto.getCompany(), experienceDto.getDescription());
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia agregada."), HttpStatus.OK);
    }
    
    //edita por id
    // @PostAuthorize("hasRole('ADMIN')")
    @PutMapping("/exp-update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienceDto experienceDto) {
        
        if (!experienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        
        if (StringUtils.isBlank(experienceDto.getRol())) {
            return new ResponseEntity(new Mensaje("El rol es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (experienceDto.getStartYear()<1900) {
            return new ResponseEntity(new Mensaje("El año tiene que se mayor a 1900."), HttpStatus.BAD_REQUEST);
        }
        
        if (experienceDto.getEndYear()<1900) {
            return new ResponseEntity(new Mensaje("El año tiene que se mayor a 1900."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(experienceDto.getCompany())) {
            return new ResponseEntity(new Mensaje("La compañia es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(experienceDto.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        Experience experience = experienceService.getOne(id).get();
        
        experience.setRol(experienceDto.getRol());
        experience.setStartYear(experienceDto.getStartYear());
        experience.setEndYear(experienceDto.getEndYear());
        experience.setCompany(experienceDto.getCompany());
        experience.setDescription(experienceDto.getDescription());
        
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("Experiencia actualizada."), HttpStatus.OK);
    }
    
    // eliminar por id
    // @PostAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/exp-delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        experienceService.delete(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada."), HttpStatus.OK);
    }
    
}
