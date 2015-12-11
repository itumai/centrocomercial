package mmm.comercial.centro.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import mmm.comercial.centro.pojo.Producto;

import org.springframework.jdbc.core.RowMapper;

public class ProductoMapper implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int column) throws SQLException {
		Producto p = new Producto();
	    p.setId(rs.getInt("id"));
	    p.setNombre(rs.getString("nombre"));
	    p.setDescripcion(rs.getString("descripcion"));
	    p.setRuta_imagen(rs.getString("ruta_imagen"));
	    p.setDisponible(rs.getInt("disponible"));
	    return p;
	}
	
}
