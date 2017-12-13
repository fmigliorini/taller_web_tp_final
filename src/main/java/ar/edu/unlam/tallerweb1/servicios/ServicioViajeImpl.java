package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.dao.ViajeDao;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
		return viajeDao.buscarViajePorId(id);
	}

	public List<Viaje> listarViajesAct() {
		return viajeDao.listarViajesAct();
	}

	@Override
	public List<Viaje> buscarViajesDeChoferId(Long id) {
		return viajeDao.buscarViajesDeChoferId(id);
	}

	@Override
	public void ActualizarViaje(Viaje viaje) {

		viajeDao.ActualizarViaje(viaje);
	}

	@Override
	public List<Viaje> listarViajesActivos(Usuario chofer) {
		return viajeDao.listarViajesActivos(chofer);
	}

	// actualiza el estado de viaje
	@Override
	public void viajeActualizadoEnProceso(Viaje viaje) {

		viajeDao.viajeActualizadoEnProceso(viaje);
		viajeDao.guardarViaje(viaje);
	}

	// trae viajes terminados
	@Override
	public List<Viaje> listarViajesTerminados(Usuario chofer) {
		return viajeDao.listarViajesTerminados(chofer);
	}

	@Override
	public Viaje buscarViajeEnProceso(Usuario chofer) {
		return viajeDao.buscarViajeEnProceso(chofer);
	}

	@Override
	public List<Viaje> listarViajesIntervalo(Date fechaHora, Date fechaHoraFin ) {
		return viajeDao.listarViajesIntervalo(fechaHora, fechaHoraFin);
	}
	
	public List<Viaje> listarViajesActVeh(TipoVehiculo t){
		return viajeDao.listarViajesActVeh(t);
		
	}
	
	
}