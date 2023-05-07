package vista;


import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modelo.Reserva;

import java.awt.*;



public class test extends JFrame{
	
	
	public test()
	{
		setLayout(new BorderLayout());
		JPanel detail = new PanelReservaDetalle();
		JPanel form = new PanelReservasFormulario(new String[]{"1","3"});
		//JPanel lista = new PanelReservasLista(new Reserva(null, null, null, null, defaultCloseOperation));
		add(detail, BorderLayout.CENTER);
		add(form, BorderLayout.EAST);
		setVisible(true);
	}
}
