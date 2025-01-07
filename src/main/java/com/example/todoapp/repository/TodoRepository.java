package com.example.todoapp.repository;

import com.example.todoapp.model.Todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para acceder a los datos de la entidad Todo.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	 List<Todo> findByTitleContainingOrDescriptionContaining(String title, String description);
	


	// Si quieres buscar por usuario autenticado directamente
	@Query("SELECT t FROM Todo t WHERE t.usuario.username = :username")
	List<Todo> findByUsuarioUsername(String username);

}
