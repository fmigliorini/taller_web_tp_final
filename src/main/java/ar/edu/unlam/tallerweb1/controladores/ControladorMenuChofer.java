package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(path = "listaDeViajesActivos")
	public ModelAndView irAlaListaDeViajesArealizar(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
		Viaje viajeEnProceso = servicioViaje.buscarViajeEnProceso(chofer);
		if (viajeEnProceso != null) {
			return new ModelAndView("redirect:/viajeEnProceso");
		}
		ModelMap model = new ModelMap();
		List<Viaje> listaViajeActivo = servicioViaje.listarViajesActivos(chofer);
		model.put("listaViajeActivo", listaViajeActivo);
		model.put("viaje", new Viaje());
		return new ModelAndView("chofer-viajes-activo", model);
	}

	@RequestMapping(path = "activarViaje", method = RequestMethod.POST)
	public ModelAndView activarViaje(@RequestParam("idViaje") Long idViaje, HttpServletRequest request) {
		// Long idUsuario = (Long)
		// request.getSession().getAttribute("idUsuario");
		Viaje viaje = servicioViaje.buscarViajePorId(idViaje);
		viaje.setEstado("En proceso");
		servicioViaje.viajeActualizadoEnProceso(viaje);
		return new ModelAndView("redirect:/viajeEnProceso");
	}

	@RequestMapping(path = "viajeEnProceso")
	public ModelAndView irAlMenuDeViajeActivo(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
		Viaje viajeEnProceso = servicioViaje.buscarViajeEnProceso(chofer);
		if (viajeEnProceso != null) {
			ModelMap model = new ModelMap();
			model.put("viajeEnProceso", viajeEnProceso);
			return new ModelAndView("chofer-viaje-en-proceso", model);
		} else {
			return new ModelAndView("redirect:/listaDeViajesActivos");
		}
	}

	// Con seguridad
	@RequestMapping(path = "finalizarViaje", method = RequestMethod.POST)
	public ModelAndView irAFinalizarViaje(@ModelAttribute("viaje") Viaje viaje, HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
			ModelMap modelo = new ModelMap();
			if (chofer.getRol().equals("chofer")) {
				Viaje viajeTerminado = servicioViaje.buscarViajePorId(viaje.getId());
				viajeTerminado.setEstado("Terminado");
				servicioViaje.viajeActualizadoEnProceso(viajeTerminado);
				modelo.put("tipo", "success");
				modelo.put("titulo", "El viaje ha sido realizado con exito");
				modelo.put("mensaje", String.format("El viaje fue realizado con exito."));
			} else {
				modelo.put("tipo", "danger");
				modelo.put("titulo", "No tiene autorizaci�n");
				modelo.put("mensaje", String.format("Entrar con rol chofer."));
			}
			return new ModelAndView("notificacionGestion", modelo);
		} else {
			return new ModelAndView("login");
		}
	}

	// Falta cosas a este m�todo
	@RequestMapping("listaDeViajesHechos")
	public ModelAndView irAlaListaDeViajesRealizados(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
		ModelMap modelo2 = new ModelMap();
		List<Viaje> listaDeViajesTerminados = servicioViaje.listarViajesTerminados(chofer);
		modelo2.put("listaDeViajesTerminados", listaDeViajesTerminados);
		System.out.println("estado de viaje---" + ((Viaje) listaDeViajesTerminados).getEstado());
		return new ModelAndView("listaDeViajesHechos", modelo2);

	}

	@RequestMapping("listaDeRemitos")
	public ModelAndView irAlaListaDeRemitos() {
		return new ModelAndView("listaDeRemitos");
	}

	@RequestMapping("reportesDiarioDeViaje")
	public ModelAndView irAlistaDeReportesDiariosDeViajes() {
		return new ModelAndView("reportesDiarioDeViaje");
	}

}
