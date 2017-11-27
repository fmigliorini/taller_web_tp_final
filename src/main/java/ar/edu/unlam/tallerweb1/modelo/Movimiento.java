package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int puntoVenta;
	private Long numeroMovimiento;
	private String fecha_hora;
	private String fecha_vencimiento;
	private char letra;
	private String observaciones;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_tipoMovimento")
	private TipoMovimiento tipoMovimiento;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_EstadoMovimento")
	private EstadoMovimiento estadoMovimiento;
	
	@OneToOne
	private Viaje viaje;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_Usuario")
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public int getPuntoVenta() {
		return puntoVenta;
	}

	public void setPuntoVenta(int puntoVenta) {
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
	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
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
	
	public TipoMovimiento getEstadoMovimiento() {
		return tipoMovimiento;
	}

	public void setEstadoMovimiento(EstadoMovimiento estadoMovimiento) {
		this.estadoMovimiento = estadoMovimiento;
	}
	
	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}


}

