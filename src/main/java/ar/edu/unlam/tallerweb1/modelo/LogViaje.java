package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LogViaje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipoLogViaje;
	private Double precio;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_viaje")
	private Viaje viaje;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipoLogViaje() {
		return tipoLogViaje;
	}
	public void setTipoLogViaje(String tipoLogViaje) {
		this.tipoLogViaje = tipoLogViaje;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Viaje getViaje() {
		return viaje;
	}
	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
}
