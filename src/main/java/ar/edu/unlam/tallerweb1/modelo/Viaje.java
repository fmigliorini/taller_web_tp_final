package ar.edu.unlam.tallerweb1.modelo;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Viaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fecha_hora;
	private String origen;
	private String destino;
	private Integer Kilometros;
	private String descripcion;
	private Float precio;
    
	@OneToMany(mappedBy = "viaje", cascade = CascadeType.ALL)
	private List<LogViaje> logViajes = new LinkedList<LogViaje>();

   //hay que cambiar el nombre de logViaje por n_registro
	@OneToOne
	private TipoVehiculo tipoVehiculo;

	@OneToOne
	private Usuario chofer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(String fecha_hora) {
		this.fecha_hora = fecha_hora;
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

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Usuario getChofer() {
		return chofer;
	}

	public void setChofer(Usuario chofer) {
		this.chofer = chofer;
	}

	public Integer getKilometros() {
		return Kilometros;
	}

	public void setKilometros(Integer kilometros) {
		this.Kilometros = kilometros;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public List<LogViaje> getLogViajes() {
		return logViajes;
	}

	public void setLogViajes(List<LogViaje> logViajes) {
		this.logViajes = logViajes;
	}

}
