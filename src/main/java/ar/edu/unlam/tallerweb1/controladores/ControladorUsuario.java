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
	public ModelAndView irFormularioCliente() {
		ModelMap model = new ModelMap();
		model.put("usuario", new Usuario());
		return new ModelAndView("cliente-form", model);
	}

	@RequestMapping("profile")
	public ModelAndView profile(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		
		if (idUsuario != null) {
			Usuario usuario = servicioUsuario.buscarPorId(idUsuario);

			ModelMap model = new ModelMap();
			model.put("Usuario", usuario);
			if (usuario.getRol().equals("admin")) {
				return new ModelAndView("admin-profile", model);
			} else if (usuario.getRol().equals("chofer")) {
				return new ModelAndView("chofer-profile", model);
			} else if (usuario.getRol().equals("cliente")) {
				return new ModelAndView("cliente-profile", model);
			}

		}
		return new ModelAndView("redirect:/login");
	}
	
	
	@RequestMapping(path = "/actualizarDatos", method = RequestMethod.POST)
	public ModelAndView actualizarDatos(@ModelAttribute("Usuario") Usuario usuario, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			servicioUsuario.actualizarUsuario(usuario);
			model.put("tipo", "success");
			model.put("titulo", "Actualizacion Exitosa");
			model.put("mensaje", "Su usuario se a modificado de manera exitosa");
			return new ModelAndView("notificacionGestion", model);

		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/registrar-cliente", method = RequestMethod.POST)
	public ModelAndView registrarCliente(@ModelAttribute("Usuario") Usuario usuario) {
		usuario.setRol("cliente");
		servicioUsuario.generarUsuario(usuario);
		return new ModelAndView("redirect:/login");

	}

}
