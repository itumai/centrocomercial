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
public class RegistroClienteController {

	@Autowired
	@Qualifier("clienteService")
	private IClienteService cliservice;
	
	@Autowired
	@Qualifier("administradorService")
	private IAdministradorService admservice;

	/**
	 * Método para la página principal con el registro de cliente
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/registrocliente", method = RequestMethod.GET)
	public ModelAndView displayRegistroCliente(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/cliente/registro");
		Cliente cliente = new Cliente();
		model.addObject("cliente", cliente);
		return model;
	}

	/**
	 * Método de registro que redirige a la página de clientes
	 * @param request
	 * @param response
	 * @param administrador
	 * @return String
	 */
	@RequestMapping(value = "/registrocliente", method = RequestMethod.POST)
	public String executeRegistroCliente(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("cliente") Cliente cliente) {
		String model = null;
		//comprobar quien esta online
		Cliente cl = cliservice.getByOnline();
		if(cl==null) {
			//comprobar que el nuevo cliente no este repetido
			Cliente c = cliservice.getByUser(cliente.getUser());
			if(c==null) {
				//guardar en la bd el nuevo cliente
				Cliente cli = new Cliente();			
				cli.setUser(cliente.getUser());
				cli.setPass(cliente.getPass());
				cli.setNombre(cliente.getNombre());
				cli.setApellidos(cliente.getApellidos());
				cliservice.create(cli);
				Administrador adm = new Administrador();
				adm.setUser(cliente.getUser());
				adm.setPass(cliente.getPass());
				adm.setRole("CLI");
				admservice.create(adm);
				model = "redirect:clientes";		
			} else {
				model = "error";	
			}
		} else {
			model = "error2cliente";	
		}
		
		request.setAttribute("adminuser", cliente.getUser());
		request.setAttribute("adminpass", cliente.getPass());
		request.setAttribute("nombre", cliente.getNombre());
		request.setAttribute("apellidos", cliente.getApellidos());
		return model;
	}

}
