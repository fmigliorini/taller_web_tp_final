package ar.edu.unlam.tallerweb1.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogViaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorLogViaje {
	@Inject
	ServicioLogViaje servicioLogViaje;
	@Inject
	ServicioViaje servicioViaje;
	@Inject
	ServicioUsuario servicioUsuario;

	@RequestMapping("listaLogViaje")
	public ModelAndView mostrarListaLogViaje(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
			Viaje viajeEnProceso = servicioViaje.buscarViajeEnProceso(chofer);
			ModelMap model = new ModelMap();
			List<LogViaje> listaLogViajeEnProceso = servicioLogViaje.listarLogViajePorViaje(viajeEnProceso);
			model.put("listaLogViajeEnProceso", listaLogViajeEnProceso);
			return new ModelAndView("chofer-log-viaje-en-progreso", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "logViajeForm")
	public ModelAndView irAFormularioLogViaje(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
			Viaje viajeEnProceso = servicioViaje.buscarViajeEnProceso(chofer);
			LogViaje logViaje = new LogViaje();
			logViaje.setViaje(servicioViaje.buscarViajePorId(viajeEnProceso.getId()));
			ModelMap model = new ModelMap();
			model.put("logViaje", logViaje);
			return new ModelAndView("chofer-log-viaje-form", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "cargarLogViaje", method = RequestMethod.POST)
	public ModelAndView cargarLogViaje(@ModelAttribute("logViaje") LogViaje logViaje, HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
			Viaje viajeEnProceso = servicioViaje.buscarViajeEnProceso(chofer);
			
			logViaje.setViaje(viajeEnProceso);

			// Trae la fecha de ahora
			final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			logViaje.setFecha(sdf.format(date));

			// guardo el Log
			servicioLogViaje.gardarLogViaje(logViaje);

			ModelMap modelo = new ModelMap();

			modelo.put("logViaje", logViaje);
			return new ModelAndView("chofer-log-viaje-invoice", modelo);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	/*
	 * @RequestMapping("listaLogViaje") public ModelAndView
	 * mostrarListaLogViaje(Long id){ ModelMap modelo2=new ModelMap(); Viaje
	 * viaje =servicioViaje.buscarViajePorId(id); List<LogViaje> listaLog
	 * =servicioLogViaje.traerLogViajeSegunViaje(viaje); modelo2.put("listaLog",
	 * listaLog); return new ModelAndView("listaLogViaje",modelo2); }
	 */

}
