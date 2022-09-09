package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Avion;

public interface IAvionService {
	
	public void insertarAvion(Avion avion);
	public void actualizarAvion(Avion avion);
	public Avion buscarAvionPorId(Integer id);
	public void borrarAvionPorId(Integer id);
	public Avion buscarPorNombre(String nombreAvion); 

}
