package mmm.comercial.centro.controller.empleado;

import mmm.comercial.centro.pojo.Empleado;
import mmm.comercial.centro.service.interfaces.IEmpleadoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutEmpleadoController {

	@Autowired
	@Qualifier("empleadoService")
	private IEmpleadoService empservice;
	
	@RequestMapping(value = "/empleados/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView();
		
		// comprobar quien es el empleado online
		Empleado emp = empservice.getByOnline();
		if(emp!=null) {
			emp.setOnline(0);
			empservice.update(emp);	
			mav.setViewName("logout");
		} else {
			mav = new ModelAndView("error");
		}
		return mav;
	}

}
