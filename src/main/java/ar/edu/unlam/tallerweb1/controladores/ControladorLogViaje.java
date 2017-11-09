package ar.edu.unlam.tallerweb1.controladores;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogViaje;

//No borraste comentaste, el servicioLogViaje

@Controller
public class ControladorLogViaje {
	@Inject 
	ServicioLogViaje servicioLogViaje;
	//hay que insertar un servicioViajeendo
	@RequestMapping("logViajeForm")
	public ModelAndView irAFormularioLogViaje(){
		return new ModelAndView("logViaje-form");
	}
	

	@RequestMapping("cargarLogViaje")
	public ModelAndView cargarLogViaje(
			                          @RequestParam("descripcion") String descripcion,
			                          @RequestParam("precio") Double precio)
			                         
	{
		LogViaje logViaje=new LogViaje();
		
		logViaje.setDescripcion(descripcion);
		logViaje.setPrecio(precio);
		//LogViaje test = servicioLogViaje.buscarPorId(idViaje);
		//logViaje.setId(test.getId());//Algo así?
		//aca va el id del viaje, por ahora no lo puse porque no esta creada la clase viaje
		servicioLogViaje.gardarLogViaje(logViaje);
		ModelMap model = new ModelMap();
		model.put("logViaje", logViaje);
		//esto no va a ningun lado
		return new ModelAndView("invoice2",model);
	}
}
	
