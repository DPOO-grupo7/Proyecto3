package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal () {
		// TODO Auto-generated constructor stub
		VentanaInformacionHotel ();
		
		setSize(900, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("HotelGranDPOO");
	}

	public void VentanaInformacionHotel () {
		/* Esta funcion se llamara cuando se quiera mostrar la ventana principal
		 * 
		 * Se tiene inicialmente la parte de seleccion en un Panel
		 * y toda la informacion esta en Contenedor, en dos paneles diferentes
		 * */
		panelHSeleccionVista panelHSeleccionVista = new panelHSeleccionVista();
		JPanel Contenedor = new JPanel();
		
		panelHInformacion panelHInformacion = new panelHInformacion();
		panelHServicios panelHServicios = new panelHServicios();
		Contenedor.setLayout(new GridLayout(1,2,0,0));
		Contenedor.add(panelHInformacion);
		Contenedor.add(panelHServicios);
		
		add(panelHSeleccionVista, BorderLayout.NORTH);
		add(Contenedor, BorderLayout.CENTER);
		
		
	}
	
	public static void main(String[] args) {

		VentanaPrincipal ventana = new VentanaPrincipal();
		
	}
}
