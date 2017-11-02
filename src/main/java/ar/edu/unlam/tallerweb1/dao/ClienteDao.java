package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

public interface ClienteDao 
{
	List<Cliente> listarClientes();
	Cliente buscarPorId(Long id);
}
