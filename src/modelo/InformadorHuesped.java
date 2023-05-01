package modelo;

import java.util.ArrayList;



public class InformadorHuesped {
	private static ArrayList<InformadorHuesped> LISTA_HUESPEDES;
	private String login;
	private String password;
	private int identificacion;
	private String correo;
	private int telefono;
	//private ArrayList<Producto> cuentaRestaurante;
	//private ArrayList<ServicioAdicional> cuentaAdicional;
	private int numeroHuesped;

	
	public InformadorHuesped(String pLogin,String pPassword, int pIdentificacion, String pCorreo, int pTelefono)
	{
		login=pLogin;
		password=pPassword;
		identificacion=pIdentificacion;
		correo=pCorreo;
		telefono=pTelefono;
	}
	public String getLogin()
	{
		return login;
	}
	public String getPassword()
	{
		return password;
	}
	public static void crearListaHuespedes() {
		LISTA_HUESPEDES = new ArrayList<InformadorHuesped>();
		
		
	}
}
