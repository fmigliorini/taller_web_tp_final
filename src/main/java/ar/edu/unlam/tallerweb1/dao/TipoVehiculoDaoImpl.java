package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;

@Repository("TipoVehiculoDao")
public class TipoVehiculoDaoImpl implements TipoVehiculoDao {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public List<TipoVehiculo> listarTiposVehiculos()
	{
		final Session session = sessionFactory.getCurrentSession();
		List<TipoVehiculo> tipoVehiculos = session.createCriteria(TipoVehiculo.class)
												.list();
		return tipoVehiculos;
	}
}
