package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelHSeleccionVista extends JPanel {
	private static final long serialVersionUID = 1L;
	String Nombre = "GRAN DPOO";

	public panelHSeleccionVista() {

		JLabel NombreHotel = new JLabel(Nombre);
		add(NombreHotel);
//		ImageIcon HotelDpoo = new ImageIcon("./data/HotelDpoo.jpg");
//		JLabel NombreHotel = new JLabel(HotelDpoo);

//		add(NombreHotel);
	}

	
}