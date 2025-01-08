package com.example.todoapp.dto;

import java.time.LocalDate;

public class CreateTodo {
    private Long idUsuario; // ID del usuario al que pertenece el Todo
    private String descripcion; // Descripción del Todo
    private String title; // Título del Todo
    private String prioridad; // Prioridad del Todo (por ejemplo: "Alta", "Media", "Baja")
    private LocalDate dueDate; // Fecha límite del Todo

  

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
