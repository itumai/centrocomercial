package mmm.comercial.centro.model.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import mmm.comercial.centro.pojo.Tienda;

import org.springframework.jdbc.core.RowMapper;

public class TiendaMapper implements RowMapper<Tienda> {
	
	/* private final EmpleadoMapper eMapper;
	
	public TiendaMapper(EmpleadoMapper eMapper) {
		this.eMapper = eMapper;
	} */

	@Override
	public Tienda mapRow(ResultSet rs, int column) throws SQLException {
		Tienda t = new Tienda();
	    t.setId(rs.getInt("id"));
	    t.setNombre(rs.getString("nombre"));
	    t.setDescripcion(rs.getString("descripcion"));
	    t.setRuta_imagen(rs.getString("ruta_imagen"));
	    t.setTipo(rs.getString("tipo"));
	    t.setEstado(rs.getInt("estado"));
	    t.setHorario_abrir(rs.getString("horario_abrir"));
	    t.setHorario_cerrar(rs.getString("horario_cerrar"));
	    //Empleado e = eMapper.mapRow(rs,column);
	    //t.getListaEmpleados().add(e);
	    return t;
	}
	
}