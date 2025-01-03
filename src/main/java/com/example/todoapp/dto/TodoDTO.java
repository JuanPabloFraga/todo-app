package com.example.todoapp.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.Pattern;


/**
 * Esta clase es un DTO (Data Transfer Object) que se utiliza para transferir los datos de un Todo.
 * Un DTO se utiliza para evitar la exposición directa de las entidades a través de la API.
 */
public class TodoDTO {

    private Long id;
    @NotNull(message = "Title cannot be null") // El título no puede ser nulo
    @Size(min = 1, max = 100, message = "Title must be between 1 and 100 characters")
    private String title;
    
    private String description;
    
    private boolean completed;
    
    @NotNull(message = "Priority cannot be null")
    @Pattern(regexp = "High|Medium|Low", message = "Priority must be 'High', 'Medium', or 'Low'")
    private String priority;
    
    @NotNull(message = "Due date cannot be null") // La fecha límite no puede ser nula
    @FutureOrPresent(message = "Due date must be in the future or today")
    private LocalDate dueDate;

    // Constructor vacío
    public TodoDTO() {
    }

    // Constructor con parámetros
    public TodoDTO(Long id, String title, String description, boolean completed, String priority, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    public String getPriority() {
    	return priority;
    	}
    
    public void setPriority(String priority) {
    	this.priority = priority;
    }
}
