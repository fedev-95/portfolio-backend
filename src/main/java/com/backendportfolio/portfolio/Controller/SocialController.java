package com.backendportfolio.portfolio.Controller;

import com.backendportfolio.portfolio.Dto.SocialDto;
import com.backendportfolio.portfolio.Dto.Mensaje;
import com.backendportfolio.portfolio.Entity.Social;
import com.backendportfolio.portfolio.Service.SocialService;
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
public class SocialController {
    
    @Autowired
    SocialService socialService;

    //busca lista de elementos
    @GetMapping("/soc-list")
    public ResponseEntity<List<Social>> list() {
        List<Social> list = socialService.list();
        return new ResponseEntity<List<Social>>(list, HttpStatus.OK);
    }

    //busca un elemento por id
    @GetMapping("/soc-detail/{id}")
    public ResponseEntity<Social> getById(@PathVariable("id") int id) {
        if (!socialService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Social social = socialService.getOne(id).get();
        return new ResponseEntity<Social>(social, HttpStatus.OK);
    }

    //busca un elemento por nombre
    @GetMapping("/soc-detailname/{socialName}")
    public ResponseEntity<Social> getBySocialName(@PathVariable("socialName") String socialName) {
        if (!socialService.existsBySocialName(socialName)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        Social social = socialService.getBySocialName(socialName).get();
        return new ResponseEntity<Social>(social, HttpStatus.OK);
    }

    //crea un nuevo elemento
    // @PostAuthorize("hasRole('ADMIN')")
    @PostMapping("/soc-add")
    public ResponseEntity<?> create(@RequestBody SocialDto socialDto) {
        if (StringUtils.isBlank(socialDto.getSocialName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(socialDto.getSocialLink())) {
            return new ResponseEntity(new Mensaje("El enlace es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        Social social = new Social(socialDto.getSocialName(), socialDto.getSocialLink());
        socialService.save(social);
        return new ResponseEntity(new Mensaje("Red social agregada."), HttpStatus.OK);
    }

    //edita un elemento por id
    // @PostAuthorize("hasRole('ADMIN')")
    @PutMapping("/soc-update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody SocialDto socialDto) {
        
        if (!socialService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        
        if (StringUtils.isBlank(socialDto.getSocialName())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(socialDto.getSocialLink())) {
            return new ResponseEntity(new Mensaje("El enlace es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        
        Social social = socialService.getOne(id).get();
        
        social.setSocialName(socialDto.getSocialName());
        social.setSocialLink(socialDto.getSocialLink());
        
        socialService.save(social);
        return new ResponseEntity(new Mensaje("Red social actualizada."), HttpStatus.OK);
    }

    // delete por id
    // @PostAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/soc-delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!socialService.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe."), HttpStatus.NOT_FOUND);
        }
        socialService.delete(id);
        return new ResponseEntity(new Mensaje("Red Social eliminada."), HttpStatus.OK);
    }
}
