package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

public interface LogViajeDao {
	
	LogViaje gardarLogViaje(LogViaje logViaje);
	List<LogViaje>listarLogViajesPorViaje();
	LogViaje buscarPorId(Long id);
	
		
}
