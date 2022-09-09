package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICompraPasajeRepo;
import com.uce.edu.demo.repository.modelo.CompraPasaje;
@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService{
	
	@Autowired
	private ICompraPasajeRepo compraPasajeRepo;

	@Override
	public void insertarCompraPasaje(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.compraPasajeRepo.insertarCompraPasaje(compraPasaje);
	}

	@Override
	public void actualizarCompraPasaje(CompraPasaje compraPasaje) {
		// TODO Auto-generated method stub
		this.compraPasajeRepo.actualizarCompraPasaje(compraPasaje);
	}

	@Override
	public CompraPasaje buscarCompraPasajePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepo.buscarCompraPasajePorId(id);
	}

	@Override
	public void borrarCompraPasajePorId(Integer id) {
		// TODO Auto-generated method stub
		this.compraPasajeRepo.borrarCompraPasajePorId(id);
	}

	@Override
	public CompraPasaje buscarCompraPasajePorNumero(String numeroCompra) {
		// TODO Auto-generated method stub
		return this.compraPasajeRepo.buscarCompraPasajePorNumero(numeroCompra);
	}

}
