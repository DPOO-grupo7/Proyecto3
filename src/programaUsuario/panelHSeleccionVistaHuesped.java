package programaUsuario;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelHSeleccionVistaHuesped extends JPanel {
	private static final long serialVersionUID = 1L;
	String Nombre = "GRAN DPOO";

	public panelHSeleccionVistaHuesped() {

		JLabel NombreHotel = new JLabel(Nombre);
		add(NombreHotel);
//		ImageIcon HotelDpoo = new ImageIcon("./data/HotelDpoo.jpg");
//		JLabel NombreHotel = new JLabel(HotelDpoo);

//		add(NombreHotel);
	}

	
}