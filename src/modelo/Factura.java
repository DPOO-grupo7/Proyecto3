package modelo;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class Factura implements Serializable{
	
	
	
	
	private static final long serialVersionUID = 1L;
	private String numeroFactura;
	private String fecha;
	private String huesped;
	private String idHabitacion;
	private String tipoConsumo;
	private Boolean estaPagado;
	private int total;
	
	
	public Factura(String nf, String fecha, String nombreh,String idhab,String tipo,Boolean pagado) {
		
		
		this.fecha = fecha;
		this.tipoConsumo = tipo;
		this.huesped = nombreh;
		this.idHabitacion = idhab;
		this.numeroFactura = nf;
		
		this.estaPagado = pagado;
		this.total = 0;
}
	
	public String getFecha() {return fecha;}
	public String getHuesped() {return huesped;}
	public String getidHabitacion() {return idHabitacion;}
	public String getnumeroFactura() {return numeroFactura;}
	public int getcosto() {return total;}
	public Boolean getpagado() {return estaPagado;}
	public String gettipoConsumo() {return tipoConsumo;}
	
	
	
	
	
	
	

}
