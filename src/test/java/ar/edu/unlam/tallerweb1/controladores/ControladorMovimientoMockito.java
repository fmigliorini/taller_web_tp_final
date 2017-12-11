package ar.edu.unlam.tallerweb1.controladores;

import static org.mockito.Matchers.any;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import org.springframework.web.servlet.ModelAndView;
import static org.assertj.core.api.Assertions.assertThat;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class ControladorMovimientoMockito {

	@Mock
	ServicioMovimiento servicioMovimiento;
	@Mock
	private HttpServletRequest request;
	@Mock 
	private HttpSession session;
	@Mock
	private Usuario usuario;
	@Mock
	private TipoMovimiento tipoMovimiento;
	@Mock
	ServicioUsuario servicioUsuario;
	@Mock
    private List <Movimiento> movimientosTipo;
	@InjectMocks private ControladorMovimiento controladorMovimiento;
	@Mock
	Usuario cliente;
	@Before
	public void inyeccionAntesDeCadaTest(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testQueMeDirijaAlLoginCuandoNoEstaLogueado(){
		//preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(null);
		//ejecucion
		ModelAndView mav=controladorMovimiento.mostrarFacturas(request);
		//verificacion
		assertThat(mav.getViewName()).isEqualTo("redirect:/login");
		assertThat(mav.getModel()).isEmpty();
		verify(usuario,never()).getRol();
	}
	@Test
	public void testQueListeFacturas(){
		//preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(1L);
		when(servicioMovimiento.buscarMovimientosPorUsuario(any(Long.class))).thenReturn(movimientosTipo);
		//ejecucion
		ModelAndView mav1=controladorMovimiento.mostrarFacturas(request);
		//verificacion
		assertThat(mav1.getModel()).isNotEmpty();
		assertThat(mav1.getViewName()).isEqualTo("listaMovimientos");
		verify(servicioMovimiento,times(1)).buscarMovimientosPorUsuario(1L);
		assertThat(mav1.getModelMap()).isNotEmpty();
	}
	//Falta
	/*@Test
	public void testQueListePresupuestos(){
		//preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(2L);
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(cliente);
		//when(servicioMovimiento.buscarMovimientosPorUsuario((any(Long.class)),any(int.class))).thenReturn(cliente,2);
		//when(servicioMovimiento.buscarMovimientosPorUsuario(any(Long.class))).thenReturn(movimientosTipo);
		//ejecucion
		ModelAndView mav2=controladorMovimiento.mostrarPresupuestos(request);
		//verificacion
		assertThat(mav2.getModel()).isNotEmpty();
		assertThat(mav2.getViewName()).isEqualTo("listaMovimientos");
	}*/
	//Falta
	/*@Test
	public void testQueGenereFactura(){
		//preparacion
		//ejecucion
		ModelAndView mav3=controladorMovimiento.generarFactura(idCliente, idTipoVehiculo, fecha_hora, origen, destino, kilometros, descripcion, request);
		//verificacion
	}*/
	
}
