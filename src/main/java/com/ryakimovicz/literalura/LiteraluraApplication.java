package com.ryakimovicz.literalura;

import com.ryakimovicz.literalura.model.Datos;
import com.ryakimovicz.literalura.service.ConsumoAPI;
import com.ryakimovicz.literalura.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1. Instanciamos nuestras clases de servicio
		var consumoApi = new ConsumoAPI();
		var convierteDatos = new ConvierteDatos();

		// 2. Definimos la URL para buscar un libro
		var url = "https://gutendex.com/books/?search=Don+Quixote";

		// 3. Obtenemos el JSON de la API
		var json = consumoApi.obtenerDatos(url);
		System.out.println("JSON recibido: " + json);

		// 4. Convertimos el JSON a nuestros objetos Java
		var datos = convierteDatos.obtenerDatos(json, Datos.class);

		// 5. Mostramos el título del primer libro para verificar
		if (datos != null && !datos.resultados().isEmpty()) {
			var primerLibro = datos.resultados().get(0);
			System.out.println("Título del primer libro: " + primerLibro.titulo());
		} else {
			System.out.println("No se encontraron resultados.");
		}
	}
}
