package programaUsuario;

import java.awt.BorderLayout;

import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Insets;

import modelo.Factura;
import modelo.GeneradorFactura;
import modelo.Habitacion;
import modelo.Hotel;
import modelo.InformadorHuesped;
import modelo.Reserva;
import pasarelaPago.PasarelaPago;
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
    private JLabel lblNumeroTarjeta;
    private JLabel lblFechaVencimiento;
    private JLabel lblCVV;
    private JTextField txtNumeroTarjeta;
    private JTextField txtFechaVencimiento;
    private JPasswordField txtCVV;
    private JLabel lblNombrePagador;
    private JLabel lblDireccionPagador;
    private JTextField txtNombrePagador;
    private JTextField txtIdReserva;
    private JButton btnRealizarPago;
    private String nombrePagador = "";
    private String direccionPagador = "";
	
    private String pasarela = "pasarelaPago.PayU";
    
    private Image payu = new ImageIcon("./data/payu.png").getImage();
    private Image paypal = new ImageIcon("./data/logo_paypal.jpg").getImage();
    
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
			JPanel calendarios = new JPanel();
			calendarios.setLayout(new GridLayout(2, 3, 10, 10));
			JLabel lblHuespedPrincipal = new JLabel("Huesped Principal:");
	        calendarios.add(lblHuespedPrincipal);

	        JTextField HuespedPrincipal = new JTextField(20);
	        calendarios.add(HuespedPrincipal);
			JDateChooser dateChooser1 = new JDateChooser();
			JDateChooser dateChooser2 = new JDateChooser();
			JButton refresh = new JButton("Refrescar");
			calendarios.add(refresh);
			JButton reservar = new JButton("Reservar");
			
			calendarios.add(dateChooser1);
			calendarios.add(dateChooser2);
			calendarios.add(reservar);
			
			add(calendarios, BorderLayout.SOUTH);
			
			//Date fechaInicial = dateChooser1.getDate();
			//Date fechaFinal = dateChooser2.getDate();
			
			
			refresh.addActionListener(e -> {
				Date fechaInicial = dateChooser1.getDate();
				Date fechaFinal = dateChooser2.getDate();
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
			reservar.addActionListener(e -> {
				Date fechaInicial = dateChooser1.getDate();
				Date fechaFinal = dateChooser2.getDate();
				if (fechaInicial != null && fechaFinal != null) 
	        	{
	        		try {
	        			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
	        			String fechaFormateada1 = formatoFecha.format(fechaInicial);
	        			String fechaFormateada2 = formatoFecha.format(fechaFinal);
	    	            this.fechaIni = formatoFecha.parse(fechaFormateada1);
	    	            this.fechaFin = formatoFecha.parse(fechaFormateada2);
	    	        
	    	        } catch (ParseException e1) {
	    	            e1.printStackTrace();
	    	            JOptionPane.showMessageDialog(null, "Error con la fecha", "Error", JOptionPane.WARNING_MESSAGE);
	    	        }
	        	}
	        	String huespedP = HuespedPrincipal.getText();
	        	InformadorHuesped huespedPrinci = hotel.encontrarHuesped(huespedP);
	        	if (huespedPrinci == null)
	        	{
	        		hotel.crearCuentaHuesped(huespedP, "", "", "", "");
	        		huespedPrinci = hotel.encontrarHuesped(huespedP);
	        	}
	        	try {
					crearReserva(hotel, this.fechaIni, this.fechaFin, huespedPrinci);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        });
			
			
		}
		else if (tipo == "pagar")
		{
			Icon payuu = new ImageIcon(this.payu);
			Icon paypall = new ImageIcon(this.paypal);
			
			
			
			JLabel payuuu = new JLabel();
			JLabel paypalll = new JLabel();
			
			
			payuuu.setIcon(payuu);
			paypalll.setIcon(paypall);
		
			
			
			lblNumeroTarjeta = new JLabel("Número de Tarjeta:");
	        lblFechaVencimiento = new JLabel("Fecha de Vencimiento (MM/AA):");
	        lblCVV = new JLabel("CVV:");
	        txtNumeroTarjeta = new JTextField(16);
	        txtFechaVencimiento = new JTextField(5);
	        txtCVV = new JPasswordField(3);
	        lblNombrePagador = new JLabel("Nombre del Pagador:");
	        lblDireccionPagador = new JLabel("Id de la reserva:");
	        txtNombrePagador = new JTextField(20);
	        txtIdReserva = new JTextField(20);
	        btnRealizarPago = new JButton("Realizar Pago");
	        
	        JLabel dificultad = new JLabel("Plataforma:");
	        
	        JRadioButton facil = new JRadioButton("Payu");
	        JRadioButton medio = new JRadioButton("Paypal");
	        JRadioButton dificil = new JRadioButton("Sire");
	        ButtonGroup dificultades = new ButtonGroup();
	        

	        // Configuración del diseño del panel con GridBagLayout
	        setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 0;
	        gbc.anchor = GridBagConstraints.WEST;
	        gbc.insets = new Insets(5, 5, 5, 5);

	        // Agregar componentes al panel
	        add(lblNumeroTarjeta, gbc);
	        gbc.gridy++;
	        add(txtNumeroTarjeta, gbc);
	        gbc.gridy++;
	        add(lblFechaVencimiento, gbc);
	        gbc.gridy++;
	        add(txtFechaVencimiento, gbc);
	        gbc.gridy++;
	        add(lblCVV, gbc);
	        gbc.gridy++;
	        add(txtCVV, gbc);
	        gbc.gridy++;
	        add(lblNombrePagador, gbc);
	        gbc.gridy++;
	        add(txtNombrePagador, gbc);
	        gbc.gridy++;
	        add(lblDireccionPagador, gbc);
	        gbc.gridy++;
	        add(txtIdReserva, gbc);
	        gbc.gridy++;
	        add(btnRealizarPago, gbc);
	        this.add(dificultad);
	        dificultades.add(facil);
	        dificultades.add(medio);
	        dificultades.add(dificil);
	        this.add(facil);
	        this.add(medio);
	        this.add(dificil);
	        gbc.gridx++;
			add(payuuu, gbc);
			gbc.gridx++;
			add(paypalll, gbc);
			
	        // Establecer los valores del pagador
	        txtNombrePagador.setText(this.nombrePagador);
	        txtIdReserva.setText(this.direccionPagador);
	        
	        facil.addActionListener(e -> {
	        	pasarela = "pasarelaPago.PayU";
	        });
	        
	        medio.addActionListener(e -> {
	        	pasarela = "pasarelaPago.Paypal";
	        });
	        
	        dificil.addActionListener(e -> {
	        	pasarela = "pasarelaPago.Sire";
	        });
	        
	        btnRealizarPago.addActionListener(e -> {
	        	
	        	this.nombrePagador = txtNombrePagador.getText();
	        	this.direccionPagador = txtIdReserva.getText();
	        	if ((this.txtNumeroTarjeta.getText() != "" || this.txtNumeroTarjeta.getText() != null) && (this.txtFechaVencimiento.getText() != "" || this.txtFechaVencimiento.getText() != null))
	        	{
	        		try {
						pagarReserva(hotel, Integer.parseInt(txtIdReserva.getText()), this.pasarela);
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "El id de su reserva está en la factura", "Error", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        	}
	        	else
	        	{
	        		JOptionPane.showMessageDialog(null, "Coloque su tarjeta", "Error", JOptionPane.WARNING_MESSAGE);
	        	}
	        });
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
	public ArrayList<InformadorHuesped> informacionHuespedes(Hotel hotel, int cantidad, InformadorHuesped principal) throws NumberFormatException, IOException {

		int continuar = 0;
		

		ArrayList<InformadorHuesped> miembrosGrupo = new ArrayList<InformadorHuesped>();
		miembrosGrupo.add(principal);
		while (continuar < cantidad-1) {
			String nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre");
			String documento = JOptionPane.showInputDialog(null, "Introduce tu numero de documento");
			String email = JOptionPane.showInputDialog(null, "Introduce tu email");
			String telefono = JOptionPane.showInputDialog(null, "Introduce tu telefono");
			
			

			InformadorHuesped persona = new InformadorHuesped(nombre, documento, documento, email, telefono);
			miembrosGrupo.add(persona);
			//hotel.crearCuentaHuesped(nombre, documento, documento, email, telefono);
			
			
			//continuar = JOptionPane.showConfirmDialog(null, "¿Quieres seguir agregando?", "Agregar Ocupantes", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			continuar++;
			
		}
		return miembrosGrupo;
	}
	
	
	
	public void crearReserva(Hotel hotel, Date fechaIngreso, Date fechaSalida, InformadorHuesped principal) throws IOException {
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
		int seleccionN = JOptionPane.showOptionDialog(null, "Cantidad de Niños", "Cantidad de Niños",
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

		ArrayList<InformadorHuesped> listadeMiebros = informacionHuespedes(hotel, CntPersonas, principal);
		// se divide entre el huesped a cargo y el resto de miembros.
		ArrayList<InformadorHuesped> listaGrupo = listadeMiebros;
		if (listadeMiebros.size() != 1) {
			listaGrupo.remove(0);
		} else {
			listaGrupo = null;

		}
		
		hotel.actualizarHabitaciones(resultadoCuartos, fechaIngreso, fechaSalida);
		
		Reserva reservaEncurso = hotel.nuevaReserva2(listadeMiebros.get(0), listaGrupo, CntPersonas, fechaIngreso, fechaSalida, resultadoCuartos);
		//System.out.println(reservaEncurso.getNumPersonas());
		JOptionPane.showMessageDialog(this, "Reserva Exitosa");
		//finalizarReserva(reservaEncurso, hotel);
		int id = resultadoCuartos.get(0).getIdentificador();
		String type = resultadoCuartos.get(0).getTipo();
		int price = resultadoCuartos.get(0).getPrecio();
		Random nroRandom = new Random();
		int nroFactura = nroRandom.nextInt(10000)+1;
		Factura factura = new Factura(String.valueOf(nroFactura), fechaSalida.toString(), principal.getLogin(), String.valueOf(id),type, false, String.valueOf(reservaEncurso.getIdentificacion()), price);
		GeneradorFactura.generarFacturaTxt(factura);
		reservaEncurso.setFactura(factura);
		
	}
	public void finalizarReserva(Reserva reservaEncurso,  Hotel hotel) {

		ArrayList<String> informacionFinal = hotel.informacionSobreReserva2(reservaEncurso);
		
	}
	

    public String getNumeroTarjeta() {
        return txtNumeroTarjeta.getText();
    }

    public String getFechaVencimiento() {
        return txtFechaVencimiento.getText();
    }

    public String getCVV() {
        return new String(txtCVV.getPassword());
    }
    
    public void pagarReserva(Hotel hotel, int id , String plataforma) throws IOException {
		boolean pago = true;
		
		PasarelaPago pasarelaPago = new PasarelaPago();
		pasarelaPago.Pagar(plataforma, this.txtNumeroTarjeta.getText(), this.nombrePagador, 10);
		
		
		Reserva reservaApagar = hotel.encontrarReserva(id);
		reservaApagar.setPagado(pago);
		Factura factura = reservaApagar.getFactura();
		
		int ventanaYesNotCancel = JOptionPane.showConfirmDialog(null, "¿Quieres generar una nueva factura?", "Facturacion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		//0=yes, 1=no, 2=cancel
		if(ventanaYesNotCancel == 0) {
			GeneradorFactura.generarFacturaTxt(factura);
			JOptionPane.showMessageDialog(null, "Gracias por confiar en nosotros", "Facturación", -1);
		}else if(ventanaYesNotCancel == 1){
			JOptionPane.showMessageDialog(null, "Gracias por confiar en nosotros", "Facturación", -1);
		}
		
		
    }
}
