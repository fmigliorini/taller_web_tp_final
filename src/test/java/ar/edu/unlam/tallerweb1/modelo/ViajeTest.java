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
	public void listarViajesActivos() {

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

}
