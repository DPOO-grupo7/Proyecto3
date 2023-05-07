package vista;

import javax.swing.*;
import java.awt.*;

public class PanelInventarioTotal extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel titulo;
	private JList<String> listaHabitaciones;
	private JButton btnAsignar;
	private JButton btnTerminar;

	public PanelInventarioTotal() {
		setLayout(new BorderLayout());

		// Título del panel
		titulo = new JLabel("Inventario de habitaciones total");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(titulo, BorderLayout.NORTH);

		// Lista de habitaciones
		listaHabitaciones = new JList<>(new String[] { "Habitación 101", "Habitación 102", "Habitación 103",
				"Habitación 104", "Habitación 105" });
		JScrollPane scrollPane = new JScrollPane(listaHabitaciones);
		add(scrollPane, BorderLayout.CENTER);

		// Botones para agregar y eliminar habitaciones
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		add(panelBotones, BorderLayout.SOUTH);
	}

	// Getters para los componentes
	public JList<String> getListaHabitaciones() {
		return listaHabitaciones;
	}

	public JButton getBtnAsignar() {
		return btnAsignar;
	}

	public void setBtnAsignar(JButton btnAsignar) {
		this.btnAsignar = btnAsignar;
	}

	public JButton getBtnTerminar() {
		return btnTerminar;
	}

	public void setBtnTerminar(JButton btnTerminar) {
		this.btnTerminar = btnTerminar;
	}

}
