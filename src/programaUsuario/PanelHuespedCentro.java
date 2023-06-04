package programaUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import modelo.Habitacion;
import modelo.Hotel;
import vista.VentanaAdmin;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;

public class PanelHuespedCentro extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> desplegable;
	private JButton utilidad;
	private JLabel titulo;
    private JList<String> listaHabitaciones;
    private JButton btnAgregar;
    private JButton btnEliminar;
	//metodo de controlador habitaciones
	//hotel recopilarDisponibilidad();
	
	public PanelHuespedCentro(String tipo, VentanaHuesped ventana, Hotel hotel, String tamanio, String cama, boolean ac, boolean heat, boolean tv, boolean cafe,
			boolean plancha, boolean ropa, boolean secador, boolean voltaje, boolean usba, boolean usbc,
			boolean desayuno)
	{
		this.setBackground(Color.decode("#f5f6fb"));
		
		JCalendar calendar = new JCalendar();
		add(calendar);
		if (tipo == "habitaciones")
		{
			//crearCosas(tipo);
			setLayout(new BorderLayout());

	        // Título del panel
	        titulo = new JLabel("Inventario de habitaciones");
	        titulo.setHorizontalAlignment(SwingConstants.CENTER);
	        add(titulo, BorderLayout.NORTH);
	        ArrayList<Habitacion> lista = hotel.recopilarDisponibilidadFecha();
	        DefaultListModel listModel = new DefaultListModel();
	        	for(int i=0; i<lista.size(); i++) {
	            //Añadir cada elemento del ArrayList en el modelo de la lista
	        		listModel.add(i, lista.get(i).getDatos());
	        }
	        listaHabitaciones = new JList<>(listModel);
	        JScrollPane scrollPane = new JScrollPane(listaHabitaciones);
	        add(scrollPane, BorderLayout.CENTER);

	        // Botones para agregar y eliminar habitaciones
	        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        btnAgregar = new JButton("Agregar habitación");
	        panelBotones.add(btnAgregar);
	        add(panelBotones, BorderLayout.SOUTH);
	        btnAgregar.addActionListener(e -> {
	        	String clase = "";
	        	int capacidad = 0;
	        	String[] botones = { "1", "2", "3", "4", "5"};
	        	String[] botones2 = { "Estandar", "Suite", "Suite Doble"};
				String ubicacion = JOptionPane.showInputDialog(null, "Ubicacion de Habitacion");
				int seleccion = JOptionPane.showOptionDialog(null, "Elige capacidad", "Elegir capacidad",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones, botones[0]);
				if (seleccion == 0) {
					capacidad = 1;
				} else if (seleccion == 1) {
					capacidad = 2;
				} else if (seleccion == 2) {
					capacidad = 3;
				} else if (seleccion == 3) {
					capacidad = 4;
				} else if (seleccion == 4) {
					capacidad = 5;
				}
				int seleccion2 = JOptionPane.showOptionDialog(null, "Elige un tipo", "Elegir tipo",
						JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botones2, botones2[0]);
				if (seleccion2 == 0) {
					clase = "Estandar";
				} else if (seleccion2 == 1) {
					clase = "Suite";
				} else if (seleccion2 == 2) {
					clase = "Suite Doble";
				} 
				hotel.crearHabitacion(capacidad, ubicacion, clase,  tamanio,  cama,  ac,  heat,  tv,  cafe,
						 plancha,  ropa,  secador,  voltaje,  usba,  usbc,
						 desayuno);
				ventana.repintar("habitaciones");
				
	        
	    	
	            
	        });
	        
		}
		else if (tipo == "tarifa")
		{
			crearCosas(tipo, ventana);
		}
		else if (tipo == "servicios")
		{
			crearCosas(tipo, ventana);
		}
		
	}
	public void crearCosas(String tipo, VentanaHuesped ventana)
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
