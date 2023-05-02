package vista;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelHSeleccionVista extends JPanel {
	String Nombre = "GRAN DPOO";

	public panelHSeleccionVista() {
		
		JLabel NombreHotel = new JLabel(Nombre);
		add(NombreHotel);
	}

}
