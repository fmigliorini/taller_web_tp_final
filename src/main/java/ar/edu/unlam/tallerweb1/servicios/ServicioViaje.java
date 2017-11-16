package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Viaje;

public interface ServicioViaje {
	Viaje guardarViaje(Viaje viaje);
	Viaje buscarViajePorId(Long id);
	List<Viaje> buscarViajesDeChoferId(Long id);
}
