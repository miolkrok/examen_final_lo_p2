package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.ReservaPasajeTO;
import com.uce.edu.demo.repository.modelo.VueloTO;

public interface IGestorClienteService {
	
	List<VueloTO> buscarVuelosDispon(String origen, String destino, String fechaVuelo);
	ReservaPasajeTO vueloNumero(String numeroVuelo);
	boolean reservarPasajesAereos(Integer cantidad, String numeroTarjeta, String numeroVuelo);

}
