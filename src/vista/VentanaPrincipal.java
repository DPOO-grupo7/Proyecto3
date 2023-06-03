package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.ControladorHabitaciones;
import controlador.ManejadorReservas;
import controlador.ManejadorTarifa;
import modelo.Hotel;
import posterityKeeper.Archivador;
import utilidades.Autenticador;



public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private static VentanaPrincipal Ventana;
	private static final long serialVersionUID = 1L;
	//private Autenticador Autenticador;
	//= new Autenticador();
	private JButton iniciar = new JButton("Iniciar Sesion");
	private JButton restaurante = new JButton("Restaurante");
	private Hotel hotel;


	public VentanaPrincipal(Hotel hotel)
	{
		//this.Autenticador = hotel.getAutenticador();
		this.hotel = hotel;
		VentanaInformacionHotel();

		setSize(900, 650);
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
		restaurante.addActionListener(this);
		iniciar.addActionListener(this);
		panelHSeleccionVista.add(restaurante);
		panelHSeleccionVista.add(iniciar);
		Contenedor.setLayout(new GridLayout(1, 2, 0, 0));
		Contenedor.add(panelHInformacion);
		Contenedor.add(panelHServicios);
		add(panelHSeleccionVista, BorderLayout.NORTH);
		add(Contenedor, BorderLayout.CENTER);

	}

	
	public static void main(String[] args) {
		Autenticador autenticador = new Autenticador();
		Archivador archivador = new Archivador();
		String[] botones = {"Nuevo Hotel", "Continuar"};
		Hotel hotel = null;
		int opcion = JOptionPane.showOptionDialog(null, 
				"Elige una opción:", 
				"Crear o continuar con hotel", 
				JOptionPane.DEFAULT_OPTION, 
				JOptionPane.QUESTION_MESSAGE, null, 
				botones, botones[0]);
		if (opcion == 0)
		{
			hotel = new Hotel(archivador, true, true, true ,true ,true, true, true, autenticador);
		}
		else
		{
			hotel = archivador.cargarHotel();
		}
		
		Ventana = new VentanaPrincipal(hotel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == iniciar) {
			new LogIn(hotel);
			dispose();
		}
		if (e.getSource() == restaurante) {

			Ventana.getContentPane().removeAll();
			Ventana.revalidate();
			Ventana.repaint();
			Ventana.getContentPane().add(new VentanaRestaurante(), BorderLayout.CENTER);
			Ventana.revalidate();
			Ventana.repaint();

		}

	}
}