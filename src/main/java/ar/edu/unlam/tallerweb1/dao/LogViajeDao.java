package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;

public interface LogViajeDao {
	
	LogViaje gardarLogViaje(LogViaje logViaje);
	List<LogViaje>listarLogViajes();
	LogViaje buscarPorId(Long id);
	
		
}
