package ar.edu.unlam.tallerweb1.dao;
import java.util.List;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

public interface ViajeDao {
	Viaje guardarViaje(Viaje viaje);
	Viaje buscarViajePorId(Long id);
	List<Viaje> buscarViajesDeChoferId(Long id);
	void ActualizarViaje(Viaje viaje);
}
