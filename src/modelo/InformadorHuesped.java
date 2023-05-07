package modelo;

public class InformadorHuesped {

	private String login;
	private String password;
	private int identificacion;
	private String correo;
	private int telefono;
	// private ArrayList<Producto> cuentaRestaurante;
	// private ArrayList<ServicioAdicional> cuentaAdicional;
//	private int numeroHuesped;

	public InformadorHuesped(String pLogin, String pPassword, int pIdentificacion, String pCorreo, int pTelefono) {
		login = pLogin;
		password = pPassword;
		setIdentificacion(pIdentificacion);
		setCorreo(pCorreo);
		setTelefono(pTelefono);
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
