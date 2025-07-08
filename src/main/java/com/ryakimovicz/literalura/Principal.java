package com.ryakimovicz.literalura;

import com.ryakimovicz.literalura.model.Autor;
import com.ryakimovicz.literalura.model.Datos;
import com.ryakimovicz.literalura.model.DatosLibro;
import com.ryakimovicz.literalura.model.Libro;
import com.ryakimovicz.literalura.repository.LibroRepository;
import com.ryakimovicz.literalura.service.ConsumoAPI;
import com.ryakimovicz.literalura.service.ConvierteDatos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service // Anotación para marcar como un servicio de Spring
public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "https://gutendex.com/books/";
    private LibroRepository libroRepository; // Repositorio

    // Constructor para inyectar el repositorio
    public Principal(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por título 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void buscarLibroWeb() {
        System.out.println("Escribe el nombre del libro que deseas buscar:");
        var nombreLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .findFirst();

        if (libroBuscado.isPresent()) {
            System.out.println("Libro Encontrado ");
            var datosLibro = libroBuscado.get();

            Libro libro = new Libro(datosLibro);
            Autor autor = new Autor(datosLibro.autor().get(0));
            libro.setAutor(autor);

            // Guardamos en la base de datos
            libroRepository.save(libro);

            System.out.println(libro);

        } else {
            System.out.println("Libro no encontrado");
        }
    }
}