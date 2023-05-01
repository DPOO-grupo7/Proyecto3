package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Habitacion;
import modelo.InformadorHuesped;
import modelo.Reserva;



public class ManejadorReservas implements Serializable{
	private ArrayList<Reserva> LISTA_RESERVA = new ArrayList<Reserva>();
	private Reserva reservaenProceso;
	private InformadorHuesped huespedAcargo;
	private ArrayList<InformadorHuesped> grupoHuespedes;
	private Date fechaInicio;
	private Date fechaFin;
	private List<String> especificaciones;
	private String tipoHabitacion;
	private int tarifa;
	private ArrayList<Habitacion> numHabitaciones;
	private int cntMenores;

	public ManejadorReservas() {
		InformadorHuesped.crearListaHuespedes();
		
	}

	public void inicioProceso(InformadorHuesped pHuespedAcargo, Date pFechainicio, Date pFechaFin,ArrayList<String> pEspecificaciones, String tipohabitacion, ArrayList<Habitacion> pNumHabitaciones) {
		// TODO Auto-generated constructor stub
		huespedAcargo = pHuespedAcargo;

		setEspecificaciones(pEspecificaciones);
		fechaInicio = pFechainicio;
		fechaFin = pFechaFin;
		setTipohabitacion(tipohabitacion);
		numHabitaciones = pNumHabitaciones;
	}
	public void setEspecificaciones(List<String> especificaciones) {
		this.especificaciones = especificaciones;
	}
	public void setTipohabitacion(String pTipoHabitacion) {
		tipoHabitacion = pTipoHabitacion;
	}
	public void setGrupoHuespedes(ArrayList<InformadorHuesped> pGrupoHuespedes) {
		grupoHuespedes = pGrupoHuespedes;
	}
	public Reserva AsignarReserva() {
		// despues de confirmar se asigna a
		// la reserva
		int identificador = LISTA_RESERVA.size() + 1;
		reservaenProceso = new Reserva(huespedAcargo, fechaInicio,fechaFin, numHabitaciones,identificador);
		
		reservaenProceso.setGrupoHuespedes(getGrupoHuespedes());
		reservaenProceso.setNumPersonas();
		LISTA_RESERVA.add(reservaenProceso);
		
		return reservaenProceso;
	}
	public ArrayList<InformadorHuesped> getGrupoHuespedes() {
		return grupoHuespedes;
	}
	
}
