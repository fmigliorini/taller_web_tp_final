package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

public interface ServicioCliente {
	Cliente consultarCliente(Cliente cliente);
	void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Integer id);
    List list();
    Cliente getById(Long id);

}
