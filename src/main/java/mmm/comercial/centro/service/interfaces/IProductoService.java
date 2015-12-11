package mmm.comercial.centro.service.interfaces;

import java.util.List;

import mmm.comercial.centro.model.ProductoDAOImpl;
import mmm.comercial.centro.pojo.Producto;

public interface IProductoService {
	
	public int create(Producto prod);
	
	public int createAndUpdateTienda(Producto prod, int idtienda);
	
	public Producto getById(int codigo);
	
	public List<Producto> getByCliente(int cliente);
	
	public List<Producto> getByTienda(int tienda);
	
	public List<Producto> getAll();
	
	public int update(Producto prod);
	
	public int updateClienteList(int idprod, int idcliente);
	
	public int updateTiendaList(int idprod, int idtienda);
	
	public int delete(int codigo);
	
	public List<Producto> getAllJoinTienda(int idtienda);
	
	public void setProductoDAO(ProductoDAOImpl productoDAO);

}
