package com.backendportfolio.portfolio.Security.Service;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backendportfolio.portfolio.Security.Entity.Usuario;
import com.backendportfolio.portfolio.Security.Repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    public boolean existsByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

}
