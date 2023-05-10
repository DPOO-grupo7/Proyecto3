package modelo;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Consumo {
	
	private String identificadorHabitacion;
	private String tipoServicio;
	private int costoServicio;
	private Boolean estaPago;
	
	public Consumo(String id, String serv,int cs,Boolean ep) {
		this.identificadorHabitacion = id;
		this.tipoServicio = serv;
		this.costoServicio = cs;
		this.estaPago = ep;
	}
	
	public int getCostoServicio() {
		return costoServicio;
	}
	public String getdidentifiacodrHabitacion() {
		return identificadorHabitacion;
	}
	public String gettipoServicio() {
		return tipoServicio;
	}
	public Boolean getEstaPago() {
		return estaPago;
	}

}
