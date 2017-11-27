package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
@Service
public interface ServicioLogViaje {

	LogViaje gardarLogViaje(LogViaje logViaje);
	public List<LogViaje> listarLogViajePorViaje();
	public LogViaje buscarPorId(Long id);

}
