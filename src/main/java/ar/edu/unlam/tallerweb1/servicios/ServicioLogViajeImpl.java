package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.LogViajeDao;
import ar.edu.unlam.tallerweb1.dao.PresupuestoDao;
import ar.edu.unlam.tallerweb1.modelo.LogViaje;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS )
public class ServicioLogViajeImpl implements ServicioLogViaje{

	@Inject
	private LogViajeDao logViajeDao;

	@Inject
	private SessionFactory sessionFactory;
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = {Exception.class})
	public LogViaje gardarLogViaje(LogViaje logViaje) {
		
		final Session session = sessionFactory.getCurrentSession();
		session.save(logViaje);
		return logViaje;
	}
	@Override
	public List<LogViaje> listarLogViaje() {
		return logViajeDao.listarLogViajes();
	}
	@Override
	public LogViaje buscarPorId(Long id) {
		return logViajeDao.buscarPorId(id);
	}
	
}