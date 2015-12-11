package mmm.comercial.centro.controller.tienda;

import java.util.List;

import mmm.comercial.centro.pojo.Producto;
import mmm.comercial.centro.pojo.Tienda;
import mmm.comercial.centro.service.interfaces.IProductoService;
import mmm.comercial.centro.service.interfaces.ITiendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TiendaController  {

	@Autowired
	@Qualifier ("tiendaService")
	private ITiendaService tiendservice;
	
	@Autowired
	@Qualifier ("productoService")
	private IProductoService prodservice;	
	
	/**
	 * Método que, desde el cliente, puedes ver toda la lista de los productos de la tienda seleccionada
	 * @return ModelAndView
	 */	
	@RequestMapping(value ="/tiendas/{tipo}/{id}", method = RequestMethod.GET)
	protected ModelAndView tcontroller(@PathVariable(value = "tipo") String tipo, @PathVariable(value = "id") int id) {
		ModelAndView prod= new ModelAndView();
		Tienda t = tiendservice.getById(id);
		List<Producto> productos = prodservice.getByTienda(id);
		prod.addObject("lista_productos",productos);
		prod.addObject("nombre_tienda",t.getNombre());
		prod.addObject("tipo_tienda",tipo);
		prod.setViewName("/tienda/index");
		return prod;
	}
	

}
