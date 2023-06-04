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
	public String opciones(String opcion, HashMap<String, String> datos, String tamanio
			, String cama, boolean ac, boolean heat, boolean tv, boolean cafe,
			boolean plancha, boolean ropa, boolean secador, boolean voltaje, boolean usba, boolean usbc,
			boolean desayuno)
	{
		if (opcion.equals("1"))
		{
			hotel.crearHabitacion(Integer.parseInt(datos.get("capacidad")), datos.get("ubicacion"),datos.get("tipo"), datos.get("tamanio"),  datos.get("cama"),  Boolean.parseBoolean(datos.get("ac")),  Boolean.parseBoolean(datos.get("heat")),  Boolean.parseBoolean(datos.get("tv")),  Boolean.parseBoolean(datos.get("cafe")),
			Boolean.parseBoolean(datos.get("plancha")),  Boolean.parseBoolean(datos.get("ropa")),  Boolean.parseBoolean(datos.get("secador")),  Boolean.parseBoolean(datos.get("voltaje")),  Boolean.parseBoolean(datos.get("usba")),  Boolean.parseBoolean(datos.get("usbc")),
			Boolean.parseBoolean(datos.get("desayuno")), Integer.parseInt(datos.get("precio")));
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
