package mmm.comercial.centro.service;

import java.util.List;

import javax.annotation.Resource;

import mmm.comercial.centro.model.TiendaDAOImpl;
import mmm.comercial.centro.pojo.Tienda;
import mmm.comercial.centro.service.interfaces.ITiendaService;

public class TiendaServiceImpl implements ITiendaService {

	@Resource(name="tiendaDAO")
	private TiendaDAOImpl tiendaDAO;
	
	
	@Override
	public int create(Tienda tienda) {
		int codigo=tiendaDAO.create(tienda);
		return codigo;
	}

	@Override
	public Tienda getById(int id) {
		Tienda tienda= tiendaDAO.getById(id);
	    return tienda;
	}	

	@Override
	public List<Tienda> getByEstado() {
		List<Tienda> tiendas=null;
		tiendas = tiendaDAO.getByEstado();
		return tiendas;
	}

	@Override
	public List<Tienda> getAll() {
		List<Tienda> tiendas=null;
		tiendas = tiendaDAO.getAll();
		return tiendas;
	}

	@Override
	public int update(Tienda tienda) {
		int codigo=tiendaDAO.update(tienda);
		return codigo;
	}

	@Override
	public int delete(int id) {
		int cod=tiendaDAO.delete(id);
		return cod;
	}

	@Override
	public void setTiendaDAO(TiendaDAOImpl tiendaDAO) {
		this.tiendaDAO =tiendaDAO;
		
	}

}
