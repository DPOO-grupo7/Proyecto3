package vista;

import javax.swing.*;
import java.awt.*;

public class PanelAdminCentro extends JPanel {

	
	public PanelAdminCentro(String tipo)
	{
		if (tipo == "habitaciones")
		{
			this.setLayout(new GridLayout(6 ,3 ));
	        
	        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
	        //1
	        this.add(new JLabel());
	        this.add(comboBox);
	        this.add(new JLabel());
	        //2
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        JButton button = new JButton("Agregar Habitación");
	        comboBox.addActionListener(e -> {
	            if (comboBox.getSelectedItem().equals("Opción 1")) {
	                button.setEnabled(true);
	            } else {
	                button.setEnabled(false);
	            }
	        });
	        //3
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        this.add(button);
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
	        
	     
	        button.setEnabled(false);
		}
		else if (tipo == "tarifa")
		{
			this.setLayout(new GridLayout(6 ,3 ));
	        
	        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
	        //1
	        this.add(new JLabel());
	        this.add(comboBox);
	        this.add(new JLabel());
	        //2
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        JButton button = new JButton("Agregar Tarifa");
	        comboBox.addActionListener(e -> {
	            if (comboBox.getSelectedItem().equals("Opción 1")) {
	                button.setEnabled(true);
	            } else {
	                button.setEnabled(false);
	            }
	        });
	        //3
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        this.add(button);
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
	        
	     
	        button.setEnabled(false);
		}
		else if (tipo == "personal")
		{
			this.setLayout(new GridLayout(6 ,3 ));
	        
	        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
	        //1
	        this.add(new JLabel());
	        this.add(comboBox);
	        this.add(new JLabel());
	        //2
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        JButton button = new JButton("Agregar Personal");
	        comboBox.addActionListener(e -> {
	            if (comboBox.getSelectedItem().equals("Opción 1")) {
	                button.setEnabled(true);
	            } else {
	                button.setEnabled(false);
	            }
	        });
	        //3
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        this.add(button);
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
	        
	     
	        button.setEnabled(false);
		}
		else if (tipo == "servicios")
		{
			this.setLayout(new GridLayout(6 ,3 ));
	        
	        JComboBox<String> comboBox = new JComboBox<String>(new String[]{"Opción 1", "Opción 2", "Opción 3"});
	        //1
	        this.add(new JLabel());
	        this.add(comboBox);
	        this.add(new JLabel());
	        //2
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        JButton button = new JButton("Agregar Servicios");
	        comboBox.addActionListener(e -> {
	            if (comboBox.getSelectedItem().equals("Opción 1")) {
	                button.setEnabled(true);
	            } else {
	                button.setEnabled(false);
	            }
	        });
	        //3
	        this.add(new JLabel());
	        this.add(new JLabel());
	        this.add(new JLabel());
	        
	        this.add(button);
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
	        
	     
	        button.setEnabled(false);
		}
	}
}
