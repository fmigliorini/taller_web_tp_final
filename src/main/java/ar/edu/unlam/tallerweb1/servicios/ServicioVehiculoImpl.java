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

@Service("servicioVehiculo")
@Transactional
public class ServicioVehiculoImpl implements ServicioVehiculo {

	@Inject
	private VehiculoDao vehiculoDao;

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
		return vehiculoDao.buscarChofer( chofer);
	}
	
	@Override
	public Vehiculo guardarVehiculo(Vehiculo vehiculo) {
		return vehiculoDao.guardarVehiculo( vehiculo);
	}

}
