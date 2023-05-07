package vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import utilidades.Autenticador;

public class VentanaPrincipal extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Autenticador Autenticador = new Autenticador();
	private JButton iniciar = new JButton("Iniciar Sesion");
	public VentanaPrincipal() {
		// TODO Auto-generated constructor stub
		VentanaInformacionHotel();

		setSize(900, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("HotelGranDPOO");
	}

	public void VentanaInformacionHotel() {
		/*
		 * Esta funcion se llamara cuando se quiera mostrar la ventana principal
		 * 
		 * Se tiene inicialmente la parte de seleccion en un Panel y toda la informacion
		 * esta en Contenedor, en dos paneles diferentes
		 */
		panelHSeleccionVista panelHSeleccionVista = new panelHSeleccionVista();
		JPanel Contenedor = new JPanel();

		panelHInformacion panelHInformacion = new panelHInformacion();
		panelHServicios panelHServicios = new panelHServicios();
		iniciar.addActionListener(this);
		panelHServicios.add(iniciar);
		Contenedor.setLayout(new GridLayout(1, 2, 0, 0));
		Contenedor.add(panelHInformacion);
		Contenedor.add(panelHServicios);
		add(panelHSeleccionVista, BorderLayout.NORTH);
		add(Contenedor, BorderLayout.CENTER);

	}

	public static void main(String[] args) {

		new VentanaPrincipal();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == iniciar)
		{
			new LogIn(Autenticador);
			dispose();
		}

	}
}
