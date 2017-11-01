package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

public class VehiculoDaoImp implements VehiculoDao {

	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public Vehiculo buscarVehiculos()
	{
		final Session session = sessionFactory.getCurrentSession();
		return new Vehiculo();
	}
}

