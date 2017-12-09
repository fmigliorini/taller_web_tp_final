package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Servicio de Usuarios.

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service
// Interface que define los metodos del Servicio de Usuarios.

public interface ServicioUsuario {

	Usuario generarUsuario(Usuario usuario);

	Usuario buscarPorId(Long id);

	List<Usuario> listarChoferes();

	void actualizarUsuario(Usuario usuario);

	void eliminarUsuario(Usuario usuario);
	
	List<Usuario> usuariosRol(String rol);
	List<Usuario>listarChoferesSinVehiculo();


}
