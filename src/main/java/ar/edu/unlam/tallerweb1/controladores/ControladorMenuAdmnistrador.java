package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.TipoMovimiento;
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
public class ControladorMenuAdmnistrador {

	@Inject
	private ServicioEstadoMovimiento servicioEstadoMovimiento;

	@Inject
	private ServicioMovimiento servicioMovimiento;

	@Inject
	private ServicioTipoMovimiento servicioTipoMovimiento;

	@Inject
	private ServicioVehiculo servicioVehiculo;

	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;

	@Inject
	private ServicioViaje servicioViaje;

	@Inject
	private ServicioUsuario servicioUsuario;

	@RequestMapping("index_administrador")
	public ModelAndView index_administrador(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {

				return new ModelAndView("index_administrador");
			} else {
				model.put("tipo", "danger");
				model.put("titulo", "Acceso denegado");
				model.put("mensaje", "Para entrar a esta pagina usted debe tener rol Administrador");

				return new ModelAndView("notificacionGestion", model);
			}

		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("listaDePresupuestosAceptados")
	public ModelAndView presupuestosAceptados(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {

				List<Movimiento> presupuestos = servicioMovimiento.buscarMovimientosPorTipoyEstado(
						servicioTipoMovimiento.buscarPorDescripcion("Presupuesto"),
						servicioEstadoMovimiento.buscarPorDescripcion("Aceptado"));
				model.put("presupuestos", presupuestos);
				return new ModelAndView("listaDePresupuestosAceptados", model);
			} else {
				model.put("tipo", "danger");
				model.put("titulo", "Acceso denegado");
				model.put("mensaje", "Para entrar a esta pagina usted debe tener rol Administrador");

				return new ModelAndView("notificacionGestion", model);
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping("asignarVehiculo")
	public ModelAndView asignarVehiculo(@RequestParam("id") Long id, HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {

				Movimiento mov = servicioMovimiento.buscarIdMovimiento(id);
				List<Vehiculo> listVehiculos = servicioVehiculo.getVehiculosDisponibles(mov.getViaje().getFechaHora(),
						mov.getViaje().getFechaHoraFin(), mov.getViaje().getTipoVehiculo(), false);
				if (listVehiculos.size() == 0) {
					listVehiculos = servicioVehiculo.getVehiculosDisponibles(mov.getViaje().getFechaHora(),
							mov.getViaje().getFechaHoraFin(), mov.getViaje().getTipoVehiculo(), true);
				}
				model.put("mov", mov);
				model.put("listVehiculos", listVehiculos);
				return new ModelAndView("asignarVehiculo", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("generarMovimientos")
	public ModelAndView generarMovimientos(@RequestParam("idVehiculo") Long idVehiculo,
			@RequestParam("idMovimiento") Long idMovimiento, HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Movimiento movimiento = servicioMovimiento.buscarIdMovimiento(idMovimiento);
				Viaje viaje = servicioViaje.buscarViajePorId(movimiento.getViaje().getId());
				Vehiculo vehiculo = servicioVehiculo.buscarPorId(idVehiculo);
				// Cambia el estado a Facturado
				movimiento.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorId(5));
				viaje.setVehiculo(vehiculo);
				viaje.setEstado("activo");
				movimiento.setViaje(viaje);
				try {
					// Actualizo el viaje
					servicioViaje.ActualizarViaje(movimiento.getViaje());
					// Actualizo el estado del presupuesto
					servicioMovimiento.actualizarMovimiento(movimiento);

					movimiento.setId(null);
					movimiento.setLetra('A');
					movimiento.setFecha_hora(LocalDateTime.now().toString());
					// Factura
					movimiento.setTipoMovimiento(servicioTipoMovimiento.buscarPorDescripcion("Factura"));
					servicioMovimiento.guardarMovimiento(movimiento);
					movimiento.setId(null);
					// Remito
					movimiento.setTipoMovimiento(servicioTipoMovimiento.buscarPorDescripcion("Remito"));
					servicioMovimiento.guardarMovimiento(movimiento);

					model.put("tipo", "success");
					model.put("titulo", "Se acepto con exito el presupuesto");
					model.put("mensaje",
							String.format(
									"El presupuesto con el IdMovimiento %d fue aceptado con exito. Se generaron una factura y un remito para ese presupuesto.",
									idMovimiento));
				} catch (Exception excepcion) {
					model.put("tipo", "danger");
					model.put("titulo", "Se genero un problema");
					model.put("mensaje",
							String.format(
									"El presupuesto con el IdMovimiento %d tuvo algun inconveniente en actualizar el viaje con el vehiculo asignado o en genera las factura y remito.",
									idMovimiento));

				}
				return new ModelAndView("notificacionGestion", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("rechazarMovimiento")
	public ModelAndView rechazarMovimiento(@RequestParam("idMovimiento") Long idMovimiento,
			HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {

				Movimiento movimiento = servicioMovimiento.buscarIdMovimiento(idMovimiento);
				movimiento.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorId(3));
				try {
					servicioMovimiento.actualizarMovimiento(movimiento);

					model.put("tipo", "success");
					model.put("titulo", "Se rechazo con exito el presupuesto");
					model.put("mensaje", String.format("El presupuesto con el IdMovimiento %d fue rechazado con exito.",
							idMovimiento));

				} catch (Exception excepcion) {
					model.put("tipo", "danger");
					model.put("titulo", "Se genero un problema");
					model.put("mensaje",
							String.format(
									"El presupuesto con el IdMovimiento %d tuvo algun inconveniente en actualizar su estado de Rechazado.",
									idMovimiento));

				}

				return new ModelAndView("notificacionGestion", model);
			} else {
				model.put("tipo", "danger");
				model.put("titulo", "Acceso denegado");
				model.put("mensaje", "Para entrar a esta pagina usted debe tener rol Administrador");

				return new ModelAndView("notificacionGestion", model);
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	// Informes///

	@RequestMapping("reportesDeViajes")
	public ModelAndView irAreportesDeViajes() {
		return new ModelAndView("reportesDeViajes");
	}

	@RequestMapping("graficoDePresupuestos")
	public ModelAndView graficoDePresupuestos(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				TipoMovimiento presupuesto = servicioTipoMovimiento.buscarPorId(3);

				model.put("activo", servicioMovimiento
						.buscarMovimientosPorTipoyEstado(presupuesto, servicioEstadoMovimiento.buscarPorId(1)).size());
				model.put("aceptado", servicioMovimiento
						.buscarMovimientosPorTipoyEstado(presupuesto, servicioEstadoMovimiento.buscarPorId(2)).size());
				model.put("rechazado", servicioMovimiento
						.buscarMovimientosPorTipoyEstado(presupuesto, servicioEstadoMovimiento.buscarPorId(3)).size());
				model.put("vencido", servicioMovimiento
						.buscarMovimientosPorTipoyEstado(presupuesto, servicioEstadoMovimiento.buscarPorId(4)).size());
				model.put("facturado", servicioMovimiento
						.buscarMovimientosPorTipoyEstado(presupuesto, servicioEstadoMovimiento.buscarPorId(5)).size());
				return new ModelAndView("graficoDePresupuestos", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("informePresupuestosFacturados")
	public ModelAndView informePresupuestosFacturados(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				TipoMovimiento tipoMovimiento = servicioTipoMovimiento.buscarPorId(3);
				List<Movimiento> presupuestos = servicioMovimiento.buscarMovimientosPorTipoyEstado(tipoMovimiento,
						servicioEstadoMovimiento.buscarPorId(5));
				float total = 0;
				for (Movimiento p : presupuestos) {

					total = total + p.getViaje().getPrecio();
				}
				model.put("presupuestos", presupuestos);
				model.put("totalPresupuestado", total);
				return new ModelAndView("informePresupuestosFacturados", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("informeViajesActivos")
	public ModelAndView informeViajesActivos(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				model.put("viajes", servicioViaje.listarViajesAct());
				return new ModelAndView("informeViajesActivos", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	// ---------------//

	// ABM USUARIO //

	@RequestMapping("abmUsuario")
	public ModelAndView abmUsuario(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				model.put("cliente", servicioUsuario.usuariosRol("cliente"));
				model.put("chofer", servicioUsuario.usuariosRol("chofer"));
				model.put("admin", servicioUsuario.usuariosRol("admin"));
				return new ModelAndView("abmUsuario", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping("agregarUsuario")
	public ModelAndView agregarUsuario(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Usuario usuario = new Usuario();
				model.put("usuario", usuario);
				return new ModelAndView("agregarUsuario", model);
			} else {
				return new ModelAndView("redirect:/login");
			}

		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/guardarUsuario", method = RequestMethod.POST)
	public ModelAndView guardarUsuario(@ModelAttribute("Usuario") Usuario usuario, HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				if (servicioUsuario.consultarUsuarioPorEmail(usuario) == null) {
					servicioUsuario.generarUsuario(usuario);
					model.put("usuario", usuario);
					model.put("tipo", "success");
					model.put("titulo", "Creacion Exitosa");
					model.put("mensaje",
							String.format("Se ah creado el usuario con el id %d de manera exitosa", usuario.getId()));
					return new ModelAndView("notificacionGestion", model);
				} else {
					model.put("usuario", usuario);
					model.put("tipo", "danger");
					model.put("titulo", "El E-mail ya se encuentra en uso");
					model.put("mensaje",
							String.format("Otro usuario ya está usando este correo: %s", usuario.getEmail()));
					return new ModelAndView("notificacionGestion", model);

				}
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping("modificarUsuario")
	public ModelAndView modificarUsuario(@RequestParam("idUsuario") Long idUsuario, HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Usuario usuario = servicioUsuario.buscarPorId(idUsuario);
				model.put("Usuario", usuario);
				return new ModelAndView("modificarUsuario", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping(path = "/actualizarUsuario", method = RequestMethod.POST)
	public ModelAndView actualizarUsuario(@ModelAttribute("Usuario") Usuario usuario, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				if (servicioUsuario.consultarUsuarioPorEmail(usuario) == null) {
					servicioUsuario.actualizarUsuario(usuario);
					model.put("tipo", "success");
					model.put("titulo", "Actualizacion Exitosa");
					model.put("mensaje", String.format("El usuario con el id %d  se a modificado de manera exitosa",
							usuario.getId()));
					return new ModelAndView("notificacionGestion", model);
				} else {
					model.put("tipo", "danger");
					model.put("titulo", "El E-mail ya se encuentra en uso.");
					model.put("mensaje",
							String.format("Otro usuario ya está usando este correo: %s", usuario.getEmail()));
					return new ModelAndView("notificacionGestion", model);
				}

			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("eliminarUsuario")
	public ModelAndView eliminarUsuario(@RequestParam("idUsuario") Long idUsuario, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Usuario usuario = servicioUsuario.buscarPorId(idUsuario);
				servicioUsuario.eliminarUsuario(usuario);
				model.put("tipo", "success");
				model.put("titulo", "Eliminacion Exitosa");
				model.put("mensaje",
						String.format("El usuario con el id %d  se a eliminado de manera exitosa", usuario.getId()));
				return new ModelAndView("notificacionGestion", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}
	/// -----------///

	// ABM VEHICULO
	@RequestMapping("abmVehiculo")
	public ModelAndView abmVehiculo(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				model.put("vehiculo", servicioVehiculo.getAll());
				return new ModelAndView("abmVehiculo", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("agregarVehiculo")
	public ModelAndView agregarVehiculo(HttpServletRequest request) {
		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null) {
			if (servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")) {
				Vehiculo vehiculo = new Vehiculo();
				List<Usuario> listChoferes = servicioUsuario.listarChoferesSinVehiculo();
				if(listChoferes.size()>0)
				{
					model.put("Vehiculo", vehiculo);
					model.put("lisTipovehiculos", servicioTipoVehiculo.listarTiposVehiculos());

					model.put("listChoferes",listChoferes);
					return new ModelAndView("agregarVehiculo", model);
				}
				else
				{
					model.put("tipo", "danger");
					model.put("titulo", "No tiene choferes:");
					model.put("mensaje","Para poder crear un vehiculo , necesita tener al menos un chofer sin vehiculo asignado");
					return new ModelAndView("notificacionGestion", model);
					
				}

			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping(path = "/guardarVehiculo", method = RequestMethod.POST)
	public ModelAndView guardarVehiculo(@RequestParam("idTipoVehiculo") Long idTipoVehiculo,
			@RequestParam("idChofer") Long idChofer, @ModelAttribute("Vehiculo") Vehiculo vehiculo,
			HttpServletRequest request) {
		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				try {
					vehiculo.setChofer(servicioUsuario.buscarPorId(idChofer));
					vehiculo.setTipoVehiculo(servicioTipoVehiculo.buscarPorId(idTipoVehiculo));
					servicioVehiculo.guardarVehiculo(vehiculo);

					model.put("tipo", "success");
					model.put("titulo", "Creacion Exitosa");
					model.put("mensaje",
							String.format("Se ah creado el usuario con el id %d de manera exitosa", vehiculo.getId()));
				} catch (Exception e) {
					model.put("tipo", "danger");
					model.put("titulo", "Creacion Fallida");
					model.put("mensaje", String.format("No se ah podido crear el vehiculo"));
				}
				return new ModelAndView("notificacionGestion", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}

	}

	@RequestMapping(path = "/actualizarVehiculo", method = RequestMethod.POST)
	public ModelAndView actualizarVehiculo(@ModelAttribute("vehiculo") Vehiculo vehiculo,
			@RequestParam("tipovehiculo") Long tipovehiculo, @RequestParam("chofer") Long chofer,
			HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				vehiculo.setChofer(servicioUsuario.buscarPorId(chofer));
				vehiculo.setTipoVehiculo(servicioTipoVehiculo.buscarPorId(tipovehiculo));
				servicioVehiculo.actualizarVehiculo(vehiculo);
				model.put("tipo", "success");
				model.put("titulo", "Actualizacion Exitosa");
				model.put("mensaje", String.format("El vehiculo con el id %d  se a actualizado de manera exitosa",
						vehiculo.getId()));
				return new ModelAndView("notificacionGestion", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("modificarVehiculo")
	public ModelAndView modificarVehiculo(@RequestParam("idVehiculo") Long idVehiculo, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Vehiculo vehiculo = servicioVehiculo.buscarPorId(idVehiculo);
				model.put("lisTipovehiculos", servicioTipoVehiculo.listarTiposVehiculos());
				model.put("listChoferes", servicioUsuario.listarChoferesSinVehiculo());
				model.put("vehiculo", vehiculo);
				return new ModelAndView("modificarVehiculo", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

	@RequestMapping("eliminarVehiculo")
	public ModelAndView eliminarVehiculo(@RequestParam("idVehiculo") Long idVehiculo, HttpServletRequest request) {

		Long idAdmin = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idAdmin != null) {
			if (servicioUsuario.buscarPorId(idAdmin).getRol().equals("admin")) {
				Vehiculo vehiculo = servicioVehiculo.buscarPorId(idVehiculo);

				try {
					servicioVehiculo.eliminarVehiculo(vehiculo);
					model.put("tipo", "success");
					model.put("titulo", "Eliminacion Exitosa");
					model.put("mensaje", "El vehiculo con   se a eliminado de manera exitosa");
				} catch (Exception e) {
					model.put("tipo", "dangar");
					model.put("titulo", "Eliminacion Cancelada");
					model.put("mensaje",
							String.format("El vehiculo con el id %d  no pudo eliminarse", vehiculo.getId()));

				}
				return new ModelAndView("notificacionGestion", model);
			} else {
				return new ModelAndView("redirect:/login");
			}
		} else {
			return new ModelAndView("redirect:/login");
		}
	}

}
