package ar.edu.unlam.tallerweb1.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Movimiento;

import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioEstadoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioViaje;

@Controller
public class ControladorPresupuesto {

	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;

	@Inject
	private ServicioViaje servicioViaje;

	@Inject
	private ServicioTipoMovimiento servicioTipoMovimiento;

	@Inject
	private ServicioEstadoMovimiento servicioEstadoMovimiento;

	@Inject
	private ServicioMovimiento servicioMovimiento;

	@Inject
	ServicioUsuario servicioUsuario;

	@RequestMapping("/presupuestoForm")
	public ModelAndView irAFormularioPresupuesto(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			ModelMap model = new ModelMap();
			model.put("idCliente", idUsuario);
			Viaje viaje = new Viaje();
			model.put("viaje", viaje);
			return new ModelAndView("presupuesto-form", model);
		}
		return new ModelAndView("redirect:/login");

	}

	@RequestMapping(path = "/generarPresupuesto", method = RequestMethod.POST)
	public ModelAndView generarPresupuesto(@ModelAttribute("viaje") Viaje viaje, HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			// GENERACION DE UN VIAJE
			TipoVehiculo tv = servicioTipoVehiculo.buscarPorPesoMaximo(viaje.getPeso());

			if (tv == null) {
				// No poseemos un vehiculo que permita llevar dicha carga.
				ModelMap modelMapError = new ModelMap();
				modelMapError.put("viaje", viaje);
				modelMapError.put("error", "No existe un vehiculo disponible para ese peso");
				return new ModelAndView("presupuestoForm", modelMapError);
			}

			viaje.setTipoVehiculo(tv);
			viaje.setPrecio(tv.getPrecio() * viaje.getKilometros());
			servicioViaje.guardarViaje(viaje);

			// GENERACION DE UN MOVIMIENTO DE TIPO PRESUPUESTO
			Movimiento movimiento = new Movimiento();

			// seteo el tipo de movimiento
			movimiento.setTipoMovimiento(servicioTipoMovimiento.buscarPorDescripcion("Presupuesto"));

			// Seteo el estado del movimiento
			movimiento.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Activo"));

			// seteo la fecha del presupuesto
			final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			movimiento.setFecha_hora(sdf.format(date));

			// Seteo la fecha de vencimiento del presupuesto
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DATE, 1);
			movimiento.setFecha_vencimiento(sdf.format(c.getTime()));
			movimiento.setNumeroMovimiento(0001L);
			// seteo el viaje
			movimiento.setViaje(viaje);

			Usuario usuario = servicioUsuario.buscarPorId(idUsuario);
			// seteo el cliente
			movimiento.setUsuario(usuario);
			servicioMovimiento.guardarMovimiento(movimiento);

			return new ModelAndView("redirect:/verPresupuesto/" + movimiento.getId());
		}
		return new ModelAndView("redirect:/login");

	}

	@RequestMapping(path = "/verPresupuesto/{idPresupuesto}")
	public ModelAndView verPresupuesto(@PathVariable("idPresupuesto") Long idPresupuesto, HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			ModelMap modelMap = new ModelMap();
			Movimiento presupuesto = servicioMovimiento.buscarIdMovimiento(idPresupuesto);
			if (presupuesto != null) {
				modelMap.put("presupuesto", presupuesto);
				modelMap.put("cliente", presupuesto.getUsuario());
				modelMap.put("factura", servicioMovimiento.buscarMovimientosPorViaje(presupuesto.getViaje().getId(),
						servicioTipoMovimiento.buscarPorDescripcion("Factura").getId()));
				return new ModelAndView("presupuesto-invoice", modelMap);
			} else {
				// ENVIAR UN ERROR, NO AL LOGIN, QUIZÁS A LA VISTA DE LISTADO DE PRESUPUESTO.
				return new ModelAndView("redirect:/login");
			}
		}
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(path = "/aceptarPresupuesto")
	public ModelAndView aceptarPresupuesto(@RequestParam("idPresupuesto") Long idPresupuesto,
			HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Movimiento presupuesto = servicioMovimiento.buscarIdMovimiento(idPresupuesto);
			presupuesto.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Aceptado"));
			servicioMovimiento.guardarMovimiento(presupuesto);
			return new ModelAndView("redirect:/verPresupuesto/" + presupuesto.getId());
		}
		return new ModelAndView("redirect:/login");

	}

	@RequestMapping(path = "/rechazarPresupuesto")
	public ModelAndView rechazarPresupuesto(@RequestParam("idPresupuesto") Long idPresupuesto,
			HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		if (idUsuario != null) {
			Movimiento presupuesto = servicioMovimiento.buscarIdMovimiento(idPresupuesto);
			presupuesto.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Rechazado"));
			servicioMovimiento.guardarMovimiento(presupuesto);
			return new ModelAndView("redirect:/verPresupues	to/" + presupuesto.getId());
		}
		return new ModelAndView("redirect:/login");
	}

	public void setServicioTipoVehiculo(ServicioTipoVehiculo servicioTipoVehiculo) {
		this.servicioTipoVehiculo = servicioTipoVehiculo;
	}

	public void setServicioViaje(ServicioViaje servicioViaje) {
		this.servicioViaje = servicioViaje;
	}

	public void setServicioTipoMovimiento(ServicioTipoMovimiento servicioTipoMovimiento) {
		this.servicioTipoMovimiento = servicioTipoMovimiento;
	}

	public void setServicioEstadoMovimiento(ServicioEstadoMovimiento servicioEstadoMovimiento) {
		this.servicioEstadoMovimiento = servicioEstadoMovimiento;
	}

	public void setServicioUsuario(ServicioUsuario servicioUsuario) {
		this.servicioUsuario = servicioUsuario;
	}

	public void setServicioMovimiento(ServicioMovimiento servicioMovimiento) {
		this.servicioMovimiento = servicioMovimiento;
	}
}
