package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorMenuAdmnistrador;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminTest {
	
	@Test
	public void validarEliminacionMovimiento(){
		ControladorMenuAdmnistrador controlador = new ControladorMenuAdmnistrador ();
		// Mockeo la clase usuario 
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
		// preguntar when(usuarioBuscado.getRol().equals("admin")).thenReturn(true);
		when(usuario.getRol()).thenReturn("admin");
	
		Movimiento movimiento = mock(Movimiento.class);
	    when(movimiento.getEstadoMovimiento().getDescripcion()).thenReturn("aceptado");
		// Cuando request ( HttpServleRequest ) quiera acceder a una session, obligamos
		// a que devuelva una session de Mock ( falsa ) generada anteriormente en este mismo test.
		when(request.getSession()).thenReturn(sessionMock);
		
		// llamamos al metodo validar Login correspndiente a la accion que deseamos testear,
		// en este caso Login y asignamos como respuesta un "ModelAndView" ya que es lo que retorna.
		ModelAndView mav = controlador.rechazarMovimiento(movimiento.getId(),  request);
		
		// Validamos mediante un Assert que el nombre de la vista enviada sea la correcta
		// En este caso como probamos con cliente debería redireccionar a index.
		
		assertThat(mav.getViewName()).isEqualTo("notificacionGestion");
		// Validamos que el rol guardado en la session Fake de rol guarda solo una vez y que sea Usuario.
		verify(sessionMock, times(1)).setAttribute("admin", "usuario");


		
	}
	
}