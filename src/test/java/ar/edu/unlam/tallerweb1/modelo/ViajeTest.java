package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;

@SuppressWarnings("unchecked")
public class ViajeTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testQueListeViajesActivos() {

		Usuario chofer1;
		Usuario chofer2;
		Viaje viaje1;
		Viaje viaje2;
		TipoVehiculo camion;
		TipoVehiculo furgoneta;
		Vehiculo v1;
		Vehiculo v2;
		Session session;

		session = getSession();
		chofer1 = new Usuario();
		chofer2 = new Usuario();
		viaje1 = new Viaje();
		viaje2 = new Viaje();
		camion = new TipoVehiculo();
		furgoneta = new TipoVehiculo();
		v1 = new Vehiculo();
		v2 = new Vehiculo();

		// Primer viaje
		chofer1.setRol("chofer");
		chofer1.setNombre("Pablo");
		v1.setChofer(chofer1);
		viaje1.setTipoVehiculo(furgoneta);
		furgoneta.setDescripcion("furgoneta");
		viaje1.setVehiculo(v1);
		viaje1.setEstado("terminado");
		viaje1.setTipoVehiculo(furgoneta);

		// Segundo viaje
		chofer2.setRol("chofer");
		chofer2.setNombre("Mario");
		v2.setChofer(chofer2);
		viaje2.setTipoVehiculo(camion);
		camion.setDescripcion("camion");
		viaje2.setVehiculo(v2);
		viaje2.setEstado("activo");
		viaje2.setTipoVehiculo(camion);

		// salvamos
		session.save(chofer1);
		session.save(furgoneta);
		session.save(v1);
		session.save(viaje1);

		session.save(chofer2);
		session.save(camion);
		session.save(v2);
		session.save(viaje2);

		List<Viaje> listarViajesActivos = session.createCriteria(Viaje.class).add(Restrictions.eq("estado", "activo"))
				.createAlias("vehiculo", "veh").createAlias("veh.chofer", "ch").add(Restrictions.eq("ch.rol", "chofer"))
				.list();

		assertThat(listarViajesActivos).hasSize(1);
		
