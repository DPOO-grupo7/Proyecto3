package vista;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame{
	
	JFrame frame;
	JTextField usuario;
	JPasswordField contraseña;
	JLabel label;
	ImageIcon hoteldpo;
	JButton iniciar;
	

	public LogIn() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Hotel ddpo");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(800, 700);
		frame.setResizable(true);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(Color.decode("#a8c4d4"));
		
		this.usuario = new JTextField();
		usuario.setPreferredSize(new Dimension (60, 100));
		this.contraseña = new JPasswordField();
		this.label = new JLabel("hi");
		this.hoteldpo = new ImageIcon("./imagenes/Foto Dpoo.png");
		label.setIcon(this.hoteldpo);
		this.iniciar = new JButton();
		

		panel.add(Box.createVerticalGlue());
		panel.add(label);
		panel.add(Box.createVerticalGlue());
		panel.add(usuario);
		panel.add(Box.createVerticalGlue());
		panel.add(contraseña);
		panel.add(Box.createVerticalGlue());
		panel.add(iniciar);
		panel.add(Box.createVerticalGlue());
		panel.setAlignmentY(CENTER_ALIGNMENT);
		panel.setAlignmentX(CENTER_ALIGNMENT);
		panel.setVisible(true);
		frame.add(panel);
	}
}