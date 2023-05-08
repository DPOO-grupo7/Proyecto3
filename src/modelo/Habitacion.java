package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Habitacion {

	private int identificador;
	private int capacidad;
	private String ubicacion;
	private ArrayList<Date> fechasReservadas;
	private ArrayList<String> caracteristicas;
	private String tipo;

	public Habitacion(int pCapacidad, String pUbicacion, String pTipo, int identificacion) {
		identificador = identificacion;
		capacidad = pCapacidad;
		ubicacion = pUbicacion;
		fechasReservadas = new ArrayList<Date>();
		caracteristicas = new ArrayList<String>();
		tipo = pTipo;
	}

	public int getIdentificador() {
		return identificador;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getTipo() {
		return tipo;
	}

	public ArrayList<String> getCaracteristicas() {
		return caracteristicas;
	}

	public ArrayList<Date> getFechasReservadas() {
		return fechasReservadas;
	}

}
