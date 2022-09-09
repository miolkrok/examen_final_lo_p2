package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepo;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.repository.modelo.VueloTO;

@Service
public class VueloServiceImpl implements IVueloService{
	
	@Autowired
	private IVueloRepo vueloRepo;

	@Override
	public void insertarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.vueloRepo.insertarVuelo(vuelo);
	}

	@Override
	public void actualizarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.vueloRepo.actualizarVuelo(vuelo);
	}

	@Override
	public Vuelo buscarVueloPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarVueloPorId(id);
	}

	@Override
	public void borrarVueloPorId(Integer id) {
		// TODO Auto-generated method stub
		this.vueloRepo.borrarVueloPorId(id);
	}


	@Override
	public Vuelo buscarPorNumeroVuelo(String numeroVuelo) {
		// TODO Auto-generated method stub
		
		return this.vueloRepo.buscarPorNumeroVuelo(numeroVuelo);
	}


	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelosDispon(String origen, String destino, LocalDateTime fechaVuelo) {
		// TODO Auto-generated method stub
		return this.vueloRepo.buscarVuelosDispon(origen, destino, fechaVuelo);
	}



}
