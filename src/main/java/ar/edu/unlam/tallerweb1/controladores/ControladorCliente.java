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

import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;

@Controller
public class ControladorCliente {

	@Inject
	private ServicioMovimiento servicioMovimiento;

	@Inject
	private ServicioTipoMovimiento servicioTipoMovimiento;

	@RequestMapping("/home")
	public ModelAndView irAFormularioPresupuesto(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			return new ModelAndView("home");
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path = "/listarPresupuestosCliente")
	public ModelAndView listarPresupuestosCliente(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			List<Movimiento> listaMovimiento = servicioMovimiento.buscarMovimientosPorUsuario(idUsuario,
					servicioTipoMovimiento.buscarPorDescripcion("Presupuesto").getId());
			ModelMap model = new ModelMap();
			model.put("presupuestos", listaMovimiento);
			return new ModelAndView("cliente-lista-presupuesto", model);
		}
		return new ModelAndView("redirect:/login");
	}
}
