package mmm.comercial.centro.controller.producto;

import mmm.comercial.centro.service.interfaces.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreadoNuevoProductoController {

	@Autowired
	@Qualifier ("productoService")
	private IProductoService prodservice;
	
	/**
	 * Método que, desde la parte empleados, te lleva a los productos seleccionados para modificarlos
	 * @return ModelAndView
	 */
	@RequestMapping(value ="/productos/nuevocreado/{idprod}/{idtienda}", method = RequestMethod.GET)	
	protected ModelAndView pcontroller(@PathVariable(value = "idprod") int idprod, @PathVariable(value = "idtienda") int idtienda) {
		ModelAndView prod= new ModelAndView();

		prodservice.updateTiendaList(idprod,idtienda);
		System.out.println("sdfhdsfh");
		prod.setViewName("/producto/nuevocreado");
		return prod;
	}
}
