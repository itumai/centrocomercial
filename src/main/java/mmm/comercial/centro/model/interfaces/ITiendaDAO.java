package mmm.comercial.centro.model.interfaces;

import java.util.List;

import javax.sql.DataSource;

import mmm.comercial.centro.pojo.Tienda;

public interface ITiendaDAO {
	
	public int create(Tienda tienda);
	
	public Tienda getById(int codigo);
	
	public List<Tienda> getByEstado();
	
	public List<Tienda> getAll();
	
	public int update(Tienda tienda);
	
	public int delete(int codigo);

	public void setDatasource(DataSource datasource);


}
