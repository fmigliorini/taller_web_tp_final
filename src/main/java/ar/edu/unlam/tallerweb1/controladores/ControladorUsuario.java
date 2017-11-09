package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("/cliente-form")
	public ModelAndView irFormularioCliente() 
	{
		ModelMap model = new ModelMap();
		model.put("usuario",new Usuario());
		return new ModelAndView("cliente-form",model);
	}
	
	@RequestMapping(path="/registrar-cliente", method=RequestMethod.POST)
	public ModelAndView registrarCliente(@ModelAttribute("Usuario") Usuario usuario)
	{
		usuario.setRol("cliente");
		servicioUsuario.generarUsuario(usuario);
		return new ModelAndView("redirect:/login");
		
	}
	
	
}