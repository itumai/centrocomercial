package mmm.comercial.centro.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import mmm.comercial.centro.pojo.Administrador;

import org.springframework.jdbc.core.RowMapper;

public class AdministradorMapper implements RowMapper<Administrador> {

	@Override
	public Administrador mapRow(ResultSet rs, int column) throws SQLException {
		Administrador a = new Administrador();
	    a.setId(rs.getInt("id"));
	    a.setUser(rs.getString("user"));
	    a.setPass(rs.getString("pass"));
	    a.setRole(rs.getString("role"));
	    return a;
	}	
}