package mmm.comercial.centro.controller.empleado;

import java.util.List;

import mmm.comercial.centro.pojo.Empleado;
import mmm.comercial.centro.pojo.Producto;
import mmm.comercial.centro.pojo.Tienda;
import mmm.comercial.centro.service.interfaces.IEmpleadoService;
import mmm.comercial.centro.service.interfaces.IProductoService;
import mmm.comercial.centro.service.interfaces.ITiendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpleadoController  {

	@Autowired
	@Qualifier ("empleadoService")
	private IEmpleadoService empservice;
	
	@Autowired
	@Qualifier ("productoService")
	private IProductoService prodservice;
	
	@Autowired
	@Qualifier ("tiendaService")
	private ITiendaService tiendservice;
	
	/**
	 * Método que te lleva a la pagina principal de empleados en la que se muestran todos sus datos
	 * @return ModelAndView
	 */	
	@RequestMapping(value = {"/empleados","/empleados/cuenta"}, method = RequestMethod.GET)
	public ModelAndView cuenta() {		
		ModelAndView prod= new ModelAndView();
		
		// comprobar quien es el empleado online
		Empleado emp = empservice.getByOnline();
		if(emp!=null) {
			// mirar a que tienda corresponde ese empleado
			int idtienda = empservice.getTiendaByEmpleado(emp.getId());
			Tienda t = tiendservice.getById(idtienda);
			
			//sacar la lista de productos de la tienda del empleado online
			List<Producto> productos = prodservice.getByTienda(idtienda);
			
			prodservice.updateTiendaList(248,idtienda);
		
			prod.addObject("lista_productos",productos);
			prod.addObject("empleado",emp);
			prod.addObject("tienda", t);		
			prod.setViewName("/empleado/cuenta");
		} else {
			prod = new ModelAndView("error");
		}	
		
		return prod;
	}
	
}
