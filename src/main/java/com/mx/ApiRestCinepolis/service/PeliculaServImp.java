package com.mx.ApiRestCinepolis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestCinepolis.Dao.PeliculasDao;
import com.mx.ApiRestCinepolis.model.Peliculas;

@Service

public class PeliculaServImp {
	@Autowired
	PeliculasDao peliculaDao;

	@Transactional(readOnly=true)
	public List<Peliculas>listar(){
		List<Peliculas>regBd=peliculaDao.findAll();
		return regBd ;
	}
	@Transactional
	public String guardar(Peliculas pelicula) {
		
		 String respuesta = "Guardado";
	        boolean bandera = false;

	        for (Peliculas p : peliculaDao.findAll()) {
	            if (p.getClave().equals(pelicula.getClave())) {
	                respuesta = "Clave ya existe";
	               bandera = true;
	                break;
	            } else if (p.getNombre().equals(pelicula.getNombre())) {
	                respuesta = "Nombre ya existe";
	                bandera = true;
	                break;
	            }
	        }

	        if (!bandera) {
	            peliculaDao.save(pelicula);
	        }
	        return respuesta;
	    }
	        @Transactional(readOnly=true)
	        public Peliculas buscarXid(Long id) {
	    		Peliculas PeliEncon=peliculaDao.findById(id).orElse(null);
	    		return PeliEncon;
	    	}
	        
	        @Transactional
	    	public boolean editar(Peliculas pelicula) {
	    		Peliculas PeliEncon=peliculaDao.findById(pelicula.getIdPelicula()).orElse(null);
	    		
	    		if (PeliEncon != null) {
	    			peliculaDao.save(pelicula);
	    			return true;
	    			
	    		} else 
	    			return false;
	    		}
	        
	        @Transactional
	    	public boolean eliminar(Long id) {
	    		Peliculas peliEncon = peliculaDao.findById(id).orElse(null);
	    		if (peliEncon != null) {
	    			peliculaDao.deleteById(id);
	    			return true;
	    		} else {
	    			return false;
	    		}
	    	}
	    
	    	}
