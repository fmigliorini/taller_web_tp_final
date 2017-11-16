package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
@Service
public interface ServicioLogViaje {

	LogViaje gardarLogViaje(LogViaje logViaje);
	public List<LogViaje> listarLogViaje();
	public LogViaje buscarPorId(Long id);

}
