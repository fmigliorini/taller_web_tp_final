package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*En esta clase falta de todo, solo lo cree para usar el logViaje*/
@Entity
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_logViaje")//Esta bien ese nombre? no conozco tus relaciones
	private LogViaje logViaje;//Si no le hice a este
	//private List<LogViaje> logViajes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LogViaje getLogViaje() {
		return logViaje;
	}

	public void setLogViaje(LogViaje logViaje) {
		this.logViaje = logViaje;
	}
	
}
