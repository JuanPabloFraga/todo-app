package com.example.todoapp.service;

import com.example.todoapp.dto.TodoDTO;
import com.example.todoapp.model.Todo;
import com.example.todoapp.model.Usuario;
import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.todoapp.exception.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Servicio que maneja la lógica de negocio relacionada con los Todos.
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;
   
    @Autowired
    private UsuarioService usuarioService;


    // Constructor que inyecta el repositorio
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // Método para obtener todos los Todo
    public List<TodoDTO> getAllTodos() {
        return todoRepository.findAll().stream()
                .map(todo -> new TodoDTO(todo.getId(), todo.getTitle(), todo.getDescription(), todo.isCompleted(), todo.getPriority(), todo.getDueDate(), todo.getUsuario().getId()))
                .collect(Collectors.toList());
    }

    // Método para agregar un nuevo Todo
    public TodoDTO addTodo(TodoDTO todoDTO, Usuario usuario) {
        // Crear y asociar la tarea al usuario
        Todo todo = new Todo(todoDTO.getId(), todoDTO.getTitle(), todoDTO.getDescription(),
                             todoDTO.isCompleted(), todoDTO.getPriority(), todoDTO.getDueDate(),usuario);
       

        Todo savedTodo = todoRepository.save(todo);

        return new TodoDTO(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getDescription(),
                           savedTodo.isCompleted(), savedTodo.getPriority(), savedTodo.getDueDate(), usuario.getId());
    }

    // Método para marcar una tarea como completada
    public Todo markAsCompleted(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setCompleted(true);
            return todoRepository.save(todo);
        }
        return null;
    }
 // Método para filtrar tareas por estado (completadas / pendientes)
    public List<Todo> getTodosByStatus(boolean completed) {
        return todoRepository.findAll().stream()
                .filter(todo -> todo.isCompleted() == completed)
                .toList();
    }
    
 // Método para eliminar una tarea por ID
    public boolean deleteTodo(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }
 // Método para actualizar una tarea por ID
    public Todo updateTodo(Long id, Todo updatedTodo) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo existingTodo = todoOptional.get();
            existingTodo.setTitle(updatedTodo.getTitle());
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setCompleted(updatedTodo.isCompleted());
            existingTodo.setPriority(updatedTodo.getPriority());
            return todoRepository.save(existingTodo);
        }
        return null;
    }
    public List<Todo> searchTodos(String query) {
        return todoRepository.findByTitleContainingOrDescriptionContaining(query, query);
    }
    public Todo updatePriority(Long id, String priority) {
    	Todo todo = todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
        todo.setPriority(priority);  // Suponiendo que 'priority' es un String. 
        return todoRepository.save(todo);
    }
    public Todo updateDueDate(Long id, LocalDate dueDate) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setDueDate(dueDate);
        return todoRepository.save(todo);
    }
    public List<Todo> getUpcomingTodos(int days) {
        LocalDate today = LocalDate.now();
        LocalDate upcomingDate = today.plusDays(days);
        return todoRepository.findAll().stream()
                .filter(todo -> todo.getDueDate() != null && 
                                !todo.getDueDate().isBefore(today) && 
                                !todo.getDueDate().isAfter(upcomingDate))
                .collect(Collectors.toList());
    }
    
    @Transactional
    public List<Todo> markMultipleAsCompleted(List<Long> ids) {
        // Encontrar todas las tareas por sus IDs
        List<Todo> todos = todoRepository.findAllById(ids);

        // Verificar si falta alguna tarea
        if (todos.size() != ids.size()) {
            throw new ResourceNotFoundException("One or more Todos not found.");
        }

        // Marcar como completadas
        todos.forEach(todo -> todo.setCompleted(true));

        // Guardar los cambios
        return todoRepository.saveAll(todos);
    }
    
    public List<TodoDTO> addMultipleTodos(List<TodoDTO> todoDTOs) {
        List<TodoDTO> createdTodos = new ArrayList<>();
        for (TodoDTO todoDTO : todoDTOs) {
            createdTodos.add(addTodo(todoDTO)); // Esto reutiliza el método que ya tienes para agregar una tarea
        }
        return createdTodos;
    }
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
    }

    // Aquí puedes agregar métodos para actualizar, eliminar, etc.
}
