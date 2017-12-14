
package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service
public interface ServicioVehiculo {
	List<Vehiculo> getAll();

	List<Vehiculo> listarPorTipoVehiculo(TipoVehiculo tipoVehiculo);

	Vehiculo buscarPorId(Long id);

	Vehiculo buscarChofer(Usuario chofer);

	Vehiculo guardarVehiculo(Vehiculo vehiculo);

	void actualizarVehiculo(Vehiculo vehiculo);

	void eliminarVehiculo(Vehiculo vehiculo);

	List<Vehiculo> listarVehiculosDisponibles(Date fechaHora, Date fechaHoraFin, long idTipoVehiculo);
	
	List<Vehiculo> getVehiculosDisponibles(Date fechaHora, Date fechaHoraFin, TipoVehiculo tipoVehiculo, boolean externo);

	long getIdVehiculoDisponible(Date fechaHora, Date fechaHoraFin, TipoVehiculo tipoVehiculo, boolean externo);
}
