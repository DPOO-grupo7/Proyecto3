package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;


import controlador.ManejadorReservas;

import modelo.Hotel;
import programaUsuario.PanelHuespedCentro;

import java.awt.*;


public class VentanaRecepcion extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JButton botonFactura = new JButton();
	private JButton botonInventario = new JButton();
	private JButton botonInvTotal = new JButton();
	private JButton botonSalir = new JButton();
	private JButton botonReserva = new JButton();
	private JPanel izq;
	private JPanel dere;
	private JPanel arriba;
	private JPanel abajo;
	private JPanel centro;
	private Image dpo = new ImageIcon("./data/HotelDpooB.png").getImage();
	private Image factura = new ImageIcon("./data/factura.png").getImage();
	private Image inventario = new ImageIcon("./data/inventario.png").getImage();
	private Image cajas = new ImageIcon("./data/invtotal.png").getImage();
	private Image salir = new ImageIcon("./data/salir2.png").getImage();
	private Image reserva = new ImageIcon("./data/reserva.png").getImage();
	private Hotel hotel;
	private Date fechaIni = formatearFecha("01/01/2021");
    private Date fechaFin = formatearFecha("31/12/2040");


	
	public VentanaRecepcion(Hotel hotel)
	{
		this.hotel = hotel;
        Icon icono = new ImageIcon(dpo);
        Icon ticket = new ImageIcon(factura);
        Icon inventario = new ImageIcon(this.inventario);
        Icon cajas = new ImageIcon(this.cajas);
        Icon reserva = new ImageIcon(this.reserva);
        Icon out = new ImageIcon(salir);
        
		
        setLayout(new BorderLayout());
        
        this.botonFactura.setIcon(ticket);
        this.botonInventario.setIcon(inventario);
        this.botonSalir.setIcon(out);
        this.botonReserva.setIcon(reserva);
        this.botonInvTotal.setIcon(cajas);
        
        izq = new JPanel();
        izq.setLayout(new GridLayout(7, 1));
        izq.add(new JLabel());
        izq.add(botonFactura);
        izq.add(botonInventario);
        izq.add(botonInvTotal);
        izq.add(botonReserva);
        izq.add(botonSalir);
        izq.add(new JLabel());
        
        
         centro = new PanelReservasCentro("habitaciones", this, hotel, fechaIni, fechaFin);
        
        
        //dere = new PanelReservasFormulario();
        
        
       
        arriba = new JPanel();
        arriba.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel titulo = new JLabel();
        titulo.setIcon(icono);
        arriba.add(titulo);
        
        
        abajo = new JPanel();
        abajo.setSize(800, 200);
        JLabel espacio = new JLabel();
        abajo.add(espacio);
        
        botonFactura.addActionListener(this);
        botonReserva.addActionListener(this);
        botonInventario.addActionListener(this);
        botonInvTotal.addActionListener(this);
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
        setTitle("Ventana Recepcion");
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
    
        
        //IMPLEMENTAR ACTION LISTENER CON LAS FUNCIONES SIMILARES QUE HAY EN LA INTERFAZ
        //EN LA LINEA 265, Y 298. DE INTERFAZ.JAVA. 
        
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{


		if (e.getSource() == botonFactura)
		{
			
			remove(centro);
			//remove(dere);
			centro = new PanelFacturas();
			//dere = new PanelRecepDerecha("factura", this);
			add(centro, BorderLayout.CENTER);
			//add(dere, BorderLayout.EAST);
			revalidate();
			repaint();
		}
		else if (e.getSource() == botonInvTotal)
		{
			
			repintar("habitaciones");
			
		}
		else if (e.getSource() == botonReserva)
		{
			
			repintar("personal");
		}
		
		else if (e.getSource() == botonSalir)
		{
			hotel.guardarHotel();
			new VentanaPrincipal(this.hotel);
			dispose();
		}
		//else if (e.getSource() == dere.b)
	}
	public void repintar(String tipo) {
		remove(centro);
		centro = new PanelReservasCentro(tipo, this, hotel, this.fechaIni, this.fechaFin);
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
