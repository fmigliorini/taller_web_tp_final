package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe

// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion

//ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
//para encontrar esta clase.
//La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
//dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
//en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion

@Service("ServicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

	@Inject
	private ServicioVehiculo servicioVehiculo;

	@Inject
	private UsuarioDao servicioUsuarioDao;

	@Override
	public Usuario generarUsuario(Usuario usuario) {
		return servicioUsuarioDao.generarUsuario(usuario);
	}

	@Override
	public Usuario buscarPorId(Long id) {
		return servicioUsuarioDao.buscarPorId(id);
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		servicioUsuarioDao.actualizarUsuario(usuario);
	}

	@Override
	public void eliminarUsuario(Usuario usuario) {
		servicioUsuarioDao.eliminarUsuario(usuario);
	}

	@Override
	public List<Usuario> listarChoferes() {

		return servicioUsuarioDao.listarChoferes();
	}

	@Override
	public List<Usuario> usuariosRol(String rol) {

		return servicioUsuarioDao.usuariosRol(rol);
	}

	@Override
	public List<Usuario> listarChoferesSinVehiculo() {
		List<Usuario> choferes = servicioUsuarioDao.listarChoferes();
		List<Usuario> choferEliminar = new ArrayList<Usuario>();
		for (Usuario chofer : choferes) {
			Vehiculo vehiculo = servicioVehiculo.buscarChofer(chofer);
			if (vehiculo != null) {
				choferEliminar.add(chofer);
			}

		}
		choferes.removeAll(choferEliminar);
		return choferes;
	}

	@Override
	public Usuario consultarUsuarioPorEmail(Usuario usuario) {

		return servicioUsuarioDao.consultarUsuarioPorEmail(usuario);
	}

}
