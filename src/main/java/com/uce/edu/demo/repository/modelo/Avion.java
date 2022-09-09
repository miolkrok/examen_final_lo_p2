package com.uce.edu.demo.repository.modelo;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="avion")
public class Avion {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_avion")
	@SequenceGenerator(name = "seq_avion", sequenceName = "seq_avion", allocationSize = 1)
	@Id
	@Column(name="avio_id")
	private Integer id;
	@Column(name="avio_capacidad_asientos")
	private Integer capacidadAsientos;
	@Column(name="avio_nombre_avion")
	private String nombreAvion;
	
	@OneToMany(mappedBy = "avion",cascade=CascadeType.ALL)//De donde sale????
	private List<Vuelo> vueloA;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidadAsientos() {
		return capacidadAsientos;
	}

	public void setCapacidadAsientos(Integer capacidadAsientos) {
		this.capacidadAsientos = capacidadAsientos;
	}

	public String getNombreAvion() {
		return nombreAvion;
	}

	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}

	public List<Vuelo> getVueloA() {
		return vueloA;
	}

	public void setVueloA(List<Vuelo> vueloA) {
		this.vueloA = vueloA;
	}
	

}
