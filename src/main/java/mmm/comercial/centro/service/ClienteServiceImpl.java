package mmm.comercial.centro.service;

import java.util.List;

import javax.annotation.Resource;

import mmm.comercial.centro.model.ClienteDAOImpl;
import mmm.comercial.centro.pojo.Cliente;
import mmm.comercial.centro.service.interfaces.IClienteService;


public class ClienteServiceImpl implements IClienteService {

	@Resource(name = "clienteDAO")
	private ClienteDAOImpl clienteDAO;

	@Override
	public int create(Cliente c) {
		int codigo = clienteDAO.create(c);
		return codigo;
	}

	@Override
	public Cliente getById(int codigo) {
		Cliente cli = clienteDAO.getById(codigo);
		return cli;
	}
	
	@Override
	public Cliente getByUser(String user) {
		Cliente cli = clienteDAO.getByUser(user);
		return cli;
	}

	@Override
	public Cliente getByRole(String role) {
		Cliente cli = clienteDAO.getByRole(role);
		return cli;
	}

	@Override
	public Cliente getByOnline() {
		Cliente cli = clienteDAO.getByOnline();
		return cli;
	}

	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = null;
		clientes = clienteDAO.getAll();
		return clientes;
	}

	@Override
	public int update(Cliente c) {
		int codigo = clienteDAO.update(c);
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = clienteDAO.delete(codigo);
		return cod;
	}

	@Override
	public void setClienteDAO(ClienteDAOImpl clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

}