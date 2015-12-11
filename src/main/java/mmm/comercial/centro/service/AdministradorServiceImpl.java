package mmm.comercial.centro.service;

import java.util.List;

import javax.annotation.Resource;

import mmm.comercial.centro.model.AdministradorDAOImpl;
import mmm.comercial.centro.pojo.Administrador;
import mmm.comercial.centro.service.interfaces.IAdministradorService;

public class AdministradorServiceImpl implements IAdministradorService {

	@Resource(name="administradorDAO")
	private AdministradorDAOImpl administradorDAO;

	@Override
	public int create(Administrador a) {
		int codigo = administradorDAO.create(a);
		return codigo;
	}	
	
	@Override
	public Administrador getById(int id) {
		Administrador admin = administradorDAO.getById(id);
	    return admin;
	  }
	
	@Override
	public Administrador getByUser(String user) {
		Administrador admin = administradorDAO.getByUser(user);
		return admin;
	}

	@Override
	public List<Administrador> getAll() {
		List<Administrador> administradores=null;
		administradores = administradorDAO.getAll();
		return administradores;
	}	

	@Override
	public int update(Administrador a) {
		int codigo = administradorDAO.update(a);
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = administradorDAO.delete(codigo);
		return cod;
	}
	
	@Override
	public void setAdministradorDAO(AdministradorDAOImpl administradorDAO) {
		this.administradorDAO = administradorDAO;		
	}


}
