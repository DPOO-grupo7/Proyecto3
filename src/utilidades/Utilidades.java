package utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

	public Utilidades() {
		// TODO Auto-generated constructor stub
	}

	public Date formatearFecha(String fechaTexto) {
		// esta va a ser usada para cuando se quiera buscar una fecha o reservar en esa
		// fecha.
//		un ejemplo de fechaTexto = "15/01/2023";
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formatoFecha.parse(fechaTexto);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fecha;
	}

	public int[][] createGreenGrid() {
	    int[][] greenGrid = new int[12][50];

	    for (int row = 0; row < greenGrid.length; row++) {
	        for (int col = 0; col < greenGrid[row].length; col++) {
	            greenGrid[row][col] = 1; // El valor 1 indica el color verde en el array COLORS
	        }
	    }

	    return greenGrid;
	}

}
