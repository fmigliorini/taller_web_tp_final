
package ar.edu.unlam.tallerweb1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Repository("VehiculoDao")
public class VehiculoDaoImpl implements VehiculoDao {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public List<Vehiculo> getAll() {
		final Session session = sessionFactory.getCurrentSession();
		List<Vehiculo> Vehiculos = session.createCriteria(Vehiculo.class).list();
		return Vehiculos;
	}

	@Override
	public List<Vehiculo> listarPorTipoVehiculo(TipoVehiculo tipoVehiculo) {
		final Session session = sessionFactory.getCurrentSession();
		List<Vehiculo> Vehiculos = session.createCriteria(Vehiculo.class)

				.add(Restrictions.eq("tipoVehiculo", tipoVehiculo)).list();
		return Vehiculos;
	}

	@Override
	public Vehiculo buscarPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		return (Vehiculo) session.createCriteria(Vehiculo.class).add(Restrictions.eq("id", id)).uniqueResult();
	}

	@Override
	public Vehiculo buscarChofer(Usuario chofer) {
		final Session session = sessionFactory.getCurrentSession();
		return (Vehiculo) session.createCriteria(Vehiculo.class).add(Restrictions.ge("chofer", chofer)).uniqueResult();
	}

	@Override
	public Vehiculo guardarVehiculo(Vehiculo vehiculo) {

		final Session session = sessionFactory.getCurrentSession();
		session.save(vehiculo);
		return vehiculo;
	}

	@Override
	public void actualizarVehiculo(Vehiculo vehiculo) {
		final Session session = sessionFactory.getCurrentSession();
		session.update(vehiculo);
	}

	@Override
	public void eliminarVehiculo(Vehiculo vehiculo) {
		final Session session = sessionFactory.getCurrentSession();
		session.delete(vehiculo);
	}

	@Override
	public List<Vehiculo> listarVehiculosDisponibles(String diaInicioViaje, String horaInicioViaje, String diaFinViaje,
			String horaFinViaje) {
		final Session session = sessionFactory.getCurrentSession();
		String query = String.format(
				"SELECT ve.id FROM vehiculo ve where not EXISTS(SELECT * FROM viaje v JOIN vehiculo a  ON v.vehiculo_id=a.id  WHERE (v.hora BETWEEN '%s' AND '%s') and (v.horaFin BETWEEN '%s' AND '%s') AND (v.fecha BETWEEN '%s' AND '%s') AND (v.fechaFin BETWEEN '%s' AND '%s') and ve.id=a.id)",
				horaInicioViaje, horaFinViaje, horaInicioViaje, horaFinViaje, diaFinViaje, diaInicioViaje, diaFinViaje,
				diaInicioViaje);
		List<Object[]> rows = session.createSQLQuery(query).list();
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

		for (Object[] row : rows) {
			Vehiculo v = new Vehiculo();
			long id = (Long.parseLong(row[0].toString()));
			v = buscarPorId(id);
			vehiculos.add(v);
		}
		return vehiculos;
	}

}
