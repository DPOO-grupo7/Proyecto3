package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

public class PanelReservasFormulario extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField fieldHuesped;
	private JComboBox<String> comboHabitaciones;
	private JSpinner spinnerFechaEntrada;
	private JSpinner spinnerFechaSalida;
	private JButton botonGuardar;

	public PanelReservasFormulario(String[] habitaciones) {
		setLayout(new GridLayout(5, 2));
		add(new JLabel("Huésped:"));
		fieldHuesped = new JTextField();
		add(fieldHuesped);
		add(new JLabel("Habitación:"));
		comboHabitaciones = new JComboBox<>(habitaciones);
		add(comboHabitaciones);
		add(new JLabel("Fecha de entrada:"));
		spinnerFechaEntrada = new JSpinner(new SpinnerDateModel());
		add(spinnerFechaEntrada);
		add(new JLabel("Fecha de salida:"));
		spinnerFechaSalida = new JSpinner(new SpinnerDateModel());
		add(spinnerFechaSalida);
		botonGuardar = new JButton("Guardar");
		add(new JLabel());
		add(botonGuardar);
	}

	public String getHuesped() {
		return fieldHuesped.getText();
	}

	public String getHabitacionSeleccionada() {
		return (String) comboHabitaciones.getSelectedItem();
	}

	public Date getFechaEntrada() {
		return (Date) spinnerFechaEntrada.getValue();
	}

	public Date getFechaSalida() {
		return (Date) spinnerFechaSalida.getValue();
	}

	public void setActionListener(ActionListener listener) {
		botonGuardar.addActionListener(listener);
	}
}
