package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ControladorLoginMockito {

	@Test
	public void alLoguearseConUsuarioValidoDeberiaLlevarAHome() {
		ControladorLogin controlador = new ControladorLogin();
		Usuario usuario = mock(Usuario.class);
		// Mockeo HttpServleRequest para evitar errores, de todas formas, lo que 
		// vamos a hacer es usar una session de Mock ( HttpSession ).
		HttpServletRequest request = mock(HttpServletRequest.class);
		// Mockeo el servicio de Login que es utilizado para validar un usuario
		// Como ya esta mockeado puedo acceder a sus metodos, sin embargo,
		// para que funcione, debo obligar al metodo consultarUsuario que me devuelve 
		// un objeto usuario.
		ServicioLogin servicioLogin = mock(ServicioLogin.class);
		// Genero una session con Mockito
		HttpSession sessionMock = mock(HttpSession.class);
		
		// Cuando llamo al metodo getRol, obligo a que me devuelve "cliente" ( String )
		// preguntar when(usuarioBuscado.getRol().equals("cliente")).thenReturn(true);
		when(usuario.getRol()).thenReturn("cliente");
		
		// Any: https://stackoverflow.com/questions/1778744/using-mockitos-generic-any-method
		// Cuando llamamos a consultarUsuario el metodo recive un Usuario como tal, usamos any 
		// para que Mockitos se encarge de que Usuario sea correctamente enviado y retornamos un 
		// usuario Fake
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		
		// En el contorlador se crea un setServicioLogin para poder injectarle un mock del mismo.
		// por qué? Es la mejor forma de injectar un servicio mediante mockitos ya que Spring
		// lo hace por dentras, y nosotros no tenemos forma de hacerlo desde afuera.
		// Duda: Que pasa con este metodo? lo estoy creando en un controlador real y utilizado en prod,
		// deberia crear un login Fake? extendido de Login, como hicimos con Tambor / "TamborTrucho"
		controlador.setServicioLogin(servicioLogin); 
		
		// Cuando request ( HttpServleRequest ) quiera acceder a una session, obligamos
		// a que devuelva una session de Mock ( falsa ) generada anteriormente en este mismo test.
		when(request.getSession()).thenReturn(sessionMock);
		
		// llamamos al metodo validar Login correspndiente a la accion que deseamos testear,
		// en este caso Login y asignamos como respuesta un "ModelAndView" ya que es lo que retorna.
		ModelAndView mav = controlador.validarLogin(usuario, request);
		
		// Validamos mediante un Assert que el nombre de la vista enviada sea la correcta
		// En este caso como probamos con cliente debería redireccionar a index.
		assertThat(mav.getViewName()).isEqualTo("redirect:/home");
		// Validamos que el rol guardado en la session Fake de rol guarda solo una vez y que sea Cliente.
		verify(sessionMock, times(1)).setAttribute("rol", "cliente");
		
		// Deberíamos repetir el proceso para chofer en otro caso??
		// when(usuario.getRol()).thenReturn("Chofer");
		// ModelAndView mavChofer = controlador.validarLogin(usuario, request);
		// assertThat(mav.getViewName()).isEqualTo("redirect:/index_chofer");
		// verify(sessionMock, times(1)).setAttribute("rol", "Chofer");



	}
}