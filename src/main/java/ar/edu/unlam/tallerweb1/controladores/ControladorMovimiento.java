package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDate;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.Presupuesto;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioEstadoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioPresupuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorMovimiento {

	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;
	
	@Inject
	private ServicioPresupuesto servicioPresupuesto;

	@Inject
	private ServicioMovimiento servicioMovimiento;
	
	@Inject
	private ServicioViaje servicioViaje;
	
	@Inject
	private ServicioTipoMovimiento servicioTipoMovimiento;
	
	@Inject
	private ServicioEstadoMovimiento servicioEstadoMovimiento;

	
	@RequestMapping("/generarFactura")
	public ModelAndView generarFactura( @RequestParam("idCliente") Long idCliente,
											@RequestParam("tipoVehiculo") Long idTipoVehiculo,
											@RequestParam("fecha_hora") String fecha_hora,
											@RequestParam("origen") String origen,
											@RequestParam("destino") String destino,
											@RequestParam("kilometros") Integer kilometros,
											@RequestParam("descripcion") String descripcion)
	{
		Movimiento movimiento = new Movimiento();
		Viaje viaje = new Viaje();
		LocalDate diaActual = LocalDate.now();
		LocalDate diaVencimiento = LocalDate.now().plusDays(15);
	//	Presupuesto presupuesto = new Presupuesto();
		movimiento.setUsuario(servicioUsuario.buscarPorId(idCliente));
		movimiento.setFecha_hora(diaActual.toString());
		movimiento.setPuntoVenta(0001);
		movimiento.setNumeroMovimiento(servicioMovimiento.getLastNumber()+1);
		movimiento.setLetra('A');
		movimiento.setObservaciones(descripcion);
		//movimiento.setTipoMovimiento(1);
		//movimiento.setEstadoMovimiento(1);
		
		viaje.setTipoVehiculo(servicioTipoVehiculo.buscarPorId(idTipoVehiculo));		
		viaje.setOrigen(origen);
		viaje.setDestino(destino);
		viaje.setKilometros(kilometros);
		viaje.setDescripcion(descripcion);
		viaje.setPrecio(servicioTipoVehiculo.buscarPorId(idTipoVehiculo).getPrecio() * kilometros);
		servicioViaje.guardarViaje(viaje);
		
		ModelMap model = new ModelMap();
		model.put("movimiento", movimiento);
		model.put("viaje", viaje);
		return new ModelAndView("invoice",model);
	}

}