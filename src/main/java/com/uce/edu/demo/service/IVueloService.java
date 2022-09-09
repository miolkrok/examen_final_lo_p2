package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloService {
	
	
	void insertarVuelo(Vuelo vuelo);
	void actualizarVuelo(Vuelo vuelo);
	Vuelo buscarVueloPorId(Integer id);
	void borrarVueloPorId(Integer id);
	Vuelo buscarPorNumeroVuelo(String numeroVuelo);
	public List<Vuelo> buscarVuelosDispon(String origen, String destino, LocalDateTime fechaVuelo);

		
	

}
