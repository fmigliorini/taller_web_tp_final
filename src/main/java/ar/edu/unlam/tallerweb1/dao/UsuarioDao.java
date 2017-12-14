package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

//Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {

	Usuario consultarUsuario(Usuario usuario);

	Usuario generarUsuario(Usuario usuario);

	void actualizarUsuario(Usuario usuario);

	void eliminarUsuario(Usuario usuario);

	Usuario buscarPorId(Long id);

	List<Usuario> listarChoferes();

	List<Usuario> usuariosRol(String rol);

//	List<Usuario> listarChoferesSinVehiculo();
	
    Usuario consultarUsuarioPorEmail(Usuario usuario);
	

}
