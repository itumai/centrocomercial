package mmm.comercial.centro.pojo;

import java.util.ArrayList;
import java.util.List;

import mmm.comercial.centro.pojo.Producto;

public class Cliente extends Usuario {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private List<Producto> listaProductos;	
	
	public Cliente() {
		super();
		super.setRole("CLI");
		super.setRuta_imagen("resources/images/cliente/default.png");
		setListaProductos(new ArrayList<Producto>());
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<Producto> getListaProductos() {
		return listaProductos;
	}
	
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
}