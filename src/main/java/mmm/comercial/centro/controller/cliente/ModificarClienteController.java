package mmm.comercial.centro.controller.cliente;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mmm.comercial.centro.pojo.Administrador;
import mmm.comercial.centro.pojo.Cliente;
import mmm.comercial.centro.service.interfaces.IAdministradorService;
import mmm.comercial.centro.service.interfaces.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModificarClienteController {
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService cliservice;
	
	@Autowired
	@Qualifier("administradorService")
	private IAdministradorService admservice;

	/**
	 * Método para la página principal con el formulario de modificar cliente
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/clientes/modificar", method = RequestMethod.GET)
	public ModelAndView displayModificarCliente(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/cliente/modificar");
		Cliente cliente = new Cliente();
		model.addObject("cliente", cliente);
		Cliente client = cliservice.getByOnline();
		model.addObject("client", client);
		return model;
	}

	/**
	 * Método de registro que redirige a la cuenta de clientes
	 * @param request
	 * @param response
	 * @param cliente
	 * @return String
	 */
	@RequestMapping(value = "/clientes/modificar", method = RequestMethod.POST)
	public String executeModificarCliente(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("cliente") Cliente cliente) {
		String model = null;
		// comprobar quien es el cliente online
		Cliente cli = cliservice.getByOnline();
		if(cli!=null) {	
			//buscar el administrador correspondiente al cliente que se va a modificar
			Administrador adm = admservice.getByUser(cli.getUser());			
			//actualizar la bd con el nuevo cliente	(comprobando si la pass es vacia o no)			
			if(cliente.getPass().equals("")) {	
				cli.setUser(cliente.getUser());
				adm.setUser(cliente.getUser());
				cli.setNombre(cliente.getNombre());
				cli.setApellidos(cliente.getApellidos());				
			} else {
				cli.setUser(cliente.getUser());
				cli.setPass(cliente.getPass());
				adm.setPass(cliente.getPass());
				cli.setNombre(cliente.getNombre());
				cli.setApellidos(cliente.getApellidos());
			}	
			cliservice.update(cli);		
			//actualizar los datos del administrador	
			admservice.update(adm);
			model = "redirect:/clientes/cuenta";		
		} else {
			model = "error";	
		}

		return model;
	}
	
}
