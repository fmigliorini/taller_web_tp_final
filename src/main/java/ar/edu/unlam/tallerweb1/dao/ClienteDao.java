package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

public interface ClienteDao {

	Cliente consultarCliente(Cliente cliente);

	void save(Cliente cliente);

	void update(Cliente cliente);

	void delete(Long id);

	List list();

	Cliente getById(Long id);
}
