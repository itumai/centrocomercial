package mmm.comercial.centro.pojo;

public class Producto {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String ruta_imagen;
	private int disponible; // 1: disponible - 0: no disponible
		
	public Producto() {
		super();
		setNombre("");
		setDescripcion("");
		setRuta_imagen("resources/images/producto/default.png");
		setDisponible(1);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getRuta_imagen() {
		return ruta_imagen;
	}
	
	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}
	
	public int getDisponible() {
		return disponible;
	}
	
	public void setDisponible(int disponible) {
		this.disponible = disponible;
	}
	

}
