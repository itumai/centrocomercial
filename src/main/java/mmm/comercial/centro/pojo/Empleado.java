package mmm.comercial.centro.pojo;

public class Empleado extends Usuario {

	private static final long serialVersionUID = 1L;
		
	private int id;
	
	public Empleado() {
		super();
		super.setRole("EMP");	
		super.setRuta_imagen("resources/images/empleado/default.png");
	}	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}
