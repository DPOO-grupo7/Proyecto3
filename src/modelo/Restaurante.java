package modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Restaurante implements Serializable{
	private int rangoHorario;
	private ArrayList<String> menu;
	public Restaurante(int R, ArrayList<String> M) 
		{
		rangoHorario=R;
		menu=M;
		}
	public static void main(String [] args)
	{
		Object producto= crearproducto("arroz",15,false);
		
	}
	public int getrangohorario()
	{
		return rangoHorario;	
	}
	public ArrayList<String> getmenus()
	{
		return menu;
	}
	public static Object crearproducto(String nombre, double precio, boolean serviciocuarto)
	{
		Producto producto1 = new Producto(nombre,precio,serviciocuarto);
		String nombreproducto = producto1.getnombreprod();
		
		return producto1;

	}
	
}
