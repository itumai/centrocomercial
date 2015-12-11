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
public class RegistroEmpleadoController {
	
	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empservice;
	
	@Autowired
	@Qualifier("administradorService")
	private IAdministradorService admservice;

	/**
	 * Método para la página principal con el registro de empleado
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	@RequestMapping(value = "/registroempleado", method = RequestMethod.GET)
	public ModelAndView displayRegistroEmpleado(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("/empleado/registro");
		Empleado empleado = new Empleado();
		model.addObject("empleado", empleado);
		return model;
	}

	/**
	 * Método de registro que redirige a la página de clientes
	 * @param request
	 * @param response
	 * @param empleado
	 * @return String
	 */
	@RequestMapping(value = "/registroempleado", method = RequestMethod.POST)
	public String executeRegistroEmpleado(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("empleado") Empleado empleado) {
		String model = null;
		//comprobar quien esta online
		Empleado empl = empservice.getByOnline();
		if(empl==null) {
			//comprobar que el nuevo empleado no este repetido
			Empleado e = empservice.getByUser(empleado.getUser());
			if(e==null) {
				//guardar en la bd el nuevo empleado
				Empleado emp = new Empleado();			
				emp.setUser(empleado.getUser());
				emp.setPass(empleado.getPass());
				emp.setNombre(empleado.getNombre());
				emp.setApellidos(empleado.getApellidos());
				//incluir numero aleatorio para la tienda de empleado
				int idtienda = (int) Math.floor(Math.random()*(1-7+1)+7);
				empservice.createAndUpdateTienda(emp, idtienda);
				Administrador adm = new Administrador();
				adm.setUser(empleado.getUser());
				adm.setPass(empleado.getPass());
				adm.setRole("EMP");
				admservice.create(adm);

				model = "redirect:empleados";			
			} else {
				model = "error";
			}
		} else {
			model = "error2empleado";
		}
		

		return model;
	}

}
