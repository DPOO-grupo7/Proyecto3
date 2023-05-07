package vista;

import javax.swing.*;

import modelo.Reserva;

import java.awt.*;


public class PanelReservasLista extends JPanel {
    private JList<Reserva> listaReservas;

    public PanelReservasLista(Reserva[] reservas) {
        setLayout(new BorderLayout());
        JLabel titulo = new JLabel("Lista de reservas");
        add(titulo, BorderLayout.NORTH);
        listaReservas = new JList<>(reservas);
        JScrollPane scrollPane = new JScrollPane(listaReservas);
        add(scrollPane, BorderLayout.CENTER);
    }

    public Reserva getReservaSeleccionada() {
        return listaReservas.getSelectedValue();
    }
}
