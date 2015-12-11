package mmm.comercial.centro.controller.cliente;

import java.util.List;

import mmm.comercial.centro.pojo.Cliente;
import mmm.comercial.centro.pojo.Producto;
import mmm.comercial.centro.service.interfaces.IClienteService;
import mmm.comercial.centro.service.interfaces.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CuentaClienteProductoListController {

	@Autowired
	@Qualifier("clienteService")
	private IClienteService cliservice;
	
	@Autowired
	@Qualifier ("productoService")
	private IProductoService prodservice;
	
	/**
	 * Método que recoge el producto seleccionado en la parte de tiendas y lo añade a la lista
	 * @param id
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/clientes/cuenta/{id}", method = RequestMethod.GET)
	public ModelAndView cuentanuevoproductolista(@PathVariable(value = "id") int id) {		
		ModelAndView mav= new ModelAndView();
		
		// comprobar quien es el cliente online
		Cliente cli = cliservice.getByOnline();
		if(cli!=null) {

			// añadir el producto seleccionado a la lista de productos del cliente	
			prodservice.updateClienteList(id, cli.getId());

			//sacar la nueva lista de productos del cliente online
			List<Producto> productos = prodservice.getByCliente(cli.getId());
		
			Producto pro = prodservice.getById(id);
			String nuevoprod = "NUEVO. Se ha añadido " + pro.getNombre() + " a la lista.";
			mav.addObject("nuevo",nuevoprod);
			mav.addObject("lista_productos",productos);
			mav.addObject("cliente",cli);
			mav.setViewName("/cliente/cuenta");
		} else {
			mav = new ModelAndView("error");
		}	
		
		return mav;
	}

}
