package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoVehiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;	
	private Float Precio;
	private Float pesoMinimo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return Precio;
	}

	public void setPrecio(Float precio) {
		this.Precio = precio;
	}

	public Float getPesoMinimo() {
		return pesoMinimo;
	}

	public void setPesoMinimo(Float pesoMinimo) {
		this.pesoMinimo = pesoMinimo;
	}
	
}
