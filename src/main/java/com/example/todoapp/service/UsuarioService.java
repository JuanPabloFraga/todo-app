package com.example.todoapp.service;

import com.example.todoapp.dto.UsuarioDTO;
import com.example.todoapp.model.Usuario;
import com.example.todoapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(
                usuarioDTO.getUsername(),
                usuarioDTO.getEmail(),
                null // Password gestionado en el flujo de autenticación
        );
        Usuario savedUsuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(savedUsuario);
    }

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioById(Long id) {
        // Buscar la entidad Usuario
        Usuario usuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Convertir la entidad en un DTO antes de devolverla
        return new UsuarioDTO(usuario);
    }

    public UsuarioDTO updateUsuario(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setEmail(usuarioDTO.getEmail());
        // El password se gestiona en otro flujo si es necesario

        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(updatedUsuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}