package mmm.comercial.centro.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mmm.comercial.centro.model.interfaces.IProductoDAO;
import mmm.comercial.centro.model.mappers.ProductoMapper;
import mmm.comercial.centro.pojo.Producto;

@Repository("productoDAO")
public class ProductoDAOImpl implements IProductoDAO {

	private JdbcTemplate jdbctemplate;

	@Resource(name = "myDataSource")
	private DataSource datasource;

	@Override
	public int create(Producto prod) {
		int codigo;
		final String SQL = "INSERT INTO producto(nombre,descripcion,ruta_imagen,disponible) VALUES (?,?,?,?)";
		codigo = jdbctemplate.update(SQL, prod.getNombre(), prod.getDescripcion(), prod.getRuta_imagen(), prod.getDisponible());
		return codigo;
	}
	

	@Override
	public int createAndUpdateTienda(Producto prod, int idtienda) {
		int codigo;
		final String SQL = "INSERT INTO producto(nombre,descripcion,ruta_imagen,disponible,tienda) VALUES (?,?,?,?,?)";
		codigo = jdbctemplate.update(SQL, prod.getNombre(), prod.getDescripcion(), prod.getRuta_imagen(), prod.getDisponible(), idtienda);
		return codigo;
	}

	@Override
	public Producto getById(int id) {
		Producto prod = null;

		final String SQL = "SELECT id,nombre,descripcion,ruta_imagen,disponible,cliente,tienda FROM producto WHERE id=?";
		try {
			prod = jdbctemplate.queryForObject(SQL, new Object[] { id },
					new ProductoMapper());
		} catch (EmptyResultDataAccessException e) {
			prod = null;
		}

		return prod;
	}	

	@Override
	public List<Producto> getByCliente(int cliente) {
		List<Producto> productos = null;

		final String SQL = "SELECT id,nombre,descripcion,ruta_imagen,disponible FROM producto WHERE cliente=?";
		try {
			productos = jdbctemplate.query(SQL, new Object[] { cliente }, new ProductoMapper());
		} catch (EmptyResultDataAccessException e) {
			productos = null;

		}
		return productos;
	}

	@Override
	public List<Producto> getByTienda(int tienda) {
		List<Producto> productos = null;

		final String SQL = "SELECT id,nombre,descripcion,ruta_imagen,disponible FROM producto WHERE tienda=?";
		try {
			productos = jdbctemplate.query(SQL, new Object[] { tienda }, new ProductoMapper());
		} catch (EmptyResultDataAccessException e) {
			productos = null;

		}
		return productos;
	}

	@Override
	public List<Producto> getAll() {
		List<Producto> productos = null;

		final String SQL = "SELECT id,nombre,descripcion,ruta_imagen,disponible FROM producto";
		try {
			productos = jdbctemplate.query(SQL, new ProductoMapper());
		} catch (EmptyResultDataAccessException e) {
			productos = null;

		}
		return productos;
	}

	@Override
	public int update(Producto prod) {
		int codigo = -1;

		final String SQL = "UPDATE producto SET nombre=?,descripcion=?,ruta_imagen=?,disponible=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, prod.getNombre(), prod.getDescripcion(), prod.getRuta_imagen(), prod.getDisponible(), prod.getId());
		return codigo;
	}
	
	@Override
	public int updateClienteList(int idprod, int idcliente) {
		int codigo = -1;
		final String SQL = "UPDATE producto SET cliente=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, idcliente, idprod);
		return codigo;
	}
	
	@Override
	public int updateTiendaList(int idprod, int idtienda) {
		int codigo = -1;
		final String SQL = "UPDATE producto SET tienda=? WHERE id=?";
		codigo = jdbctemplate.update(SQL, idtienda, idprod);
		return codigo;
	}

	@Override
	public int delete(int id) {
		int cod = -1;
		final String SQL = "DELETE FROM producto WHERE id=?";
		cod = jdbctemplate.update(SQL, id);
		return cod;
	}	

	@Override
	public List<Producto> getAllJoinTienda(int idtienda) {
		List<Producto> productos = null;

		final String SQL = "SELECT producto.id, producto.descripcion, producto.ruta_imagen, producto.disponible, tienda.nombre FROM producto INNER JOIN tienda ON producto.tienda=?";
		try {
			productos = jdbctemplate.query(SQL, new Object[] { idtienda }, new ProductoMapper());
		} catch (EmptyResultDataAccessException e) {
			productos = null;
		}
		return productos;
	}

	@Resource(name="myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource=datasource;
		jdbctemplate=new JdbcTemplate(datasource);

	}
	
}
