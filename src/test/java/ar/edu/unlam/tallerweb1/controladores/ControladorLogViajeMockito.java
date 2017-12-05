package ar.edu.unlam.tallerweb1.controladores;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogViaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

public class ControladorLogViajeMockito {
	
	@Mock 
	private ServicioUsuario servicioUsuario;
	@Mock
	private ServicioViaje servicioViaje;
	@Mock 
	private ServicioLogViaje servicioLogViaje;
	@Mock
	private Usuario chofer;
	@Mock
	private ServicioLogin servicioLogin;
	@Mock
	private Viaje viajeEnProceso;
    @Mock
    private List<LogViaje> listaLogViajeEnProceso;
	@Mock
	private HttpServletRequest request;
	@Mock 
	private HttpSession session;
	@InjectMocks private ControladorLogViaje controladorLogViaje;
	
	@Before 
	public void inyeccionAntesDeCadaTest(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test 
	public void testQueMeRedirijaAlLogin(){
		//preparacion 
		when(request.getSession()).thenReturn(session);

		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(null);
		//ejecucion
		ModelAndView mav=controladorLogViaje.mostrarListaLogViaje(request);
		//verificacion
		assertThat(mav.getViewName()).isEqualTo("redirect:/login");
		assertThat(mav.getModel()).isEmpty();
		verify(chofer,never()).getRol();
	}
	
	@Test
	public void TestQueMuestreListaLogViaje(){
		//preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(3L);
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(chofer);
		when(servicioViaje.buscarViajeEnProceso(any(Usuario.class))).thenReturn(viajeEnProceso);
		when(servicioLogViaje.listarLogViajePorViaje(any(Viaje.class))).thenReturn(listaLogViajeEnProceso);
	
		//ejecucion
		ModelAndView mav=controladorLogViaje.mostrarListaLogViaje(request);
		//verificacion
		assertThat(mav.getViewName()).isEqualTo("chofer-log-viaje-en-progreso");
		assertThat(mav.getModel()).isNotEmpty();
		verify(servicioUsuario,times(1)).buscarPorId(3L);
		verify(servicioViaje,times(1)).buscarViajeEnProceso(chofer);
		verify(servicioLogViaje,times(1)).listarLogViajePorViaje(viajeEnProceso);
		assertThat(mav.getModelMap()).isNotEmpty();
		
		
	}
	
}
