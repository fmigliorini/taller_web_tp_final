package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Vehiculo;

@Controller
public class ControladorVehiculo {

	@RequestMapping("/vehiculo/form")
	public ModelAndView irAlFormularioCliente(){
		
		Vehiculo vehiculo = new Vehiculo();
		ModelMap model = new ModelMap();
		model.put("cliente", vehiculo);
		
		return new ModelAndView("formCliente", model);
	}
	
	@RequestMapping(path="/vehiculo/create", method=RequestMethod.POST)
	public ModelAndView crearCliente(@ModelAttribute("Vehiculo") Vehiculo vehiculo){
			
	}
	
}
