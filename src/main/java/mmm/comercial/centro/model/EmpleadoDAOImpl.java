package mmm.comercial.centro.model;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mmm.comercial.centro.model.interfaces.IEmpleadoDAO;
import mmm.comercial.centro.model.mappers.EmpleadoMapper;
import mmm.comercial.centro.pojo.Empleado;

@Repository("empleadoDAO")
public class EmpleadoDAOImpl implements IEmpleadoDAO {
	
	private JdbcTemplate jdbctemplate;
	@Resource(name="myDataSource")
	private DataSource datasource;	
	
	@Override
	public int create(Empleado emp) {
		int codigo;
		final String SQL="INSERT INTO empleado(user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role) VALUES (?,?,?,?,?,?,?,?)";
		codigo=jdbctemplate.update(SQL,emp.getUser(),emp.getPass(),emp.getNombre(),emp.getApellidos(),emp.getRuta_imagen(),emp.getOnline(),emp.getHora_conexion(),emp.getRole());
		return codigo;
	}

	@Override
	public int createAndUpdateTienda(Empleado emp, int idtienda) {
		int codigo;
		final String SQL = "INSERT INTO empleado(user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role,tienda) VALUES (?,?,?,?,?,?,?,?,?)";
		codigo = jdbctemplate.update(SQL, emp.getUser(),emp.getPass(),emp.getNombre(),emp.getApellidos(),emp.getRuta_imagen(),emp.getOnline(),emp.getHora_conexion(),emp.getRole(), idtienda);
		return codigo;
	}

	@Override
	public Empleado getById(int id) {
		Empleado emp=null;
		final String SQL="SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM empleado WHERE id=?";
		try {
			emp=jdbctemplate.queryForObject(SQL, new Object[] {id}, new EmpleadoMapper());
		}	catch (EmptyResultDataAccessException e) {
			emp=null;
		}		
		return emp;
	}
	
	@Override
	public Empleado getByUser(String user) {
		Empleado emp=null;
		final String SQL="SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM empleado WHERE user=?";
		try {
			emp=jdbctemplate.queryForObject(SQL, new Object[] { user }, new EmpleadoMapper());
		}	catch (EmptyResultDataAccessException e) {
			emp=null;
		}		
		return emp;
	}

	@Override
	public Empleado getByRole(String role) {
		Empleado emp=null;
		final String SQL="SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM empleado WHERE role=?";
		try {
			emp=jdbctemplate.queryForObject(SQL, new Object[] { role }, new EmpleadoMapper());
		}	catch (EmptyResultDataAccessException e) {
			emp=null;
		}		
		return emp;
	}
	
	@Override
	public int getTiendaByEmpleado(int idempleado) {
		int idtienda;
		final String SQL="SELECT tienda FROM empleado WHERE id=?";
		try {
			idtienda=jdbctemplate.queryForObject(SQL, new Object[] {idempleado}, Integer.class);
		}	catch (EmptyResultDataAccessException e) {
			idtienda=-1;
		}		
		return idtienda;
	}

	@Override
	public Empleado getByOnline() {
		Empleado emp=null;
		int online = 1;
		final String SQL="SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM empleado WHERE online=?";
		try {
			emp=jdbctemplate.queryForObject(SQL, new Object[] { online }, new EmpleadoMapper());
		}	catch (EmptyResultDataAccessException e) {
			emp=null;
		}		
		return emp;
	}
	
	@Override
	public List<Empleado> getAll() {
		List<Empleado> empleados=null;
		
		final String SQL="SELECT id,user,pass,nombre,apellidos,ruta_imagen,online,hora_conexion,role FROM empleado";
		
		try {
			empleados=jdbctemplate.query(SQL, new EmpleadoMapper());
		}	catch (EmptyResultDataAccessException e){
			empleados=null;			
		}
		return empleados;
	}

	@Override
	public int update(Empleado emp) {
		int codigo = -1;
		
		final String SQL="UPDATE empleado SET user=?,pass=?,nombre=?,apellidos=?,ruta_imagen=?,online=?,hora_conexion=?,role=? WHERE id=?";
		
		codigo=jdbctemplate.update(SQL,emp.getUser(),emp.getPass(), emp.getNombre(),emp.getApellidos(),emp.getRuta_imagen(),emp.getOnline(),emp.getHora_conexion(),emp.getRole(), emp.getId());
		return codigo;
	}

	@Override
	public int delete(int id) {
		int cod=-1;
		final String SQL="DELETE FROM empleado WHERE id=?";
		cod=jdbctemplate.update(SQL,id);
		return cod;
	}

	@Resource(name="myDataSource")
	@Override
	public void setDatasource(DataSource datasource) {
		this.datasource=datasource;
		jdbctemplate=new JdbcTemplate(datasource);
		
	}

	

}
