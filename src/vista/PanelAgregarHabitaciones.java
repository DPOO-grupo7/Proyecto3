package vista;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

import utilidades.Autenticador;

public class PanelAgregarHabitaciones extends JFrame {

	private JComboBox<String> Desplegable;
	private JButton TipoHabitacion;
	private JButton NumeroHabitacion;
	private JButton Tarifa;
	private JPanel izq;
	private JPanel dere;
	private JPanel arriba;
	private JPanel abajo;
	private JPanel centro;
	private Image dpo;
	
	
	
	
	public PanelAgregarHabitaciones()
	{
		dpo = new ImageIcon("./data/HotelDpoo.png").getImage();
        Icon icono = new ImageIcon(dpo);
		
        setLayout(new BorderLayout());
        
        
        izq = new JPanel();
        izq.setLayout(new GridLayout(5, 1));
        izq.add(new JButton("Botón 1"));
        izq.add(new JButton("Botón 2"));
        izq.add(new JButton("Botón 3"));
        izq.add(new JButton("Botón 4"));
        izq.add(new JButton("Botón 5"));
        
        
        centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
        centro.add(comboBox);
        JButton button = new JButton("Agregar Habitación");
        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedItem().equals("Opción 1")) {
                button.setEnabled(true);
            } else {
                button.setEnabled(false);
            }
        });
        centro.add(button);
        button.setEnabled(false);
        
        
        dere = new JPanel();
        dere.setLayout(new GridLayout(3, 1));
        dere.add(new JButton("Tipo de habitacion "));
        dere.add(new JButton("Numero de habitacion "));
        dere.add(new JButton("Tarifa"));
        
       
        arriba = new JPanel();
        arriba.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel titulo = new JLabel();
        titulo.setIcon(icono);
        arriba.add(titulo);
        
        
        abajo = new JPanel();
        
        centro.setBackground(Color.decode("#a8c4d4"));
        arriba.setBackground(Color.decode("#a8c4d4"));
        dere.setBackground(Color.decode("#a8c4d4"));
        izq.setBackground(Color.decode("#a8c4d4"));
        abajo.setBackground(Color.decode("#a8c4d4"));
        
        add(izq, BorderLayout.WEST);
        add(centro, BorderLayout.CENTER);
        add(dere, BorderLayout.EAST);
        add(arriba, BorderLayout.NORTH);
        add(abajo, BorderLayout.SOUTH);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Agregar Habitaciones");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    
	}
}
