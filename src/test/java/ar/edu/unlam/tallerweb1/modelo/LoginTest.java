package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginTest {

	@Test
	public void alLoguearseConUsuarioValidoDeberiaLlevarAHome() {
		ControladorLogin controlador = new ControladorLogin();
		Usuario usuario = mock(Usuario.class);
		HttpServletRequest request = mock(HttpServletRequest.class);
		ServicioLogin servicioLogin = mock(ServicioLogin.class);

		HttpSession sessionMock = mock(HttpSession.class);

		when(usuario.getRol()).thenReturn("cliente");

		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		controlador.setServicioLogin(servicioLogin);

		when(request.getSession()).thenReturn(sessionMock);

		ModelAndView mav = controlador.validarLogin(usuario, request);

		assertThat(mav.getViewName()).isEqualTo("redirect:/home");

		verify(sessionMock, times(1)).setAttribute("rol", "cliente");

	}
}