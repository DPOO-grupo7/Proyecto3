package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Grid extends JPanel{

	private static final int PADDING = 10;
    private static final int CELL_SIZE = 12;
    private static final int SPACING = 4;
    private static final int COLUMNS = 53;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Set the rendering hints for antialiasing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set the background color
        g2d.setColor(new Color(240, 240, 240));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the grid
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[] { 3, 1 }, 0.0f));
        int x = PADDING, y = PADDING;
        for (int i = 0; i < COLUMNS; i++) {
            g2d.drawLine(x, 0, x, getHeight());
            x += CELL_SIZE + SPACING;
        }
        while (y < getHeight()) {
            g2d.drawLine(0, y, getWidth(), y);
            y += CELL_SIZE + SPACING;
        }

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        int width = COLUMNS * (CELL_SIZE + SPACING) + PADDING * 2;
        int height = 700;
        return new Dimension(width, height);
    }
}
