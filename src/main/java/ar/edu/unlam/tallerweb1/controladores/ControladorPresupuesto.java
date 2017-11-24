package ar.edu.unlam.tallerweb1.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorPresupuesto {

	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;

	@Inject
	private ServicioViaje servicioViaje;

	@Inject
	private ServicioTipoMovimiento servicioTipoMovimiento;
	
	@Inject
	private ServicioMovimiento servicioMovimiento;
	
	@RequestMapping("/presupuestoForm")
	public ModelAndView irAFormularioPresupuesto(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			ModelMap model = new ModelMap();
			model.put("idCliente", idUsuario);
			Viaje viaje = new Viaje();
			model.put("viaje", viaje);
			return new ModelAndView("presupuesto-form", model);
		}
		return new ModelAndView("redirect:/login");

	}

	@RequestMapping(path = "/generarPresupuesto", method = RequestMethod.POST)
	public ModelAndView generarPresupuesto(@ModelAttribute("viaje") Viaje viaje) {
		
		// GENERACION DE UN VIAJE
		TipoVehiculo tv = servicioTipoVehiculo.buscarPorPesoMaximo(viaje.getPeso());
		if (tv != null) {
			// No poseemos un vehiculo que permita llevar dicha carga.
		}
		viaje.setTipoVehiculo(tv);
		viaje.setPrecio(tv.getPrecio() * viaje.getKilometros());
		servicioViaje.guardarViaje(viaje);

		
		// GENERACION DE UN MOVIMIENTO DE TIPO PRESUPUESTO
		Movimiento movimiento = new Movimiento();
		
		// seteo el tipo de movimiento
		TipoMovimiento presupuesto = servicioTipoMovimiento.buscarPorDescripcion("Factura");
		movimiento.setTipoMovimiento(presupuesto);
		
		// seteo la fecha del presupuesto
		final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		movimiento.setFecha_hora(sdf.format(date));
		
		// Seteo la fecha de vencimiento del presupuesto
		Calendar c = Calendar.getInstance(); 
		c.setTime(date);
		c.add(Calendar.DATE, 1);
		movimiento.setFecha_vencimiento(sdf.format(c.getTime()));
		
		// seteo el viaje
		movimiento.setViaje(viaje);
		
		servicioMovimiento.guardarMovimiento(movimiento);
		
		ModelMap modeMap = new ModelMap();
		
		return new ModelAndView("invoice", modeMap);
	}

}
