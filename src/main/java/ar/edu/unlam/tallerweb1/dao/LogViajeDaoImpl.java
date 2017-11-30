package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

@Repository("LogViajeDao")
public class LogViajeDaoImpl implements LogViajeDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public LogViaje gardarLogViaje(LogViaje logViaje) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(logViaje);
		return logViaje;
	}

	@Override
	public List<LogViaje> listarLogViajePorViaje(Viaje viaje) {
		final Session session = sessionFactory.getCurrentSession();
		List<LogViaje> logDeViajes = session.createCriteria(LogViaje.class)
										.add(Restrictions.eq("viaje", viaje))
										.list();
		return logDeViajes;

	}

	@Override
	public LogViaje buscarPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (LogViaje) session.createCriteria(LogViaje.class)
							.add(Restrictions.eq("id", id))
							.uniqueResult();

	}

	@Override
	public List<LogViaje> buscarPorIdViaje(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		List<LogViaje> logDeViajes = session.createCriteria(LogViaje.class)
										.createAlias("viaje", "viaje")
										.add(Restrictions.eq("viaje.id", id))
										.list();
		return logDeViajes;
	}

	@Override
	public List<LogViaje> findByViaje(Viaje viaje) {
		final Session session = sessionFactory.getCurrentSession();
		List<LogViaje> logDes = session.createCriteria(LogViaje.class)
									.add(Restrictions.eq("viaje", viaje))
									.list();
		return logDes;
	}

}
