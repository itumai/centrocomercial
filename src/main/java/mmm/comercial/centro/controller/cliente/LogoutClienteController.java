package mmm.comercial.centro.controller.cliente;

import mmm.comercial.centro.pojo.Cliente;
import mmm.comercial.centro.service.interfaces.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutClienteController {
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService cliservice;
	
	@RequestMapping(value = "/clientes/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView();
		
		// comprobar quien es el cliente online
		Cliente cli = cliservice.getByOnline();
		if(cli!=null) {
			cli.setOnline(0);
			cliservice.update(cli);	
			mav.setViewName("logout");
		} else {
			mav = new ModelAndView("error");
		}
		return mav;	
	}


}
