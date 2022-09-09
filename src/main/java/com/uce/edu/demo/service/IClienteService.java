package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Cliente;

public interface IClienteService {
	
	void insertarCliente(Cliente cliente);
	void actualizarCliente(Cliente cliente);
	Cliente buscarClientePorId(Integer id);
	void borrarClientePorId(Integer id);

}
