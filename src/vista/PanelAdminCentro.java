package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PanelAdminCentro extends JPanel{

	private JComboBox<String> desplegable;
	private JButton utilidad;
	
	public PanelAdminCentro(String tipo, VentanaAdmin ventana)
	{
		this.setBackground(Color.decode("#f5f6fb"));
		if (tipo == "habitaciones")
		{
			crearCosas(tipo);
		}
		else if (tipo == "tarifa")
		{
			crearCosas(tipo);
		}
		else if (tipo == "personal")
		{
			crearCosas(tipo);
		}
		else if (tipo == "servicios")
		{
			crearCosas(tipo);
		}
		desplegable.addActionListener(ventana);
		utilidad.addActionListener(ventana);
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
