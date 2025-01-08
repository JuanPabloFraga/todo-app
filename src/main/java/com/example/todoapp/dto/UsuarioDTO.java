package com.example.todoapp.dto;

import com.example.todoapp.model.Usuario;

public class UsuarioDTO {
    private Long id;
    private String Username;
    private String email;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.Username = usuario.getUsername();
        this.email = usuario.getEmail();
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
} 