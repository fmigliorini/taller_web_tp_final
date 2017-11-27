package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorMenuChofer {
	
	@Inject
    ServicioViaje servicioViaje;
	@Inject 
	ServicioUsuario servicioUsuario;
	
	@RequestMapping(path="listaDeViajesActivos")
	public ModelAndView irAlaListaDeViajesArealizar(HttpServletRequest request ){
		Long idUsuario=(Long)request.getSession().getAttribute("idUsuario");
		Usuario chofer=servicioUsuario.buscarPorId(idUsuario);
		ModelMap model = new ModelMap();
		List<Viaje>listaViajeActivo=servicioViaje.listarViajesActivos(chofer);
		model.put("listaViajeActivo",listaViajeActivo);
		return new ModelAndView("listaDeViajesActivos",model);
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
	public ModelAndView irAlMenuDeViajeActivo(HttpServletRequest request){
		Long idUsuario=(Long)request.getSession().getAttribute("idUsuario");
		Viaje viaje=servicioViaje.buscarViajePorId(idUsuario);
		Usuario chofer=servicioUsuario.buscarPorId(idUsuario);
		viaje.setEstado("En proceso");
		return new ModelAndView("menu_chofer_viajeActivo");
	}
	
}
