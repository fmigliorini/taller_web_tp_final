package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Usuario;


//Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);
	Usuario generarUsuario (Usuario usuario);
	Usuario buscarPorId (Long id);
	List<Usuario> listarChoferes();
	//abm
	void update(Usuario usuario);
	void delete(Usuario usuario);

}
