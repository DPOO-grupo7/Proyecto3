package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAgregarConsumo extends JPanel {

    private JComboBox<String> cbHabitaciones;
    private JTextField tfConsumo;
    private JButton btnAgregar;
    private JLabel lblMensaje;

    public PanelAgregarConsumo(String[] habitaciones) {
        setLayout(new GridLayout(3, 2));

        JLabel lblHabitacion = new JLabel("Habitación:");
        add(lblHabitacion);

        cbHabitaciones = new JComboBox<>(habitaciones);
        add(cbHabitaciones);

        JLabel lblConsumo = new JLabel("Consumo:");
        add(lblConsumo);

        tfConsumo = new JTextField();
        add(tfConsumo);

        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String habitacion = (String) cbHabitaciones.getSelectedItem();
                String consumo = tfConsumo.getText();

                // Aquí se pueden agregar las instrucciones para guardar el consumo en la base de datos o en algún archivo.

                lblMensaje.setText("Consumo agregado para la habitación " + habitacion);
            }
        });
        add(btnAgregar);

        lblMensaje = new JLabel();
        add(lblMensaje);
    }
}
