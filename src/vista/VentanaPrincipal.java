package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.ControladorHabitaciones;
import controlador.ManejadorReservas;
import controlador.ManejadorTarifa;
import utilidades.Autenticador;



public class VentanaPrincipal extends JFrame implements ActionListener {
	
	private static VentanaPrincipal Ventana;
	private static final long serialVersionUID = 1L;
	private Autenticador Autenticador;
	//= new Autenticador();
	private JButton iniciar = new JButton("Iniciar Sesion");
	private JButton restaurante = new JButton("Restaurante");
	private ControladorHabitaciones controlHabitaciones;
	private ManejadorReservas reservas;
	private ManejadorTarifa tarifas;

	public VentanaPrincipal(Autenticador Autenticador, ControladorHabitaciones controlHabitaciones, ManejadorReservas reservas, ManejadorTarifa tarifas) {
		// TODO Auto-generated constructor stub
		this.Autenticador = Autenticador;
		this.controlHabitaciones = controlHabitaciones;
		this.reservas = reservas;
		this.tarifas = tarifas;
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
		Autenticador inicio = new Autenticador();
		ControladorHabitaciones controlHabitaciones = new ControladorHabitaciones();
		ManejadorReservas reservas = new ManejadorReservas();
		ManejadorTarifa tarifas = new ManejadorTarifa();
		Ventana = new VentanaPrincipal(inicio, controlHabitaciones, reservas, tarifas);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == iniciar) {
			new LogIn(Autenticador,  controlHabitaciones,  reservas,  tarifas);
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