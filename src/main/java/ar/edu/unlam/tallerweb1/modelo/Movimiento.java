package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long puntoVenta;
	private Long numeroMovimiento;
	private String fecha_hora;
	
	@OneToOne
	private TipoMovimiento tipoMovimiento;
	
	@OneToOne
	private Viaje viaje;
	
	@OneToOne
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Long getPuntoVenta() {
		return puntoVenta;
	}

	public void setPuntoVenta(Long puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
	public Long getNumeroMovimiento() {
		return numeroMovimiento;
	}

	public void setNumeroMovimiento(Long numeroMovimiento) {
		this.numeroMovimiento = numeroMovimiento;
	}
	public String getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}
	
	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}
}
