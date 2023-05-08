package vista;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import utilidades.Autenticador;

import java.awt.*;

public class VentanaEmpleados extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton botonConsumo = new JButton();
	private JButton botonSalir = new JButton();
	private JButton botonPagar = new JButton();
	private JPanel izq;
	private JPanel dere;
	private JPanel arriba;
	private JPanel abajo;
	private JPanel centro;
	private Image dpo = new ImageIcon("./data/HotelDpooB.png").getImage();
	private Image consume = new ImageIcon("./data/consumo.png").getImage();
	private Image pay = new ImageIcon("./data/pagar.png").getImage();
	private Image salir = new ImageIcon("./data/salir2.png").getImage();
	private Autenticador autenticador;

	public VentanaEmpleados(Autenticador autenticador) {

		this.autenticador = autenticador;
		Icon icono = new ImageIcon(dpo);
		Icon consumo = new ImageIcon(consume);
		Icon pagar = new ImageIcon(pay);
		Icon out = new ImageIcon(salir);

		setLayout(new BorderLayout());

		this.botonConsumo.setIcon(consumo);
		this.botonPagar.setIcon(pagar);
		this.botonSalir.setIcon(out);

		izq = new JPanel();
		izq.setLayout(new GridLayout(7, 1));
		izq.add(new JLabel());
		izq.add(botonConsumo);
		izq.add(botonPagar);
		izq.add(botonSalir);
		izq.add(new JLabel());

		centro = new PanelAgregarConsumo(new String[] { "1", "3" });
		// dere = new PanelEmpDerecha("habitaciones", this);

		//

		arriba = new JPanel();
		arriba.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titulo = new JLabel();
		titulo.setIcon(icono);
		arriba.add(titulo);

		abajo = new JPanel();
		abajo.setSize(800, 200);
		JLabel espacio = new JLabel();
		abajo.add(espacio);

		botonConsumo.addActionListener(this);
		botonPagar.addActionListener(this);
		botonSalir.addActionListener(this);

		arriba.setBackground(Color.decode("#f5f6fb"));
		// dere.setBackground(Color.decode("#f5f6fb"));
		izq.setBackground(Color.decode("#a8c4d4"));
		abajo.setBackground(Color.decode("#a8c4d4"));

		add(izq, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		// add(dere, BorderLayout.EAST);
		add(arriba, BorderLayout.NORTH);
		add(abajo, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Panel Empleados");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setVisible(true);

		// IMPLEMENTAR ACTION LISTENER CON LAS FUNCIONES SIMILARES QUE HAY EN LA
		// INTERFAZ
		// EN LA LINEA 265, Y 298. DE INTERFAZ.JAVA.

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botonConsumo) {

			remove(centro);
			// remove(dere);
			centro = new PanelAgregarConsumo(new String[] { "1", "3" });
			// dere = new PanelEmpDerecha("servicios", this);
			add(centro, BorderLayout.CENTER);
			// add(dere, BorderLayout.EAST);
			revalidate();
			repaint();
		} else if (e.getSource() == botonPagar) {

			remove(centro);
			// remove(dere);
			centro = new PanelFacturas();
			// dere = new PanelEmpDerecha("personal", this);
			add(centro, BorderLayout.CENTER);
			// add(dere, BorderLayout.EAST);
			revalidate();
			repaint();
		}

		else if (e.getSource() == botonSalir) {
			new LogIn(autenticador);
			dispose();
		}
		// else if (e.getSource() == dere.b)
	}

	public JPanel getDere() {
		return dere;
	}

	public void setDere(JPanel dere) {
		this.dere = dere;
	}
}
