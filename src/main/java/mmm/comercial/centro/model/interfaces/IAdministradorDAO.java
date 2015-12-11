package mmm.comercial.centro.model.interfaces;

import java.util.List;

import javax.sql.DataSource;

import mmm.comercial.centro.pojo.Administrador;

public interface IAdministradorDAO {
	
	public int create(Administrador a);
	
	public Administrador getById(int codigo);
	
	public Administrador getByUser(String user);
	
	public List<Administrador> getAll();

	public int update(Administrador a);
	
	public int delete(int codigo);

	public void setDatasource(DataSource datasource);

}
