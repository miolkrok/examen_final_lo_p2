package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Avion;

public interface IAvionRepo {
	
	public void insertarAvion(Avion avion);
	public void actualizarAvion(Avion avion);
	public Avion buscarAvionPorId(Integer id);
	public void borrarAvionPorId(Integer id);
	public Avion buscarPorNombre(String nombreAvion);

}
