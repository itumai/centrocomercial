package mmm.comercial.centro.controller.tienda;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mmm.comercial.centro.pojo.Empleado;
import mmm.comercial.centro.pojo.Tienda;

import mmm.comercial.centro.service.interfaces.IEmpleadoService;
import mmm.comercial.centro.service.interfaces.ITiendaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModificarTiendaController {
	
	@Autowired
	@Qualifier("tiendaService")
	private ITiendaService tieservice;

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empservice;
	/**
	 * Método para la página principal con el formulario de modificar los datos de la tienda
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/tiendas/modificar", method = RequestMethod.GET)
	public ModelAndView displayModificarCliente(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/tienda/modificar");
		Tienda tienda = new Tienda();
		model.addObject("tienda", tienda);
		Empleado e = empservice.getByOnline();
		int idt = empservice.getTiendaByEmpleado(e.getId());
		Tienda tien = tieservice.getById(idt);
		model.addObject("tien", tien);
		return model;
	}

	/**
	 * Método de registro que redirige a la cuenta de empleados
	 * @param request
	 * @param response
	 * @param tienda
	 * @return String
	 */
	@RequestMapping(value = "/tiendas/modificar", method = RequestMethod.POST)
	public String executeModificarCliente(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("tienda") Tienda tienda) {
		String model = null;
		// comprobar quien es el empleado online
		Empleado emp =empservice.getByOnline();
		if(emp!=null) {		
			//guardar en la bd la nueva tienda actualizada				
			int t = empservice.getTiendaByEmpleado(emp.getId());
			Tienda tie = tieservice.getById(t);
			tie.setNombre(tienda.getNombre());
			tie.setDescripcion(tienda.getDescripcion());
			tie.setTipo(tienda.getTipo());		
			tie.setHorario_abrir(tienda.getHorario_abrir());
			tie.setHorario_cerrar(tienda.getHorario_cerrar());			
			tieservice.update(tie);
			
			model = "redirect:/empleados/cuenta";		
		} else {
			model = "error";	
		}

		return model;
	}
	
}
