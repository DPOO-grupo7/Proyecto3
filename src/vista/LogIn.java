package vista;

import java.awt.Color;
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
    private JButton registerButton;
    private Autenticador Autenticador = new Autenticador();

    public LogIn() {
        // Configurar el JFrame
        setTitle("Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear el panel de inicio de sesión
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        

        // Crear los componentes del panel
        JLabel usernameLabel = new JLabel("Usuario:");
        loginPanel.add(usernameLabel);

        usernameField = new JTextField();
        loginPanel.add(usernameField);

        JLabel passwordLabel = new JLabel("Contraseña:");
        loginPanel.add(passwordLabel);

        passwordField = new JPasswordField();
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
        loginPanel.setMaximumSize(new Dimension(300, 100));
        // Agregar el panel al JFrame
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
	        	JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(this, "Login successful!");
        }
        else if (e.getSource() == registerButton)
        {
        	
        }
    }

	
}
