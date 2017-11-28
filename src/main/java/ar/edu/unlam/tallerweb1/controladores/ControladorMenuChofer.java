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
		model.put("viaje", new Viaje());
		model.put("listaViajeActivo",listaViajeActivo);
		return new ModelAndView("listaDeViajesActivos",model);
	}
	
	//Luego de iniciar el viaje llega a este lugar.
		@RequestMapping("menu_chofer_viajeActivo")
		public ModelAndView irAlMenuDeViajeActivo(HttpServletRequest request){
			Long idUsuario=(Long)request.getSession().getAttribute("idUsuario");
			Viaje viajeEnProceso=servicioViaje.buscarViajePorId(idUsuario);
			ModelMap model=new ModelMap();
			viajeEnProceso.setEstado("En proceso");
			servicioViaje.viajeActualizadoEnProceso(viajeEnProceso);
			servicioViaje.guardarViaje(viajeEnProceso);
			model.put("viajeEnProceso", viajeEnProceso);
			System.out.println("estado de viaje---" +viajeEnProceso.getEstado());
			return new ModelAndView("menu_chofer_viajeActivo",model);
		}
		//Este vendría después de tocar el boton finalizar viaje
		@RequestMapping("finalizarViaje")
		public ModelAndView irAFinalizarViaje(){
			return new ModelAndView();
		}
		//Falta cosas a este método
		@RequestMapping("listaDeViajesHechos")
		public ModelAndView irAlaListaDeViajesRealizados(HttpServletRequest request){
			Long idUsuario=(Long)request.getSession().getAttribute("idUsuario");
			Usuario chofer=servicioUsuario.buscarPorId(idUsuario);
			ModelMap modelo2 = new ModelMap();
			List<Viaje>listaDeViajesTerminados=servicioViaje.listarViajesTerminados(chofer);
			modelo2.put("listaDeViajesTerminados", listaDeViajesTerminados);
			System.out.println("estado de viaje---" +((Viaje) listaDeViajesTerminados).getEstado());
			return new ModelAndView("listaDeViajesHechos",modelo2);
			
		}
		
		@RequestMapping("listaDeRemitos")
		public ModelAndView irAlaListaDeRemitos(){
			return new ModelAndView("listaDeRemitos");
		}
		@RequestMapping("reportesDiarioDeViaje")
		public ModelAndView irAlistaDeReportesDiariosDeViajes(){
			return new ModelAndView("reportesDiarioDeViaje");
		}
	
	
}
