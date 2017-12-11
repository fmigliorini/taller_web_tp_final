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
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

public class ControladorClienteMockito {
	@Mock
	private ServicioMovimiento servicioMovimiento;
	@Mock
	private ServicioTipoMovimiento servicioTipoMovimiento;
	@Mock
	private HttpServletRequest request;
	@Mock 
	private HttpSession session;
	@Mock
	private ServicioLogin servicioLogin;
	@Mock
	private Usuario cliente;
	@Mock
	private ServicioUsuario servicioUsuario;
	@Mock
	private TipoMovimiento tipoMovimiento;
	
	@InjectMocks private ControladorCliente controladorCliente;
	@Before 
	public void inyeccionAntesDeCadaTest(){
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test 
	public void testQueNoMeMuestreirAFormularioPresupuestoYMeRedirijaAlLogin(){
		//preparacion 
		when(request.getSession()).thenReturn(session);
		when(servicioLogin.consultarUsuario(any(Usuario.class))).thenReturn(null);
		when(cliente.getRol()).thenReturn(null);
		//ejecucion
		ModelAndView mav=controladorCliente.irAFormularioPresupuesto(request);
	   //verificacion
		assertThat(mav.getViewName()).isEqualTo("redirect:/login");
		assertThat(mav.getModel()).isEmpty();
		verify(cliente,never()).getRol();
	}
	@Test
	public void testQueMeMuestreirAFormularioPresupuesto(){
		//preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(1L);
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(cliente);
		when(cliente.getRol()).thenReturn("cliente");
		//ejecucion
		ModelAndView mav1=controladorCliente.irAFormularioPresupuesto(request);
		//verificacion
		assertThat(mav1.getViewName()).isEqualTo("home");
		verify(servicioUsuario,times(1)).buscarPorId(1L);
		verify(cliente,times(1)).getRol();
		
	}
	@Test
	public void testListePresupuestosCliente(){
		//preparacion
		when(request.getSession()).thenReturn(session);
		when(session.getAttribute(any(String.class))).thenReturn(2L);
		when(servicioUsuario.buscarPorId(any(Long.class))).thenReturn(cliente);
		when(cliente.getRol()).thenReturn("cliente");
		//ejecucion
		ModelAndView mav2=controladorCliente.listarPresupuestosCliente(request);
		//verificacion
		assertThat(mav2.getViewName()).isEqualTo("cliente-lista-presupuesto");
		verify(cliente,times(1)).getRol();
		verify(servicioUsuario,times(1)).buscarPorId(1L);
		
		//when(servicioMovimiento.buscarMovimientosPorUsuario(any(Long.class))).thenReturn(tipoMovimiento);
		//when(servicioMovimiento.buscarMovimientosPorUsuario(any(Long.class)))).thenReturn(tipoMovimiento);
		
		/*
			List<Movimiento> listaMovimiento = servicioMovimiento.buscarMovimientosPorUsuario(idUsuario,
					servicioTipoMovimiento.buscarPorDescripcion("Presupuesto").getId());
			ModelMap model = new ModelMap();
			model.put("presupuestos", listaMovimiento);
			return new ModelAndView("cliente-lista-presupuesto", model);*/
	}
}
