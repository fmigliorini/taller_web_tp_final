package ar.edu.unlam.tallerweb1.controladores;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class ControladorUsuarioMockito {

	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpSession session;
	@Mock
	private Usuario cliente;
	@Mock
	private ServicioUsuario servicioUsuario;
	@Mock
	private ServicioLogin servicioLogin;
	@InjectMocks
	private ControladorUsuario controladorUsuario;
	@Before
	public void inyeccionAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}
	
    @Test
    public void testIrFormularioCliente(){
    	ModelAndView modelo =controladorUsuario.irFormularioCliente();
    	assertThat(modelo.getViewName()).isEqualTo("cliente-form");
    }
    
	@Test
	public void testQueNoMuestreProfilePorNoEstarLogueado(){
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(null);
		when(cliente.getRol()).thenReturn(null);
		// ejecucion
		ModelAndView modelo2 = controladorUsuario.profile(request);
		// verificacion
		assertThat(modelo2.getViewName()).isEqualTo("redirect:/login");
		assertThat(modelo2.getModel()).isEmpty();
		verify(cliente, never()).getRol();
	}
	
	@Test
	public void testProfile(){
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(1L);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(cliente);
		when(cliente.getRol()).thenReturn("cliente");
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(cliente);
		// ejecucion
		ModelAndView modelo3 = controladorUsuario.profile(request);
		//verificacion
		assertThat(modelo3.getViewName()).isEqualTo("profile");
		assertThat(modelo3.getModel()).isNotEmpty();
		verify(cliente, times(1)).getRol();
		verify(servicioUsuario,times(2)).buscarPorId(1L);
	}
}
