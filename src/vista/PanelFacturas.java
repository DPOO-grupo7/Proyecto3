package vista;

import javax.swing.*;
import java.awt.*;

public class PanelFacturas extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfTelefono;
	private JComboBox<String> cbMedioPago;
	private JTextArea taDetalle;

	public PanelFacturas() {
		setLayout(new BorderLayout());
		JPanel panelDatos = new JPanel(new GridLayout(3, 2));
		JPanel panelDetalle = new JPanel(new BorderLayout());
		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JLabel lblNombre = new JLabel("Nombre:");
		tfNombre = new JTextField(20);
		JLabel lblDireccion = new JLabel("Dirección:");
		tfDireccion = new JTextField(20);
		JLabel lblTelefono = new JLabel("Teléfono:");
		tfTelefono = new JTextField(20);
		panelDatos.add(lblNombre);
		panelDatos.add(tfNombre);
		panelDatos.add(lblDireccion);
		panelDatos.add(tfDireccion);
		panelDatos.add(lblTelefono);
		panelDatos.add(tfTelefono);

		JLabel lblDetalle = new JLabel("Detalle:");
		taDetalle = new JTextArea(10, 30);
		JScrollPane scrollDetalle = new JScrollPane(taDetalle);
		panelDetalle.add(lblDetalle, BorderLayout.NORTH);
		panelDetalle.add(scrollDetalle, BorderLayout.CENTER);

		JLabel lblMedioPago = new JLabel("Medio de pago:");
		String[] opcionesMedioPago = { "Efectivo", "Tarjeta de crédito", "Transferencia" };
		cbMedioPago = new JComboBox<String>(opcionesMedioPago);
		panelBotones.add(lblMedioPago);
		panelBotones.add(cbMedioPago);

		JButton btnGenerarFactura = new JButton("Generar factura");
		panelBotones.add(btnGenerarFactura);

		add(panelDatos, BorderLayout.NORTH);
		add(panelDetalle, BorderLayout.CENTER);
		add(panelBotones, BorderLayout.SOUTH);

		;
	}

	public String getNombre() {
		return tfNombre.getText();
	}

	public String getDireccion() {
		return tfDireccion.getText();
	}

	public String getTelefono() {
		return tfTelefono.getText();
	}

	public String getDetalle() {
		return taDetalle.getText();
	}

	public String getMedioPago() {
		return (String) cbMedioPago.getSelectedItem();
	}

	public void limpiar() {
		tfNombre.setText("");
		tfDireccion.setText("");
		tfTelefono.setText("");
		taDetalle.setText("");
		cbMedioPago.setSelectedIndex(0);
	}
}
