package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloRepo {
	
	void insertarVuelo(Vuelo vuelo);
	void actualizarVuelo(Vuelo vuelo);
	Vuelo buscarVueloPorId(Integer id);
	void borrarVueloPorId(Integer id);
	Vuelo buscarVueloPorEstado(String estado);
	List<Vuelo> buscarVuelosDispon(String origen, String destino, LocalDateTime fechaVuelo);
	Vuelo buscarPorNumeroVuelo(String numeroVuelo);

}
