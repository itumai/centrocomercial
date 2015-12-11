package mmm.comercial.centro.controller.cliente;

import mmm.comercial.centro.pojo.Administrador;
import mmm.comercial.centro.pojo.Cliente;
import mmm.comercial.centro.service.interfaces.IAdministradorService;
import mmm.comercial.centro.service.interfaces.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BorrarClienteController {

	@Autowired
	@Qualifier("clienteService")
	private IClienteService cliservice;
	
	@Autowired
	@Qualifier("administradorService")
	private IAdministradorService adminservice;

	/**
	 * Método de registro que redirige a la cuenta de clientes
	 * @param request
	 * @param response
	 * @param cliente
	 * @return String
	 */
	@RequestMapping(value = "/clientes/borrar", method = RequestMethod.GET)
	public String executeBorrarCliente() {
		String model = null;
		// comprobar quien es el cliente online
		Cliente cli = cliservice.getByOnline();
		if(cli!=null) {	
			cliservice.delete(cli.getId());
			Administrador a = adminservice.getByUser(cli.getUser());
			adminservice.delete(a.getId());			
			model = "redirect:/home";		
		} else {
			model = "error";	
		}

		return model;
	}
	
}
