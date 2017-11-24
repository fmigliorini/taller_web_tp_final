package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;

@Repository("TipoMovimientoDao")
public class TipoMovimientoDaoImpl implements TipoMovimientoDao {

	@Inject
	private SessionFactory sessionFactotry;

	@Override
	public List<TipoMovimiento> listarTiposMovimientos() {
		final Session session = sessionFactotry.getCurrentSession();
		List<TipoMovimiento> tipoMovimientos = session.createCriteria(TipoMovimiento.class)
												.list();
		return tipoMovimientos;
	}

	@Override
	public TipoMovimiento buscarPorId(int id) {
		final Session session = sessionFactotry.getCurrentSession();
		return (TipoMovimiento) session.createCriteria(TipoMovimiento.class)
									.add(Restrictions.eq("id", id))
									.uniqueResult();
	}

	@Override
	public TipoMovimiento buscarPorDescripcion(String descripcion) {
		final Session session = sessionFactotry.getCurrentSession();
		return (TipoMovimiento) session.createCriteria(TipoMovimiento.class)
									.add(Restrictions.eq("descripcion", descripcion))
									.uniqueResult();
	}
}
