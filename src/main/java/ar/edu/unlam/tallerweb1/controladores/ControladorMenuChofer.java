package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogViaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimientoImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorMenuChofer {

	@Inject
	ServicioViaje servicioViaje;
	@Inject
	ServicioUsuario servicioUsuario;
	@Inject
	ServicioLogViaje servicioLogViaje;
	@Inject
	ServicioMovimiento servicioMovimiento;
	@Inject
	ServicioTipoMovimiento servicioTipoMovimiento;

	@RequestMapping(path = "listaDeViajesActivos")
	public ModelAndView irAlaListaDeViajesArealizar(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
		Viaje viajeEnProceso = servicioViaje.buscarViajeEnProceso(chofer);
		if (viajeEnProceso != null) {
			return new ModelAndView("redirect:/viajeEnProceso");
		}
		ModelMap model = new ModelMap();
		List<Viaje> listaViajeActivo = servicioViaje.listarViajesActivos(chofer);
		model.put("listaViajeActivo", listaViajeActivo);
		model.put("viaje", new Viaje());
		return new ModelAndView("chofer-viajes-activo", model);
	}

	@RequestMapping(path = "activarViaje", method = RequestMethod.POST)
	public ModelAndView activarViaje(@RequestParam("idViaje") Long idViaje, HttpServletRequest request) {
		// Long idUsuario = (Long)
		// request.getSession().getAttribute("idUsuario");
		Viaje viaje = servicioViaje.buscarViajePorId(idViaje);
		viaje.setEstado("En proceso");
		servicioViaje.viajeActualizadoEnProceso(viaje);
		return new ModelAndView("redirect:/viajeEnProceso");
	}

	@RequestMapping(path = "viajeEnProceso")
	public ModelAndView irAlMenuDeViajeActivo(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
		Viaje viajeEnProceso = servicioViaje.buscarViajeEnProceso(chofer);
		if (viajeEnProceso != null) {
			ModelMap model = new ModelMap();
			model.put("viajeEnProceso", viajeEnProceso);
			return new ModelAndView("chofer-viaje-en-proceso", model);
		} else {
			return new ModelAndView("redirect:/listaDeViajesActivos");
		}
	}

	@RequestMapping(path = "finalizarViajeEnProgreso", method = RequestMethod.POST)
	public ModelAndView finalizarViajeEnProgreso(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
			ModelMap modelo = new ModelMap();
			if (chofer.getRol().equals("chofer")) {
				Viaje viajeTerminado = servicioViaje.buscarViajeEnProceso(chofer);
				viajeTerminado.setEstado("Terminado");
				servicioViaje.viajeActualizadoEnProceso(viajeTerminado);
				modelo.put("tipo", "success");
				modelo.put("titulo", "Viaje finalizado correctamente");
				modelo.put("mensaje", String.format("El viaje fue completado."));
			} else {
				modelo.put("tipo", "danger");
				modelo.put("titulo", "No tiene autorizaciÃ³n");
				modelo.put("mensaje", String.format("Entrar con rol chofer."));
			}
			return new ModelAndView("chofer-viaje-finalizado", modelo);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("viajesFinalizados")
	public ModelAndView irAListadoViajesFinalizados(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
		if (chofer != null) {
			List<Viaje> listaViajeFinalizado = servicioViaje.listarViajesTerminados(chofer);
			ModelMap model = new ModelMap();
			model.put("listaViajesFinalizados", listaViajeFinalizado);
			return new ModelAndView("chofer-lista-viajes-finalizado", model);
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("listaDeRemitos")
	public ModelAndView irAlaListaDeRemitos(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Usuario chofer = servicioUsuario.buscarPorId(idUsuario);
			ModelMap modelo = new ModelMap();
			if (chofer.getRol().equals("chofer")) {
				List<Movimiento> listaRemitos = servicioMovimiento.buscarMovimientosParaChofer(idUsuario);
				modelo.put("listaRemitos", listaRemitos);
				return new ModelAndView("chofer-lista-remitos", modelo);
			} else {
				modelo.put("tipo", "danger");
				modelo.put("titulo", "No tiene autorizaciÃ³n");
				modelo.put("mensaje", String.format("Entrar con rol chofer."));
				return new ModelAndView("notificacionGestion", modelo);
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
	// Este método lo haría si quiero mostrar los remitos
	/*
	 * @RequestMapping(path = "/verRemito/{idRemito}") public ModelAndView
	 * verRemito(@PathVariable("idRemito") Long idRemito, HttpServletRequest
	 * request) { ModelMap modelMap = new ModelMap(); Movimiento remito =
	 * servicioMovimiento.buscarIdMovimiento(idRemito); modelMap.put("remito",
	 * remito); modelMap.put("chofer", remito.getUsuario());
	 * modelMap.put("Factura",
	 * servicioMovimiento.buscarMovimientosPorViaje(remito.getViaje().getId(),
	 * servicioTipoMovimientoImpl.buscarPorDescripcion("Factura").getId()));
	 * return new ModelAndView("chofer-remito-invoice", modelMap); }
	 */

}
