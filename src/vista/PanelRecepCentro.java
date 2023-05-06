package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelRecepCentro extends JPanel{

	private JComboBox<String> desplegable;
	private JButton utilidad;
	
	public PanelRecepCentro(String tipo, VentanaRecepcion ventanaRecepcion)
	{
		this.setBackground(Color.decode("#f5f6fb"));
		if (tipo == "reserva")
		{
			crearCosas(tipo);
		}
		else if (tipo == "factura")
		{
			crearCosas(tipo);
		}
		else if (tipo == "inventario")
		{
			crearCosas(tipo);
		}
		else if (tipo == "invtotal")
		{
			crearCosas(tipo);
		}
		desplegable.addActionListener(ventanaRecepcion);
		utilidad.addActionListener(ventanaRecepcion);
	}
	public void crearCosas(String tipo)
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
        
     
        utilidad.setEnabled(false);
	}
	
}
