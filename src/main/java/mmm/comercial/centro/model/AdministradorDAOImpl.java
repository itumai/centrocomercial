package mmm.comercial.centro.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mmm.comercial.centro.model.interfaces.IAdministradorDAO;
import mmm.comercial.centro.model.mappers.AdministradorMapper;
import mmm.comercial.centro.pojo.Administrador;

@Repository("administradorDAO")
public class AdministradorDAOImpl implements IAdministradorDAO {

	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public int create(Administrador a) {
		int codigo = -1;
		final String SQL = "INSERT INTO administrador(user,pass,role) VALUES (?,?,?)";
		codigo = jdbctemplate.update(SQL, a.getUser(), a.getPass(), a.getRole());
		return codigo;
	}
	
	@Override
	public Administrador getById(int id) {
		Administrador admin = null;
		final String SQL = "SELECT id,user,pass,role FROM administrador WHERE id=?";

		try {
			admin = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new AdministradorMapper());

		} catch (EmptyResultDataAccessException e) {
			admin = null;
		}

		return admin;
	}
	
	@Override
	public Administrador getByUser(String user) {
		Administrador admin = null;
		final String SQL = "SELECT id,user,pass,role FROM administrador WHERE user=?";

		try {
			admin = jdbctemplate.queryForObject(SQL, new Object[] { user },
					new AdministradorMapper());

		} catch (EmptyResultDataAccessException e) {
			admin = null;
		}

		return admin;
	}

	@Override
	public List<Administrador> getAll() {
		List<Administrador> administradores = null;

		final String SQL = "SELECT id,user,pass,role FROM administrador";

		try {
			administradores = jdbctemplate
					.query(SQL, new AdministradorMapper());
		} catch (EmptyResultDataAccessException e) {
			administradores = null;

		}
		return administradores;
	}
	
	@Override
	public int update(Administrador a) {
		int codigo = -1;
		final String SQL = "UPDATE administrador SET user=?,pass=?,role=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, a.getUser(), a.getPass(), a.getRole(), a.getId());
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = -1;
		final String SQL = "DELETE FROM administrador WHERE id=?";
		cod = jdbctemplate.update(SQL, codigo);
		return cod;
	}

	@Resource(name = "myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
		jdbctemplate = new JdbcTemplate(datasource);

	}


	
}
