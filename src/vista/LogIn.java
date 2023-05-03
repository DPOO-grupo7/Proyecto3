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
    private Autenticador Autenticador = new Autenticador();

    public LogIn() {
        // Configurar el JFrame
        setTitle("inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla

        // Crear el panel de inicio de sesión
        loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2, 10, 10));

        // Crear los componentes del panel
        JLabel usernameLabel = new JLabel("Nombre de usuario:");
        JLabel passwordLabel = new JLabel("Contraseña:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Iniciar sesión");
        loginButton.setBackground(Color.decode("#486c84"));
        //loginButton.setBorderPainted(false);
        loginButton.addActionListener(this);
        
        loginPanel.setBackground(Color.decode("#a8c4d4"));
        loginPanel.setMaximumSize(new Dimension(300, 100));
        // Agregar los componentes al panel
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);

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
        
        if (this.Autenticador.autenticar(username, password) == false)
        {
        	JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        	JOptionPane.showMessageDialog(this, "Login successful!");
        }
    	
    }

	
}
