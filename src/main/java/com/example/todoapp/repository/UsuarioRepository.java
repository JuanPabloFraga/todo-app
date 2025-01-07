package com.example.todoapp.repository;

import com.example.todoapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta para buscar un usuario por su nombre de usuario
    Optional<Usuario> findByUsername(String username);

    // Consulta para buscar un usuario por su email (opcional)
    Optional<Usuario> findByEmail(String email);

    // Puedes agregar más métodos de consulta si los necesitas
}
