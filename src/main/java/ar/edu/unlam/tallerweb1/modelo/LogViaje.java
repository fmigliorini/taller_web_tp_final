package ar.edu.unlam.tallerweb1.modelo;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class LogViaje {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descripcion;
	private Double precio;
	@OneToMany(mappedBy = "logViaje", cascade = CascadeType.ALL)
	private List<Viaje> viajes = new LinkedList<Viaje>();
	
	//private Viaje idViaje;
	
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public List<Viaje> getViajes() {
		return viajes;
	}
	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	
}
