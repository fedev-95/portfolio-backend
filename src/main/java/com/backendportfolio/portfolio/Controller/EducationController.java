package com.backendportfolio.portfolio.Controller;

import com.backendportfolio.portfolio.Dto.EducationDto;
import com.backendportfolio.portfolio.Dto.Mensaje;
import com.backendportfolio.portfolio.Entity.Education;
import com.backendportfolio.portfolio.Service.EducationService;
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
public class EducationController {
    
    @Autowired
    EducationService educationService;
    
    //busca lista de elementos
    @GetMapping("/ed-list")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = educationService.list();
        return new ResponseEntity<List<Education>>(list, HttpStatus.OK);
    }
    
    //busca un elemento por id
    @GetMapping("/ed-detail/{id}")
    public ResponseEntity<Education> getById(@PathVariable("id") int id) {
        if (!educationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Education education = educationService.getOne(id).get();
        return new ResponseEntity<Education>(education, HttpStatus.OK);
    }
    
    //busca un elemento por titulo
    @GetMapping("/ed-detailtitle/{title}")
    public ResponseEntity<Education> getByTitle(@PathVariable("title") String title) {
        if (!educationService.existsByTitle(title)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Education education = educationService.getByTitle(title).get();
        return new ResponseEntity<Education>(education, HttpStatus.OK);
    }
    
    //crea un nuevo elemento
    // @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/ed-add")
    public ResponseEntity<?> create(@RequestBody EducationDto educationDto) {
        if (StringUtils.isBlank(educationDto.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(educationDto.getAcademyName())) {
            return new ResponseEntity(new Mensaje("La institucion es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(educationDto.getCertificationLink())) {
            return new ResponseEntity(new Mensaje("El link de certificacion es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(educationDto.getTitle(), educationDto.getAcademyName(), educationDto.getCertificationLink());
        educationService.save(education);
        return new ResponseEntity(new Mensaje("Educacion agregada."), HttpStatus.OK);
    }
    
    //edita un elemento Education por id
    // @PostAuthorize("hasRole('ADMIN')")
    @PutMapping("/ed-update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody EducationDto educationDto) {
        
        if (!educationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        
        if (StringUtils.isBlank(educationDto.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(educationDto.getAcademyName())) {
            return new ResponseEntity(new Mensaje("La institucion es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(educationDto.getCertificationLink())) {
            return new ResponseEntity(new Mensaje("El link de certificacion es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        Education education = educationService.getOne(id).get();
        
        education.setTitle(educationDto.getTitle());
        education.setAcademyName(educationDto.getAcademyName());
        education.setCertificationLink(educationDto.getCertificationLink());
        
        educationService.save(education);
        return new ResponseEntity(new Mensaje("Educacion actualizada."), HttpStatus.OK);
    }
    
    // eliminar elemento por id
    // @PostAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/ed-delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        educationService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada."), HttpStatus.OK);
    }
    
    
}
