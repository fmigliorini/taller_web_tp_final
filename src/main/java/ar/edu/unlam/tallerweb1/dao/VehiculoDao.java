package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import java.util.Date;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface VehiculoDao {
	List<Vehiculo> getAll();

	List<Vehiculo> listarPorTipoVehiculo(TipoVehiculo tipoVehiculo);

	Vehiculo buscarPorId(Long id);

	Vehiculo buscarChofer(Usuario chofer);

	Vehiculo guardarVehiculo(Vehiculo vehiculo);

	void actualizarVehiculo(Vehiculo vehiculo);

	void eliminarVehiculo(Vehiculo vehiculo);

	List<Vehiculo> listarVehiculosDisponibles(Date fechaHora, Date fechaHoraFin);
}