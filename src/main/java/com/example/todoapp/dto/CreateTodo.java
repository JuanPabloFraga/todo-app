package com.example.todoapp.dto;

public class CreateTodo {
	   private String descripcion;
	    private Long usuarioId;
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public Long getUsuarioId() {
			return usuarioId;
		}
		public void setUsuarioId(Long usuarioId) {
			this.usuarioId = usuarioId;
		}
	    
	    
}
