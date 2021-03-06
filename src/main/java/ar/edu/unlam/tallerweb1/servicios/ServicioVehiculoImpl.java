package ar.edu.unlam.tallerweb1.servicios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
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
	public List<Vehiculo> listarVehiculosDisponibles(Date fechaHora, Date fechaHoraFin, long idTipoVehiculo) {
		return vehiculoDao.listarVehiculosDisponibles(fechaHora, fechaHoraFin, idTipoVehiculo);
	}

	public List<Vehiculo> getVehiculosDisponibles(Date fechaHora, Date fechaHoraFin, TipoVehiculo tipoVehiculo, boolean externo) {

		List<Vehiculo> vehiculos = vehiculoDao.listarPorTipoVehiculo(tipoVehiculo);
		List<Vehiculo> vehiculosEliminar = new ArrayList<Vehiculo>();
		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo != null) {
				List<Viaje> viajes = servicioViaje.listarViajesIntervalo(fechaHora, fechaHoraFin, vehiculo);
				if (viajes != null && viajes.size() > 0 || vehiculo.isExterno()!= externo) {
					vehiculosEliminar.add(vehiculo);
				}
			}
			
		}
		vehiculos.removeAll(vehiculosEliminar);
		return vehiculos;
	}

	@Override
	public long getIdVehiculoDisponible(Date fechaHora, Date fechaHoraFin, TipoVehiculo tipoVehiculo, boolean externo) {
		List<Vehiculo> vehiculos = getVehiculosDisponibles(fechaHora, fechaHoraFin, tipoVehiculo, externo);

		if (vehiculos.isEmpty()) {
			return 0;
		} else {
			return vehiculos.get(0).getId();
		}

	}

}
