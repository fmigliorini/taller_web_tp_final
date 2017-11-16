package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Servicio de Usuarios.
@Service
public interface ServicioLogin {

	Usuario consultarUsuario(Usuario usuario);
}
