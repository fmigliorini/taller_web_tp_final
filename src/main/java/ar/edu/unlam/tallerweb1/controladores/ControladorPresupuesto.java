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
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
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

		// GENERACION DE UN VIAJE
		TipoVehiculo tv = servicioTipoVehiculo.buscarPorPesoMaximo(viaje.getPeso());

		if (tv == null) {
			// No poseemos un vehiculo que permita llevar dicha carga.
			ModelMap modeMapError = new ModelMap();
			modeMapError.put("viaje", viaje);
			modeMapError.put("error", "No existe un vehiculo disponible para ese peso");
			return new ModelAndView("presupuestoForm", modeMapError);
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

		// seteo el viaje
		movimiento.setViaje(viaje);

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		Usuario usuario = servicioUsuario.buscarPorId(idUsuario);
		// seteo el cliente
		movimiento.setUsuario(usuario);
		servicioMovimiento.guardarMovimiento(movimiento);

		return new ModelAndView("redirect:/verPresupuesto/" + movimiento.getId());
	}

	@RequestMapping(path = "/verPresupuesto/{idPresupuesto}")
	public ModelAndView verPresupuesto(@PathVariable("idPresupuesto") Long idPresupuesto, HttpServletRequest request) {
		ModelMap modelMap = new ModelMap();
		Movimiento presupuesto = servicioMovimiento.buscarIdMovimiento(idPresupuesto);
		modelMap.put("presupuesto", presupuesto);
		modelMap.put("cliente", presupuesto.getUsuario());
		return new ModelAndView("presupuesto-invoice", modelMap);
	}

	@RequestMapping(path = "/aceptarPresupuesto")
	public ModelAndView aceptarPresupuesto(@RequestParam("idPresupuesto") Long idPresupuesto) {
		Movimiento presupuesto = servicioMovimiento.buscarIdMovimiento(idPresupuesto);
		presupuesto.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Aceptado"));
		servicioMovimiento.guardarMovimiento(presupuesto);
		return new ModelAndView("redirect:/verPresupuesto/" + presupuesto.getId());
	}

	@RequestMapping(path = "/rechazarPresupuesto")
	public ModelAndView rechazarPresupuesto(@RequestParam("idPresupuesto") Long idPresupuesto) {
		Movimiento presupuesto = servicioMovimiento.buscarIdMovimiento(idPresupuesto);
		presupuesto.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorDescripcion("Rechazado"));
		servicioMovimiento.guardarMovimiento(presupuesto);
		return new ModelAndView("redirect:/verPresupues	to/" + presupuesto.getId());
	}

	@RequestMapping(path = "/listarPresupuestosCliente")
	public ModelAndView listarPresupuestosCliente(HttpServletRequest request) {
		
		// validar rol cliente
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		
		List<Movimiento> listaMovimiento = servicioMovimiento.buscarMovimientosPorUsuario(idUsuario, servicioTipoMovimiento.buscarPorDescripcion("Presupuesto").getId());
		ModelMap model = new ModelMap();
		model.put("presupuestos", listaMovimiento);
		return new ModelAndView("cliente-lista-presupuesto",model);
	}
}
