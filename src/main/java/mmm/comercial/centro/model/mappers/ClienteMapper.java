package mmm.comercial.centro.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import mmm.comercial.centro.pojo.Cliente;

import org.springframework.jdbc.core.RowMapper;

public class ClienteMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int column) throws SQLException {
		Cliente cliente = new Cliente();
	    cliente.setId(rs.getInt("id"));
	    cliente.setUser(rs.getString("user"));
	    cliente.setPass(rs.getString("pass"));
	    cliente.setNombre(rs.getString("nombre"));
	    cliente.setApellidos(rs.getString("apellidos"));
	    cliente.setRuta_imagen(rs.getString("ruta_imagen"));
	    cliente.setOnline(rs.getInt("online"));
	    cliente.setHora_conexion(rs.getDate("hora_conexion"));
	    cliente.setRole(rs.getString("role"));
	    return cliente;
	}	

}
