package vista;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelHServicios extends JPanel {
	private static final long serialVersionUID = 1L;

	public panelHServicios() {

		// Esta ventana tiene 1 seccion

		// panel de ir a otras ventanas

		// servicios con su informacion
		Font font = new Font("Arial", Font.BOLD, 20);
		ImageIcon imagenGuia = new ImageIcon("./data/FGuia.jpg");

		ImageIcon imagenSpa = new ImageIcon("./data/FSpa.jpg");
		ImageIcon imagenRestaurante = new ImageIcon("./data/FRestaurante.jpg");
		JLabel imageGuia = new JLabel(imagenGuia);
		JLabel imageSpa = new JLabel(imagenSpa);
		JLabel imageRestaurante = new JLabel(imagenRestaurante);
		JLabel Guia =  new JLabel("Guia Turistico");
		Guia.setFont(font);
		Guia.setHorizontalAlignment(JLabel.CENTER);
		JLabel Spa =  new JLabel("Spa");
		Spa.setFont(font);
		Spa.setHorizontalAlignment(JLabel.CENTER);
		JLabel Restaurante =  new JLabel("Restaurante");
		Restaurante.setFont(font);
		Restaurante.setHorizontalAlignment(JLabel.CENTER);
		setLayout(new GridLayout(3, 2, 0, 0));
		add(Guia);
		add(imageGuia);
		add(Spa);
		add(imageSpa);
		add(Restaurante);
		add(imageRestaurante);
		

	}
}
