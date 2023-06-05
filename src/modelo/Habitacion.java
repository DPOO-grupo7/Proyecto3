package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
	
	private static HashMap<String, Integer> preciosHabitaciones = new HashMap<>();


	public Habitacion(int pCapacidad, String pUbicacion, String pTipo, int identificacion,
			String tamanio, String cama, boolean ac, boolean heat, boolean tv, boolean cafe,
			boolean plancha, boolean ropa, boolean secador, boolean voltaje, boolean usba, boolean usbc,
			boolean desayuno, int precio) {
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
		this.precio = obtenerTarifa(tipo);
		
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
	public String getDatos() {
	    String cadena = String.format("ID: %2d  Capacidad: %-2d  Ubicacion: %-18s  Tipo: %-15s  Tamaño: %-6s  AC: %-3s  Calefacción: %-3s  Tamaño cama: %-8s  TV: %-3s  Cafetera: %-3s  Plancha: %-3s  Ropa De Cama: %-3s  Secador: %-3s  Voltaje: %-3s  USB-A: %-3s  USB-C: %-3s  Desayuno: %-3s  Precio: %-2d", 
	        identificador, capacidad, ubicacion, tipo, tamanio, aireAcondicionado ? "si" : "no", calefaccion ? "si" : "no", tamanioCama,
	        tv ? "si" : "no", cafetera ? "si" : "no", plancha ? "si" : "no", ropaDeCama ? "si" : "no", secador ? "si" : "no",
	        voltaje ? "si" : "no", USBA ? "si" : "no", USBC ? "si" : "no", desayuno ? "si" : "no", precio);
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

    public static int obtenerTarifa(String tipoHab) {
        return preciosHabitaciones.getOrDefault(tipoHab, 0);
    }

    public static void actualizarTarifa(String tipoHab, int tarifa) {
        preciosHabitaciones.put(tipoHab, tarifa);
    }
    
    
	
}
