package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Presupuesto;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioPresupuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;


@Controller
public class ControladorPresupuesto {

	@Inject
	private ServicioUsuario servicioUsuario;
	
	@Inject
	private ServicioTipoVehiculo servicioTipoVehiculo;
	
	@Inject
	private ServicioPresupuesto servicioPresupuesto;
	
	/**
	 * Simplemente retorno la vista con el formulario
	 * para generar un nuevo presupuesto
	 * @return ModelAndView
	 */
	@RequestMapping("/presupuestoForm")
	public ModelAndView irAFormularioPresupuesto(HttpServletRequest request) {
		Long idUsuario = (Long)request.getSession().getAttribute("idUsuario");
		
		ModelMap model = new ModelMap();
		model.put("idCliente", idUsuario);
		model.put("tiposVehiculos", servicioTipoVehiculo.listarTiposVehiculos());
		return new ModelAndView("presupuesto-form", model);
		
	}
	
	@RequestMapping("/generarPresupuesto")
	public ModelAndView generarPresupuesto( @RequestParam("idCliente") Long idCliente,
											@RequestParam("tipoVehiculo") Long idTipoVehiculo,
											@RequestParam("origen") String origen,
											@RequestParam("destino") String destino,
											@RequestParam("kilometros") Integer kilometros,
											@RequestParam("descripcion") String descripcion)
	{
		
		Presupuesto presupuesto = new Presupuesto();
		presupuesto.setUsuario(servicioUsuario.buscarPorId(idCliente));
		presupuesto.setTipoVehiculo(servicioTipoVehiculo.buscarPorId(idTipoVehiculo));		
		presupuesto.setOrigen(origen);
		presupuesto.setDestino(destino);
		presupuesto.setKilometros(kilometros);
		presupuesto.setDescripcion(descripcion);
		presupuesto.setPrecio(servicioTipoVehiculo.buscarPorId(idTipoVehiculo).getPrecio() * kilometros);
		servicioPresupuesto.guardarPresupusto(presupuesto);
		
		ModelMap model = new ModelMap();
		model.put("presupuesto", presupuesto);
		return new ModelAndView("invoice",model);
	}

}
