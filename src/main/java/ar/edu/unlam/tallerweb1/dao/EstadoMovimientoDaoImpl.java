package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.EstadoMovimiento;

@Repository("EstadoMovimientoDao")
public class EstadoMovimientoDaoImpl implements EstadoMovimientoDao {

	@Inject
	private SessionFactory sessionFactotry;
	
	@Override
	public List<EstadoMovimiento> listarEstadosMovimientos()
	{
		final Session session = sessionFactotry.getCurrentSession();
		List<EstadoMovimiento> tipoMovimientos = session.createCriteria(EstadoMovimiento.class)
												.list();
		return tipoMovimientos;
	}
	
	@Override
	public EstadoMovimiento buscarPorId(int id)
	{
		final Session session = sessionFactotry.getCurrentSession();
		return (EstadoMovimiento) session.createCriteria(EstadoMovimiento.class)
								.add(Restrictions.eq("id", id))
								.uniqueResult();
	}
}