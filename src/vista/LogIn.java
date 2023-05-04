package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import utilidades.Autenticador;

public class LogIn extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JPanel loginPanel;
    private JPanel imgPanel;
    private JButton registerButton;
    private Image dpo;
    private Autenticador Autenticador = new Autenticador();

    public LogIn() {
        // Configurar el JFrame
        setTitle("Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(this); // Centrar la ventana en la pantalla
        setResizable(false);

        // Crear el panel de inicio de sesión
        imgPanel = new JPanel();
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        
        dpo = new ImageIcon("./data/HotelDpoo.png").getImage();
        Icon icono = new ImageIcon(dpo);
        
        
        // Crear los componentes del panel
        JLabel titulo = new JLabel();
        titulo.setIcon(icono);
        imgPanel.add(titulo);
        
        JLabel usernameLabel = new JLabel("Usuario:");
        usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
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
        loginPanel.setMaximumSize(new Dimension(300, 100));
        // Agregar el panel al JFrame
        add(imgPanel, BorderLayout.NORTH);
        add(loginPanel, BorderLayout.CENTER);

        
        // Mostrar el JFrame
        setVisible(true);
     
    }
    
    @Override
    public void actionPerformed (ActionEvent e )
    {
    	String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        if (e.getSource() == loginButton)
        
	        if (this.Autenticador.autenticar(username, password) == false)
	        {
	        	JOptionPane.showMessageDialog(this, "Usuario o contraseña invalido.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(this, "Inicio exitoso.");
        }
        else if (e.getSource() == registerButton)
        {
        	String tipo = "";
        	String[] botones = {"Recepcion", "Personal"};
        	int ventanaTipo = JOptionPane.showOptionDialog(null, "Elige un tipo", "Elegir Tipo de Personal",JOptionPane.DEFAULT_OPTION, 
					JOptionPane.QUESTION_MESSAGE, null,  botones, botones[0]);
        	if (ventanaTipo == 0)
        	{
        		tipo = "RECEPCIONISTA";
        	}
        	else if (ventanaTipo == 1)
        	{
        		tipo = "PERSONAL DEL HOTEL";
        	}
        	this.Autenticador.setUsuarios(username, password, tipo);
        	JOptionPane.showMessageDialog(this, "Registro exitoso.");
        	
        }
    }

	
}
