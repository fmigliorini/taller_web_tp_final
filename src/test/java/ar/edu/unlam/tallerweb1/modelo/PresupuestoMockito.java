package ar.edu.unlam.tallerweb1.modelo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import ar.edu.unlam.tallerweb1.controladores.ControladorPresupuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioEstadoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

public class PresupuestoMockito {

	@Test
	public void generacionDePresupuesto() {

		HttpServletRequest request = mock(HttpServletRequest.class);
		Viaje viaje = mock(Viaje.class);
		Movimiento movimiento = mock(Movimiento.class);
		
		ControladorPresupuesto controlador = new ControladorPresupuesto();
		
		ServicioTipoVehiculo servicioTipoVehiculo = mock(ServicioTipoVehiculo.class);
		controlador.setServicioTipoVehiculo(servicioTipoVehiculo);
		
		ServicioViaje servicioViaje = mock(ServicioViaje.class);
		controlador.setServicioViaje(servicioViaje);
		
		ServicioTipoMovimiento servicioTipoMovimiento = mock(ServicioTipoMovimiento.class);
		controlador.setServicioTipoMovimiento(servicioTipoMovimiento);
		
		ServicioEstadoMovimiento servicioEstadoMovimiento = mock(ServicioEstadoMovimiento.class);
		controlador.setServicioEstadoMovimiento(servicioEstadoMovimiento);
		
		ServicioUsuario servicioUsuario = mock(ServicioUsuario.class);
		controlador.setServicioUsuario(servicioUsuario);
		
		ServicioMovimiento servicioMovimiento = mock(ServicioMovimiento.class);
		controlador.setServicioMovimiento(servicioMovimiento);
		
		TipoVehiculo tipoVehiculo = mock(TipoVehiculo.class);
		Usuario usuario = mock(Usuario.class);
		
		when(viaje.getPeso()).thenReturn(200f);
		
		when(servicioTipoVehiculo.buscarPorPesoMaximo(viaje.getPeso())).thenReturn(tipoVehiculo);
		
		when(usuario.getRol()).thenReturn("cliente");
				
		HttpSession sessionMock = mock(HttpSession.class);
		
		when(request.getSession()).thenReturn(sessionMock);
		when(request.getSession().getAttribute("idUsuario")).thenReturn(1l);
		
		when(movimiento.getId()).thenReturn(1l);
		
		ModelAndView mav = controlador.generarPresupuesto(viaje,request);
		
		
		assertThat(mav.getViewName()).isEqualTo("redirect:/verPresupuesto/1");

	}

}
