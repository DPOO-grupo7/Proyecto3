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
		frame.setTitle("Hotel ddpo");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(1000, 800);
		frame.setResizable(true);

		JPanel izq = new JPanel();
		JPanel centro = new JPanel();
		JPanel dere = new JPanel();
		
		izq.setBackground(Color.decode("#a8c4d4"));
		izq.setPreferredSize(new Dimension (300,700));
		
		dere.setBackground(Color.decode("#a8c4d4"));
		dere.setPreferredSize(new Dimension (300,700));
	
		centro.setBackground(Color.decode("#a8c4d4"));
		centro.setPreferredSize(new Dimension (500, 700));
		centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
		
		
		this.usuario = new JTextField();
		usuario.setPreferredSize(new Dimension (200,50));
		this.contraseña = new JPasswordField();
		contraseña.setPreferredSize(new Dimension (200, 50));
		this.label = new JLabel("HOTEL DPO");
		this.iniciar = new JButton();
		iniciar.setPreferredSize(new Dimension(200,50));
		

		centro.add(Box.createVerticalGlue());
		centro.add(Box.createVerticalGlue());
		centro.add(label);
		centro.add(Box.createVerticalGlue());
		centro.add(Box.createVerticalGlue());
		centro.add(usuario);
		centro.add(Box.createVerticalGlue());
		centro.add(Box.createVerticalGlue());
		centro.add(contraseña);
		centro.add(Box.createVerticalGlue());
		centro.add(Box.createVerticalGlue());
		centro.add(Box.createHorizontalGlue());
		centro.add(iniciar);
		centro.add(Box.createVerticalGlue());
		centro.add(Box.createVerticalGlue());
		centro.setAlignmentY(Component.CENTER_ALIGNMENT);
		centro.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		frame.add(izq, BorderLayout.WEST);
		frame.add(centro, BorderLayout.CENTER);
		frame.add(dere, BorderLayout.EAST);
		frame.setVisible(true);
		centro.setVisible(true);
	}
}