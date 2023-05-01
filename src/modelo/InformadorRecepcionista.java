package modelo;

import java.util.HashMap;


public class InformadorRecepcionista {
	private String login;
	private String password;
	private Hotel hotel;
	
	public InformadorRecepcionista(String pLogin, String pPassword, Hotel pHotel)
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
	public Object opciones(String opcion, HashMap<String, String> datos)
	{
		if (opcion.equals("1"))
		{
			return solicitarHabitacion(datos);
		}
		return "";
	}
	public Habitacion solicitarHabitacion(HashMap<String, String> datos)
	{
		int id=Integer.parseInt(datos.get("id"));
		return hotel.solicitarHabitacion(id);
	}
	
}
