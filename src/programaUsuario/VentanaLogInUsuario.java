package programaUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.ControladorHabitaciones;
import controlador.ManejadorReservas;
import controlador.ManejadorTarifa;
import modelo.Hotel;

import java.awt.*;

import utilidades.Autenticador;

public class VentanaLogInUsuario extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JPanel loginPanel;
	private JPanel imgPanel;
	private JPanel sur;
	private JPanel izq;
	private JPanel dere;
	private JButton registerButton;
	private Image dpo;
	private Hotel hotel;
	
	public VentanaLogInUsuario(Hotel hotel) {
		// Configurar el JFrame
		this.hotel = hotel;
		setTitle("Inicio de sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 250);
		setLocationRelativeTo(this); // Centrar la ventana en la pantalla
		setResizable(false);
		

		// Crear el panel de inicio de sesión
		imgPanel = new JPanel();
		loginPanel = new JPanel();
		sur = new JPanel();
		sur.setSize(500, 50);
		izq = new JPanel();
		izq.setSize(80, 250);
		dere = new JPanel();
		dere.setSize(80, 250);
		loginPanel.setLayout(new GridLayout(3, 2));

		dpo = new ImageIcon("./data/HotelDpoo.png").getImage();
		Icon icono = new ImageIcon(dpo);

		// Crear los componentes del panel
		JLabel titulo = new JLabel();
		titulo.setIcon(icono);
		imgPanel.add(titulo);

		JLabel usernameLabel = new JLabel("Usuario:");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(usernameLabel);

		usernameField = new JTextField();
		loginPanel.add(usernameField);

		JLabel passwordLabel = new JLabel("Contraseña:");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setSize(100, 30);
		loginPanel.add(passwordField);

		loginButton = new JButton("Iniciar sesión");
		loginButton.setBackground(Color.decode("#486c84"));
		loginButton.addActionListener(this);
		loginPanel.add(loginButton);

		registerButton = new JButton("Registrarse");
		registerButton.setBackground(Color.decode("#486c84"));
		registerButton.addActionListener(this);
		loginPanel.add(registerButton);

		loginPanel.setBackground(Color.decode("#a8c4d4"));
		imgPanel.setBackground(Color.decode("#a8c4d4"));
		dere.setBackground(Color.decode("#a8c4d4"));
		izq.setBackground(Color.decode("#a8c4d4"));
		sur.setBackground(Color.decode("#a8c4d4"));

		loginPanel.setMaximumSize(new Dimension(400, 200));
		// Agregar el panel al JFrame
		add(imgPanel, BorderLayout.NORTH);
		add(loginPanel, BorderLayout.CENTER);
		add(sur, BorderLayout.SOUTH);
		add(izq, BorderLayout.WEST);
		add(dere, BorderLayout.EAST);

		// Mostrar el JFrame
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = usernameField.getText();
		String password = new String(passwordField.getPassword());

		if (e.getSource() == loginButton)
		{
			String tipo = "";
			String[] botones = { "Recepcion", "Personal", "Admin" };
			int ventanaTipo = JOptionPane.showOptionDialog(null, "Elige un tipo", "Elegir Tipo de Personal",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
			if (ventanaTipo == 0) {
				tipo = "2";
			} else if (ventanaTipo == 1) {
				tipo = "3";
			}
			else if (ventanaTipo == 2) {
				tipo = "1";
			}
			if (this.hotel.iniciarSesion(tipo, username, password) == false) {
				JOptionPane.showMessageDialog(this, "Usuario o contraseña invalido.", "Error",
						JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Inicio exitoso.");
				if (tipo == "1") {
					System.out.println("perra1");
					//new VentanaAdmin(this.hotel);
					dispose();
				} else if (tipo  == "2") {
					//new VentanaRecepcion(hotel);
					dispose();
				} else if (tipo == "3") {
					//new VentanaEmpleados(hotel);
					dispose();
				}
			
			}
		}
			
		else if (e.getSource() == registerButton) {
			String tipo = "";
			String[] botones = { "Recepcion", "Personal", "Admin"};
			int ventanaTipo = JOptionPane.showOptionDialog(null, "Elige un tipo", "Elegir Tipo de Personal",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
			if (ventanaTipo == 0) {
				tipo = "2";
			} else if (ventanaTipo == 1) {
				tipo = "3";
			} else if (ventanaTipo == 2) {
				tipo = "1";
			}
			this.hotel.crearCuenta(tipo, username, password);;
			JOptionPane.showMessageDialog(this, "Registro exitoso.");

		}
	}

}