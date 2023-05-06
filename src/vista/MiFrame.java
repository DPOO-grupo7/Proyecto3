package vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiFrame extends JFrame implements ActionListener {
  
  private JPanel panelWest;
  private JPanel panelCenter;
  private JPanel panelEast;
  
  public MiFrame() {
    super("Mi aplicación");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // Creamos los paneles y los añadimos al frame
    panelWest = new JPanel();
    panelCenter = new PanelCenter();
    panelEast = new PanelEast();
    add(panelWest, BorderLayout.WEST);
    add(panelCenter, BorderLayout.CENTER);
    add(panelEast, BorderLayout.EAST);
    
    // Creamos los botones y los añadimos al panel del oeste
    JButton boton1 = new JButton("Panel 1");
    boton1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Actualizamos el contenido de los paneles en el centro y este
        panelCenter.removeAll();
        panelCenter.add(new JButton("Botón 1"));
        panelCenter.add(new JButton("Botón 2"));
        panelCenter.revalidate();
        panelCenter.repaint();
        
        panelEast.removeAll();
        panelEast.add(new JButton("Botón 3"));
        panelEast.add(new JButton("Botón 4"));
        panelEast.revalidate();
        panelEast.repaint();
      }
    });
    panelWest.add(boton1);
    
    JButton boton2 = new JButton("Panel 2");
    boton2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // Actualizamos el contenido de los paneles en el centro y este
        panelCenter.removeAll();
        panelCenter.add(new JButton("Botón 5"));
        panelCenter.add(new JButton("Botón 6"));
        panelCenter.revalidate();
        panelCenter.repaint();
        
        panelEast.removeAll();
        panelEast.add(new JButton("Botón 7"));
        panelEast.add(new JButton("Botón 8"));
        panelEast.revalidate();
        panelEast.repaint();
      }
    });
    panelWest.add(boton2);
    
    setVisible(true);
  }
  
  

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
}

class PanelCenter extends JPanel {
  public PanelCenter() {
    add(new JButton("Botón 1"));
    add(new JButton("Botón 2"));
  }
}

class PanelEast extends JPanel {
  public PanelEast() {
    add(new JButton("Botón 3"));
    add(new JButton("Botón 4"));
  }
}
