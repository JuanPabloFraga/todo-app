package com.example.todoapp.service;


import com.example.todoapp.model.Todo;
import com.example.todoapp.model.Usuario;
import com.example.todoapp.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ActiveProfiles("test")
public class TodoServiceTest {
	
	@Test
	public void testGetTodoById() {
	    // Crear el mock del repositorio y el servicio
	    TodoRepository mockRepository = mock(TodoRepository.class);
	    TodoService todoService = new TodoService(mockRepository);

	    // Crear un usuario asociado a la Todo
	    Usuario usuario = new Usuario("usuario prueba", "prueba@gmail.com", "1234");
	    usuario.setId(1L); // Establecer un ID para el usuario

	    // Crear una Todo con el usuario
	    Todo todo = new Todo(1L, "Test Todo", "Description", false, "High", LocalDate.now(), usuario);

	    // Configurar el mock para devolver la Todo
	    when(mockRepository.findById(1L)).thenReturn(Optional.of(todo));

	    // Llamar al método del servicio
	    Todo result = todoService.getTodoById(1L);

	    // Validar los campos de la Todo
	    assertEquals(1L, result.getId());
	    assertEquals("Test Todo", result.getTitle());
	    assertEquals("Description", result.getDescription());
	    assertEquals("High", result.getPriority());
	    assertEquals(false, result.isCompleted());

	    // Validar el usuario asociado a la Todo
	    assertEquals(1L, result.getUsuario().getId());
	    assertEquals("usuario prueba", result.getUsuario().getUsername());
	    assertEquals("prueba@gmail.com", result.getUsuario().getEmail());
	    assertEquals("1234", result.getUsuario().getPassword());
	}
}