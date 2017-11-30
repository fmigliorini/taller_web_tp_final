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
public class VehiculoTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void testlistarPorTipoVehiculoTest() {

	
		TipoVehiculo tipoVehiculo1 = new TipoVehiculo();
		tipoVehiculo1.setId(1L);
		tipoVehiculo1.setDescripcion("furgoneta");
		tipoVehiculo1.setPesoMaximo(500F);
		tipoVehiculo1.setPrecio(100F);

		TipoVehiculo tipoVehiculo2 = new TipoVehiculo();
		tipoVehiculo2.setId(2L);
		tipoVehiculo2.setDescripcion("camioneta");
		tipoVehiculo2.setPesoMaximo(1500F);
		tipoVehiculo2.setPrecio(200F);

		TipoVehiculo tipoVehiculo3 = new TipoVehiculo();
		tipoVehiculo3.setId(3L);
		tipoVehiculo3.setDescripcion("camion");
		tipoVehiculo3.setPesoMaximo(2000F);
		tipoVehiculo3.setPrecio(300F);

		Usuario chofer1 = new Usuario();
		chofer1.setId(1L);
		chofer1.setRol("chofer");

		Usuario chofer2 = new Usuario();
		chofer2.setId(2L);
		chofer2.setRol("chofer");

		Usuario chofer3 = new Usuario();
		chofer3.setId(3L);
		chofer3.setRol("chofer");

		Vehiculo v1 = new Vehiculo();
		v1.setId(1L);
		v1.setChofer(chofer1);
		v1.setMarca("marca1");
		v1.setModelo("modelo1");
		v1.setPatente("patente1");
		v1.setTipoVehiculo(tipoVehiculo1);

		Vehiculo v2 = new Vehiculo();
		v2.setId(2L);
		v2.setChofer(chofer2);
		v2.setMarca("marca2");
		v2.setModelo("modelo2");
		v2.setPatente("patente2");
		v2.setTipoVehiculo(tipoVehiculo2);

		Vehiculo v3 = new Vehiculo();
		v3.setId(3L);
		v3.setChofer(chofer3);
		v3.setMarca("marca3");
		v3.setModelo("modelo3");
		v3.setPatente("patente3");
		v3.setTipoVehiculo(tipoVehiculo3);

		Session session = null;
		session.getSessionFactory();
		// salvamos
		session.save(tipoVehiculo3);
		session.save(tipoVehiculo2);
		session.save(tipoVehiculo1);
		session.save(chofer1);
		session.save(chofer2);
		session.save(chofer3);

		session.save(v3);
		session.save(v1);
		session.save(v2);

		List<Vehiculo> listarPorTipoVehiculoTest = session.createCriteria(Vehiculo.class)
				.add(Restrictions.eq("tipoVehiculo", tipoVehiculo1)).list();

		assertThat(listarPorTipoVehiculoTest).hasSize(1);

		for (Vehiculo v : listarPorTipoVehiculoTest) {
			assertEquals("tipoVehiculo1", v.getTipoVehiculo());
		}

	}

}
