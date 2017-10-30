package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cliente;

@Repository("ClienteDao")
public class ClienteDaoImpl implements ClienteDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Cliente consultarCliente(Cliente cliente) {

		final Session session = sessionFactory.getCurrentSession();

		return (Cliente) session.createCriteria(Cliente.class);
		
		//aca va el criteria para la busqueda

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
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List list() {
		final Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Cliente.class).list();
	}

	@Override
	public Cliente getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
