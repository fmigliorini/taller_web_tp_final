package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.dao.ClienteDao;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

@Service("servicioCliente")
public class ServicioClienteImpl implements ClienteDao {

	@Inject
	private ClienteDao clienteDao;
	
	
	@Override
	public List<Cliente> listarClientes()
	{
		return clienteDao.listarClientes();
	}
}