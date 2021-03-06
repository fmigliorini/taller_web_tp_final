package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.EstadoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;

@Repository("MovimientoDao")
public class MovimientoDaoImpl implements MovimientoDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Movimiento guardarMovimiento(Movimiento movimiento) {

		final Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(movimiento);
		return movimiento;
	}

	@Override
	public Movimiento actualizarMovimiento(Movimiento movimiento){
		
		final Session session = sessionFactory.getCurrentSession();
		session.update(movimiento);
		return movimiento;
	}
	
	@Override
	public Movimiento buscarIdMovimiento(Long idMovimiento){
		final Session session = sessionFactory.getCurrentSession();
		return (Movimiento) session.createCriteria(Movimiento.class).add(Restrictions.eq("id", idMovimiento))
				.uniqueResult();
	}

	@Override
	public List<Movimiento> buscarMovimientosPorTipo(Long idTipoMovimiento) {
		final Session session = sessionFactory.getCurrentSession();
		List<Movimiento> movimientosTipo = session.createCriteria(Movimiento.class)
				// Creo el join con Tipo Movimiento
				.createAlias("TipoMovimiento", "tipoMovimiento")
				// Le digo que me traiga los Movimientos correspondiente al tipo
				.add(Restrictions.eq("tipoMovimiento.id", idTipoMovimiento)).list();
		return movimientosTipo;
	}
	
	@Override
	public List<Movimiento> buscarMovimientosPorTipoyEstado(TipoMovimiento tipoMovimiento,EstadoMovimiento estadoMovimiento ) {
		final Session session = sessionFactory.getCurrentSession();
		List<Movimiento> movimientosTipo = session.createCriteria(Movimiento.class)
				.add(Restrictions.eq("estadoMovimiento", estadoMovimiento))
				// Le digo que me traiga los Movimientos correspondiente al tipo
				.add(Restrictions.eq("tipoMovimiento", tipoMovimiento)).list();
		return movimientosTipo;
	}
	

	// Trae todos los movimientos del usuario
	@Override
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario) {
		final Session session = sessionFactory.getCurrentSession();
		List<Movimiento> movimientosTipo = session.createCriteria(Movimiento.class)
				// Creo el join con Usuario
				.createAlias("Usuario", "usuario")
				// Le digo que me traiga los Movimientos correspondiente al
				// usuario
				.add(Restrictions.eq("usuario.id", idUsuario)).list();
		return movimientosTipo;
	}

	// Trae un movimiento especifico los movimientos del usuario
	@Override
	public List<Movimiento> buscarMovimientosPorUsuario(Long idUsuario, int idTipoMovimiento) {
		final Session session = sessionFactory.getCurrentSession();
		List<Movimiento> movimientosTipoUsuario = session.createCriteria(Movimiento.class)
				// Creo el join con Usuario
				.createAlias("usuario", "usuario")
				// Le digo que me traiga los Movimientos correspondiente al
				// usuario
				.add(Restrictions.eq("usuario.id", idUsuario))
				// Creo el join con Tipo Movimiento
				.createAlias("tipoMovimiento", "tipo")
				// Le digo que me traiga los Movimientos correspondiente al tipo
				.add(Restrictions.eq("tipo.id", idTipoMovimiento)).addOrder(Order.desc("id")).list();
		return movimientosTipoUsuario;
	}

	// Trae los remitos para los choferes
	@Override
	public List<Movimiento> buscarMovimientosParaChofer(Long idChofer) {
		final Session session = sessionFactory.getCurrentSession();
		List<Movimiento> movimientosChofer = session.createCriteria(Movimiento.class)
				// Creo el join con Usuario
				.createAlias("viaje", "viaje").createAlias("viaje.vehiculo", "vehiculo").createAlias("vehiculo.chofer", "chofer")
				// Creo el join con Tipo Movimiento
				.createAlias("tipoMovimiento", "tipoMovimiento")
				// Le digo que me traiga los Movimientos correspondiente al tipo
				// 3 = Remito
				.add(Restrictions.eq("tipoMovimiento.id", 3)).add(Restrictions.eq("chofer.id", idChofer))

				.list();
		return movimientosChofer;
	}
	
	// Trae los remitos para los choferes
/*	@Override
	public List<Movimiento> buscarMovimientosParaChofer(Usuario chofer , TipoMovimeinto tm) {
		final Session session = sessionFactory.getCurrentSession();
		List<Movimiento> movimientosChofer = session.createCriteria(Movimiento.class)
				.createAlias("viaje", "viaje").createAlias("viaje.Chofer", "chofer")
				.add(Restrictions.eq("tipoMovimiento", tm)).add(Restrictions.eq("chofer", chofer))

				.list();
		return movimientosChofer;
	}*/

	public long getLastNumber() {

		final Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Movimiento.class).setProjection(Projections.max("number"));
		long numeroMovimiento = (Integer) criteria.uniqueResult();

		return numeroMovimiento;

	}

	// Trae todos los Presupuestos Aceptados
	@Override
	public List<Movimiento> BuscarPresupuestosAceptados() {
		final Session session = sessionFactory.getCurrentSession();

		EstadoMovimiento em = new EstadoMovimiento();
		em.setDescripcion("Aceptado");
		em.setId(2);

		TipoMovimiento tp = new TipoMovimiento();
		tp.setDescripcion("Presupuesto");
		tp.setId(3);

		List<Movimiento> presupuestoaceptados = session.createCriteria(Movimiento.class)
				// Le digo que me traiga los Movimientos correspondiente al tipo
				.add(Restrictions.eq("tipoMovimiento", tp)).add(Restrictions.eq("estadoMovimiento", em)).list();
		return presupuestoaceptados;
	}

	@Override
	public Movimiento buscarMovimientosPorViaje(Long idViaje, int idTipoMovimiento) {
		final Session session = sessionFactory.getCurrentSession();
		return (Movimiento) session.createCriteria(Movimiento.class)
				.createAlias("viaje", "v")
				.add(Restrictions.eq("v.id", idViaje))
				.createAlias("tipoMovimiento", "tipo")
				.add(Restrictions.eq("tipo.id", idTipoMovimiento))
				.uniqueResult();

	}
}
