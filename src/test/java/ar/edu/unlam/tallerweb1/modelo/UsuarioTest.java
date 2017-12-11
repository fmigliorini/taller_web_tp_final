package ar.edu.unlam.tallerweb1.modelo;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import ar.edu.unlam.tallerweb1.SpringTest;
import junit.framework.Assert;

public class UsuarioTest extends SpringTest{
	
	private Usuario cliente, chofer, administrador,usuario;
	private Session session;
	
	@Before
    public void inicializacion(){
    	cliente=new Usuario();
		chofer=new Usuario();
		administrador=new Usuario();
		session = getSession();
		usuario=new Usuario();
    	
    }

	@Test
	@Transactional
	@Rollback(true)
	public void tetsUsuarioConRolCliente(){
		cliente.setNombre("Pedro");
		cliente.setRol("cliente");
		chofer.setNombre("Mario");
		chofer.setRol("chofer");
		administrador.setRol("admin");
		administrador.setNombre("Martinez");
		//salvamos
		session.save(cliente);
		session.save(chofer);
		session.save(administrador);
		
		List<Usuario>usuarios=session.createCriteria(Usuario.class)
			 .add(Restrictions.eq("rol", "cliente"))
		     .list();
		assertThat(usuarios).hasSize(1);
		for(Usuario listaUsuario: usuarios){
			assertEquals("cliente",listaUsuario.getRol());
		}
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void tetsUsuarioConRolChofer(){
				//seteamos
				cliente.setNombre("Pedro");
				cliente.setRol("cliente");
				chofer.setNombre("Mario");
				chofer.setRol("chofer");
				administrador.setRol("admin");
				administrador.setNombre("Martinez");
				//salvamos
				session.save(cliente);
				session.save(chofer);
				session.save(administrador);
				
				List<Usuario>usuarios=session.createCriteria(Usuario.class)
					 .add(Restrictions.eq("rol", "chofer"))
				     .list();
				assertThat(usuarios).hasSize(1);
				for(Usuario listaUsuario: usuarios){
					assertEquals("chofer",listaUsuario.getRol());
				}
				
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void tetsUsuarioConRolAdministrador(){
		
				
				//seteamos
				cliente.setNombre("Pedro");
				cliente.setRol("cliente");
				chofer.setNombre("Mario");
				chofer.setRol("chofer");
				administrador.setRol("admin");
				administrador.setNombre("Martinez");
				//salvamos
				session.save(cliente);
				session.save(chofer);
				session.save(administrador);
				
				List<Usuario>usuarios=session.createCriteria(Usuario.class)
					 .add(Restrictions.eq("rol", "admin"))
				     .list();
				assertThat(usuarios).hasSize(1);
				for(Usuario listaUsuario: usuarios){
					assertEquals("admin",listaUsuario.getRol());
				}
				
		
	}
	@Test
	@Transactional
	@Rollback(true)
	public void testActualizarDatos(){
		
		usuario.setApellido("Ramirez");
		usuario.setNombre("Mario");
		usuario.setDireccion("Velarde 2345");
		usuario.setPassword("ramirez12@gmail.com");
		usuario.setPassword("1234");
		usuario.setTelefono("123456789");
		usuario.setDni("38465322");
		usuario.setRol("cliente");
		
		session.save(usuario);
		
		usuario.setDireccion("Urdaneta 1860");
		
	
		
		List<Usuario> usuarios = session.createCriteria(Usuario.class)
				.list();

		assertThat(usuarios).hasSize(1);

		for (Usuario v : usuarios) {
			assertEquals("Urdaneta 1860", v.getDireccion());
		}
		
		
	}
	
}
