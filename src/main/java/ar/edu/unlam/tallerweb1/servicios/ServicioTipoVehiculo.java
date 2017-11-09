package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
@Service
public interface ServicioTipoVehiculo {
	List<TipoVehiculo> listarTiposVehiculos();
	TipoVehiculo buscarPorId(Long id);
}
