package mmm.comercial.centro.controller.producto;

import java.util.List;

import mmm.comercial.centro.pojo.Producto;
import mmm.comercial.centro.service.interfaces.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductoController  {

	@Autowired
	@Qualifier ("productoService")
	private IProductoService prodservice;
	
	/**
	 * Método que, desde la parte empleados, te lleva a los productos seleccionados para modificarlos
	 * @return ModelAndView
	 */
	@RequestMapping(value ="/productos", method = RequestMethod.GET)	
	protected ModelAndView pcontroller() {
		ModelAndView prod= new ModelAndView();
		List<Producto> productos = prodservice.getAll();
		prod.addObject("lista_productos",productos);
		prod.setViewName("/producto/index");
		return prod;
	}

}