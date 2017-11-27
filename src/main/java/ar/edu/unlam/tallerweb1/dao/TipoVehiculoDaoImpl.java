package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;

@Repository("TipoVehiculoDao")
public class TipoVehiculoDaoImpl implements TipoVehiculoDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<TipoVehiculo> listarTiposVehiculos() {
		final Session session = sessionFactory.getCurrentSession();
		List<TipoVehiculo> tipoVehiculos = session.createCriteria(TipoVehiculo.class)
											.list();
		return tipoVehiculos;
	}

	@Override
	public TipoVehiculo buscarPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (TipoVehiculo) session.createCriteria(TipoVehiculo.class)
								.add(Restrictions.eq("id", id))
								.uniqueResult();
	}

	@Override
	public TipoVehiculo buscarPorPesoMaximo(Float peso) {
		final Session session = sessionFactory.getCurrentSession();
		return (TipoVehiculo ) session.createCriteria(TipoVehiculo.class)
								.add(Restrictions.ge("pesoMaximo", peso))
								.setMaxResults(1)
								.uniqueResult();
	}
}
