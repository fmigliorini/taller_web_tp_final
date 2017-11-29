package ar.edu.unlam.tallerweb1.controladores;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

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
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.modelo.Viaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioEstadoMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoMovimiento;
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
	private ServicioViaje servicioViaje;
	
	
	@Inject
	private ServicioUsuario servicioUsuario;
	
	@RequestMapping("listadoChoferes")
	public ModelAndView irAlABMchofer(){
		return new ModelAndView("listadoChoferes");

	}
	
	@RequestMapping("index_administrador")
	public ModelAndView index_administrador(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null ) {
		if(	servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")){
			
		return new ModelAndView("index_administrador");
		}
		else
		{
			model.put("tipo", "danger");	
			model.put("titulo", "Acceso denegado");
			model.put("mensaje","Para entrar a esta pagina usted debe tener rol Administrador");
	
			return new ModelAndView("notificacionGestion",model);
		}
		
		}
		else{
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping("listaDePresupuestosAceptados")
	public ModelAndView presupuestosAceptados(HttpServletRequest request) {

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null ) {
		if(	servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")){
		

		List<Movimiento> listaLog=servicioMovimiento.BuscarPresupuestosAceptados();
		model.put("listaLog", listaLog);
		return new ModelAndView("listaDePresupuestosAceptados",model);
		}
		else
		{
			model.put("tipo", "danger");	
			model.put("titulo", "Acceso denegado");
			model.put("mensaje","Para entrar a esta pagina usted debe tener rol Administrador");
	
			return new ModelAndView("notificacionGestion",model);
		}
	}
	else{
		return new ModelAndView("redirect:/login");
	}

	}
	@RequestMapping("asignarVehiculo")
	public ModelAndView asignarVehiculo( @RequestParam("id") Long id, HttpServletRequest request){

		Long idUsuario = (Long) request.getSession().getAttribute("idUsuario");
		ModelMap model = new ModelMap();
		if (idUsuario != null ) {
			if(	servicioUsuario.buscarPorId(idUsuario).getRol().equals("admin")){
				
		
		Movimiento mov =servicioMovimiento.buscarIdMovimiento(id);
		List<Vehiculo> listVehiculos = servicioVehiculo.listarPorTipoVehiculo(mov.getViaje().getTipoVehiculo());
		model.put("mov", mov);
		model.put("listVehiculos", listVehiculos);
		return new ModelAndView("asignarVehiculo",model);
	}
	else
	{
		model.put("tipo", "danger");	
		model.put("titulo", "Acceso denegado");
		model.put("mensaje","Para entrar a esta pagina usted debe tener rol Administrador");

		return new ModelAndView("notificacionGestion",model);
	}
}
else{
	return new ModelAndView("redirect:/login");
	}
}
	
	
	@RequestMapping("generarMovimientos")
	public ModelAndView generarMovimientos( @RequestParam("idVehiculo") Long idVehiculo,
											@RequestParam("idMovimiento") Long idMovimiento){
		ModelMap model = new ModelMap();
		Movimiento movimiento = servicioMovimiento.buscarIdMovimiento(idMovimiento);
		Viaje viaje = servicioViaje.buscarViajePorId(movimiento.getViaje().getId());
		Vehiculo vehiculo = servicioVehiculo.buscarPorId(idVehiculo);
		//Cambia el estado a Facturado
		movimiento.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorId(5));
		viaje.setVehiculo(vehiculo);
		movimiento.setViaje(viaje);
		try{
		//Actualizo el viaje	
		servicioViaje.ActualizarViaje(movimiento.getViaje());
	   //Actualizo el estado del presupuesto
		servicioMovimiento.actualizarMovimiento(movimiento);

		movimiento.setId(null);
		movimiento.setLetra('A');
		movimiento.setFecha_hora(LocalDateTime.now().toString());		
		//Factura
		movimiento.setTipoMovimiento(servicioTipoMovimiento.buscarPorId(1));
		servicioMovimiento.guardarMovimiento(movimiento);
		movimiento.setId(null);
		//Remito
		movimiento.setTipoMovimiento(servicioTipoMovimiento.buscarPorId(3));
		servicioMovimiento.guardarMovimiento(movimiento);

		model.put("tipo", "success");		
		model.put("titulo", "Se acepto con exito el presupuesto");
		model.put("mensaje",String.format("El presupuesto con el IdMovimiento %d fue aceptado con exito. Se generaron una factura y un remito para ese presupuesto.", idMovimiento) );
		}
		catch(Exception  excepcion)
		{
			model.put("tipo", "danger");	
			model.put("titulo", "Se genero un problema");
			model.put("mensaje",String.format("El presupuesto con el IdMovimiento %d tuvo algun inconveniente en actualizar el viaje con el vehiculo asignado o en genera las factura y remito.", idMovimiento) );
			
		}
		return new ModelAndView("notificacionGestion",model);
	}
	
	@RequestMapping("rechazarMovimiento")
	public ModelAndView rechazarMovimiento( @RequestParam("idMovimiento") Long idMovimiento){
		
		Movimiento movimiento = servicioMovimiento.buscarIdMovimiento(idMovimiento);
		ModelMap model = new ModelMap();
		
		movimiento.setEstadoMovimiento(servicioEstadoMovimiento.buscarPorId(3));
	try{
		servicioMovimiento.actualizarMovimiento(movimiento);

		model.put("tipo", "success");	
		model.put("titulo", "Se rechazo con exito el presupuesto");
		model.put("mensaje",String.format("El presupuesto con el IdMovimiento %d fue rechazado con exito.", idMovimiento) );
		
	}
	catch(Exception  excepcion)
	{
		model.put("tipo", "danger");	
		model.put("titulo", "Se genero un problema");
		model.put("mensaje",String.format("El presupuesto con el IdMovimiento %d tuvo algun inconveniente en actualizar su estado de Rechazado.", idMovimiento) );
		
	}
		
		return new ModelAndView("notificacionGestion",model);
	}

	@RequestMapping("reportesDeViajes")
	public ModelAndView irAreportesDeViajes(){
		return new ModelAndView("reportesDeViajes");
	}
	
	@RequestMapping("graficoDePresupuestos")
	public ModelAndView graficoDePresupuestos(){
		TipoMovimiento presupuesto = servicioTipoMovimiento.buscarPorId(3);
		ModelMap model = new ModelMap();
		model.put("activo", servicioMovimiento.buscarMovimientosPorTipoyEstado(presupuesto,servicioEstadoMovimiento.buscarPorId(1)).size());
		model.put("aceptado", servicioMovimiento.buscarMovimientosPorTipoyEstado(presupuesto,servicioEstadoMovimiento.buscarPorId(2)).size());
		model.put("rechazado",servicioMovimiento.buscarMovimientosPorTipoyEstado(presupuesto,servicioEstadoMovimiento.buscarPorId(3)).size());
		model.put("vencido", servicioMovimiento.buscarMovimientosPorTipoyEstado(presupuesto,servicioEstadoMovimiento.buscarPorId(4)).size());
		model.put("facturado", servicioMovimiento.buscarMovimientosPorTipoyEstado(presupuesto,servicioEstadoMovimiento.buscarPorId(5)).size());
		return new ModelAndView("graficoDePresupuestos",model);
	}
	
	@RequestMapping("informePresupuestosFacturados")
	public ModelAndView informePresupuestosFacturados(){
		TipoMovimiento tipoMovimiento = servicioTipoMovimiento.buscarPorId(3);
		List<Movimiento> presupuestos = servicioMovimiento.buscarMovimientosPorTipoyEstado(tipoMovimiento,servicioEstadoMovimiento.buscarPorId(5));
		float total=0;
		for(Movimiento p:presupuestos){
		
		total = total + p.getViaje().getPrecio();
	}
		
		
		ModelMap model = new ModelMap();
		model.put("presupuestos",presupuestos );
		model.put("totalPresupuestado", total);
		return new ModelAndView("informePresupuestosFacturados",model);
	}
}
