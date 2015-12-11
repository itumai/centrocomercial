package mmm.comercial.centro.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mmm.comercial.centro.model.interfaces.ITiendaDAO;
import mmm.comercial.centro.model.mappers.TiendaMapper;
import mmm.comercial.centro.pojo.Tienda;

@Repository("tiendaDAO")
public class TiendaDAOImpl implements ITiendaDAO {

	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public int create(Tienda tienda) {
		int codigo;
		final String SQL = "INSERT INTO tienda (nombre,descripcion,ruta_imagen,tipo,estado,horario_abrir,horario_cerrar) VALUES (?,?,?,?,?,?,?)";
		codigo = jdbctemplate.update(SQL, tienda.getNombre(),tienda.getDescripcion(), tienda.getRuta_imagen(), tienda.getTipo(), tienda.getEstado(),tienda.getHorario_abrir(), tienda.getHorario_cerrar());
		return codigo;
	}

	@Override
	public Tienda getById(int codigo) {
		Tienda tienda = null;

		final String SQL = "SELECT id,nombre,descripcion,ruta_imagen,tipo,estado,horario_abrir,horario_cerrar FROM tienda WHERE id=?";
		try {
			tienda = jdbctemplate.queryForObject(SQL, new Object[] { codigo }, new TiendaMapper());
		} catch (EmptyResultDataAccessException e) {
			tienda = null;
		}

		return tienda;
	}	

	@Override
	public List<Tienda> getByEstado() {
		List<Tienda> tiendas = null;
		int estado = 1;
		final String SQL = "SELECT id,nombre,descripcion,ruta_imagen,tipo,estado,horario_abrir,horario_cerrar FROM tienda WHERE estado=?";
		try {
			tiendas = jdbctemplate.query(SQL, new Object[] { estado }, new TiendaMapper());
		} catch (EmptyResultDataAccessException e) {
			tiendas = null;
		}
		return tiendas;
	}

	@Override
	public List<Tienda> getAll() {
		List<Tienda> tiendas = null;

		final String SQL = "SELECT id,nombre,descripcion,ruta_imagen,tipo,estado,horario_abrir,horario_cerrar FROM tienda";
		try {
			tiendas = jdbctemplate.query(SQL, new TiendaMapper());
		} catch (EmptyResultDataAccessException e) {
			tiendas = null;
		}
		return tiendas;
	}

	@Override
	public int update(Tienda tienda) {
		int codigo = -1;
		final String SQL = "UPDATE tienda SET nombre=?,descripcion=?,ruta_imagen=?,tipo=?,estado=?,horario_abrir=?,horario_cerrar=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, tienda.getNombre(),tienda.getDescripcion(),tienda.getRuta_imagen(), tienda.getTipo(), tienda.getEstado(),	tienda.getHorario_abrir(), tienda.getHorario_cerrar(), tienda.getId());
		return codigo;
	}

	@Override
	public int delete(int codigo) {
		int cod = -1;
		final String SQL = "DELETE FROM tienda WHERE id=?";
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
