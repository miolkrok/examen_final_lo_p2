package com.uce.edu.demo.repository.modelo;

public class ReservaPasajeTO {
	
	private String numeroVuelo;
	private String estado;
	private Integer cantidadAsientosComprados;
	private String numeroTarjeta;
	private Integer asientosDisponibles;
	private Integer asientosOcupados;
	
	public ReservaPasajeTO() {
		// TODO Auto-generated constructor stub
	}



	public ReservaPasajeTO(String numeroVuelo, String estado, Integer cantidadAsientosComprados, String numeroTarjeta,
			Integer asientosDisponibles, Integer asientosOcupados) {
		super();
		this.numeroVuelo = numeroVuelo;
		this.estado = estado;
		this.cantidadAsientosComprados = cantidadAsientosComprados;
		this.numeroTarjeta = numeroTarjeta;
		this.asientosDisponibles = asientosDisponibles;
		this.asientosOcupados = asientosOcupados;
	}



	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getCantidadAsientosComprados() {
		return cantidadAsientosComprados;
	}

	public void setCantidadAsientosComprados(Integer cantidadAsientosComprados) {
		this.cantidadAsientosComprados = cantidadAsientosComprados;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public Integer getAsientosOcupados() {
		return asientosOcupados;
	}
	
	public void setAsientosOcupados(Integer asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}
	
	
	

}
