package com.example.todoapp.service;


import com.example.todoapp.model.Todo;

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
        TodoRepository mockRepository = mock(TodoRepository.class);
        TodoService todoService = new TodoService(mockRepository);

        Todo todo = new Todo(1L, "Test Todo", "Description", false,"High", LocalDate.now());
        when(mockRepository.findById(1L)).thenReturn(Optional.of(todo));

        Todo result = todoService.getTodoById(1L);

        assertEquals(1L, result.getId());
        assertEquals("Test Todo", result.getTitle());
        assertEquals("Description", result.getDescription());
        assertEquals("High", result.getPriority());
        assertEquals(false, result.isCompleted());
    }

    @Test
    public void testGetTodoByIdNotFound() {
        TodoRepository mockRepository = mock(TodoRepository.class);
        TodoService todoService = new TodoService(mockRepository);

        when(mockRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> todoService.getTodoById(1L));
    }
}
