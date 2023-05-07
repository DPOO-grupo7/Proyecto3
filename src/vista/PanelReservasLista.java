package vista;

import javax.swing.*;

import modelo.Reserva;
import controlador.ManejadorReservas;

import java.awt.*;
import java.util.ArrayList;


public class PanelReservasLista extends JPanel {
    private JList<Reserva> listaReservas;
    

    public PanelReservasLista(ManejadorReservas res) {
        setLayout(new BorderLayout());
        ArrayList<Reserva> lista = res.getListaReservas();
        JLabel titulo = new JLabel("Lista de reservas");
        Reserva[] reservs = lista.toArray(new Reserva[lista.size()]);
        add(titulo, BorderLayout.NORTH);
        listaReservas = new JList<Reserva>(reservs);
        JScrollPane scrollPane = new JScrollPane(listaReservas);
        add(scrollPane, BorderLayout.CENTER);
        add(new PanelReservaDetalle(), BorderLayout.SOUTH);
    }

    public Reserva getReservaSeleccionada() {
        return listaReservas.getSelectedValue();
    }
}
