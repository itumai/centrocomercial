package mmm.comercial.centro.controller.producto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mmm.comercial.centro.pojo.Empleado;
import mmm.comercial.centro.pojo.Producto;
import mmm.comercial.centro.service.interfaces.IEmpleadoService;
import mmm.comercial.centro.service.interfaces.IProductoService;
import mmm.comercial.centro.service.interfaces.ITiendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NuevoProductoController {
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService prodservice;
	
	@Autowired
	@Qualifier("tiendaService")
	private ITiendaService tiendservice;
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empservice;

	/**
	 * Método para la página principal con el formulario de crear nuevo producto
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/productos/nuevo", method = RequestMethod.GET)
	public ModelAndView displayNuevoProducto(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/producto/nuevo");
		Producto producto = new Producto();
		model.addObject("producto", producto);
		return model;
	}

	/**
	 * Método de registro que redirige a la cuenta de empleados
	 * @param request
	 * @param response
	 * @param producto
	 * @return String
	 */
	@RequestMapping(value = "/productos/nuevo", method = RequestMethod.POST)
	public String executeNuevoProducto(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("producto") Producto producto) {
		String model = null;
		// comprobar quien es el empleado online
		Empleado emp = empservice.getByOnline();
		if(emp!=null) {		
			//saber en que tienda se esta creando un nuevo producto
			int idtienda = empservice.getTiendaByEmpleado(emp.getId());
			
			Producto p = new Producto();
			p.setNombre(producto.getNombre());
			p.setDescripcion(producto.getDescripcion());
			prodservice.createAndUpdateTienda(p, idtienda);
			
			model = "redirect:/empleados/cuenta";
		} else {
			model = "error";	
		}

		return model;

	}
	
}
