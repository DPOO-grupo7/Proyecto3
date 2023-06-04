package modelo;

import java.io.Serializable;
import java.util.HashMap;

public class InformadorPersonal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String login;
	private String password;
	private Hotel hotel;

	
	public InformadorPersonal (String pLogin, String pPassword, Hotel pHotel)
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
			boolean desayuno, int precio)
	{
		if (opcion.equals("1"))
		{
			hotel.crearHabitacion(Integer.parseInt(datos.get("capacidad")), datos.get("ubicacion"),datos.get("tipo"), tamanio,  cama,  ac,  heat,  tv,  cafe,
					 plancha,  ropa,  secador,  voltaje,  usba,  usbc,
					 desayuno, precio);
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
