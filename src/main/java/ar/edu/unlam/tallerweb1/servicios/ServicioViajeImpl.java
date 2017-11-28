package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ViajeDao;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

@Service("servicioViaje")
@Transactional
public class ServicioViajeImpl implements ServicioViaje {
	
	@Inject
	private ViajeDao viajeDao;

	@Override
	public Viaje guardarViaje(Viaje viaje) {
	
		return viajeDao.guardarViaje(viaje);
	}

	@Override
	public Viaje buscarViajePorId(Long id) {
		return viajeDao.buscarViajePorId( id);
	}

	@Override
	public List<Viaje> buscarViajesDeChoferId(Long id) {

		return viajeDao.buscarViajesDeChoferId(id);
	}
	public void ActualizarViaje(Viaje viaje){

		return viajeDao.ActualizarViaje(viaje);
	}
}