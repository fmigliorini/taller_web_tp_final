package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorWeb {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/index");
	}
	
	@RequestMapping(path = "/index", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	//Esto lo agruegue para el menú de chófer, va a la vista index_chofer
	//A su vez la vista index_chofer, contiene el archivo Menu_chofer con sus menus
	
	@RequestMapping(path = "/indexChofer", method = RequestMethod.GET)
	public ModelAndView indexChofer() {
		return new ModelAndView("index_chofer");
	}

}