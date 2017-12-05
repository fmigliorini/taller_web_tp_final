package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

public interface LogViajeDao {

	LogViaje gardarLogViaje(LogViaje logViaje);

	List<LogViaje> listarLogViajePorViaje(Viaje viaje);

	LogViaje buscarPorId(Long id);

	public List<LogViaje> buscarPorIdViaje(Long id);

	List<LogViaje> findByViaje(Viaje viaje);
	public List<LogViaje> listarLogViaje();
}
