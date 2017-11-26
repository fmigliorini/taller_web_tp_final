package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;



@Controller
public class ControladorMenuAdmnistrador {
	
	@Inject
	private ServicioMovimiento servicioMovimiento;
	

	@RequestMapping("abmChofer")
	public ModelAndView irAlABMchofer(){
		return new ModelAndView("abmChofer");

	}
	
	@RequestMapping("listaDePresupuestosAceptados")
	public ModelAndView presupuestosAceptados(){

		ModelMap model = new ModelMap();
		model.put("movimiento", servicioMovimiento.BuscarPresupuestosAceptados());
		return new ModelAndView("listaDePresupuestosAceptados",model);


	}
	
	@RequestMapping("reportesDeViajes")
	public ModelAndView irAreportesDeViajes(){
		return new ModelAndView("reportesDeViajes");
	}
}
