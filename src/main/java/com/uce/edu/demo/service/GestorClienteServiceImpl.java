package com.uce.edu.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepo;
import com.uce.edu.demo.repository.modelo.Avion;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.ReservaPasajeTO;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloTO;

@Service
public class GestorClienteServiceImpl implements IGestorClienteService {

	@Autowired
	private IVueloService vueloService;

	@Autowired
	private ICompraPasajeService compraPasajeService;
	
	@Autowired
	private IAvionService avionService;
	
	@Autowired
	private IVueloRepo vueloRepo;
	
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<VueloTO> buscarVuelosDispon(String origen, String destino, String fechaVuelo) {
		// TODO Auto-generated method stub
		DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNueva = LocalDate.parse(fechaVuelo,form);
		LocalDateTime fechaFinal = LocalDateTime.of(fechaNueva, LocalDateTime.MIN.toLocalTime());
		
		List<Vuelo> vuelo = this.vueloRepo.buscarVuelosDispon(origen, destino, fechaFinal);
		
		List<Vuelo> vuelosDisponibles = vuelo.stream().filter(v -> v.getEstado().equals("DIS")).collect(Collectors.toList());
		
		List<VueloTO> vueloEncontrado = vuelosDisponibles.stream().map(v -> {
			VueloTO vueloTO = new VueloTO();
			
			vueloTO.setCategoria(v.getCategoria());
			vueloTO.setDestino(v.getDestino());
			vueloTO.setOrigen(v.getOrigen());
			vueloTO.setNombreAvion(v.getAvion().getNombreAvion());
			vueloTO.setValorAsiento(v.getValorAsiento());
			vueloTO.setNumeroVuelo(v.getNumeroVuelo());
			return vueloTO;
			
		}).collect(Collectors.toList());
		
		return vueloEncontrado;
	}

	@Override
	public ReservaPasajeTO vueloNumero(String numeroVuelo) {
		// TODO Auto-generated method stub
		Vuelo vuelo = this.vueloService.buscarPorNumeroVuelo(numeroVuelo);
		if(vuelo != null) {
			if(vuelo.getEstado().equals("DIS")) {
				Avion avio = this.avionService.buscarAvionPorId(vuelo.getAvion().getId());
				ReservaPasajeTO reservaPasajeTO = new ReservaPasajeTO();
				reservaPasajeTO.setNumeroVuelo(numeroVuelo);
				reservaPasajeTO.setAsientosDisponibles(vuelo.getAsientosDisponibles());
				reservaPasajeTO.setAsientosOcupados(avio.getCapacidadAsientos()- vuelo.getAsientosDisponibles());
				return reservaPasajeTO;
			}
		}
		return null;
	}


	@Override
	public boolean reservarPasajesAereos(Integer cantidad, String numeroTarjeta, String numeroVuelo) {
		// TODO Auto-generated method stub
		CompraPasaje compraPasaje = new CompraPasaje();
		Vuelo vuelo = this.vueloService.buscarPorNumeroVuelo(numeroVuelo);
		
		if(cantidad <= vuelo.getAsientosDisponibles()) {
			compraPasaje.setCantidadAsientosComprados(cantidad);
			compraPasaje.setCliente(compraPasaje.getCliente());
			compraPasaje.setEstado("RES");
			compraPasaje.setFechaCompra(LocalDateTime.now());
			compraPasaje.setNumeroCompra(String.valueOf((int) Math.random()*9999));
			compraPasaje.setNumeroTarjeta(numeroTarjeta);
			compraPasaje.setVuelo(vuelo);
			this.compraPasajeService.insertarCompraPasaje(compraPasaje);
			
			if((vuelo.getAsientosDisponibles()-cantidad)<=0) {
				vuelo.setEstado("ND");
				
			}
			vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles()-cantidad);
			this.vueloService.actualizarVuelo(vuelo);
			return true;
			
		}
		return false;
	}


	
	




}
