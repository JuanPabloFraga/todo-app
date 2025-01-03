package com.example.todoapp.repository;

import com.example.todoapp.model.Todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para acceder a los datos de la entidad Todo.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	 List<Todo> findByTitleContainingOrDescriptionContaining(String title, String description);
	
    // Puedes agregar consultas personalizadas aquí si es necesario
}
