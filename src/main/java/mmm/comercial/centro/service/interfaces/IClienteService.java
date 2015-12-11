package mmm.comercial.centro.service.interfaces;

import java.util.List;

import mmm.comercial.centro.model.ClienteDAOImpl;
import mmm.comercial.centro.pojo.Cliente;


public interface IClienteService {

	public int create(Cliente c);

	public Cliente getById(int codigo);
	
	public Cliente getByUser(String user);
	
	public Cliente getByRole(String role);
	
	public Cliente getByOnline();

	public List<Cliente> getAll();
	
	public int update(Cliente c);
	
	public int delete(int codigo);
	
	public void setClienteDAO(ClienteDAOImpl clienteDAO);


}
