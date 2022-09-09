package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="vuelo")
public class Vuelo {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_vuelo")
	@SequenceGenerator(name = "seq_vuelo", sequenceName = "seq_vuelo", allocationSize = 1)
	@Id
	@Column(name="vuel_id")
	private Integer id;
	
	@Column(name="vuel_numero_vuelo")
	private String numeroVuelo;
	
	@Column(name="vuel_fecha_vuelo", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaVuelo;

	@Column(name="vuel_asientos_disponibles")
	private Integer asientosDisponibles;
	
	@Column(name="vuel_origen")
	private String origen;
	
	@Column(name="vuel_destino")
	private String destino;
	
	@Column(name="vuel_categoria")
	private String categoria;
	
	@Column(name="vuel_valor_asiento")
	private BigDecimal valorAsiento;
	
	@Column(name="vuel_estado")
	private String estado;
	
	@OneToMany(mappedBy = "vuelo",cascade=CascadeType.ALL)//De donde sale????
	private List<CompraPasaje> compraPasajeV;
	
	@ManyToOne
	@JoinColumn(name="avio_id")
	private Avion avion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public List<CompraPasaje> getCompraPasajeV() {
		return compraPasajeV;
	}

	public void setCompraPasajeV(List<CompraPasaje> compraPasajeV) {
		this.compraPasajeV = compraPasajeV;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	


}
