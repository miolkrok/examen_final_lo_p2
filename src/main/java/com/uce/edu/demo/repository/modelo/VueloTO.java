package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;


public class VueloTO {
	
	
	private String numeroVuelo;
	private String origen;
	private String destino;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private String fechaVuelo;
	private String categoria;
	private String nombreAvion;
	private BigDecimal valorAsiento;
	private String estado;
	
	public VueloTO() {
		// TODO Auto-generated constructor stub
	}



	public VueloTO(String numeroVuelo, String origen, String destino, String fechaVuelo, String categoria,
			String nombreAvion, BigDecimal valorAsiento, String estado) {
		super();
		this.numeroVuelo = numeroVuelo;
		this.origen = origen;
		this.destino = destino;
		this.fechaVuelo = fechaVuelo;
		this.categoria = categoria;
		this.nombreAvion = nombreAvion;
		this.valorAsiento = valorAsiento;
		this.estado = estado;
	}



	public String getNumeroVuelo() {
		return numeroVuelo;
	}
	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getFechaVuelo() {
		return fechaVuelo;
	}
	public void setFechaVuelo(String fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNombreAvion() {
		return nombreAvion;
	}
	public void setNombreAvion(String nombreAvion) {
		this.nombreAvion = nombreAvion;
	}
	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}
	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
