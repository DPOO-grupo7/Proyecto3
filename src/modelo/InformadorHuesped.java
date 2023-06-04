package modelo;

import java.io.Serializable;

public class InformadorHuesped implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private String identificacion;
	private String correo;
	private String telefono;
	// private ArrayList<Producto> cuentaRestaurante;
	// private ArrayList<ServicioAdicional> cuentaAdicional;
//	private int numeroHuesped;

	public InformadorHuesped(String pLogin, String pPassword, String pIdentificacion, String pCorreo, String pTelefono) {
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
