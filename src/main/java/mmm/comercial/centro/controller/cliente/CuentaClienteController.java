package mmm.comercial.centro.controller.cliente;

import java.util.List;

import mmm.comercial.centro.pojo.Cliente;
import mmm.comercial.centro.pojo.Producto;
import mmm.comercial.centro.service.interfaces.IClienteService;
import mmm.comercial.centro.service.interfaces.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CuentaClienteController {
	
	@Autowired
	@Qualifier("clienteService")
	private IClienteService cliservice;
	
	@Autowired
	@Qualifier ("productoService")
	private IProductoService prodservice;
	
	/**
	 * Método que se accede desde el menú que lleva a la cuenta personal del cliente
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/clientes/cuenta", method = RequestMethod.GET)
	public ModelAndView cuenta() {		
		ModelAndView prod= new ModelAndView();
		
		// comprobar quien es el cliente online
		Cliente cli = cliservice.getByOnline();
		if(cli!=null) {
			//sacar la lista de productos del cliente online
			List<Producto> productos = prodservice.getByCliente(cli.getId());		
			prod.addObject("lista_productos",productos);
			prod.addObject("cliente",cli);
			prod.setViewName("/cliente/cuenta");
		} else {
			prod = new ModelAndView("error");
		}	
		
		return prod;
	}

}
