package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;


@Repository("MovimientoDao")
public class MovimientoDaoImpl implements MovimientoDao {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Movimiento guardarMovimiento(Movimiento movimiento){
		
		final Session session = sessionFactory.getCurrentSession();
		session.save(movimiento);
		return movimiento;
	}
	
	
	@Override
	public Movimiento buscarIdMovimiento(Long idMovimiento){
		final Session session = sessionFactory.getCurrentSession();
		return (Movimiento) session.createCriteria(Movimiento.class)
								.add(Restrictions.eq("id", idMovimiento))
								.uniqueResult();
	}
	
	@Override
	public List<Movimiento> buscarMovimientosPorTipo(Long idTipoMovimiento){
		final Session session = sessionFactory.getCurrentSession();
		List <Movimiento> movimientosTipo =	session.createCriteria(Movimiento.class)
											//Creo el join con Tipo Movimiento
											.createAlias("TipoMovimiento", "tipoMovimiento")
											//Le digo que me traiga los Movimientos correspondiente al tipo 
											.add(Restrictions.eq("tipoMovimiento.id",idTipoMovimiento))
											.list();
		return movimientosTipo;
	}
	
	//Trae todos los movimientos del usuario
	@Override
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario){
		final Session session = sessionFactory.getCurrentSession();
		List <Movimiento> movimientosTipo =	session.createCriteria(Movimiento.class)
											//Creo el join con Usuario
											.createAlias("Usuario", "usuario")
											//Le digo que me traiga los Movimientos correspondiente al usuario
											.add(Restrictions.eq("usuario.id",idUsuario))
											.list();
		return movimientosTipo;
	}
	
	//Trae un movimiento especifico los movimientos del usuario
	@Override
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario,Long idTipoMovimiento){
		final Session session = sessionFactory.getCurrentSession();
		List <Movimiento> movimientosTipoUsuario =	session.createCriteria(Movimiento.class)
											//Creo el join con Usuario
											.createAlias("Usuario", "usuario")
											//Le digo que me traiga los Movimientos correspondiente al usuario
											.add(Restrictions.eq("usuario.id",idUsuario))
											//Creo el join con Tipo Movimiento
											.createAlias("TipoMovimiento", "tipoMovimiento")
											//Le digo que me traiga los Movimientos correspondiente al tipo 
											.add(Restrictions.eq("tipoMovimiento.id",idTipoMovimiento))
											
											.list();
		return movimientosTipoUsuario;
	}
	

	
	//Trae los remitos para los choferes
	@Override
	public List<Movimiento> buscarMovimientosParaChofer(Long idChofer){
		final Session session = sessionFactory.getCurrentSession();
		List <Movimiento> movimientosChofer =	session.createCriteria(Movimiento.class)
											//Creo el join con Usuario
											.createAlias("Viaje", "viaje")
											.createAlias("viaje.Chofer", "chofer")
											//Creo el join con Tipo Movimiento
											.createAlias("TipoMovimiento", "tipoMovimiento")
											//Le digo que me traiga los Movimientos correspondiente al tipo 3 = Remito 
											.add(Restrictions.eq("tipoMovimiento.id",3))
											.add(Restrictions.eq("chofer.id",idChofer))
											
											.list();
		return movimientosChofer;
	}
}
