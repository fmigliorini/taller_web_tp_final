package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.TipoVehiculoDao;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;

@Service("servicioTipoVehiculo")
@Transactional
public class ServicioTipoVehiculoImpl implements ServicioTipoVehiculo {
	
	@Inject
	private TipoVehiculoDao tipoVehiculoDao;
	
	@Override
	public List<TipoVehiculo> listarTiposVehiculos()
	{
		return tipoVehiculoDao.listarTiposVehiculos();
	}

	@Override
	public TipoVehiculo buscarPorId(Long id)
	{
		return tipoVehiculoDao.buscarPorId(id);
	}
}
