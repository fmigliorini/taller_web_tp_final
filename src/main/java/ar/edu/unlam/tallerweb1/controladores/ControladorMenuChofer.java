package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorMenuChofer {
	@RequestMapping("listaDeViajesArealizar")
	public ModelAndView irAlaListaDeViajesArealizar(){
		return new ModelAndView("listaDeViajesArealizar");
	}
	@RequestMapping("listaDeViajesHechos")
	public ModelAndView irAlaListaDeViajesRealizados(){
		return new ModelAndView("listaDeViajesHechos");
	}
	@RequestMapping("listaDeRemitos")
	public ModelAndView irAlaListaDeRemitos(){
		return new ModelAndView("listaDeRemitos");
	}
	@RequestMapping("reportesDiarioDeViaje")
	public ModelAndView irAlistaDeReportesDiariosDeViajes(){
		return new ModelAndView("reportesDiarioDeViaje");
	}
	@RequestMapping("menu_chofer_viajeActivo")
	public ModelAndView irAlMenuDeViajeActivo(){
		return new ModelAndView("menu_chofer_viajeActivo");
	}
	
}
