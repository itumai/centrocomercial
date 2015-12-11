package mmm.comercial.centro.model.interfaces;

import java.util.List;

import javax.sql.DataSource;

import mmm.comercial.centro.pojo.Cliente;

public interface IClienteDAO {	
	
	public int create(Cliente c);
	
	public Cliente getById(int codigo);
	
	public Cliente getByUser(String user);
	
	public Cliente getByRole(String role);
	
	public Cliente getByOnline();
	
	public List<Cliente> getAll();
	
	public int update(Cliente c);
	
	public int delete(int codigo);
	
	public void setDatasource(DataSource datasource);

}

