package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ClienteDao;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

@Service("servicioCliente")
@Transactional
public class ServicioClienteImpl implements ServicioCliente {

	@Inject
	private ClienteDao clienteDao;
	
	@Override
	public List<Cliente> listarClientes()
	{
		return clienteDao.listarClientes();
	}
	
	@Override
	public Cliente buscarPorId(Long id)
	{
		return clienteDao.buscarPorId(id);
	}
}