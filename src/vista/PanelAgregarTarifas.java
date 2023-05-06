package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;


//PENDIENTE ARREGLAR QUE SEA DE TARIFAS, POR EL MOMENTO SE VE IGUAL A LA DE HABITACIONES

public class PanelAgregarTarifas extends JFrame {

	private JComboBox<String> Desplegable;
	private JButton botonComida = new JButton();
	private JButton botonHabitaciones = new JButton();
	private JButton botonTarifa = new JButton();
	private JButton botonSalir = new JButton();
	private JButton botonPersonal = new JButton();
	private JPanel izq;
	private JPanel dere;
	private JPanel arriba;
	private JPanel abajo;
	private JPanel centro;
	private Image dpo = new ImageIcon("./data/HotelDpooB.png").getImage();
	private Image comida = new ImageIcon("./data/comida.png").getImage();
	private Image personas = new ImageIcon("./data/personal2.png").getImage();
	private Image tarifa = new ImageIcon("./data/tarifa.png").getImage();
	private Image salir = new ImageIcon("./data/salir2.png").getImage();
	private Image puerta = new ImageIcon("./data/habitacion.png").getImage();
	
	
	public PanelAgregarTarifas()
	{
		
        Icon icono = new ImageIcon(dpo);
        Icon food = new ImageIcon(comida);
        Icon people = new ImageIcon(personas);
        Icon door = new ImageIcon(puerta);
        Icon price = new ImageIcon(tarifa);
        Icon out = new ImageIcon(salir);
        
		
        setLayout(new BorderLayout());
        
        this.botonComida.setIcon(food);
        this.botonPersonal.setIcon(people);
        this.botonSalir.setIcon(out);
        this.botonTarifa.setIcon(price);
        this.botonHabitaciones.setIcon(door);
        
        izq = new JPanel();
        izq.setLayout(new GridLayout(5, 1));
        izq.add(botonHabitaciones);
        izq.add(botonComida);
        izq.add(botonPersonal);
        izq.add(botonTarifa);
        izq.add(botonSalir);
        
        
        centro = new JPanel();
        centro.setLayout(new GridLayout(6 ,3 ));
        
        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
        //1
        centro.add(new JLabel());
        centro.add(comboBox);
        centro.add(new JLabel());
        //2
        centro.add(new JLabel());
        centro.add(new JLabel());
        centro.add(new JLabel());
        
        JButton button = new JButton("Agregar Habitación");
        comboBox.addActionListener(e -> {
            if (comboBox.getSelectedItem().equals("Opción 1")) {
                button.setEnabled(true);
            } else {
                button.setEnabled(false);
            }
        });
        //3
        centro.add(new JLabel());
        centro.add(new JLabel());
        centro.add(new JLabel());
        
        centro.add(button);
        centro.add(new JLabel());
        centro.add(new JLabel());
        
        centro.add(new JLabel());
        centro.add(new JLabel());
        centro.add(new JLabel());

        centro.add(new JLabel());
        centro.add(new JLabel());
        centro.add(new JLabel());
        
        centro.add(new JLabel());
        centro.add(new JLabel());
        centro.add(new JLabel());
        
        centro.add(new JLabel());
        centro.add(new JLabel());
        centro.add(new JLabel());
        
     
        button.setEnabled(false);
        
        
        dere = new JPanel();
        dere.setLayout(new GridLayout(8, 1));
        //dere.add(new JLabel());
        dere.add(new JButton("Tipo de habitacion "));
        dere.add(new JLabel());
        dere.add(new JButton("Numero de habitacion "));
        dere.add(new JLabel());
        dere.add(new JButton("Tarifa"));
        dere.add(new JLabel());
        dere.add(new JButton("Guardar"));
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
