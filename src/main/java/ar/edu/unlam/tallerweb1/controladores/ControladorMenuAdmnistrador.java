package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMenuAdmnistrador {
	
	//Esto lo dejé así porque no sé hasta donde hiciste Facu
	@RequestMapping("listadoChoferes")
	public ModelAndView irAlABMchofer(){
		return new ModelAndView("listadoChoferes");

	}
	
	@RequestMapping("listaDePresupuestosAceptados")
	public ModelAndView irAlaListaDePresupuestosAceptados(){
		return new ModelAndView("listaDePresupuestosAceptados");

	}
	
	@RequestMapping("reportesDeViajes")
	public ModelAndView irAreportesDeViajes(){
		return new ModelAndView("reportesDeViajes");
	}
}
