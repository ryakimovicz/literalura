# Challenge ONE - Backend: Literalura 📚

<p align="center">
  <img src="https://img.shields.io/badge/status-finalizado-brightgreen" alt="Status: Finalizado">
  <img src="https://img.shields.io/badge/Java-21-blue" alt="Java 21">
  <img src="https://img.shields.io/badge/Spring_Boot-3.3-green" alt="Spring Boot 3.3">
</p>

## 📖 Descripción del Proyecto

**Literalura** es una aplicación de consola desarrollada como parte del Challenge de Backend del programa **Oracle Next Education (ONE)**. El objetivo principal es construir un catálogo de libros interactivo que consume la API de [Gutendex](https://gutendex.com/) para obtener información sobre libros y autores, y persiste estos datos en una base de datos PostgreSQL.

Esta aplicación permite a los usuarios buscar libros por título, listar los libros y autores guardados, consultar autores vivos en un determinado año y listar libros por idioma, todo a través de una interfaz de consola intuitiva.

## ✨ Funcionalidades

La aplicación cuenta con las siguientes funcionalidades:

-   [x] **Buscar libro por título:** Consulta la API de Gutendex, encuentra el primer resultado coincidente y lo guarda en la base de datos local.
-   [x] **Listar libros registrados:** Muestra todos los libros que han sido guardados en la base de datos.
-   [x] **Listar autores registrados:** Muestra todos los autores que han sido guardados, sin duplicados.
-   [x] **Listar autores vivos en un determinado año:** Permite al usuario ingresar un año y muestra los autores que estaban vivos en ese período.
-   [x] **Listar libros por idioma:** Muestra una lista de libros filtrada por el idioma seleccionado por el usuario (Español, Inglés, Francés, Portugués).

## 🛠️ Tecnologías Utilizadas

-   **Java 21:** Versión del Lenguaje de Programación.
-   **Spring Boot 3:** Framework principal para la creación de la aplicación.
-   **Spring Data JPA:** Para la persistencia de datos y la interacción con la base de datos.
-   **PostgreSQL:** Sistema de gestión de base de datos relacional.
-   **Maven:** Gestor de dependencias y construcción del proyecto.
-   **Jackson:** Librería para el procesamiento de datos JSON obtenidos de la API.

## ⚙️ Cómo Ejecutar el Proyecto

Sigue estos pasos para ejecutar el proyecto en tu entorno local.

### **Pre-requisitos**

Asegúrate de tener instalados:

-   **Java JDK 21** o superior.
-   **Maven 4** o superior.
-   **PostgreSQL 16** o superior.
-   Un IDE de tu preferencia (ej. IntelliJ IDEA).

### **Instalación**

1.  **Clona el repositorio:**
    ```bash
    git clone [https://github.com/tu-usuario/literalura.git](https://github.com/tu-usuario/literalura.git)
    cd literalura
    ```

2.  **Configura la base de datos:**
    -   Abre tu cliente de PostgreSQL (como pgAdmin) y crea una nueva base de datos llamada `literalura`.
    -   Abre el archivo `src/main/resources/application.properties`.
    -   Modifica las siguientes líneas con tus credenciales de PostgreSQL:
        ```properties
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        ```

3.  **Ejecuta la aplicación:**
    -   Puedes ejecutar el proyecto directamente desde tu IDE, buscando la clase `LiteraluraApplication.java` y ejecutando el método `main`.
    -   O puedes usar Maven en la terminal desde la raíz del proyecto:
        ```bash
        mvn spring-boot:run
        ```

## 👨‍💻 Autor

**Román Yakimovicz**

-   [LinkedIn](https://www.linkedin.com/in/ryakimovicz/)
-   [GitHub](https://github.com/ryakimovicz/)

---
