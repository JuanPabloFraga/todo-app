package com.example.todoapp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Esta clase representa la entidad Todo. Se utiliza para interactuar con la base de datos.
 */
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    private String prioridad;
    
    @Column(nullable = true)
    private LocalDate dueDate; // Nueva propiedad para fecha límite
    
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // Constructores, getters y setters
    public Todo() {
    }

    public Todo(Long id, String title, String description, boolean completed, String prioridad,LocalDate dueDate, Usuario usuario) {
       
       this.id = id;
       this.title = title;
       this.description = description;
       this.completed = completed;
       this.prioridad = prioridad;
       this.dueDate=dueDate;
       this.usuario=usuario;
    }
    
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
    
    public String getPriority() {
        return prioridad;
    }
    
    public void setPriority(String prioridad) {
        this.prioridad = prioridad;
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
    
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	} 
}
