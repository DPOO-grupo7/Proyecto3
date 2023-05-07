package vista;

import javax.swing.*;
import java.awt.*;

public class PanelAdminCentro extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> desplegable;
	private JButton utilidad;
	private JLabel titulo;
    private JList<String> listaHabitaciones;
    private JButton btnAgregar;
    private JButton btnEliminar;
	
	public PanelAdminCentro(String tipo, VentanaAdmin ventana)
	{
		this.setBackground(Color.decode("#f5f6fb"));
		if (tipo == "habitaciones")
		{
			//crearCosas(tipo);
			setLayout(new BorderLayout());

	        // Título del panel
	        titulo = new JLabel("Inventario de habitaciones");
	        titulo.setHorizontalAlignment(SwingConstants.CENTER);
	        add(titulo, BorderLayout.NORTH);

	        // Lista de habitaciones
	        listaHabitaciones = new JList<>(new String[]{"Habitación 101", "Habitación 102", "Habitación 103", "Habitación 104", "Habitación 105"});
	        JScrollPane scrollPane = new JScrollPane(listaHabitaciones);
	        add(scrollPane, BorderLayout.CENTER);

	        // Botones para agregar y eliminar habitaciones
	        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        btnAgregar = new JButton("Agregar habitación");
	        btnEliminar = new JButton("Eliminar habitación");
	        panelBotones.add(btnAgregar);
	        panelBotones.add(btnEliminar);
	        add(panelBotones, BorderLayout.SOUTH);
		}
		else if (tipo == "tarifa")
		{
			crearCosas(tipo, ventana);
		}
		else if (tipo == "personal")
		{
			crearCosas(tipo, ventana);
		}
		else if (tipo == "servicios")
		{
			crearCosas(tipo, ventana);
		}
		
	}
	public void crearCosas(String tipo, VentanaAdmin ventana)
	{
		this.setLayout(new GridLayout(6 ,3 ));
        
        desplegable = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
        //1
        this.add(new JLabel());
        this.add(desplegable);
        this.add(new JLabel());
        //2
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        
        utilidad = new JButton("Agregar"+" "+tipo);
        desplegable.addActionListener(e -> {
            if (desplegable.getSelectedItem().equals("Opción 1")) {
                utilidad.setEnabled(true);
            } else {
                utilidad.setEnabled(false);
            }
        });
        //3
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        
        this.add(utilidad);
        this.add(new JLabel());
        this.add(new JLabel());
        
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());

        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        
        desplegable.addActionListener(ventana);
		utilidad.addActionListener(ventana);
        utilidad.setEnabled(false);
	}
	
}
