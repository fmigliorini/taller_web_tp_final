package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

@Repository("ClienteDao")
public class ClienteDaoImpl implements ClienteDao
{

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<Cliente> listarClientes()
	{
	
		final Session session = sessionFactory.getCurrentSession();
		List<Cliente> clientes = session.createCriteria(Cliente.class)
									.list();
		return clientes;
									
	}
	
    @Override
    public Cliente buscarPorId(Long id)
    {
		final Session session = sessionFactory.getCurrentSession();
		return (Cliente) session.createCriteria(Cliente.class)
							.add(Restrictions.eq("id", id))
							.uniqueResult();
		
    }

}
