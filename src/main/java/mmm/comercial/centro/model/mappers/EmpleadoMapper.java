package mmm.comercial.centro.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import mmm.comercial.centro.pojo.Empleado;

import org.springframework.jdbc.core.RowMapper;

public class EmpleadoMapper implements RowMapper<Empleado> {

	@Override
	public Empleado mapRow(ResultSet rs, int column) throws SQLException {
		Empleado e = new Empleado();
	    e.setId(rs.getInt("id"));
	    e.setUser(rs.getString("user"));
	    e.setPass(rs.getString("pass"));
	    e.setNombre(rs.getString("nombre"));
	    e.setApellidos(rs.getString("apellidos"));
	    e.setRuta_imagen(rs.getString("ruta_imagen"));
	    e.setOnline(rs.getInt("online"));
	    e.setHora_conexion(rs.getDate("hora_conexion"));
	    e.setRole(rs.getString("role"));
	    //Tienda t = this.tMapper.mapRow(rs, column);
	    //e.setTienda(t);
	    return e;
	}
	
}
