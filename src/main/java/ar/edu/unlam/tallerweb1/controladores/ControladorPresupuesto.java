package ar.edu.unlam.tallerweb1.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioEstadoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;
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

	@Inject
	ServicioVehiculo servicioVehiculo;

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
	
		    //TO DO : HAcer la fecha fin y hora fin 
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
			final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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

			long idMovimiento = presupuesto.getId();

			boolean error = false;

			Viaje viaje = presupuesto.getViaje();
			Vehiculo vehiculo = new Vehiculo();

			error = AsignarChofer(viaje, presupuesto);
			if (!error) {
				
				presupuesto.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Facturado"));
				servicioMovimiento.guardarMovimiento(presupuesto);
				// Actualizo el estado del presupuesto
				servicioMovimiento.actualizarMovimiento(presupuesto);
				presupuesto.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Factura"));
				presupuesto.setId(null);
				presupuesto.setLetra('A');
				presupuesto.setFecha_hora(LocalDateTime.now().toString());
				// Factura
				presupuesto.setTipoMovimiento(servicioTipoMovimiento.buscarPorDescripcion("Factura"));
				servicioMovimiento.guardarMovimiento(presupuesto);
				presupuesto.setId(null);
				// Remito
				presupuesto.setTipoMovimiento(servicioTipoMovimiento.buscarPorDescripcion("Remito"));
				servicioMovimiento.guardarMovimiento(presupuesto);

				return new ModelAndView("redirect:/verPresupuesto/" + idMovimiento);

			}

			else {
				presupuesto.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Aceptado"));
				servicioMovimiento.guardarMovimiento(presupuesto);
				ModelMap model = new ModelMap();
				model.put("tipo", "success");
				model.put("titulo", "No se pudo generar la Factura y el Remito");
				model.put("mensaje",
						String.format(
								"No se pudo generar la factura por falta de disponibilidad de vehículos, un representante va a estar viendo como lo pueda solucionar, en breve se está contactando con usted vía email para brindarle una resolución.",
								idMovimiento));

				return new ModelAndView("redirect:/notificacionGestion");
			}

		}
		return new ModelAndView("redirect:/login");

	}

	public void GenerarFacturaRemito() {
		this.servicioTipoVehiculo = servicioTipoVehiculo;
	}

	public boolean AsignarChofer(Viaje viaje, Movimiento presupuesto) {
		// Cambia el estado a Facturado
		long idVehiculo = servicioVehiculo.getIdVehiculoDisponible(viaje.getFecha(), viaje.getFechaFin(), viaje.getHora(),viaje.getHoraFin());
		if (idVehiculo > 0) {
			viaje.setVehiculo(servicioVehiculo.buscarPorId(idVehiculo));
			viaje.setEstado("activo");
			presupuesto.setViaje(viaje);
			// Actualizo el viaje
			servicioViaje.ActualizarViaje(presupuesto.getViaje());
			return false;
		} else {
			return true;
		}

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
