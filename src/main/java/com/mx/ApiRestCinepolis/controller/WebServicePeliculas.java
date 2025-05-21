package com.mx.ApiRestCinepolis.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mx.ApiRestCinepolis.model.Peliculas;
import com.mx.ApiRestCinepolis.service.PeliculaServImp;

@RestController
@RequestMapping(path ="WebServicePeliculas")
public class WebServicePeliculas {
	
	   @Autowired
	PeliculaServImp peliculaServImp;
	
	@GetMapping(path = "Mostrar")
	public List<Peliculas> Mostrar(){
		 return peliculaServImp.listar();
	}
	@PostMapping(path = "Guardar")
	public ResponseEntity<?> guardar(@RequestBody Peliculas pelicula) {
		try {
			String response = peliculaServImp.guardar(pelicula);

			if (response.equals("Clave ya existe"))
				return new ResponseEntity<>("Esa clave ya existe", HttpStatus.OK);
			else if (response.equals("Nombre ya existe"))
				return new ResponseEntity<>("Ese nombre ya existe", HttpStatus.OK);
			else
				return new ResponseEntity<>(pelicula, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Error al guardar", HttpStatus.OK);
		}
	}

	// http://localhost:9000/WebServicePeliculas/buscarXid
	@PostMapping(path = "buscarXid")
	public Peliculas buscarXid(@RequestBody Peliculas pelicula) {
		return peliculaServImp.buscarXid(pelicula.getIdPelicula());
	}

	// http://localhost:9000/WebServicePeliculas/editar
	@PutMapping(path = "editar")
	public ResponseEntity<?> editar(@RequestBody Peliculas pelicula) {
		boolean response = peliculaServImp.editar(pelicula);
		if (response == true)
			return new ResponseEntity<>(pelicula, HttpStatus.CREATED);
		else
			return new ResponseEntity<>("No se editó, ese registro no existe", HttpStatus.OK);
	}

	// http://localhost:9000/WebServicePeliculas/eliminar
	@DeleteMapping(path = "eliminar")
	public ResponseEntity<String> eliminar(@RequestBody Peliculas pelicula) {
		boolean response = peliculaServImp.eliminar(pelicula.getIdPelicula());
		if (response == true)
			return new ResponseEntity<>("Eliminado correctamente", HttpStatus.OK);
		else
			return new ResponseEntity<>("No se eliminó, ese registro no existe", HttpStatus.OK);
	}
}

