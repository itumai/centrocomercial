package mmm.comercial.centro.service.interfaces;

import java.util.List;

import mmm.comercial.centro.model.TiendaDAOImpl;
import mmm.comercial.centro.pojo.Tienda;

public interface ITiendaService {
	
	public int create(Tienda tienda);
	
	public Tienda getById(int codigo);
	
	public List<Tienda> getByEstado();
	
	public List<Tienda> getAll();
	
	public int update(Tienda tienda);
	
	public int delete(int codigo);
	
	public void setTiendaDAO(TiendaDAOImpl tiendaDAO);

}
