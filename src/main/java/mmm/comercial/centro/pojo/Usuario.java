package mmm.comercial.centro.pojo;

import java.sql.Date;
import java.util.Calendar;

import mmm.comercial.centro.exceptions.UserException;

public class Usuario extends UserException  {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String user;
	private String pass;
	private String nombre;
	private String apellidos;
	private String ruta_imagen;
	private Date hora_conexion;
	private int online; // 1: conectado - 0: desconectado
	private String role; // CLI - EMP
	
	public Usuario() {		
		setUser("");
		setPass("");
		setNombre("");
		setApellidos("");
		setHora_conexion(new Date(Calendar.getInstance().getTime().getTime()));
		setOnline(1);	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		if (user.length()<10){
			this.user=user;
		} else {
			try {
				throw new UserException(UserException.MSG_USU_NO_VALIDO,UserException.COD_USU_NO_VALIDO);
			} catch (UserException e) {			
				e.printStackTrace();
			}		
		}
	}		
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		if (pass.length()<20){
			this.pass=pass;
		}else{
			try {
				throw new UserException(UserException.MSG_PASS_NO_VALIDA,UserException.COD_PASS_NO_VALIDO);
			} catch (UserException e) {
				e.printStackTrace();
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRuta_imagen() {
		return ruta_imagen;
	}


	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	public Date getHora_conexion() {
		return hora_conexion;
	}

	public void setHora_conexion(Date hora_conexion) {
		this.hora_conexion = hora_conexion;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
	
}
