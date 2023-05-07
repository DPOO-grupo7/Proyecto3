package vista;

import javax.swing.*;

import modelo.Reserva;

import java.awt.*;

public class PanelReservaDetalle extends JPanel {
    private static final long serialVersionUID = 1L;
	private JLabel labelHuesped;
    private JLabel labelHabitacion;
    private JLabel labelFechaEntrada;
    private JLabel labelFechaSalida;

    public PanelReservaDetalle() {
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Huésped:"));
        labelHuesped = new JLabel();
        add(labelHuesped);
        add(new JLabel("Habitación:"));
        labelHabitacion = new JLabel();
        add(labelHabitacion);
        add(new JLabel("Fecha de entrada:"));
        labelFechaEntrada = new JLabel();
        add(labelFechaEntrada);
        add(new JLabel("Fecha de salida:"));
        labelFechaSalida = new JLabel();
        add(labelFechaSalida);
    }

    public void mostrarReserva(Reserva reserva) {
        labelHuesped.setText(reserva.getHuesped().toString());
        //labelHabitacion.setText(reserva.getHabitacion());
        labelFechaEntrada.setText(reserva.getFechaLlegada().toString());
        labelFechaSalida.setText(reserva.getFechaSalida().toString());
    }
}
