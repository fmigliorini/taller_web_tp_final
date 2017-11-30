package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ViajeDao;
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
		return viajeDao.buscarViajePorId( id);
	}

	@Override
	public List<Viaje> buscarViajesDeChoferId(Long id) {

		return viajeDao.buscarViajesDeChoferId(id);
	}

	public void ActualizarViaje(Viaje viaje){

		 viajeDao.ActualizarViaje(viaje);
	}



	@Override
	public List<Viaje> listarViajesActivos(Usuario chofer) {
		
		return viajeDao.listarViajesActivos(chofer);
	}


	//actualiza el estado de viaje
	public void viajeActualizadoEnProceso(Viaje viaje){
			
			 viajeDao.viajeActualizadoEnProceso(viaje);
			 viajeDao.guardarViaje(viaje);
	}
	//trae viajes terminados
	@Override
	public List<Viaje> listarViajesTerminados(Usuario chofer) {
			
			return viajeDao.listarViajesTerminados(chofer);

	}
}