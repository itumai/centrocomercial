package mmm.comercial.centro.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mmm.comercial.centro.model.interfaces.IClienteDAO;
import mmm.comercial.centro.model.mappers.ClienteMapper;
import mmm.comercial.centro.pojo.Cliente;


@Repository("clienteDAO")
public class ClienteDAOImpl implements IClienteDAO {

	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public int create(Cliente c) {
		int codigo = -1;
		final String SQL = "INSERT INTO cliente(user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role) VALUES (?,?,?,?,?,?,?,?)";
		codigo = jdbctemplate.update(SQL, c.getUser(), c.getPass(), c.getNombre(),
				c.getApellidos(), c.getRuta_imagen(), c.getOnline(), c.getHora_conexion(),
				c.getRole());
		return codigo;
	}

	@Override
	public Cliente getById(final int codigo) {
		Cliente c = null;
		final String SQL = "SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM cliente WHERE id=?";
		try {
			c = jdbctemplate.queryForObject(SQL, new Object[] { codigo },
					new ClienteMapper());
		} catch (EmptyResultDataAccessException e) {
			c = null;
		}
		return c;
	}
	
	@Override
	public Cliente getByUser(String user) {
		Cliente c = null;
		final String SQL = "SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM cliente WHERE user=?";
		try {
			c = jdbctemplate.queryForObject(SQL, new Object[] { user },
					new ClienteMapper());
		} catch (EmptyResultDataAccessException e) {
			c = null;
		}
		return c;
	}

	@Override
	public Cliente getByRole(String role) {
		Cliente c = null;
		final String SQL = "SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM cliente WHERE role=?";
		try {
			c = jdbctemplate.queryForObject(SQL, new Object[] { role },
					new ClienteMapper());
		} catch (EmptyResultDataAccessException e) {
			c = null;
		}
		return c;
	}

	@Override
	public Cliente getByOnline() {
		Cliente c = null;
		int online = 1;
		final String SQL = "SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM cliente WHERE online=?";
		try {
			c = jdbctemplate.queryForObject(SQL, new Object[] { online },
					new ClienteMapper());
		} catch (EmptyResultDataAccessException e) {
			c = null;
		}
		return c;
	}

	@Override
	public List<Cliente> getAll() {
		List<Cliente> clientes = null;
		final String SQL = "SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM cliente";
		try {
			clientes = jdbctemplate.query(SQL, new ClienteMapper());
		} catch (EmptyResultDataAccessException e) {
			clientes = null;
		}
		return clientes;
	}

	@Override
	public int update(Cliente c) {
		int codigo = -1;
		final String SQL = "UPDATE cliente SET user=?,pass=?,nombre=?,apellidos=?,ruta_imagen=?,online=?,hora_conexion=?,role=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, c.getUser(), c.getPass(),
				c.getNombre(), c.getApellidos(), c.getRuta_imagen(),
				c.getOnline(), c.getHora_conexion(), c.getRole(), c.getId());
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = -1;
		final String SQL = "DELETE FROM cliente WHERE id=?";
		cod = jdbctemplate.update(SQL, codigo);
		return cod;
	}

	@Resource(name="myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource=datasource;
		jdbctemplate=new JdbcTemplate(datasource);

	}


}