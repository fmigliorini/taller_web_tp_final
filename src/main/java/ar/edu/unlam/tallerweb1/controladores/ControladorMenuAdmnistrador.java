package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.LogViaje;
import ar.edu.unlam.tallerweb1.modelo.Movimiento;
import ar.edu.unlam.tallerweb1.modelo.Vehiculo;
import ar.edu.unlam.tallerweb1.servicios.ServicioMovimiento;
import ar.edu.unlam.tallerweb1.servicios.ServicioVehiculo;



@Controller
public class ControladorMenuAdmnistrador {
	
	@Inject
	private ServicioMovimiento servicioMovimiento;
	
	@Inject
	private ServicioVehiculo servicioVehiculo;
	
	@RequestMapping("abmChofer")
	public ModelAndView irAlABMchofer(){
		return new ModelAndView("abmChofer");

	}
	
	@RequestMapping("listaDePresupuestosAceptados")
	public ModelAndView presupuestosAceptados(){

		ModelMap model = new ModelMap();
		List<Movimiento> listaLog=servicioMovimiento.BuscarPresupuestosAceptados();
		model.put("listaLog", listaLog);
		return new ModelAndView("listaDePresupuestosAceptados",model);


	}
	@RequestMapping("asignarChofer")
	public ModelAndView asignarChofer( @RequestParam("id") Long id){

		ModelMap model = new ModelMap();
		
		Movimiento mov =servicioMovimiento.buscarIdMovimiento(id);
		List<Vehiculo> listVehiculos = servicioVehiculo.listarPorTipoVehiculo(mov.getViaje().getTipoVehiculo());
		model.put("mov", mov);
		model.put("listVehiculos", listVehiculos);
		return new ModelAndView("asignarChofer",model);
	}
	

	@RequestMapping("reportesDeViajes")
	public ModelAndView irAreportesDeViajes(){
		return new ModelAndView("reportesDeViajes");
	}
}
