package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


import ar.edu.unlam.tallerweb1.modelo.Viaje;

@Repository("ViajeDao")
public class ViajeDaoImpl implements ViajeDao {
	
	@Inject
	private SessionFactory sessionFactotry;
	
	@Override
	public Viaje guardarViaje(Viaje viaje){
		
		final Session session = sessionFactotry.getCurrentSession();
		session.save(viaje);
		return viaje;
	}
	
	@Override
	public Viaje buscarViajePorId(Long id)
	{
		final Session session = sessionFactotry.getCurrentSession();
		return (Viaje) session.createCriteria(Viaje.class)
								.add(Restrictions.eq("id", id))
								.uniqueResult();
	}
	
	@Override
	public List<Viaje> buscarViajesDeChoferId(Long idChofer)
	{
		final Session session = sessionFactotry.getCurrentSession();
		List<Viaje> viajesChofer= session.createCriteria(Viaje.class)
								    //Creo el join con usuario/chofer
									.createAlias("usuario", "chofer")
								.add(Restrictions.eq("chofer.id", idChofer))
								.list();
		return viajesChofer ;
	}
	
	
	public Viaje ActualizarViaje(Viaje viaje) {
	
		final Session session = sessionFactotry.getCurrentSession();
		session.update(viaje);
		return viaje;
	}


}
