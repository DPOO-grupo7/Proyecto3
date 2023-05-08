package vista;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class panelHServicios extends JPanel{
	 private static final long serialVersionUID = 1L;

	public panelHServicios() {

		// Esta ventana tiene 1 seccion

		// panel de ir a otras ventanas
		
		
		// servicios con su informacion
		JPanel InformacionServicios = new JPanel();
		
		add(InformacionServicios, BorderLayout.CENTER);
	}
}
