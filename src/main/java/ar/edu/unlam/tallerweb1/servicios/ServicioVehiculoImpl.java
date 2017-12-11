package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TipoVehiculoDao;
import ar.edu.unlam.tallerweb1.dao.VehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

@Service("servicioVehiculo")
@Transactional
public class ServicioVehiculoImpl implements ServicioVehiculo {

	@Inject
	private ServicioViaje servicioViaje;

	@Inject
	private VehiculoDao vehiculoDao;

	@Override
	public List<Vehiculo> getAll() {
		return vehiculoDao.getAll();
	}

	@Override
	public List<Vehiculo> listarPorTipoVehiculo(TipoVehiculo tipoVehiculo) {
		return vehiculoDao.listarPorTipoVehiculo(tipoVehiculo);
	}

	@Override
	public Vehiculo buscarPorId(Long id) {
		return vehiculoDao.buscarPorId(id);
	}

	@Override
	public Vehiculo buscarChofer(Usuario chofer) {
		return vehiculoDao.buscarChofer(chofer);
	}

	// viaje en proceso
	@Override
	public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
		return vehiculoDao.guardarVehiculo(vehiculo);
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		vehiculoDao.actualizarVehiculo(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) {
		vehiculoDao.eliminarVehiculo(vehiculo);
	}

	@Override
	public List<Vehiculo> listarVehiculosDisponibles(String diaInicioViaje, String horaInicioViaje, String diaFinViaje,
			String horaFinViaje) {
		return vehiculoDao.listarVehiculosDisponibles(diaInicioViaje, horaInicioViaje, diaFinViaje, horaFinViaje);
	}

	@Override
	public List<Vehiculo> getVehiculosDisponibles(String fecha, String hora, String fechaFin, String horaFin) {

		List<Vehiculo> vehiculos = vehiculoDao.getAll();
		List<Viaje> viajes = servicioViaje.listarViajesIntervalo(fecha, hora, fechaFin, horaFin);

		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo != null) {
				if (viajes.contains(vehiculo) || vehiculo.getTipoVehiculo().getDescripcion() == "Terceros") {
					vehiculos.remove(vehiculo);
				}
			}
		}

		return vehiculos;
	}

	@Override
	public long getIdVehiculoDisponible(String fecha, String hora, String fechaFin, String horaFin) {
		List<Vehiculo> vehiculos = getVehiculosDisponibles(fecha, hora, fechaFin, horaFin);

		if (vehiculos.isEmpty()) {
			return 0;
		} else {
			return vehiculos.get(0).getId();
		}

	}

}
