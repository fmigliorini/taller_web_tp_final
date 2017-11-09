package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
@Service
//Interface que define los metodos del Servicio de Usuarios.
public interface ServicioUsuario {

	Usuario generarUsuario(Usuario usuario);
	Usuario buscarPorId(Long id);
}