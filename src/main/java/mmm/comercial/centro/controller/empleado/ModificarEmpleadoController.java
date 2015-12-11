package mmm.comercial.centro.controller.empleado;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mmm.comercial.centro.pojo.Administrador;
import mmm.comercial.centro.pojo.Empleado;
import mmm.comercial.centro.service.interfaces.IAdministradorService;
import mmm.comercial.centro.service.interfaces.IEmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModificarEmpleadoController {
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empservice;
	
	@Autowired
	@Qualifier("administradorService")
	private IAdministradorService admservice;

	/**
	 * Método para la página principal con el formulario de modificar empleado
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/empleados/modificar", method = RequestMethod.GET)
	public ModelAndView displayModificarEmpleado(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/empleado/modificar");
		Empleado empleado = new Empleado();
		model.addObject("empleado", empleado);
		Empleado empl = empservice.getByOnline();
		model.addObject("emple", empl);
		return model;
	}

	/**
	 * Método de registro que redirige a la cuenta de empleados
	 * @param request
	 * @param response
	 * @param empleado
	 * @return String
	 */
	@RequestMapping(value = "/empleados/modificar", method = RequestMethod.POST)
	public String executeModificarEmpleado(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("empleado") Empleado empleado) {
		String model = null;
		// comprobar quien es el empleado online
		Empleado emp = empservice.getByOnline();
		if(emp!=null) {		
			//buscar el administrador correspondiente al empelado que se va a modificar
			Administrador adm = admservice.getByUser(emp.getUser());			
			//actualizar la bd con el nuevo empleado (comprobando si la pass es vacia o no)					
			if(empleado.getPass().equals("")) {	
				emp.setUser(empleado.getUser());
				adm.setUser(empleado.getUser());
				emp.setNombre(empleado.getNombre());
				emp.setApellidos(empleado.getApellidos());					
			} else {
				emp.setUser(empleado.getUser());
				emp.setPass(empleado.getPass());
				adm.setPass(empleado.getPass());
				emp.setNombre(empleado.getNombre());
				emp.setApellidos(empleado.getApellidos());
			}
			empservice.update(emp);
			//actualizar los datos del administrador		
			admservice.update(adm);
			model = "redirect:/empleados/cuenta";		
		} else {
			model = "error";	
		}

		return model;
	}
	

}
