package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.Viaje;

@Repository("ViajeDao")
@SuppressWarnings("unchecked")
public class ViajeDaoImpl implements ViajeDao {

	@Inject
	private SessionFactory sessionFactotry;

	@Override
	public Viaje guardarViaje(Viaje viaje) {

		final Session session = sessionFactotry.getCurrentSession();
		session.save(viaje);
		return viaje;
	}

	@Override
	public Viaje buscarViajePorId(Long id) {

		final Session session = sessionFactotry.getCurrentSession();
		return (Viaje) session.createCriteria(Viaje.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public List<Viaje> listarViajesAct() {
		final Session session = sessionFactotry.getCurrentSession();
		List<Viaje> viajesChofer = session.createCriteria(Viaje.class)

				.add(Restrictions.eq("estado", "activo")).list();
		return viajesChofer;
	}

	@Override
	public List<Viaje> listarViajesActVeh(TipoVehiculo t) {
		final Session session = sessionFactotry.getCurrentSession();
		List<Viaje> viajesChofer = session.createCriteria(Viaje.class).createAlias("vehiculo", "ve")
				.add(Restrictions.eq("ve.tipoVehiculo", t)).add(Restrictions.eq("estado", "activo")).list();
		return viajesChofer;
	}

	@Override
	public List<Viaje> buscarViajesDeChoferId(Long idChofer) {
		final Session session = sessionFactotry.getCurrentSession();
		List<Viaje> viajesChofer = session.createCriteria(Viaje.class)

				// Creo el join con usuario/chofer
				.createAlias("vehiculo", "veh").createAlias("veh.chofer", "ch").createAlias("ch.usuario", "us")
				.add(Restrictions.eq("us.id", idChofer)).list();

		return viajesChofer;
	}

	// Se utiliza para agregar el chofer
	@Override
	public void ActualizarViaje(Viaje viaje) {

		final Session session = sessionFactotry.getCurrentSession();
		session.update(viaje);
	}

	@Override
	public List<Viaje> listarViajesActivos(Usuario chofer) {
		final Session session = sessionFactotry.getCurrentSession();

		List<Viaje> viajesActivos = session.createCriteria(Viaje.class).add(Restrictions.eq("estado", "activo"))
				.createAlias("vehiculo", "veh").createAlias("veh.chofer", "ch")

				.add(Restrictions.eq("ch.id", chofer.getId())).add(Restrictions.eq("ch.rol", "chofer")).list();
		return viajesActivos;
	}

	// Viaje en proceso es la actualización de viajeActivo a viajeEnProceso.
	@Override
	public void viajeActualizadoEnProceso(Viaje viaje) {
		final Session session = sessionFactotry.getCurrentSession();
		session.update(viaje);
	}

	// Viaje hechos
	@Override
	public List<Viaje> listarViajesTerminados(Usuario chofer) {
		final Session session = sessionFactotry.getCurrentSession();

		List<Viaje> viajesTerminados = session.createCriteria(Viaje.class).add(Restrictions.eq("estado", "Terminado"))
				.createAlias("vehiculo", "veh").createAlias("veh.chofer", "ch")
				.add(Restrictions.eq("ch.id", chofer.getId())).add(Restrictions.eq("ch.rol", "chofer")).list();
		return viajesTerminados;
	}

	@Override
	public Viaje buscarViajeEnProceso(Usuario chofer) {
		final Session session = sessionFactotry.getCurrentSession();
		return (Viaje) session.createCriteria(Viaje.class).add(Restrictions.eq("estado", "En proceso"))
				.createAlias("vehiculo", "veh").createAlias("veh.chofer", "ch")
				.add(Restrictions.eq("ch.id", chofer.getId())).add(Restrictions.eq("ch.rol", "chofer")).uniqueResult();

	}

	;

	@Override
	public List<Viaje> listarViajesIntervalo(Date fechaHora, Date fechaHoraFin, Vehiculo vehiculo) {
		final Session session = sessionFactotry.getCurrentSession();
		List<Viaje> viajes = session.createCriteria(Viaje.class)
				.add(Restrictions.eq("estado", "activo"))
				.add(Restrictions.eq("vehiculo", vehiculo))
				.add(Restrictions.between("fechaHora", fechaHora, fechaHoraFin))
				.add(Restrictions.between("fechaHoraFin", fechaHora, fechaHoraFin)).list();

		// .add(Restrictions.ge("fechaHora",
		// fechaHora)).add(Restrictions.lt("fechaHoraFin", fechaHora))
		// .add(Restrictions.ge("fechaHora",
		// fechaHoraFin)).add(Restrictions.lt("fechaHoraFin", fechaHoraFin))
		// .list();
		return viajes;
	}
}
