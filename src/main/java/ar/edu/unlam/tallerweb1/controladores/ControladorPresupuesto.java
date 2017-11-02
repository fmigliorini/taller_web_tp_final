package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.modelo.Presupuesto;
import ar.edu.unlam.tallerweb1.modelo.TipoVehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioCliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioPresupuesto;
import ar.edu.unlam.tallerweb1.servicios.ServicioTipoVehiculo;

@Controller
public class ControladorPresupuesto {

	@Inject
	private ServicioCliente servicioCliente;
	
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
	public ModelAndView irAFormularioPresupuesto() {
		
		ModelMap model = new ModelMap();
		model.put("clientes", servicioCliente.listarClientes());
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
		presupuesto.setCliente(servicioCliente.buscarPorId(idCliente));
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
