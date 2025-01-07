package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoDTO;
import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para manejar las peticiones de Todo.
 */
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping()
    public List<TodoDTO> getAllTodos() {
        return todoService.getAllTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }

    @PostMapping
    public TodoDTO addTodo(@RequestBody TodoDTO todoDTO) {
        return todoService.addTodo(todoDTO);
    }
    
    // Método para marcar una tarea como completada
    @PutMapping("/{id}/complete")
    public ResponseEntity<Todo> markAsCompleted(@PathVariable Long id) {
        Todo updatedTodo = todoService.markAsCompleted(id);
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }                                              // true          false
 // Método para obtener tareas filtradas por estado (completadas / pendientes)
    @GetMapping("/filter")
    public List<Todo> getTodosByStatus(@RequestParam boolean completed) {
        return todoService.getTodosByStatus(completed);
        }
        
        
     // Método para eliminar una tarea por ID
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
            if (todoService.deleteTodo(id)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
     // Método para actualizar una tarea por ID
        @PutMapping("/{id}")
        public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
            Todo todo = todoService.updateTodo(id, updatedTodo);
            if (todo != null) {
                return ResponseEntity.ok(todo);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        @GetMapping("/search")
        public List<Todo> searchTodos(@RequestParam String query) {
            return todoService.searchTodos(query);
        }
        @PutMapping("/{id}/priority")
        public ResponseEntity<Todo> updatePriority(@PathVariable Long id, @RequestParam String priority) {
            Todo updatedTodo = todoService.updatePriority(id, priority);
            return ResponseEntity.ok(updatedTodo);
        }

        @PutMapping("/{id}/dueDate")
        public ResponseEntity<Todo> updateDueDate(@PathVariable Long id, @RequestParam String dueDate) {
            LocalDate parsedDate = LocalDate.parse(dueDate); // Convertir string a LocalDate
            Todo updatedTodo = todoService.updateDueDate(id, parsedDate);
            return ResponseEntity.ok(updatedTodo);
        }

        @GetMapping("/upcoming")
        public List<Todo> getUpcomingTodos(@RequestParam int days) {
            return todoService.getUpcomingTodos(days);
        } 
        @PutMapping("/complete-multiple")
        public ResponseEntity<List<Todo>> markMultipleAsCompleted(@RequestBody List<Long> ids) {
            List<Todo> updatedTodos = todoService.markMultipleAsCompleted(ids);
            return ResponseEntity.ok(updatedTodos);
        }
        @PostMapping("/bulk")
        public ResponseEntity<List<TodoDTO>> addMultipleTodos(@RequestBody List<TodoDTO> todoDTOs) {
            List<TodoDTO> createdTodos = todoService.addMultipleTodos(todoDTOs);
            return ResponseEntity.ok(createdTodos);
        }

    // Aquí puedes agregar endpoints para actualizar, eliminar, etc.
}
