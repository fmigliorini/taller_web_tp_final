package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorPresupuesto {

	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;

	@Inject
	private ServicioViaje servicioViaje;

	@RequestMapping("/presupuestoForm")
	public ModelAndView irAFormularioPresupuesto(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			ModelMap model = new ModelMap();
			model.put("idCliente", idUsuario);
			model.put("tiposVehiculos", servicioTipoVehiculo.listarTiposVehiculos());
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
		
		ModelMap modeMap = new ModelMap();
		
		return new ModelAndView("invoice", modeMap);
	}

}
