package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;

@Service("ServicioTipoVehiculo")
public class ServicioTipoVehiculoImpl implements ServicioTipoVehiculo {
	
	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;
	
	@Override
	public List<TipoVehiculo> listarTiposVehiculos()
	{
		return servicioTipoVehiculo.listarTiposVehiculos();
	}
}
