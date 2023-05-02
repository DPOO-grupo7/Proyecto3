package vista;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import modelo.Habitacion;
import modelo.Hotel;
import modelo.InformadorHuesped;
import modelo.Reserva;
import posterityKeeper.Archivador;

public class Interfaz {
	private Hotel hotel;
	private String usuario;
	private String login;
	private String password;
	private Archivador archivador;
	public Interfaz()
	{
		archivador=new Archivador();
		menuOpciones();
	}
	public void menuOpciones()
	{
		while (true)
		{
			if (hotel==null)
			{
				System.out.println("Bienvenido al sistema de reservas de hoteles");
				System.out.println("--------------------------------------------");
				System.out.println("Seleccione una opci�n:");
				System.out.println("1. Crear nuevo hotel");
				System.out.println("2. Continuar con hotel previo");
				System.out.println("0. Fin");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        try {
					String input = br.readLine();
					if (input.equals("1"))
					{
						crearHotel();
					}
					else if (input.equals("2"))
					{
						cargarHotel();
					}
					else if (input.equals("0"))
					{
						break;
					}
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}
			}
			else if (usuario==null)
			{
				System.out.println("Opciones");
				System.out.println("--------");
				System.out.println("1. Iniciar sesi�n como administrador");
				System.out.println("2. Iniciar sesi�n como recepcionista");
				System.out.println("3. Iniciar sesi�n como huesped");
				System.out.println("4. Registrarse");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        try {
					String input = br.readLine();
					iniciarSesion(input);
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}
			}
			else if(usuario.equals("admin"))
			{
				System.out.println("Bienvenido "+login);
				System.out.println("1. Crear habitaci�n");
				System.out.println("2. Guardar habitaciones");
				System.out.println("3. Cargar habitaciones");
				
				System.out.println("4. Modificar tarifas");
				System.out.println("5. Cargar tarifas");
				System.out.println("6. Guardar hotel");
				System.out.println("7. Cargar men�s");
				System.out.println("0. Cerrar sesi�n");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        try {
					String input = br.readLine();
					if (input.equals("0"))
					{
						usuario=null;
					}
					else 
					{
						opcionesAdmin(input);
					}
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}
			}
			else if (usuario.equals("recepcionista"))
			{
				System.out.println("Bienvenido "+login);
				System.out.println("1. Consultar inventario");
				System.out.println("2. Crear reserva");
				System.out.println("3. Hacer check out");
				System.out.println("4. Imprimir factura");
				System.out.println("5. Asignar habitaci�n");
				System.out.println("0. Cerrar sesi�n");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        try {
					String input = br.readLine();
					if (input.equals("0"))
					{
						usuario=null;
					}
					else
					{
						opcionesRecepcion(input);
					}
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}
			}
			else if (usuario.equals("huesped"))
			{
				System.out.println("Bienvenido "+login);
				System.out.println("1. Solicitar check out");
				System.out.println("2. Generar factura");
				System.out.println("0. Cerrar sesi�n");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try {
					String input = br.readLine();
					if (input.equals("0"))
					{
						usuario=null;
					}
					else
					{
						//opcionesHuesped(input);
					}
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}
			}
		}
		
	}
	private void crearHotel()
	{
		hotel=new Hotel(archivador);
	}
	private void iniciarSesion(String tipoUsuario) throws IOException
	{
		if (tipoUsuario.equals("1"))
		{
			System.out.println("Ingresar nombre de usuario:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String loginActual = br.readLine();
			System.out.println("Ingresar contrase�a:");
			String passwordActual = br.readLine();
			if (hotel.iniciarSesion(tipoUsuario, loginActual, passwordActual)==true)
			{
				usuario="admin";
				login=loginActual;
				password=passwordActual;
			}
			else
			{
				System.err.println("No se encontr� el administrador especificado. Vuelva a intentarlo o intente con otro nombre de usuario y contrase�a.");
			}

		}
		else if (tipoUsuario.equals("2"))
		{
			System.out.println("Ingresar nombre de usuario:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String loginActual = br.readLine();
			System.out.println("Ingresar contrase�a:");
			String passwordActual = br.readLine();

			if (hotel.iniciarSesion(tipoUsuario, loginActual, passwordActual)==true)
			{
				usuario="recepcionista";
				login=loginActual;
				password=passwordActual;
			}
			else
			{
				System.err.println("No se encontr� el recepcionista especificado. Vuelva a intentarlo o intente con otro nombre de usuario y contrase�a.");
			}

		}
		else if (tipoUsuario.equals("3"))
		{
			System.out.println("Ingresar nombre de usuario:");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String loginActual = br.readLine();
			System.out.println("Ingresar contrase�a:");
			String passwordActual = br.readLine();
			//System.out.println(hotel.iniciarSesion(tipoUsuario, loginActual, passwordActual));
			if (hotel.iniciarSesion(tipoUsuario, loginActual, passwordActual)==true)
			{
				usuario="huesped";
				login=loginActual;
				password=passwordActual;
			}
			else
			{
				System.err.println("No se encontr� el administrador especificado. Vuelva a intentarlo o intente con otro nombre de usuario y contrase�a.");
			}
		}
		else if (tipoUsuario.equals("4"))
		{
			System.out.println("Escoger tipo de usuario:");
			System.out.println("------------------------");
			System.out.println("1. Crear cuenta administrador");
			System.out.println("2. Crear cuenta recepcionista");
			System.out.println("3. Crear cuenta huesped");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String tipoCuenta = br.readLine();
			System.out.println("Ingresar nombre de usuario:");
			String loginActual = br.readLine();
			System.out.println("Ingresar contrase�a:");
			String passwordActual = br.readLine();
			if (tipoCuenta.equals("3"))
			{
				System.out.println("Ingresar identificaci�n:");
				br = new BufferedReader(new InputStreamReader(System.in));
				String identificacion = br.readLine();
				System.out.println("Ingresar correo electr�nico:");
				String correo = br.readLine();
				System.out.println("Ingresar tel�fono:");
				String telefono = br.readLine();
				hotel.crearCuentaHuesped(loginActual, passwordActual, Integer.parseInt(identificacion), correo, Integer.parseInt(telefono));
			}
			else if (tipoCuenta.equals("1") || tipoCuenta.equals("2"))
			{
				System.out.println(loginActual);
				System.out.println(passwordActual);
				hotel.crearCuenta(tipoCuenta, loginActual, passwordActual);
			}
			else
			{
				System.err.println("No se ingreso un usuario correcto. Por favor vuelva a intentarlo.");
			}
		}
		else
		{
			System.err.println("No se ingreso un usuario correcto. Por favor vuelva a intentarlo.");
		}
		
		menuOpciones();
	}
	private void opcionesAdmin(String opcion)
	{
		HashMap<String, String> datos;
		try {
			datos = solicitarDatos(opcion);
			System.out.println(hotel.opcionesAdmin(opcion, login,datos));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void opcionesRecepcion(String opcion)
	{
		HashMap<String, String> datos;
		try {
			datos = solicitarDatos(opcion);
			Habitacion buscada=(Habitacion) hotel.opcionesRecepcion(opcion, login,datos);
			System.out.println("Habitaci�n: "+datos.get("id"));
			System.out.println("------------");
			System.out.println("Capacidad: "+buscada.getCapacidad());
			System.out.println("Ubicaci�n: "+buscada.getUbicacion());
			System.out.println("Tipo: "+buscada.getTipo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
				
	}
	public HashMap<String, String> solicitarDatos(String input) throws IOException
	{
		HashMap<String,String> respuesta=new HashMap<String,String>();
		if (usuario.equals("admin"))
		{
			if (input.equals("1"))
			{
				try {
					System.out.println("Ingresar capacidad");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String capacidad = br.readLine();
					respuesta.put("capacidad", capacidad);
					
					System.out.println("Ingresar ubicacion");
					String ubicacion = br.readLine();
					respuesta.put("ubicacion", ubicacion);
					
					System.out.println("Ingresar tipo");
					String tipo = br.readLine();
					respuesta.put("tipo", tipo);
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}

			}
			else if (input.equals("4"))
			{
				try {
					System.out.println("�Qu� tipo de tarifa desea modificar?");
					System.out.println("------------------------------------");
					System.out.println("1. Habitaci�n.");
					System.out.println("2. Servicio.");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String tipoServicio = br.readLine();
					respuesta.put("tipoServicio", tipoServicio);
					if (tipoServicio.equals("1"))
					{
						System.out.println("�A qu� tipo de habitaci�n le desea modificar la tarifa?");
						System.out.println("------------------------------------");
						System.out.println("1. Estandar.");
						System.out.println("2. Suite.");
						System.out.println("3. Suite doble.");
						respuesta.put("tipoHabitacion", br.readLine());
						System.out.println("�En qu� fecha la desea cambiar?");
						respuesta.put("fecha", br.readLine());
						System.out.println("�Qu� valor le desea poner?");
						respuesta.put("valor", br.readLine());

					}
					else if (tipoServicio.equals("2"))
					{
						System.out.println("�A qu� servicio le desea modificar la tarifa?");
						System.out.println("------------------------------------");
						HashMap<String, Integer> servicios=solicitarServicios();
						int i=1;
						for (Map.Entry<String, Integer> entrada: servicios.entrySet())
						{
							System.out.println(Integer.toString(i)+". "+entrada.getKey()+" - $"+Integer.toString(entrada.getValue()));
							i++;
						}
						String servicioAModificar=br.readLine();
						respuesta.put("servicio", servicioAModificar);
						System.out.println("�En qu� fecha la desea cambiar?");
						respuesta.put("fecha", br.readLine());
						System.out.println("�Qu� valor le desea poner?");
						respuesta.put("valor", br.readLine());
					}
					
					System.out.println("Ingresar ubicacion");
					String ubicacion = br.readLine();
					respuesta.put("ubicacion", ubicacion);
					
					System.out.println("Ingresar tipo");
					String tipo = br.readLine();
					respuesta.put("tipo", tipo);
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}			}
		}
		else if (usuario.equals("recepcionista"))
		{
			if (input.equals("1"))
			{
				try {
					System.out.println("Ingresar identificador de la habitaci�n");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					String identificador = br.readLine();
					respuesta.put("id", identificador);
				} catch (IOException e) {
					System.err.println("Ha ocurrido un error. Vuelva a intentarlo m�s tarde.");
				}
			}
			
			else if (input.equals("2"))
			{
				crearReserva();
			}
	
		}
		return respuesta;
	}
	public void crearReserva() throws IOException {
		int CntP = 0;
		// Primera interacción: Verificar disponibilidad de la solicitud general
		System.out.println("Reserva de habitaci�n");
		System.out.println("---------------------");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Ingrese fecha de inicio de su estad�a (dd/MM/yyyy):");
		String fechaIngreso = br.readLine();
		System.out.println("Ingrese fecha de finalizaci�n de su estad�a (dd/MM/yyyy):");
		String fechaSalida = br.readLine();
		System.out.println("Ingresar tipo de habitaci�n:");
		System.out.println("----------------------------");
		System.out.println("1 - Estandar");
		System.out.println("2 - Suite");
		System.out.println("3 - Suite doble");
		int tipoHabitacion = Integer.parseInt(br.readLine());
		System.out.println("Ingresar car�cteristicas adicionales de la habitaci�n separadas por comas (,)");
		String caracteristicas=br.readLine();

		String tipo = "";
		if (tipoHabitacion == 1) {
			tipo = "Estandar";
		} else if (tipoHabitacion == 2) {
			tipo = "Suite";
		} else if (tipoHabitacion == 3) {
			tipo = "Suite Doble";
		}
		String[] caracterisitcas = caracteristicas.split(",");
		ArrayList<Habitacion> listaDisponibilidad = hotel.recopilarDisponibilidad(tipo,formatearFecha(fechaIngreso),formatearFecha(fechaSalida), caracterisitcas);

		if (listaDisponibilidad.isEmpty()) {
			System.out.println("Las fechas que busca para el tipo de habitaci�n y caracter�sticas est�n tot�lmente ocupadas.");
		}

		// Segunda interaccion : #personas y #ni�os y si cuentan

		System.out.println("Ingresar n�mero de personas en su grupo:");
		int CntPersonas = Integer.parseInt(br.readLine());
		System.out.println("De esas personas, ingresar cuantos son ni�os que no necesitan cama:");
		int cntKids = Integer.parseInt(br.readLine());
		
		CntP = CntPersonas - cntKids;
		ArrayList<Habitacion> resultadoCuartos = hotel.asignacioncuartos(listaDisponibilidad, CntP);
		if (resultadoCuartos.isEmpty()) {
			System.out.println("Lo siento, no hay habitaciones disponibles para el número de personas indicado.");
			return;

			// TODO escribir que pasa
		}

		ArrayList<InformadorHuesped> listadeMiebros = informacionHuespedes();
		// se divide entre el huesped a cargo y el resto de miembros.
		ArrayList<InformadorHuesped> listaGrupo = listadeMiebros;
		if (listadeMiebros.size() != 1) {
			listaGrupo.remove(0);
		} else {
			listaGrupo = null;

		}

		Reserva reservaEncurso = hotel.nuevaReserva(listadeMiebros.get(0), listaGrupo, CntPersonas, formatearFecha(fechaIngreso), formatearFecha(fechaSalida), resultadoCuartos,new ArrayList<String>(Arrays.asList(caracterisitcas)), tipo);

		finalizarReserva(reservaEncurso, new ArrayList<String>(Arrays.asList(caracterisitcas)));

	}
	public Date formatearFecha(String fechaTexto) {
		// esta va a ser usada para cuando se quiera buscar una fecha o reservar en esa
		// fecha.
//		un ejemplo de fechaTexto = "15/01/2023";
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formatoFecha.parse(fechaTexto);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fecha;
	}
	public ArrayList<InformadorHuesped> informacionHuespedes() throws NumberFormatException, IOException {

		System.out.println("Por favor responda las siguientes preguntas para cada miembro de su reserva (recuerde que la reserva qeudar� a nombre de la primera persona):");
		int continuar = 0;

		ArrayList<InformadorHuesped> miembrosGrupo = new ArrayList<InformadorHuesped>();
		while (continuar == 0) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Nombre:");
			String nombre=br.readLine();
			System.out.println("Documento:");
			String documento=br.readLine();
			System.out.println("Correo electr�nico:");
			String correo=br.readLine();
			System.out.println("Tel�fono:");
			String telefono=br.readLine();
			

			InformadorHuesped persona = new InformadorHuesped(nombre, documento, Integer.parseInt(documento), correo, Integer.parseInt(telefono));
			miembrosGrupo.add(persona);
			hotel.crearCuentaHuesped(nombre, documento, Integer.parseInt(documento), correo, Integer.parseInt(telefono));
			System.out.println("�Desea a�adir m�s hu�spedes?");
			System.out.println("-----------------");
			System.out.println("1. S�.");
			System.out.println("2. No.");
			continuar=Integer.parseInt(br.readLine());
			
		}
		return miembrosGrupo;

	}
	public void finalizarReserva(Reserva reservaEncurso, ArrayList<String> caracteristicas) {

		ArrayList<String> informacionFinal = hotel.informacionSobreReserva(reservaEncurso, caracteristicas);
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("---------------------------------------------------");
		for (String elemento : informacionFinal) {
			System.out.println(elemento);
		}
		System.out.println("---------------------------------------------------");
		System.out.println("\n");
		System.out.println("\n");
	}
	public void FinalizarReserva(Reserva reservaEncurso, ArrayList<String> caracteristicas) {

		ArrayList<String> informacionFinal = hotel.informacionSobreReserva(reservaEncurso, caracteristicas);
		System.out.println("\n");
		System.out.println("\n");
		System.out.println("---------------------------------------------------");
		for (String elemento : informacionFinal) {
			System.out.println(elemento);
		}
		System.out.println("---------------------------------------------------");
		System.out.println("\n");
		System.out.println("\n");
	}
	private void cargarHotel()
	{
		hotel=archivador.cargarHotel();
		archivador=hotel.getArchivador();
	}
	public HashMap<String, Integer> solicitarServicios()
	{
		return hotel.getServicios();
	}
	public static void main(String[] args) {
		Interfaz interfaz=new Interfaz();
		

	}
	

}
