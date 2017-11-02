package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorApp {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		return new ModelAndView("redirect:/home");
	}
	
	/**
	 * Retorno la ventana del Home
	 * @return ModelAndView
	 */
	@RequestMapping("/home")
	public ModelAndView irAFormularioPresupuesto() {
		return new ModelAndView("home");
	}

}
