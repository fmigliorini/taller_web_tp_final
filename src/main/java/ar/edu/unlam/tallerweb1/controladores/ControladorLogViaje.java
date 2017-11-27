package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogViaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorLogViaje {
	@Inject 
	ServicioLogViaje servicioLogViaje;
	@Inject 
	ServicioViaje servicioViaje;
	
	@RequestMapping("logViajeForm")
	public ModelAndView irAFormularioLogViaje(){
		LogViaje logViaje = new LogViaje();
		ModelMap model = new ModelMap();
		model.put("logViaje", logViaje);//El "logViaje" (la clave) es la que esta en el modelAttribute del form
		return new ModelAndView("logViaje-form1", model);
	}
	@RequestMapping(path="cargarLogViaje", method=RequestMethod.POST)
	public ModelAndView cargarLogViaje(@ModelAttribute("logViaje") LogViaje logViaje){
		servicioLogViaje.gardarLogViaje(logViaje);
		ModelMap modelo = new ModelMap();
		modelo.put("logViaje", logViaje);
		return new ModelAndView("invoiceLogViaje",modelo);
	}
	@RequestMapping("listaLogViaje")
	public ModelAndView mostrarListaLogViaje(Long id){
		ModelMap modelo2=new ModelMap();
		Viaje viaje =servicioViaje.buscarViajePorId(id);
		List<LogViaje> listaLog = servicioLogViaje.listarLogViajePorViaje(viaje);
		modelo2.put("listaLog", listaLog);
		return new ModelAndView("listaLogViaje",modelo2);
	}
		                         
}			                         
	
		
		
		
		
		
		
		
		
		
	

	
