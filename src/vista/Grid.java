package vista;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Grid extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final int PADDING = 20;
	private static final int CELL_SIZE = 25;
	private static final int SPACING = 10;
	private static final int COLUMNS = 12;
	private static final Color[] COLORS = { Color.WHITE, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED };
	private int[][] colorGrid = new int[COLUMNS][50];

	public Grid(int[][] colorGrid) {
		this.colorGrid = colorGrid;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(new Color(240, 240, 240));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		int x = PADDING, y = PADDING;
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < 50; j++) {
				int colorIndex = colorGrid[i][j];
				g2d.setColor(COLORS[colorIndex]);
				g2d.fillRect(x, y, CELL_SIZE, CELL_SIZE);
				g2d.setColor(Color.LIGHT_GRAY);
				g2d.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f,
						new float[] { 3, 1 }, 0.0f));
				g2d.drawRect(x, y, CELL_SIZE, CELL_SIZE);
				y += CELL_SIZE + SPACING;
			}
			y = PADDING;
			x += CELL_SIZE + SPACING;
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