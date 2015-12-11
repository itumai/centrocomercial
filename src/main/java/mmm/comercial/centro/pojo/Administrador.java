package mmm.comercial.centro.pojo;

public class Administrador {
	
	private int id;
	private String user;
	private String pass;
	private String role;
	
	public Administrador() {
		setUser("");
		setPass("");
		setRole("");
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
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
}
