package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;

public interface TipoVehiculoDao {
	List<TipoVehiculo> listarTiposVehiculos();
	TipoVehiculo buscarPorId(Long id);
	TipoVehiculo buscarPorPesoMaximo(Float peso);

}
