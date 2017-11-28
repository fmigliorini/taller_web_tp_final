package ar.edu.unlam.tallerweb1.modelo;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;

public class ClienteTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void generarNuevoCliente() {
		Usuario usu = new Usuario();
		usu.setApellido("Apellido");
		usu.setNombre("nombre");
		usu.setRol("Cliente");
		
		Usuario usu2 = new Usuario();
		usu2.setApellido("Apellido2");
		usu2.setNombre("nombre2");
		usu2.setRol("Cliente");
		
		getSession().save(usu);
		getSession().save(usu2);
		
		List <Usuario> usuarios = getSession().createCriteria(Usuario.class)
									.add(Restrictions.eq("rol", "Cliente"))
									.list();
		
		for( Usuario u: usuarios ){
			Assert.assertEquals( u.getRol(), "Cliente" );
		}
		
	}

}
