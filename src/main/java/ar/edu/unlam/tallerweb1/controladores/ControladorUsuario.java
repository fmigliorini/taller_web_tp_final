package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

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
	

	//Hace el formulario de chófer
		@RequestMapping(path="/chofer-form")
		public ModelAndView irFormularioChofer()
		{
			ModelMap modelo1=new ModelMap();
			modelo1.put("usuario", new Usuario());
			return new ModelAndView("chofer-form",modelo1);
		}
		//Registra el chófer
		@RequestMapping(path="/registrar-chofer", method=RequestMethod.POST)
		public ModelAndView registrarChofer(@ModelAttribute("Usuario")Usuario usuarioChofer)
		{
			ModelMap modelo2=new ModelMap();
			usuarioChofer.setRol("chofer");
			servicioUsuario.generarUsuario(usuarioChofer);
			List<Usuario>listaChoferes=servicioUsuario.listarChoferes();
			modelo2.put("listaChoferes", listaChoferes);
			return new ModelAndView("listadoChoferes",modelo2);
		}
	
}
