package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ClienteDao;
import ar.edu.unlam.tallerweb1.modelo.Cliente;

@Service("servicioCliente")
@Transactional

public class ServicioClienteImpl implements ServicioCliente{

	@Inject
	private ClienteDao servicioClienteDao;

	@Override
	public Cliente consultarCliente(Cliente cliente) {
		
		return servicioClienteDao.consultarCliente(cliente);
	}

	@Override
	public void save(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
