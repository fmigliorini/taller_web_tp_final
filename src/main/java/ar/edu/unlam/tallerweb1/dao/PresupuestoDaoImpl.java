package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Presupuesto;

@Repository("PresupuestoDao")
public class PresupuestoDaoImpl implements PresupuestoDao {
	
	@Inject
	private SessionFactory sessionFacotry;
	
	@Override
	public Presupuesto guardarPresupusto(Presupuesto presupuesto){
		
		final Session session = sessionFacotry.getCurrentSession();
		session.save(presupuesto);
		return presupuesto;
	}
}