		for(Viaje viajesActivos :listarViajesActivos ){
			assertEquals("chofer",viajesActivos.getVehiculo().getChofer().getRol());
			assertEquals("activo",viajesActivos.getEstado());
			
		}

	}
	@Test
	@Transactional
	@Rollback(true)
	public void testQuelisteViajesTerminados() {
		
		Usuario chofer1;
		Usuario chofer2;
		Viaje viaje1;
		Viaje viaje2;
		TipoVehiculo camion;
		TipoVehiculo furgoneta;
		Vehiculo v1;
		Vehiculo v2;
		Session session;

		session = getSession();
		chofer1 = new Usuario();
		chofer2 = new Usuario();
		viaje1 = new Viaje();
		viaje2 = new Viaje();
		camion = new TipoVehiculo();
		furgoneta = new TipoVehiculo();
		v1 = new Vehiculo();
		v2 = new Vehiculo();

		// Primer viaje
		chofer1.setRol("chofer");
		chofer1.setNombre("Pablo");
		v1.setChofer(chofer1);
		viaje1.setTipoVehiculo(furgoneta);
		furgoneta.setDescripcion("furgoneta");
		viaje1.setVehiculo(v1);
		viaje1.setEstado("terminado");
		viaje1.setTipoVehiculo(furgoneta);

		// Segundo viaje
		chofer2.setRol("chofer");
		chofer2.setNombre("Mario");
		v2.setChofer(chofer2);
		viaje2.setTipoVehiculo(camion);
		camion.setDescripcion("camion");
		viaje2.setVehiculo(v2);
		viaje2.setEstado("terminado");
		viaje2.setTipoVehiculo(camion);

		// salvamos
		session.save(chofer1);
		session.save(furgoneta);
		session.save(v1);
		session.save(viaje1);

		session.save(chofer2);
		session.save(camion);
		session.save(v2);
		session.save(viaje2);

		List<Viaje> listarViajesTerminados = session.createCriteria(Viaje.class).add(Restrictions.eq("estado", "terminado"))
				.createAlias("vehiculo", "veh").createAlias("veh.chofer", "ch").add(Restrictions.eq("ch.rol", "chofer"))
				.list();

		assertThat(listarViajesTerminados).hasSize(2);
		
		for(Viaje viajesTerminado :listarViajesTerminados ){
			assertEquals("chofer",viajesTerminado.getVehiculo().getChofer().getRol());
			assertEquals("terminado",viajesTerminado.getEstado());
			
		}
	}
	@Test
	@Transactional
	@Rollback(true)
	public void testQuelisteLogDeViajeEnProcesoDeUnSoloViaje() {
    //En otras Palabras va a testear que el log sea de un solo viaje (en este caso chofer, un viaje se le asigna un solo chofer)
		
		Usuario chofer1;
		Usuario chofer2;
		Viaje viaje1;
		Viaje viaje2;
		TipoVehiculo camion;
		TipoVehiculo furgoneta;
		Vehiculo v1;
		Vehiculo v2;
		LogViaje combustible;
		LogViaje peaje;
		Session session;

		session = getSession();
		chofer1 = new Usuario();
		chofer2 = new Usuario();
		viaje1 = new Viaje();
		viaje2 = new Viaje();
		camion = new TipoVehiculo();
		furgoneta = new TipoVehiculo();
		v1 = new Vehiculo();
		v2 = new Vehiculo();
		peaje=new LogViaje();
		combustible=new LogViaje();
		
	

		// Primer viaje
		chofer1.setRol("chofer");
		chofer1.setNombre("Pablo");
		v1.setChofer(chofer1);
		viaje1.setTipoVehiculo(furgoneta);
		furgoneta.setDescripcion("furgoneta");
		viaje1.setVehiculo(v1);
		viaje1.setEstado("En proceso");
		viaje1.setTipoVehiculo(furgoneta);
		combustible.setTipoLogViaje("combustible");
		combustible.setViaje(viaje1);

		// Segundo viaje
		chofer2.setRol("chofer");
		chofer2.setNombre("Mario");
		v2.setChofer(chofer2);
		viaje2.setTipoVehiculo(camion);
		camion.setDescripcion("camion");
		viaje2.setVehiculo(v2);
		viaje2.setEstado("Terminado");
		viaje2.setTipoVehiculo(camion);
		peaje.setTipoLogViaje("peaje");
		peaje.setViaje(viaje2);

		// salvamos
		session.save(chofer1);
		session.save(furgoneta);
		session.save(v1);
		session.save(viaje1);
		session.save(combustible);

		session.save(chofer2);
		session.save(camion);
		session.save(v2);
		session.save(viaje2);
		session.save(peaje);

		List<LogViaje> listarLogDeViajeDelViaje1ChoferPablo = session.createCriteria(LogViaje.class)
				.createAlias("viaje","via")
				.add(Restrictions.eq("via.estado", "En proceso"))
				.createAlias("via.vehiculo", "veh")
				.createAlias("veh.chofer", "ch")
				.add(Restrictions.eq("ch.rol", "chofer"))
				.add(Restrictions.eq("ch.nombre", "Pablo"))
				.list();

		assertThat(listarLogDeViajeDelViaje1ChoferPablo).hasSize(1);
		
		for(LogViaje viajesConLogs :listarLogDeViajeDelViaje1ChoferPablo ){
			assertEquals("chofer",viajesConLogs.getViaje().getVehiculo().getChofer().getRol());
			assertEquals("En proceso",viajesConLogs.getViaje().getEstado());
			assertEquals("combustible",viajesConLogs.getTipoLogViaje());
			
		}
	}
}
