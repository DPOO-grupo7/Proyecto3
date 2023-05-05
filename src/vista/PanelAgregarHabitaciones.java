package vista;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;


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
		dpo = new ImageIcon("./data/HotelDpooB.png").getImage();
        Icon icono = new ImageIcon(dpo);
		
        setLayout(new BorderLayout());
        
        
        izq = new JPanel();
        izq.setLayout(new GridLayout(5, 1));
        izq.add(new JButton());
        izq.add(new JButton());
        izq.add(new JButton());
        izq.add(new JButton());
        izq.add(new JButton());
        
        
        centro = new JPanel();
        centro.setLayout(new GridLayout(6 ,1 ));
        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
        centro.add(comboBox);
        centro.add(new JLabel());
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
        dere.setLayout(new GridLayout(6, 1));
        //dere.add(new JLabel());
        dere.add(new JButton("Tipo de habitacion "));
        dere.add(new JLabel());
        dere.add(new JButton("Numero de habitacion "));
        dere.add(new JLabel());
        dere.add(new JButton("Tarifa"));
        dere.add(new JLabel());
        
       
        arriba = new JPanel();
        arriba.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel titulo = new JLabel();
        titulo.setIcon(icono);
        arriba.add(titulo);
        
        
        abajo = new JPanel();
        JLabel espacio = new JLabel();
        abajo.add(espacio);
        
        
        centro.setBackground(Color.decode("#f5f6fb"));
        arriba.setBackground(Color.decode("#f5f6fb"));
        dere.setBackground(Color.decode("#f5f6fb"));
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
