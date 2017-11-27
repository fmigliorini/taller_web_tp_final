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
	public List<LogViaje> listarLogViajesPorViaje() {
		final Session session=sessionFactory.getCurrentSession();
		List<LogViaje>logDeViajes=session.createCriteria(LogViaje.class)
				.list();
		return logDeViajes;
	}

	@Override
	public LogViaje buscarPorId(Long id) {
		final Session session=sessionFactory.getCurrentSession();
		return(LogViaje)session.createCriteria(LogViaje.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		
	}



}
