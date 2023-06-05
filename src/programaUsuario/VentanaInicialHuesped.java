package programaUsuario;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
import vista.VentanaPrincipal;



public class VentanaInicialHuesped extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static VentanaInicialHuesped Ventana;
	//private Autenticador Autenticador;
	//= new Autenticador();
	private JButton iniciar = new JButton("Iniciar Sesion");
	private JButton administrativo = new JButton("Administrativo");
	private Hotel hotel;


	public VentanaInicialHuesped(Hotel hotel)
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
		panelHSeleccionVistaHuesped panelHSeleccionVista = new panelHSeleccionVistaHuesped();
		JPanel Contenedor = new JPanel();

		panelHInformacionHuesped panelHInformacion = new panelHInformacionHuesped();
		panelHServiciosHuesped panelHServicios = new panelHServiciosHuesped();
		//restaurante.addActionListener(this);
		iniciar.addActionListener(this);
		administrativo.addActionListener(this);
		//panelHSeleccionVista.add(restaurante);
		panelHSeleccionVista.add(iniciar);
		panelHSeleccionVista.add(administrativo);
		Contenedor.setLayout(new GridLayout(1, 2, 0, 0));
		Contenedor.add(panelHInformacion);
		Contenedor.add(panelHServicios);
		add(panelHSeleccionVista, BorderLayout.NORTH);
		add(Contenedor, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                hotel.guardarHotel(); 
               
                dispose();
            }
        });

	}

	
	public static void main(String[] args) {
		
		Archivador archivador = new Archivador();
		
		Hotel hotel = null;
		hotel = archivador.cargarHotel();
		
		
		Ventana = new VentanaInicialHuesped(hotel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == iniciar) {
			new VentanaLogInUsuario(hotel);
			dispose();
		
	}
		else if (e.getSource() == administrativo) {
			new VentanaPrincipal(hotel);
			dispose();
		
	}
  }
}