package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

public interface ServicioCliente {

	public List<Cliente> listarClientes();
	public Cliente buscarPorId(Long id);
	
}
