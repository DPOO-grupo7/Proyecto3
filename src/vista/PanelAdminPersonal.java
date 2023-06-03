package vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.Hotel;
import utilidades.Autenticador;

public class PanelAdminPersonal extends JPanel {

	private JLabel userLabel, passLabel;
    JTextField userField;
    JPasswordField passField;
    JButton addButton;
    private Hotel hotel;
	
	public PanelAdminPersonal(VentanaAdmin ventana, Hotel hotel)
	{
		setLayout(new GridLayout(6, 4)); // Establece el layout del panel
		
		
		//add(new JLabel());
        userLabel = new JLabel("Usuario: "); // Crea el label para el usuario
        add(userLabel); // Agrega el label al panel

        userField = new JTextField(20); // Crea el campo de texto para el usuario
        add(userField); // Agrega el campo de texto al panel

        add(new JLabel());
        
        add(new JLabel());
        
        passLabel = new JLabel("Contraseña: "); // Crea el label para la contraseña
        add(passLabel); // Agrega el label al panel

        passField = new JPasswordField(20); // Crea el campo de texto para la contraseña
        add(passField); // Agrega el campo de texto al panel
        
        
        
        add(new JLabel());
        add(new JLabel());
        add(new JLabel());
        addButton = new JButton("Agregar"); // Crea el botón de agregar
        add(addButton); // Agrega el botón al panel
        addButton.addActionListener(e -> {
        	String username = userField.getText();
    		String password = new String(passField.getPassword());
        	String tipo = "";
			String[] botones = { "Recepcion", "Personal","Admin" };
			int ventanaTipo = JOptionPane.showOptionDialog(null, "Elige un tipo", "Elegir Tipo de Personal",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
			if (ventanaTipo == 0) {
				tipo = "RECEPCIONISTA";
			} else if (ventanaTipo == 1) {
				tipo = "PERSONAL DEL HOTEL";
			} else if (ventanaTipo == 2) {
				tipo = "ADMINISTRADOR";
			}
			hotel.setUsuarios(username, password, tipo);
			JOptionPane.showMessageDialog(this, "Registro exitoso.");
            
        });
    
	}

	
}
