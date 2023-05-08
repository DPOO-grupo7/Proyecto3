package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class panelHInformacion extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image imagen;

	public panelHInformacion() {
		imagen = new ImageIcon("./data/FotoHotel.jpg").getImage();
		ImageIcon imagenEstandar = new ImageIcon("./data/Estandar.jpg");

		ImageIcon imagenSuite = new ImageIcon("./data/Suite.jpg");
		ImageIcon imagenSuiteDoble = new ImageIcon("./data/SuiteDoble.jpg");

		setOpaque(false);
		Color SilverTransparente = new Color(192, 192, 192, 200);
		Color Powder = new Color(93, 138, 168);

		// Esta ventana tiene 3 secciones

		setLayout(new GridLayout(3, 1, 0, 0));
		Font font = new Font("Arial", Font.BOLD, 20);
		Font fontN = new Font("Arial", Font.PLAIN, 20);
		// Opciones adicionals que pueden aparecer
		JPanel OpcionesAdicionales = new JPanel();
//		OpcionesAdicionales.setOpaque(false);
		// objetos que van dentro de este panel
		JLabel EtiquetaOpciones = new JLabel("Opciones Adicionales: ");
		EtiquetaOpciones.setFont(font);

		// deberia ser un for para las posibles caracteristicas que hay
		JLabel Vista = new JLabel(" Vista ");
		Vista.setVerticalAlignment(SwingConstants.CENTER);
		Vista.setFont(fontN);
		JLabel Cocina = new JLabel(" Cocina ");
		Cocina.setVerticalAlignment(SwingConstants.CENTER);
		Cocina.setFont(fontN);
		JLabel Balcon = new JLabel(" Balcon ");
		Balcon.setVerticalAlignment(SwingConstants.CENTER);
		Balcon.setFont(fontN);
		OpcionesAdicionales.setLayout(new FlowLayout());
		OpcionesAdicionales.add(EtiquetaOpciones);
		OpcionesAdicionales.add(Vista);
		OpcionesAdicionales.add(Cocina);
		OpcionesAdicionales.add(Balcon);
		OpcionesAdicionales.setBackground(SilverTransparente);

		
		

		JPanel TiposHabitaciones = new JPanel();

		TiposHabitaciones.setBackground(SilverTransparente);
		TiposHabitaciones.setLayout(new GridLayout(2, 3, 0, 0));
		JLabel Estandar = new JLabel(" Estandar ");
		Estandar.setBackground(Color.WHITE);
		Estandar.setOpaque(true);
		Estandar.setFont(font);
		Estandar.setForeground(Powder);
		Estandar.setPreferredSize(new Dimension(100, 50));
		JLabel Suite = new JLabel(" Suite ");
		Suite.setBackground(Color.WHITE);
		Suite.setOpaque(true);
		Suite.setFont(font);
		Suite.setForeground(Powder);
		Suite.setPreferredSize(new Dimension(100, 50));
		JLabel SuiteDoble = new JLabel(" Suite Doble ");
		SuiteDoble.setBackground(Color.WHITE);
		SuiteDoble.setOpaque(true);
		SuiteDoble.setFont(font);
		SuiteDoble.setForeground(Powder);
		SuiteDoble.setPreferredSize(new Dimension(100, 50));

		JLabel imageEstandar = new JLabel(imagenEstandar);
		JLabel imageSuite = new JLabel(imagenSuite);
		JLabel imageSuiteDoble = new JLabel(imagenSuiteDoble);
		TiposHabitaciones.add(imageEstandar);
		TiposHabitaciones.add(imageSuite);
		TiposHabitaciones.add(imageSuiteDoble);
		TiposHabitaciones.add(Estandar);
		TiposHabitaciones.add(Suite);
		TiposHabitaciones.add(SuiteDoble);

		// el grid de ocupacion

		Grid GRID = new Grid();
//		GRID.setBackground(SilverTransparente);
//		GRID.setOpaque(true);

		// Agregar todo a PanelInformacion

		add(OpcionesAdicionales);
		add(TiposHabitaciones);
		add(GRID);

	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

		super.paint(g);
	}

}