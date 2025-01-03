# Task Management API

Este proyecto es una API RESTful para la gestión de tareas. Incluye funcionalidades para crear, leer, actualizar y eliminar tareas, implementada en Java con Spring Boot y Docker.

## Características

- Gestión de tareas: Crear, leer, actualizar y eliminar tareas.
- Arquitectura RESTful.
- Persistencia de datos con MySQL.
- Contenedores Docker para garantizar portabilidad.
- Pruebas unitarias implementadas con JUnit y Mockito.

## Requisitos previos

Asegúrate de tener instalados los siguientes componentes:

- Docker
- Java 17+
- Maven
- Git 

## Instalación

**Clona el repositorio**
   git clone [(https://github.com/JuanPabloFraga/todo-app.git)]
   cd tu-repositorio
   mvn clean install
   docker-compose up --build

Acceso a la API: La API estará disponible en: http://localhost:8080.



##Endpoint principales
Tareas
Obtener todas las tareas: GET /api/tasks
Obtener una tarea por ID: GET /api/tasks/{id}
Crear una nueva tarea: POST /api/tasks
Actualizar una tarea: PUT /api/tasks/{id}
Eliminar una tarea: DELETE /api/tasks/{id}


##Tecnologías utilizadas
Java 17: Lenguaje principal.
Spring Boot: Framework para construir la API.
MySQL: Base de datos relacional.
Docker: Contenerización de la aplicación.
JUnit y Mockito: Pruebas unitarias y simulación.
Maven: Gestión de dependencias y construcción.







