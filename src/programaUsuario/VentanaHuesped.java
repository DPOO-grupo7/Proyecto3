package programaUsuario;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controlador.ControladorHabitaciones;
import controlador.ManejadorReservas;
import controlador.ManejadorTarifa;
import modelo.Hotel;
import utilidades.Autenticador;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;

public class VentanaHuesped extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
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
	private Hotel hotel;
	private Date fechaIni = formatearFecha("01/01/2021");
    private Date fechaFin = formatearFecha("31/12/2040");
	

	public VentanaHuesped(Hotel hotel)
	{
		this.hotel = hotel;
		
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
		izq.setLayout(new GridLayout(7, 1));
		izq.add(new JLabel());
		izq.add(botonHabitaciones);
		izq.add(botonComida);
		izq.add(botonPersonal);
		izq.add(botonTarifa);
		izq.add(botonSalir);
		izq.add(new JLabel());

		//crear
		centro = new PanelHuespedCentro("habitaciones", this, hotel, fechaIni, fechaFin);

		//dere = new PanelAdminDerecha("habitaciones", this);

		arriba = new JPanel();
		arriba.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titulo = new JLabel();
		titulo.setIcon(icono);
		arriba.add(titulo);

		abajo = new JPanel();
		abajo.setSize(800, 200);
		JLabel espacio = new JLabel();
		abajo.add(espacio);

		botonComida.addActionListener(this);
		botonTarifa.addActionListener(this);
		botonPersonal.addActionListener(this);
		botonHabitaciones.addActionListener(this);
		botonSalir.addActionListener(this);

		arriba.setBackground(Color.decode("#f5f6fb"));
		//dere.setBackground(Color.decode("#f5f6fb"));
		izq.setBackground(Color.decode("#a8c4d4"));
		abajo.setBackground(Color.decode("#a8c4d4"));

		add(izq, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		//add(dere, BorderLayout.EAST);
		add(arriba, BorderLayout.NORTH);
		add(abajo, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Panel Admin");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                hotel.guardarHotel(); 
               
                dispose();
            }
        });

		// IMPLEMENTAR ACTION LISTENER CON LAS FUNCIONES SIMILARES QUE HAY EN LA
		// INTERFAZ
		// EN LA LINEA 265, Y 298. DE INTERFAZ.JAVA.

	}

	
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == botonComida) {

			repintar("servicios");
			
		}// else if (e.getSource() == botonPersonal) {
			//remove(centro);
			//remove(dere);
			//centro = new PanelAdminPersonal(this, hotel);
			//dere = new PanelAdminDerecha("personal", this);
			//add(centro, BorderLayout.CENTER);
			//add(dere, BorderLayout.EAST);
			//revalidate();
			//repaint();
		//}
		 else if (e.getSource() == botonHabitaciones) {

			repintar("habitaciones");

		} else if (e.getSource() == botonTarifa) {

			repintar("tarifa");
		}

		else if (e.getSource() == botonSalir) {
			new VentanaInicialHuesped(hotel);
			dispose();
		}
		// else if (e.getSource() == dere.b)
	}
	public void repintar(String tipo) {
		remove(centro);
		centro = new PanelHuespedCentro(tipo, this, hotel, this.fechaIni, this.fechaFin);
		add(centro, BorderLayout.CENTER);
		//add(dere, BorderLayout.EAST);
		revalidate();
		repaint();
	}
	
	public Date formatearFecha(String fechaTexto) {
		// esta va a ser usada para cuando se quiera buscar una fecha o reservar en esa
		// fecha.
//		un ejemplo de fechaTexto = "15/01/2023";
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formatoFecha.parse(fechaTexto);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return fecha;
	}
	
	public void setFechas(Date ini, Date end)
	{
		this.fechaIni = ini;
		this.fechaFin = end;
	}
}
