package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Habitacion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int identificador;
	private int capacidad;
	private String ubicacion;
	private ArrayList<Date> fechasReservadas;
	private ArrayList<String> caracteristicas;
	private String tipo;
	private String tamanio;
	private boolean aireAcondicionado;
	private boolean calefaccion;
	private String tamanioCama;
	private boolean tv;
	private boolean cafetera;
	private boolean plancha;
	private boolean ropaDeCama;
	private boolean secador;
	private boolean voltaje;
	private boolean USBA;
	private boolean USBC;
	private boolean desayuno;
	private int precio = 0;

	public Habitacion(int pCapacidad, String pUbicacion, String pTipo, int identificacion,
			String tamanio, String cama, boolean ac, boolean heat, boolean tv, boolean cafe,
			boolean plancha, boolean ropa, boolean secador, boolean voltaje, boolean usba, boolean usbc,
			boolean desayuno) {
		identificador = identificacion;
		capacidad = pCapacidad;
		ubicacion = pUbicacion;
		fechasReservadas = new ArrayList<Date>();
		caracteristicas = new ArrayList<String>();
		tipo = pTipo;
		this.tamanio = tamanio;
		this.aireAcondicionado = ac;
		this.calefaccion = heat;
		this.tamanioCama = cama;
		this.tv = tv;
		this.cafetera = cafe;
		this.plancha = plancha;
		this.ropaDeCama = ropa;
		this.secador = secador;
		this.voltaje = voltaje;
		this.USBA = usba;
		this.USBC = usbc;
		this.desayuno = desayuno;
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
	
	public void setFechasReservadas(Date date1, Date date2)
	{
		this.fechasReservadas.add(date1);
		this.fechasReservadas.add(date2);
	}

	public ArrayList<String> getCaracteristicas() {
		return caracteristicas;
	}

	public ArrayList<Date> getFechasReservadas() {
		return fechasReservadas;
	}
	public String getDatos()
	{
		String cadena = "ID: "+this.identificador+" Capacidad: "+this.capacidad+" Ubicacion: "+this.ubicacion+ " Tipo: "
		+tipo + "Tamaño: "+this.tamanio+ "AC: "+this.aireAcondicionado+ "Calefacción: "+this.calefaccion + "Tamaño cama: "+this.tamanioCama + "TV: "+this.tv+
		"Cafetera: "+this.cafetera+ "Plancha: "+this.plancha+ "Ropa De Cama: "+this.ropaDeCama+ "Secador: "+this.secador+ "Voltaje: "+this.voltaje+ "USB-A: "+this.USBA+
		"USB-C: "+this.USBC+ "Desayuno: "+this.desayuno;
		return cadena;
	}

	public String getTamanio() {
		return tamanio;
	}

	public boolean isAireAcondicionado() {
		return aireAcondicionado;
	}

	public boolean isCalefaccion() {
		return calefaccion;
	}

	public String getTamanioCama() {
		return tamanioCama;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isTv() {
		return tv;
	}

	public boolean isCafetera() {
		return cafetera;
	}

	public boolean isPlancha() {
		return plancha;
	}

	public boolean isRopaDeCama() {
		return ropaDeCama;
	}

	public boolean isSecador() {
		return secador;
	}

	public boolean isVoltaje() {
		return voltaje;
	}

	public boolean isUSBA() {
		return USBA;
	}

	public boolean isUSBC() {
		return USBC;
	}

	public boolean isDesayuno() {
		return desayuno;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	
}
