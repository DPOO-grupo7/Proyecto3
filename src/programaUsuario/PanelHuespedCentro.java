package programaUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    private JButton btnBuscar;
    private JButton btnFechas;
    private Date fechaIni = formatearFecha("01/01/2021");
    private Date fechaFin = formatearFecha("31/12/2040");
	//metodo de controlador habitaciones
	//hotel recopilarDisponibilidad();
	
	public PanelHuespedCentro(String tipo, VentanaHuesped ventana, Hotel hotel, Date uno, Date fin)
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
	        
	        ListaDisponible(hotel, uno, fin);

	        // Botones para agregar y eliminar habitaciones
	        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        
	        btnBuscar = new JButton("Buscar");
	        btnFechas = new JButton("Fechas");
	        panelBotones.add(btnFechas);
	        panelBotones.add(btnBuscar);
	        
	        add(panelBotones, BorderLayout.SOUTH);
	        btnFechas.addActionListener(e -> {
	        	this.fechaIni = JOptionPaneCalendario.mostrarCalendario();
	        	this.fechaFin = JOptionPaneCalendario.mostrarCalendario();
	        });
	        btnBuscar.addActionListener(e -> {
	        	ventana.setFechas(this.fechaIni, this.fechaFin);
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
	
	public void ListaDisponible(Hotel hotel, Date fechaIni, Date fechaFin )
	{
		ArrayList<Habitacion> lista = hotel.recopilarDisponibilidadFecha(fechaIni, fechaFin);
        DefaultListModel listModel = new DefaultListModel();
        	for(int i=0; i<lista.size(); i++) {
            //Añadir cada elemento del ArrayList en el modelo de la lista
        		listModel.add(i, lista.get(i).getDatos());
        }
        listaHabitaciones = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaHabitaciones);
        add(scrollPane, BorderLayout.CENTER);
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
	public Date formatearFecha(String fechaTexto) {
		// esta va a ser usada para cuando se quiera buscar una fecha o reservar en esa
		// fecha.
//		un ejemplo de fechaTexto = "15/01/2023";
		DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = formatoFecha.parse(fechaTexto);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return fecha;
	}
	
}
