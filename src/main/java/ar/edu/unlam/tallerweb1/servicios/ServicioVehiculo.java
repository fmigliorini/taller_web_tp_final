
package ar.edu.unlam.tallerweb1.servicios;
import java.util.List;
import org.springframework.stereotype.Service;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service
public interface ServicioVehiculo {
	List<Vehiculo> listarPorTipoVehiculo(TipoVehiculo tipoVehiculo);
	Vehiculo buscarPorId(Long id);
	Vehiculo buscarChofer(Usuario chofer);
	Vehiculo guardarVehiculo(Vehiculo vehiculo);
}
