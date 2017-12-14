package ar.edu.unlam.tallerweb1.servicios;

import java.util.Date;
import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

public interface ServicioViaje {
	Viaje guardarViaje(Viaje viaje);

	Viaje buscarViajePorId(Long id);

	List<Viaje> buscarViajesDeChoferId(Long id);

	void ActualizarViaje(Viaje viaje);

	List<Viaje> listarViajesAct();

	List<Viaje> listarViajesActivos(Usuario chofer);

	// viaje en proceso es cuando el chofer esta en camino
	void viajeActualizadoEnProceso(Viaje viaje);

	// lista viajes hechos
	List<Viaje> listarViajesTerminados(Usuario chofer);

	Viaje buscarViajeEnProceso(Usuario chofer);

	List<Viaje> listarViajesIntervalo(Date fechaHora, Date fechaHoraFin, Vehiculo vehiculo);

	List<Viaje> listarViajesActVeh(TipoVehiculo t);

	List<Viaje> listarViajesEstado(String estado);
	List<Viaje> listarViajesIntervaloTerminado(Date fechaHora, Date fechaHoraFin);
}
