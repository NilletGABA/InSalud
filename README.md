# 🏥 Proyecto Insalud - Backend

## 🚀 Descripción
Este proyecto es el **backend** de Insalud, un sistema de gestión de atenciones médicas con roles de **paciente, médico y administrador**.  
Está desarrollado con **Java + Spring Boot + Hibernate + PostgreSQL**, siguiendo la arquitectura **Modelo-Vista-Controlador (MVC)** y utilizando **REST APIs**.

---

## 🏗️ Tecnologías
- Java 17
- Spring Boot 3.5.6
- Spring Data JPA (Hibernate)
- Spring Security con JWT
- PostgreSQL
- Lombok
- Validation
- Maven

---

## ⚙️ Requisitos previos
Antes de ejecutar el proyecto asegúrate de tener instalado:
- [Java 17+](https://adoptium.net/)
- [Maven](https://maven.apache.org/)
- [PostgreSQL](https://www.postgresql.org/) (o Docker si prefieres usar contenedores)

---

## ▶️ Ejecución del backend

1. **Clonar el repositorio**
   bash
   git clone https://github.com/NilletGABA/InSalud.git
   cd insalud-backend

2. **Configurar la base de datos**
   
	CREATE DATABASE insalud;

	Edita src/main/resources/application.properties con tus credenciales de PostgreSQL:
	spring.datasource.url=jdbc:postgresql://localhost:5432/insalud
	spring.datasource.username=tu_usuario
	spring.datasource.password=tu_password

3. **Compilar y ejecutar**
	./mvnw spring-boot:run
4. **Acceder a la API**
	http://localhost:8080
4. **🔒 Autenticación**

	POST /auth/sign-in → Login
	
	POST /auth/sign-up → Registro

5. **🏥 Atenciones**

	GET /api/atenciones → Listado de todas las atenciones (ADMIN)
	
	GET /api/atenciones/mias → Listado de atenciones del paciente autenticado (PACIENTE)
	
	POST /api/atenciones → Crear atención (ADMIN/MEDICO)
	
	PUT /api/atenciones/{id} → Actualizar atención (ADMIN/MEDICO)
	
	DELETE /api/atenciones/{id} → Eliminar atención (ADMIN)
6. **Registro en Postman**
	http://localhost:8080/api/auth/register
7. **Registro**

	{
	  "usuario": "nillet",
	  "contrasena": "gamboa2025",
	  "nombre": "nillet.gamboa",
	  "email": "nilletgb@gmail.com",
	  "rol": "PACIENTE" ("ADMIN","PACIENTE", "MEDICO")
	}

