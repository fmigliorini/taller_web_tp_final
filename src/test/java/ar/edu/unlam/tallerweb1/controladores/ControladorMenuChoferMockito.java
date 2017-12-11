package ar.edu.unlam.tallerweb1.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogViaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

public class ControladorMenuChoferMockito {

	@Mock
	private ServicioViaje servicioViaje;
	@Mock
	private ServicioUsuario servicioUsuario;
	@Mock
	private ServicioLogViaje servicioLogViaje;
	@Mock
	private ServicioMovimiento servicioMovimiento;
	@Mock
	private ServicioTipoMovimiento servicioTipoMovimiento;
	@Mock
	private ServicioLogin servicioLogin;
	@Mock
	private HttpServletRequest request;
	@Mock
	private HttpSession session;
	@Mock
	private Usuario chofer,cliente;
	@Mock
	private Viaje viajeEnProceso;
	@Mock
	private List<Viaje> listaViajes;
	@Mock
	private Viaje viaje;
	@Mock
	private List<Movimiento>listaRemitos;
	@InjectMocks
	private ControladorMenuChofer controladorMenuChofer;

	@Before
	public void inyeccionAntesDeCadaTest() {
		MockitoAnnotations.initMocks(this);
	}

	// Mockea todo el primer metodo
	@Test
	public void testQueNoMeMuestreNadaPorNoEstarLogueado() {
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(null);
		when(chofer.getRol()).thenReturn(null);
		// ejecucion
		ModelAndView mav = controladorMenuChofer.irAlaListaDeViajesArealizar(request);
		// verificacion
		assertThat(mav.getViewName()).isEqualTo("redirect:/login");
		assertThat(mav.getModel()).isEmpty();
		verify(chofer, never()).getRol();
	}

	@Test
	public void testIrAlaListaDeViajesArealizar() {
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(1L);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(chofer);
		when(chofer.getRol()).thenReturn("chofer");
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(chofer);
		when(servicioViaje.buscarViajeEnProceso(any(Usuario.class))).thenReturn(viajeEnProceso);
		when(servicioViaje.listarViajesActivos(any(Usuario.class))).thenReturn(listaViajes);
		// ejecucion
		ModelAndView mav1 = controladorMenuChofer.irAlaListaDeViajesArealizar(request);
		// verificacion
		assertThat(mav1.getViewName()).isEqualTo("redirect:/viajeEnProceso");
		verify(servicioUsuario, times(2)).buscarPorId(1L);
		verify(servicioViaje, times(1)).buscarViajeEnProceso(chofer);
		verify(servicioViaje, never()).listarViajesActivos(chofer);
		assertThat(mav1.getModelMap()).isEmpty();
		verify(chofer, times(1)).getRol();

	}

	@Test
	public void testIrAlaListaDeViajesArealizarCuandoElViajeEnProcesoEsNull() {
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(1L);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(chofer);
		when(chofer.getRol()).thenReturn("chofer");
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(chofer);
		when(servicioViaje.buscarViajeEnProceso(any(Usuario.class))).thenReturn(null);
		when(servicioViaje.listarViajesActivos(any(Usuario.class))).thenReturn(listaViajes);
		// ejecucion
		ModelAndView mav2 = controladorMenuChofer.irAlaListaDeViajesArealizar(request);
		// verificacion
		assertThat(mav2.getViewName()).isEqualTo("chofer-viajes-activo");
		verify(servicioUsuario, times(2)).buscarPorId(1L);
		verify(servicioViaje, times(1)).buscarViajeEnProceso(chofer);
		verify(servicioViaje, times(1)).listarViajesActivos(chofer);
		assertThat(mav2.getModelMap()).isNotEmpty();
		verify(chofer, times(1)).getRol();
	}

	@Test
	public void testIrAlMenuDeViajeActivo() {
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(2L);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(chofer);
		when(chofer.getRol()).thenReturn("chofer");
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(chofer);
		when(servicioViaje.buscarViajeEnProceso(any(Usuario.class))).thenReturn(viaje);
		// ejecucion
		ModelAndView mav4 = controladorMenuChofer.irAlMenuDeViajeActivo(request);
		// verificacion
		assertThat(mav4.getViewName()).isEqualTo("chofer-viaje-en-proceso");
		assertThat(mav4.getModelMap()).isNotEmpty();
		verify(chofer, times(1)).getRol();
		verify(servicioViaje,times(1)).buscarViajeEnProceso(chofer);
		verify(servicioUsuario,times(2)).buscarPorId(2L);
		
	}
	@Test
	public void testIrAListadoViajesFinalizadoso() {
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(6L);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(chofer);
		when(chofer.getRol()).thenReturn("chofer");
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(chofer);
		when(servicioViaje.listarViajesTerminados(any(Usuario.class))).thenReturn(listaViajes);
		//ejecucion
		ModelAndView mav6 = controladorMenuChofer.irAListadoViajesFinalizados(request);
		//verificacion
		assertThat(mav6.getViewName()).isEqualTo("chofer-lista-viajes-finalizado");
		assertThat(mav6.getModelMap()).isNotEmpty();
		verify(chofer, times(1)).getRol();
		verify(servicioViaje,times(1)).listarViajesTerminados(chofer);
		verify(servicioUsuario,times(2)).buscarPorId(6L);
		
		
	}
	@Test
	public void testListaDeRemitos() {
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(7L);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(chofer);
		when(chofer.getRol()).thenReturn("chofer");
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(chofer);
		when(servicioMovimiento.buscarMovimientosParaChofer(any(Long.class))).thenReturn(listaRemitos);
		//ejecucion
		ModelAndView mav7 = controladorMenuChofer.listaDeRemitos(request);
		//verificacion
		assertThat(mav7.getViewName()).isEqualTo("chofer-lista-remitos");
		assertThat(mav7.getModelMap()).isNotEmpty();
		verify(chofer, times(1)).getRol();
		verify(servicioUsuario,times(1)).buscarPorId(7L);
		verify(servicioMovimiento,times(1)).buscarMovimientosParaChofer(7L);
		
	}
	@Test
	public void testListaDeRemitosNoAutorizadoPorSerRolDiferenteAchofer() {
		// preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(8L);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(cliente);
		when(cliente.getRol()).thenReturn("cliente");
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(cliente);
		when(servicioMovimiento.buscarMovimientosParaChofer(any(Long.class))).thenReturn(null);
		//ejecucion
		ModelAndView mav7 = controladorMenuChofer.listaDeRemitos(request);
		//verificacion
		assertThat(mav7.getViewName()).isEqualTo("notificacionGestion");
		assertThat(mav7.getModelMap()).isNotEmpty();
		verify(cliente, times(1)).getRol();
		verify(servicioUsuario,times(1)).buscarPorId(8L);
		verify(servicioMovimiento,never()).buscarMovimientosParaChofer(8L);
		assertThat(mav7.getModel().get("mensaje")).isEqualTo("Entrar con rol chofer.");
		
	}

}
