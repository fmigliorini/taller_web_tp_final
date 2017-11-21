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
public class ControladorLogin {


	@Inject
	private ServicioLogin servicioLogin;

	@RequestMapping("/login")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		modelo.put("usuario", usuario);
		return new ModelAndView("login", modelo);
	}

	@RequestMapping(path = "/validar-login", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		ModelMap model = new ModelMap();
		
		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		if (usuarioBuscado != null) {
		
			request.getSession().setAttribute("rol", usuarioBuscado.getRol());
			request.getSession().setAttribute("idUsuario", usuarioBuscado.getId());
			
			if(usuarioBuscado.getRol().equals("chofer")){
				return new ModelAndView("redirect:/index_chofer");
			}
			if(usuarioBuscado.getRol().equals("cliente")){
				return new ModelAndView("redirect:/home");
			}
			return new ModelAndView("redirect:/index");
			
		} else {
			model.put("error", "Usuario o clave incorrecta");
		}
		return new ModelAndView("redirect:/login", model);
	}
	
	public void setServicioLogin(ServicioLogin servicioLogin) {
		this.servicioLogin = servicioLogin;
	}

}
