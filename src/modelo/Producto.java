package modelo;

import java.io.Serializable;

public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombreprod;
	private double precioprod;
	private boolean serviciocuarto;
	
	public Producto(String N, double P, boolean S) {
		nombreprod= N;
		precioprod= P;
		serviciocuarto=S;
	}
	public String getnombreprod()
	{
		return nombreprod;
	}
	public double getprecioprod() 
	{
		return precioprod;
	}
	public boolean getserviciocuatro() 
	{
		return serviciocuarto;
	}
	public void setnombreprod(String nombre)
	{
		this.nombreprod = nombre;			
	}
	public void setprecioprod(double precioProducto) 
	{
		this.precioprod = precioProducto;
	}
	public void setserviciocuarto(boolean servicioCuarto)
	{
		this.serviciocuarto = servicioCuarto;
	}
}
	