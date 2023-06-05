package vista;

import javax.swing.*;

import controlador.ControladorHabitaciones;
import controlador.ManejadorReservas;
import controlador.ManejadorTarifa;
import modelo.Habitacion;
import modelo.Hotel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

public class PanelAdminCentro extends JPanel{

	private static final long serialVersionUID = 1L;
	private JComboBox<String> desplegable;
	private JButton utilidad;
	private JLabel titulo;
    private JList<String> listaHabitaciones;
    private JButton btnAgregar;
    private JButton btnSubir;
    private JButton btnEliminar;
    
	
	public PanelAdminCentro(String tipo, VentanaAdmin ventana, Hotel hotel)
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
	        ArrayList<Habitacion> lista = hotel.retornarHabitaciones();
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
	        btnSubir = new JButton("Subir Habitaciones");
	        panelBotones.add(btnAgregar);
	        panelBotones.add(btnSubir);
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
				
				String tamanio = JOptionPane.showInputDialog(null, "Tamaño de la habitación en m^2");
			    String cama = JOptionPane.showInputDialog(null, "Tamaño de la cama");
			    boolean ac = JOptionPane.showConfirmDialog(null, "¿Tiene aire acondicionado?") == JOptionPane.YES_OPTION;
			    boolean heat = JOptionPane.showConfirmDialog(null, "¿Tiene calefacción?") == JOptionPane.YES_OPTION;
			    boolean tv = JOptionPane.showConfirmDialog(null, "¿Tiene TV?") == JOptionPane.YES_OPTION;
			    boolean cafe = JOptionPane.showConfirmDialog(null, "¿Tiene cafetera?") == JOptionPane.YES_OPTION;
			    boolean plancha = JOptionPane.showConfirmDialog(null, "¿Tiene plancha?") == JOptionPane.YES_OPTION;
			    boolean ropa = JOptionPane.showConfirmDialog(null, "¿Tiene ropa de cama y tapetes hipoalergénicos?") == JOptionPane.YES_OPTION;
			    boolean secador = JOptionPane.showConfirmDialog(null, "¿Tiene secador de pelo?") == JOptionPane.YES_OPTION;
			    boolean voltaje = JOptionPane.showConfirmDialog(null, "¿Tiene voltaje AC?") == JOptionPane.YES_OPTION;
			    boolean usba = JOptionPane.showConfirmDialog(null, "¿Tiene tomas USB-A?") == JOptionPane.YES_OPTION;
			    boolean usbc = JOptionPane.showConfirmDialog(null, "¿Tiene tomas USB-C?") == JOptionPane.YES_OPTION;
			    boolean desayuno = JOptionPane.showConfirmDialog(null, "¿Incluye desayuno?") == JOptionPane.YES_OPTION;
			    int precio = 100000;
			    precio = Integer.parseInt(JOptionPane.showInputDialog(null, "Precio Habitacion"));
			    
			    hotel.crearHabitacion(capacidad, ubicacion, clase,  tamanio,  cama,  ac,  heat,  tv,  cafe,
						 plancha,  ropa,  secador,  voltaje,  usba,  usbc,
						 desayuno, precio);
				ventana.repintar("habitaciones");

	        
	    	
	            
	        });
	        
	        btnSubir.addActionListener(e -> {
	            JFileChooser fileChooser = new JFileChooser();
	            int option = fileChooser.showOpenDialog(ventana); 
	            int precio = 0;
	            
	            if (option == JFileChooser.APPROVE_OPTION) { 
	                File file = fileChooser.getSelectedFile(); 
	                
	                try {
	                    BufferedReader reader = new BufferedReader(new FileReader(file)); 
	                    String line;
	                    boolean isFirstLine = true; 
	                    
	                    while ((line = reader.readLine()) != null) { 
	                        if (isFirstLine) { 
	                            isFirstLine = false;
	                            continue;
	                        }
	                        
	                        String[] values = line.split(","); 
	                        
	                        if (values.length == 16) { 
	                            String ubicacion = values[0].trim();
	                            int capacidad = Integer.parseInt(values[1].trim());
	                            String tipoHab = values[2].trim();
	                            String tamanio = values[3].trim();
	                            String cama = values[4].trim();
	                            boolean ac = parseBoolean(values[5].trim());
	                            boolean calefaccion = parseBoolean(values[6].trim());
	                            boolean tv = parseBoolean(values[7].trim());
	                            boolean cafetera = parseBoolean(values[8].trim());
	                            boolean plancha = parseBoolean(values[9].trim());
	                            boolean ropaCama = parseBoolean(values[10].trim());
	                            boolean secador = parseBoolean(values[11].trim());
	                            boolean voltaje = parseBoolean(values[12].trim());
	                            boolean usbA = parseBoolean(values[13].trim());
	                            boolean usbC = parseBoolean(values[14].trim());
	                            boolean desayuno = parseBoolean(values[15].trim());
	                            
	                            hotel.crearHabitacion(capacidad, ubicacion, tipoHab, tamanio, cama, ac, calefaccion, tv, cafetera,
	                                    plancha, ropaCama, secador, voltaje, usbA, usbC, desayuno, precio);
	                        }
	                    }
	                    
	                    reader.close();
	                    
	                    
	                    ventana.repintar("habitaciones"); 
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	            }
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
	
	private boolean parseBoolean(String value) {
	    return value.equalsIgnoreCase("Si");
	}
	
	public void crearCosas(String tipo, VentanaAdmin ventana)
	{
		this.setLayout(new GridLayout(6 ,3 ));
        
        desplegable = new JComboBox<String>(new String[]{"Habitaciones", "Opción 2", "Opción 3"});
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
            if (desplegable.getSelectedItem().equals("Habitaciones")) {
                utilidad.setEnabled(true);
            } else {
                utilidad.setEnabled(false);
            }
            
        });
        //3
        this.add(new JLabel());
        this.add(new JLabel());
        this.add(new JLabel());
        
        utilidad.addActionListener(e -> {
            if (desplegable.getSelectedItem().equals("Habitaciones")) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(ventana);

                if (option == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line;
                        boolean isFirstLine = true;

                        while ((line = reader.readLine()) != null) {
                            if (isFirstLine) {
                                isFirstLine = false;
                                continue;
                            }

                            String[] values = line.split(",");

                            if (values.length == 2) {
                                String tipoHab = values[0].trim();
                                int tarifa = Integer.parseInt(values[1].trim());
                                
                                Habitacion.actualizarTarifa(tipoHab, tarifa);

                            }
                        }

                        reader.close();

                        ventana.repintar("habitaciones");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
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
