package mmm.comercial.centro.exceptions;

public class UserException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public static final int COD_USU_NO_VALIDO = 10;
	public static final String MSG_USU_NO_VALIDO = "Nombre de usuario no válido.";
		
	public static final int COD_PASS_NO_VALIDO = 20;
	public static final String MSG_PASS_NO_VALIDA = "Contraseña no válida.";
		
	private transient int codigo;

	public UserException() {
		super();
	}	
	
	public UserException(String mensaje, int pcodigo) {
		super(mensaje);
		this.codigo=pcodigo;		
	}
	
	public UserException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public  UserException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public  UserException(String arg0) {
		super(arg0);
	}

	public  UserException(Throwable arg0) {
		super(arg0);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public int getCodigo() {
		return codigo;
	}

	
}
