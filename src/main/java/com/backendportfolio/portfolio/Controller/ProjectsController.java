package com.backendportfolio.portfolio.Controller;

import com.backendportfolio.portfolio.Dto.ProjectsDto;
import com.backendportfolio.portfolio.Dto.Mensaje;
import com.backendportfolio.portfolio.Entity.Projects;
import com.backendportfolio.portfolio.Service.ProjectsService;
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
public class ProjectsController {

    @Autowired
    ProjectsService projectsService;
    
    //busca lista de elementos
    @GetMapping("/prj-list")
    public ResponseEntity<List<Projects>> list() {
        List<Projects> list = projectsService.list();
        return new ResponseEntity<List<Projects>>(list, HttpStatus.OK);
    }

    //busca un elemento por id
    @GetMapping("/prj-detail/{id}")
    public ResponseEntity<Projects> getById(@PathVariable("id") int id) {
        if (!projectsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Projects project = projectsService.getOne(id).get();
        return new ResponseEntity<Projects>(project, HttpStatus.OK);
    }

    //busca un elemento por titulo
    @GetMapping("/prj-detailtitle/{title}")
    public ResponseEntity<Projects> getByTitle(@PathVariable("title") String title) {
        if (!projectsService.existsByTitle(title)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Projects project = projectsService.getByTitle(title).get();
        return new ResponseEntity<Projects>(project, HttpStatus.OK);
    }

    //crea un nuevo elemento
    // @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/prj-add")
    public ResponseEntity<?> create(@RequestBody ProjectsDto projectsDto) {
        if (StringUtils.isBlank(projectsDto.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectsDto.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (projectsDto.getDate()<1900) {
            return new ResponseEntity(new Mensaje("El año tiene que se mayor a 1900."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(projectsDto.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(projectsDto.getPrjLink())) {
            return new ResponseEntity(new Mensaje("El link es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        Projects project = new Projects(projectsDto.getImg(), projectsDto.getTitle(), projectsDto.getDate(), projectsDto.getDescription(), projectsDto.getPrjLink());
        projectsService.save(project);
        return new ResponseEntity(new Mensaje("Proyecto agregado."), HttpStatus.OK);
    }

    //edita un elemento por id
    // @PostAuthorize("hasRole('ADMIN')")
    @PutMapping("/prj-update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProjectsDto projectsDto) {
        
        if (!projectsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        
        if (StringUtils.isBlank(projectsDto.getImg())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(projectsDto.getTitle())) {
            return new ResponseEntity(new Mensaje("El titulo es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (projectsDto.getDate()<1900) {
            return new ResponseEntity(new Mensaje("El año tiene que se mayor a 1900."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(projectsDto.getDescription())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(projectsDto.getPrjLink())) {
            return new ResponseEntity(new Mensaje("El link es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        Projects project = projectsService.getOne(id).get();
        
        project.setImg(projectsDto.getImg());
        project.setTitle(projectsDto.getTitle());
        project.setDate(projectsDto.getDate());
        project.setDescription(projectsDto.getDescription());
        project.setPrjLink(projectsDto.getPrjLink());
        
        projectsService.save(project);
        return new ResponseEntity(new Mensaje("Proyecto actualizado."), HttpStatus.OK);
    }

    // delete por id
    // @PostAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/prj-delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!projectsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        projectsService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado."), HttpStatus.OK);
    }

}
