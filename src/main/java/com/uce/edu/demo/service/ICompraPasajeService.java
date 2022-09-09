package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.CompraPasaje;

public interface ICompraPasajeService {
	
	void insertarCompraPasaje(CompraPasaje compraPasaje);
	void actualizarCompraPasaje(CompraPasaje compraPasaje);
	CompraPasaje buscarCompraPasajePorId(Integer id);
	void borrarCompraPasajePorId(Integer id);
	CompraPasaje buscarCompraPasajePorNumero(String numeroCompra);

}
