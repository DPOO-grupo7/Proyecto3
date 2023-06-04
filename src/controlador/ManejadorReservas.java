package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Habitacion;
import modelo.InformadorHuesped;
import modelo.Reserva;

public class ManejadorReservas implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Reserva> LISTA_RESERVA = new ArrayList<Reserva>();
	private ArrayList<Reserva> ListaHuespedes = new ArrayList<Reserva>();
	private Reserva reservaenProceso;
	private InformadorHuesped huespedAcargo;
	private ArrayList<InformadorHuesped> grupoHuespedes;
	private Date fechaInicio;
	private Date fechaFin;
	@SuppressWarnings("unused")
	private List<String> especificaciones;
	private String tipoHabitacion;
	private int tarifa;
	private ArrayList<Habitacion> numHabitaciones;
	private int cntMenores;

	public ManejadorReservas() {

	}

	public void inicioProceso(InformadorHuesped pHuespedAcargo, Date pFechainicio, Date pFechaFin,
			ArrayList<String> pEspecificaciones, String tipohabitacion, ArrayList<Habitacion> pNumHabitaciones) {
		huespedAcargo = pHuespedAcargo;
		setEspecificaciones(pEspecificaciones);
		fechaInicio = pFechainicio;
		fechaFin = pFechaFin;
		setTipohabitacion(tipohabitacion);
		numHabitaciones = pNumHabitaciones;
	}
	
	public void inicioProceso2(InformadorHuesped pHuespedAcargo, Date pFechainicio, Date pFechaFin,
			ArrayList<Habitacion> pNumHabitaciones) {
		huespedAcargo = pHuespedAcargo;
		fechaInicio = pFechainicio;
		fechaFin = pFechaFin;
		numHabitaciones = pNumHabitaciones;
	}
	

	public void setEspecificaciones(List<String> especificaciones) {
		this.especificaciones = especificaciones;
	}

	public void setTipohabitacion(String pTipoHabitacion) {
		setTipoHabitacion(pTipoHabitacion);
	}

	public void setGrupoHuespedes(ArrayList<InformadorHuesped> pGrupoHuespedes) {
		grupoHuespedes = pGrupoHuespedes;
	}

	public Reserva AsignarReserva() {
		// despues de confirmar se asigna a
		// la reserva
		int identificador = LISTA_RESERVA.size() + 1;
		reservaenProceso = new Reserva(huespedAcargo, fechaInicio, fechaFin, numHabitaciones, identificador, false);

		reservaenProceso.setGrupoHuespedes(getGrupoHuespedes());
		reservaenProceso.setNumPersonas();
		LISTA_RESERVA.add(reservaenProceso);

		return reservaenProceso;
	}

	public ArrayList<InformadorHuesped> getGrupoHuespedes() {
		return grupoHuespedes;
	}

	public ArrayList<Reserva> getListaReservas() {
		return LISTA_RESERVA;
	}

	public ArrayList<Reserva> getListaHuespedes() {
		return ListaHuespedes;
	}

	public void setListaHuespedes(ArrayList<Reserva> listaHuespedes) {
		ListaHuespedes = listaHuespedes;
	}

	public int getCntMenores() {
		return cntMenores;
	}

	public void setCntMenores(int cntMenores) {
		this.cntMenores = cntMenores;
	}

	public int getTarifa() {
		return tarifa;
	}

	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(String tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public Reserva encontrarReserva(int id) {

		Reserva buscada=null;
		for (Reserva reserva : LISTA_RESERVA) {
			if (reserva.getIdentificacion() == id) {
				return reserva;

			}

		}
		return buscada;
	}
}
