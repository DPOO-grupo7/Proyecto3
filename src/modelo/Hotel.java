package modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import controlador.ControladorHabitaciones;
import controlador.ManejadorReservas;
import controlador.ManejadorTarifa;
import posterityKeeper.Archivador;



public class Hotel implements Serializable{
	private static final long serialVersionUID = 1L;
	private Archivador archivador;
	private ArrayList<InformadorRecepcionista> recepcionistas;
	private ArrayList<InformadorAdministrador> admins;
	private ArrayList<InformadorHuesped> huespedes;
	private ControladorHabitaciones ch;
	private ManejadorReservas mr;
	private ManejadorTarifa mt;
	private HashMap<String, Integer> servicios;
	private HashMap<SimpleDateFormat, Integer> tarifasEstandar;
	private HashMap<SimpleDateFormat, Integer> tarifasSuite;
	private HashMap<SimpleDateFormat, Integer> tarifasDoble;
	public Hotel(Archivador pArchivador)
	{
		archivador=pArchivador;
		recepcionistas=new ArrayList<InformadorRecepcionista>();
		admins=new ArrayList<InformadorAdministrador>();
		huespedes=new ArrayList<InformadorHuesped>();
		ch=new ControladorHabitaciones();
		mr=new ManejadorReservas();
		mt=new ManejadorTarifa();
		servicios=new HashMap<String, Integer>();
		tarifasEstandar=new HashMap<SimpleDateFormat, Integer>();
		tarifasSuite=new HashMap<SimpleDateFormat, Integer>();
		tarifasDoble=new HashMap<SimpleDateFormat, Integer>();
		servicios.put("Servicio Prueba", 25);
	}
	public Archivador getArchivador()
	{
		return archivador;
	}
	public boolean iniciarSesion(String tipoUsuario, String login, String password)
	{
		boolean existe=false;
		
		if (tipoUsuario.equals("1"))
		{
			for (int i=0; i<admins.size();i++)
			{
				if (admins.get(i).getLogin().equals(login) && admins.get(i).getPassword().equals(password))
				{
					existe=true;
				}
			}
		}
		else if (tipoUsuario.equals("2"))
		{
			for (int i=0; i<recepcionistas.size();i++)
			{
				if (recepcionistas.get(i).getLogin().equals(login) && recepcionistas.get(i).getPassword().equals(password))
				{
					existe=true;
				}
			}
		}
		else if (tipoUsuario.equals("3"))
		{
			for (int i=0; i<huespedes.size();i++)
			{
				if (huespedes.get(i).getLogin().equals(login) && huespedes.get(i).getPassword().equals(password))
				{
					existe=true;
				}
			}
		}
		return existe;
	}
	public void crearCuenta(String tipoUsuario, String login, String password)
	{
		if (tipoUsuario.equals("1"))
		{
			admins.add(new InformadorAdministrador(login, password,this));
		}
		else if (tipoUsuario.equals("2"))
		{
			recepcionistas.add(new InformadorRecepcionista(login, password, this));
		}
	}
	public void crearCuentaHuesped(String login, String password,  int identificacion, String correo, int telefono)
	{
		huespedes.add(new InformadorHuesped(login, password, identificacion, correo, telefono));
	}
	public Object opcionesAdmin(String opcion,String login,HashMap<String, String> datos)
	{
		return admins.get(encontrarAdmin(login)).opciones(opcion,datos);
	}
	public Object opcionesRecepcion(String opcion,String login, HashMap<String, String> datos)
	{
		return recepcionistas.get(encontrarRecepcionista(login)).opciones(opcion, datos);
	}
	private int encontrarAdmin(String login)
	{
		for (int i=0; i<admins.size();i++)
		{
			if (admins.get(i).getLogin().equals(login))
			{
				return i; 
			}
		}
		return -1;
	}
	private int encontrarRecepcionista(String login)
	{
		for (int i=0; i<recepcionistas.size();i++)
		{
			if (recepcionistas.get(i).getLogin().equals(login))
			{
				return i; 
			}
		}
		return -1;
	}
	public void crearHabitacion(int pCapacidad, String pUbicacion, String pTipo)
	{
		ch.crearHabitacion(pCapacidad, pUbicacion, pTipo);
	}
	public Habitacion solicitarHabitacion(int id)
	{
		return ch.encontrarHabitacion(id);
	}
	public void guardarHabitaciones()
	{
		ArrayList<Habitacion> inventario=ch.retornarHabitaciones();
		archivador.guardarHabitaciones(inventario);
	}
	public void cargarHabitaciones()
	{
		ArrayList<Habitacion> inventario=archivador.cargarHabitaciones();
		ch.asignarListaHabitaciones(inventario);
	}
	public ArrayList<Habitacion> recopilarDisponibilidad(String tipo, Date fechaInicio, Date fechaFin,String[] especificaciones) 
	{

		ArrayList<Habitacion> CuartosDisponibles = ch.habitacionesDisponibles(tipo, fechaInicio, fechaFin,new ArrayList<String>(Arrays.asList(especificaciones)));
		if (CuartosDisponibles.isEmpty()) {
			System.out.println("ESTA VACIO");
		}
		return CuartosDisponibles;
	}
	public ArrayList<Habitacion> asignacioncuartos(ArrayList<Habitacion> listaDisponibilidadCuartos, int cantidadPersonas) {

		ArrayList<Habitacion> cuartosAsignados = ch.asignarcuartos(listaDisponibilidadCuartos,cantidadPersonas);
		return cuartosAsignados;
	}
	public Reserva nuevaReserva(InformadorHuesped huespedPrincipal, ArrayList<InformadorHuesped> listaGrupo, int cntPersonas,Date fechaInicio, Date fechaFinal, ArrayList<Habitacion> resultadoCuartos, ArrayList<String> caracterisitcas,String tipo) {

		mr.inicioProceso(huespedPrincipal, fechaInicio, fechaFinal, caracterisitcas, tipo, resultadoCuartos);
		if (listaGrupo != null) {
			mr.setGrupoHuespedes(listaGrupo);
		} else {
			mr.setGrupoHuespedes(new ArrayList<InformadorHuesped>());
		}

		Reserva reservaActual = mr.AsignarReserva();

		return reservaActual;
	}
	public ArrayList<String> informacionSobreReserva(Reserva reservaEncurso, ArrayList<String> CaracterisitcasF) {
		ArrayList<String> infoReserva = new ArrayList<>();
		String resumen = "Resumen:\n";
		resumen += reservaEncurso.getNumPersonas() + " personas\n";
		
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    String fechaLlegada = dateFormat.format(reservaEncurso.getFechaLlegada());
	    String fechaSalida = dateFormat.format(reservaEncurso.getFechaSalida());
	    resumen += fechaLlegada + " - " + fechaSalida + "\n";
		
		
		
		resumen += reservaEncurso.getNumHabitaciones().size() + " cuartos\n";// solo da la cantidad de cuartos
		resumen += reservaEncurso.getNumHabitaciones().get(0).getTipo() + "\n";
		resumen += "Especificaciones:\n";
		for (String especificacion : CaracterisitcasF) {
			resumen += especificacion + "\n";
		}
		int tarifa = mt.tarifaReserva(reservaEncurso);
		String infoTarifa = "Precio: " + tarifa;

		infoReserva.add("Reserva # " + reservaEncurso.getIdentificacion() + ":");
		infoReserva.add(resumen);
		infoReserva.add(infoTarifa);

		return infoReserva;
	}
	public void guardarHotel()
	{
		archivador.guardarHotel(this);
	}
	public HashMap<String, Integer> getServicios()
	{
		return servicios;
	}
	public void cambiarTarifa(HashMap<String, String> datos)
	{
		if (datos.get("tipoServicio").equals("1"))
		{
			if (datos.get("tipoHabitacion").equals("1"))
			{
				tarifasEstandar.put(new SimpleDateFormat(datos.get("fecha")), Integer.parseInt(datos.get("valor")));
			}
			else if (datos.get("tipoHabitacion").equals("2"))
			{
				tarifasSuite.put(new SimpleDateFormat(datos.get("fecha")), Integer.parseInt(datos.get("valor")));
			}
			else if (datos.get("tipoHabitacion").equals("3"))
			{
				tarifasDoble.put(new SimpleDateFormat(datos.get("fecha")), Integer.parseInt(datos.get("valor")));
			}
		}
		else if (datos.get("tipoServicio").equals("2"))
		{
			int i=1;
			for (Map.Entry<String, Integer> entrada: servicios.entrySet())
			{
				if (Integer.parseInt(datos.get("servicio"))==i)
				{
					servicios.put(entrada.getKey(),Integer.parseInt(datos.get("valor")));
				}
			}
		}
		servicios.get(admins);
	}

}
