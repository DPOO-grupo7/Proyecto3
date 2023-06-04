package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Reserva implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private InformadorHuesped huespedAcargo;
	private ArrayList<InformadorHuesped> grupoHuespedes;
	private int numPersonas;
	private Date fechaLlegada;
	private Date fechaSalida;
	private ArrayList<Habitacion> numHabitaciones;
	private int identificacion;
	private int facturacion = 0;
	private boolean enUso;
	private boolean pagada;

	public Reserva(InformadorHuesped pHuespedAcargo, Date pFechaLlegada, Date pFechaSalida,
			ArrayList<Habitacion> pNumHabitaciones, int identificador, boolean pagada) {
		huespedAcargo = pHuespedAcargo;
		grupoHuespedes = new ArrayList<InformadorHuesped>();
		grupoHuespedes.add(huespedAcargo);
		fechaLlegada = pFechaLlegada;
		fechaSalida = pFechaSalida;
		numHabitaciones = pNumHabitaciones;
		identificacion = identificador;
		setEnUso(false);
		this.pagada = false;
	}

	public void setGrupoHuespedes(ArrayList<InformadorHuesped> pGrupoHuespedes) {
		grupoHuespedes.addAll(pGrupoHuespedes);
	}

	public void setNumPersonas() {
		numPersonas = grupoHuespedes.size();
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public ArrayList<Habitacion> getNumHabitaciones() {
		return numHabitaciones;
	}

	public int getIdentificacion() {
		return identificacion;
	}

	public InformadorHuesped getHuesped() {
		// TODO Auto-generated method stub
		return this.huespedAcargo;
	}

	public int getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(int facturacion) {
		this.facturacion = facturacion;
	}

	public boolean isEnUso() {
		return enUso;
	}
	
	public boolean setPagado(boolean pago) {
		return pagada;
	}

	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}
}
