package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cliente;
import ar.edu.unlam.tallerweb1.servicios.ServicioCliente;

@Controller
public class ClienteController {

    @Inject
    private ServicioCliente servicioCliente;

    @RequestMapping(path = "/Cliente/create", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelMap model = new ModelMap();
        model.put("cliente", new Cliente());
        return new ModelAndView("/Cliente/create", model);
    }

    @RequestMapping(path = "/cliente", method = RequestMethod.POST)
    public String store(@ModelAttribute("cliente") Cliente cliente) {
    	servicioCliente.save(cliente);
        return "redirect:/clientes";
    }

    /*
    @RequestMapping("/clientes")
    public ModelAndView clientes(){
        ModelMap model = new ModelMap();
        model.put("records",servicioCliente.list());
        return new ModelAndView("/Cliente/lista", model);
    }
    */
    
}