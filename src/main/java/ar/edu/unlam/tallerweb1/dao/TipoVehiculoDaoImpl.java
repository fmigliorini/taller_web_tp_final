package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;

public class TipoVehiculoDaoImpl implements TipoVehiculoDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<TipoVehiculo> listarTiposVehiculos()
	{
		final Session session = sessionFactory.getCurrentSession();
		List<TipoVehiculo> tipoVehiculos = session.createCriteria(TipoVehiculo.class)
												.addOrder(Order.asc("descripcion"))
												.list();
		return tipoVehiculos;
	}
}
