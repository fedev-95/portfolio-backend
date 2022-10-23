package com.backendportfolio.portfolio.Controller;

import com.backendportfolio.portfolio.Dto.SkillsDto;
import com.backendportfolio.portfolio.Dto.Mensaje;
import com.backendportfolio.portfolio.Entity.Skills;
import com.backendportfolio.portfolio.Service.SkillsService;
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
public class SkillsController {
    
    @Autowired
    SkillsService skillsService;

    //busca lista de elementos
    @GetMapping("/skl-list")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = skillsService.list();
        return new ResponseEntity<List<Skills>>(list, HttpStatus.OK);
    }

    //busca un elemento por id
    @GetMapping("/skl-detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Skills skill = skillsService.getOne(id).get();
        return new ResponseEntity<Skills>(skill, HttpStatus.OK);
    }

    //busca un elemento por nombre
    @GetMapping("/skl-detailname/{skillName}")
    public ResponseEntity<Skills> getBySkillName(@PathVariable("skillName") String skillName) {
        if (!skillsService.existsBySkillName(skillName)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Skills skill = skillsService.getBySkillName(skillName).get();
        return new ResponseEntity<Skills>(skill, HttpStatus.OK);
    }

    //crea un nuevo elemento
    // @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/skl-add")
    public ResponseEntity<?> create(@RequestBody SkillsDto skillsDto) {
        if (StringUtils.isBlank(skillsDto.getSkillName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(skillsDto.getSkillType())) {
            return new ResponseEntity(new Mensaje("El tipo de habilidad es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        Skills skill = new Skills(skillsDto.getSkillName(), skillsDto.getSkillType());
        skillsService.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad agregada."), HttpStatus.OK);
    }

    //edita un elemento por id
    // @PostAuthorize("hasRole('ADMIN')")
    @PutMapping("/skl-update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SkillsDto skillsDto) {
        
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        
        if (StringUtils.isBlank(skillsDto.getSkillName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(skillsDto.getSkillType())) {
            return new ResponseEntity(new Mensaje("El tipo de habilidad es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        Skills skill = skillsService.getOne(id).get();
        
        skill.setSkillName(skillsDto.getSkillName());
        skill.setSkillType(skillsDto.getSkillType());
        
        skillsService.save(skill);
        return new ResponseEntity(new Mensaje("Habilidad actualizada."), HttpStatus.OK);
    }

    // delete por id
    // @PostAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/skl-delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!skillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        skillsService.delete(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada."), HttpStatus.OK);
    }


}
