package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

public class ClienteDaoImpl implements ClienteDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cliente> listarClientes()
	{
	
		final Session session = sessionFactory.getCurrentSession();
		List<Cliente> clientes = session.createCriteria(Cliente.class)
									.addOrder(Order.asc("apellido"))
									.addOrder(Order.asc("nombre"))
									.list();
		return clientes;
									
	}
	
    

}
