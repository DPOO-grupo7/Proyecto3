package programaUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import modelo.InformadorHuesped;
import modelo.Reserva;
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
	        
	        ListaDisponible(hotel, uno, fin, "habs");

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
		else if (tipo == "personal")
		{
			
			setLayout(new BorderLayout());
			ListaDisponible(hotel, this.fechaIni, this.fechaFin, "reserva");
			add(new JLabel("Reservación"), BorderLayout.NORTH);
			JPanel calendarios = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JDateChooser dateChooser1 = new JDateChooser();
			JDateChooser dateChooser2 = new JDateChooser();
			JButton refresh = new JButton("Refrescar Lista");
			calendarios.add(refresh);
			calendarios.add(dateChooser1);
			calendarios.add(dateChooser2);
			
			add(calendarios, BorderLayout.SOUTH);
			
			Date fechaInicial = dateChooser1.getDate();
			Date fechaFinal = dateChooser2.getDate();
			
			
			refresh.addActionListener(e -> {
	        	if (fechaInicial != null && fechaFinal != null) 
	        	{
	        		try {
	        			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
	        			String fechaFormateada1 = formatoFecha.format(fechaInicial);
	        			String fechaFormateada2 = formatoFecha.format(fechaFinal);
	    	            this.fechaIni = formatoFecha.parse(fechaFormateada1);
	    	            this.fechaFin = formatoFecha.parse(fechaFormateada2);
	    	            ventana.setFechas(this.fechaIni, this.fechaFin);
	    	            ventana.repintar("personal");
	    	        } catch (ParseException e1) {
	    	            e1.printStackTrace();
	    	            JOptionPane.showMessageDialog(null, "Error con la fecha", "Error", JOptionPane.WARNING_MESSAGE);
	    	        }
	        	}
	        });
			
			
		}
		else if (tipo == "pagar")
		{
			crearCosas(tipo, ventana);
		}
		
		
	}
	
	private void ListaDisponible(Hotel hotel, Date fechaIni, Date fechaFin, String tipo )
	{
		ArrayList<Habitacion> lista = hotel.recopilarDisponibilidadFecha(fechaIni, fechaFin);
        DefaultListModel listModel = new DefaultListModel();
        	for(int i=0; i<lista.size(); i++) {
            //Añadir cada elemento del ArrayList en el modelo de la lista
        		listModel.add(i, lista.get(i).getDatos());
        }
        listaHabitaciones = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaHabitaciones);
        if (tipo == "reserva")
        {
        	scrollPane.setPreferredSize(new Dimension(300, 150));
        }
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
	public ArrayList<InformadorHuesped> informacionHuespedes(Hotel hotel) throws NumberFormatException, IOException {

		int continuar = 0;

		ArrayList<InformadorHuesped> miembrosGrupo = new ArrayList<InformadorHuesped>();
		while (continuar == 0) {
			String nombre = JOptionPane.showInputDialog(null, "Introduce tu numero de documento");
			String documento = JOptionPane.showInputDialog(null, "Introduce tu numero de documento");
			String email = JOptionPane.showInputDialog(null, "Introduce tu email");
			String telefono = JOptionPane.showInputDialog(null, "Introduce tu telefono");
			
			

			InformadorHuesped persona = new InformadorHuesped(nombre, documento, documento, email, telefono);
			miembrosGrupo.add(persona);
			//hotel.crearCuentaHuesped(nombre, documento, documento, email, telefono);
			
			
			continuar = JOptionPane.showConfirmDialog(null, "¿Quieres seguir agregando?", "Agregar Ocupantes", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			
		}
		return miembrosGrupo;
	}
	
	public void crearReserva(Hotel hotel, Date fechaIngreso, Date fechaSalida) throws IOException {
		int CntP = 0;
		// Primera interacción: Verificar disponibilidad de la solicitud general
		
		ArrayList<Habitacion> listaDisponibilidad = hotel.recopilarDisponibilidadFecha(fechaIngreso,fechaSalida);

		if (listaDisponibilidad.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Fechas no disponibles");
			//System.out.println("Las fechas que busca para el tipo de habitaci�n y caracter�sticas est�n tot�lmente ocupadas.");
		}

		// Segunda interaccion : #personas y #ni�os y si cuentan
		int CntPersonas = 0;
		
		
		String[] botonesP = { "1", "2", "3", "4", "5"};
		int seleccion = JOptionPane.showOptionDialog(null, "Cantidad de personas", "Cantidad de personas",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesP, null);
		if (seleccion == 0) {
			CntPersonas = 1;
		} else if (seleccion == 1) {
			CntPersonas = 2;
		} else if (seleccion == 2) {
			CntPersonas = 3;
		} else if (seleccion == 3) {
			CntPersonas = 4;
		} else if (seleccion == 4) {
			CntPersonas = 5;
		}
		
		
		int cntKids = 0;
		
		String[] botonesN = { "0","1", "2", "3", "4", "5"};
		int seleccionN = JOptionPane.showOptionDialog(null, "Cantidad de personas", "Cantidad de personas",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, botonesN, null);
		if (seleccion == 0) {
			cntKids = 0;
		} else if (seleccionN == 1) {
			cntKids = 1;
		} else if (seleccionN == 2) {
			cntKids = 2;
		} else if (seleccionN == 3) {
			cntKids = 3;
		} else if (seleccionN == 4) {
			cntKids = 4;
		} else if (seleccionN == 5) {
			cntKids = 5;
		}
		CntP = CntPersonas - cntKids;
		ArrayList<Habitacion> resultadoCuartos = hotel.asignacioncuartos(listaDisponibilidad, CntP);
		if (resultadoCuartos.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No hay habitaciones pa toda esa gente");
			//System.out.println("Lo siento, no hay habitaciones disponibles para el número de personas indicado.");
			System.exit(0);

			// TODO escribir que pasa
		}

		ArrayList<InformadorHuesped> listadeMiebros = informacionHuespedes(hotel);
		// se divide entre el huesped a cargo y el resto de miembros.
		ArrayList<InformadorHuesped> listaGrupo = listadeMiebros;
		if (listadeMiebros.size() != 1) {
			listaGrupo.remove(0);
		} else {
			listaGrupo = null;

		}

		Reserva reservaEncurso = hotel.nuevaReserva2(listadeMiebros.get(0), listaGrupo, CntPersonas, fechaIngreso, fechaSalida, resultadoCuartos);

		//finalizarReserva(reservaEncurso, hotel);

	}
	public void finalizarReserva(Reserva reservaEncurso,  Hotel hotel) {

		ArrayList<String> informacionFinal = hotel.informacionSobreReserva2(reservaEncurso);
		
	}
}
