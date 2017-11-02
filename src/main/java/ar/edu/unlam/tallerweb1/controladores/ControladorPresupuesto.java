package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioCliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;

@Controller
public class ControladorPresupuesto {

	@Inject
	private ServicioCliente servicioCliente;
	
	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;
	
	/**
	 * Simplemente retorno la vista con el formulario
	 * para generar un nuevo presupuesto
	 * @return ModelAndView
	 */
	@RequestMapping("/presupuestoForm")
	public ModelAndView irAFormularioPresupuesto() {
		
		ModelMap model = new ModelMap();
		model.put("clientes", servicioCliente.listarClientes());
		model.put("tiposVehiculos", servicioTipoVehiculo.listarTiposVehiculos());
		return new ModelAndView("presupuesto-form", model);
		
	}
	
	

}
