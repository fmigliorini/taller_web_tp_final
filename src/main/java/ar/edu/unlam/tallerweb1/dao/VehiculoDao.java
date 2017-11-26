package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface VehiculoDao {
	List<Vehiculo> listarPorTipoVehiculo(TipoVehiculo tipoVehiculo);
	Vehiculo buscarPorId(Long id);
	Vehiculo buscarChofer(Usuario chofer);
	Vehiculo guardarVehiculo(Vehiculo vehiculo);

}