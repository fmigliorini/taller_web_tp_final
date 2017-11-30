package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

public interface ServicioViaje {
	Viaje guardarViaje(Viaje viaje);

	Viaje buscarViajePorId(Long id);

	List<Viaje> buscarViajesDeChoferId(Long id);

	void ActualizarViaje(Viaje viaje);

	List<Viaje> listarViajesAct();
    
	List<Viaje>listarViajesActivos(Usuario chofer);
    //viaje en proceso es cuando el chofer esta en camino
 	void viajeActualizadoEnProceso(Viaje viaje);
    //lista viajes hechos
  	List<Viaje>listarViajesTerminados(Usuario chofer);

	// lista viajes hechos
	List<Viaje> listarViajesTerminados(Usuario chofer);

	Viaje buscarViajeEnProceso(Usuario chofer);

}
