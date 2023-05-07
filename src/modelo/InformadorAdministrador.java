package modelo;

import java.io.Serializable;
import java.util.HashMap;

public class InformadorAdministrador implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private Hotel hotel;

	
	public InformadorAdministrador(String pLogin, String pPassword, Hotel pHotel)
	{
		login=pLogin;
		password=pPassword;
		hotel=pHotel;
	}
	public String getLogin()
	{
		return login;
	}
	public String getPassword()
	{
		return password;
	}
	public String opciones(String opcion, HashMap<String, String> datos)
	{
		if (opcion.equals("1"))
		{
			hotel.crearHabitacion(Integer.parseInt(datos.get("capacidad")), datos.get("ubicacion"),datos.get("tipo"));
		}
		
		else if (opcion.equals("2"))
		{
			hotel.guardarHabitaciones();
		}
		
		else if (opcion.equals("3"))
		{
			hotel.cargarHabitaciones();
		}
		else if (opcion.equals("4"))
		{
			hotel.cambiarTarifa(datos);
		}
		else if (opcion.equals("6"))
		{
			hotel.guardarHotel();
		}
		return "";
	}
}
