package controlador;


import java.util.ArrayList;
import java.util.Date;
import modelo.Habitacion;

public class ControladorHabitaciones {
	ArrayList<Habitacion> LISTA_HABITACIONES = new ArrayList<Habitacion>();
	
	public ControladorHabitaciones() {
		
	}
	public void crearHabitacion(int capacidad, String ubicacion, String tipo) {
		int identificador=LISTA_HABITACIONES.size()+1;
		
		LISTA_HABITACIONES.add(new Habitacion(capacidad, ubicacion, tipo, identificador));
		
	}
	public Habitacion encontrarHabitacion(int id) {

		Habitacion buscada=null;
		for (Habitacion habitacion : LISTA_HABITACIONES) {
			if (habitacion.getIdentificador() == id) {
				return habitacion;

			}

		}
		return buscada;
	}
	public ArrayList<Habitacion> retornarHabitaciones()
	{
		return LISTA_HABITACIONES;
	}
	public void asignarListaHabitaciones(ArrayList<Habitacion> inventario)
	{
		LISTA_HABITACIONES=inventario;
	}
	public ArrayList<Habitacion> habitacionesDisponibles(String tipo, Date FechaInicio, Date FechaFin,ArrayList<String> especificaciones) {
		ArrayList<Habitacion> FiltroTipo = habitacionesDisponiblesTipo(LISTA_HABITACIONES, tipo);
		ArrayList<Habitacion> FiltroFecha = habitacionesDisponiblesFecha(FiltroTipo, FechaInicio, FechaFin);
		ArrayList<Habitacion> FiltroFinal = habitacionesDisponiblesEspecificaciones(FiltroFecha, especificaciones);
		if (FiltroFinal.isEmpty()) {
			System.out.println("ESTA VACIO controlador");
		}
		return FiltroFinal;
	}
	public ArrayList<Habitacion> habitacionesDisponiblesTipo(ArrayList<Habitacion> listaPorFiltrar, String tipo) {
		ArrayList<Habitacion> listaFiltrada = new ArrayList<Habitacion>();

		for (Habitacion habitacion : listaPorFiltrar) {

			if (habitacion.getTipo().equals(tipo)) {
				listaFiltrada.add(habitacion);
			}

		}
		
		if (listaFiltrada.isEmpty()) {
			System.out.println("ESTA VACIO TIPO");
		}
		return listaFiltrada;
	}
	public ArrayList<Habitacion> habitacionesDisponiblesFecha(ArrayList<Habitacion> listaPorFiltrar, Date fechaInicio,Date fechaFin) {
		ArrayList<Habitacion> listaFiltrada = new ArrayList<Habitacion>();

		for (Habitacion habitacion : listaPorFiltrar) {

			ArrayList<Date> fechasReservadas = habitacion.getFechasReservadas();
			boolean disponible = true;
			for (Date fecha : fechasReservadas) {
				if ((fecha.after(fechaInicio) || fecha.equals(fechaInicio)) && fecha.before(fechaFin)) {
					disponible = false;
					break;
				}
			}
			if (disponible) {
				listaFiltrada.add(habitacion);
			}
		}

		if (listaFiltrada.isEmpty()) {
			System.out.println("ESTA VACIO Date");
		}
		return listaFiltrada;
	}

	public ArrayList<Habitacion> habitacionesDisponiblesEspecificaciones(ArrayList<Habitacion> listaPorFiltrar, ArrayList<String> especificacionesBuscadas) {
		ArrayList<Habitacion> listaFiltrada = new ArrayList<Habitacion>();
		
		
		for(Habitacion habitacion: listaPorFiltrar) {
			
			ArrayList<String> caracteristicas = habitacion.getCaracteristicas();
			
			if (caracteristicas.containsAll(especificacionesBuscadas)) {
				listaFiltrada.add(habitacion);
		    }
			
		}
		
		
		
		if (listaFiltrada.isEmpty()) {
			System.out.println("ESTA VACIO especificaciones");
		}
		return listaFiltrada;
	}
    public ArrayList<Habitacion> asignarcuartos(ArrayList<Habitacion> listaDisponibilidadCuartos, int cantidadPersonas) {
		
    	ArrayList<Habitacion> cuartosAsignados = new ArrayList<Habitacion>();
	    int personasAsignadas = 0;
		
		
	    for (Habitacion habitacion : listaDisponibilidadCuartos) {
	    	int capacidad = habitacion.getCapacidad();
	        if (capacidad >= cantidadPersonas - personasAsignadas) {
	            cuartosAsignados.add(habitacion);
	            personasAsignadas += capacidad;
	            if (personasAsignadas >= cantidadPersonas) {
	                break;
	            }
	        }
	    }
	    
	    if (personasAsignadas < cantidadPersonas) {
	        cuartosAsignados.clear();
	        // o lanzar una excepción
	        System.out.println("NO ESTA ASIGNANDO TODAS LAS PEROSNAS CONTROLADOR HABITACIONES");
	    }
	    
	    return cuartosAsignados;
		
		
	}
}
	
