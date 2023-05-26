import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	static double[][] PerlinMap = PerlinNoise.PerlinMap;
	static int size = PerlinNoise.size;
	
	MyPanel() {
		// TODO Auto-generated constructor stub
		this.setPreferredSize(new Dimension(500,500));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		
		int gridSize = 500/size;
		for(int i = 0; i < 500; i += gridSize) {
			for(int j = 0; j < 500; j += gridSize) {
				int x = i / gridSize;
				int y = j / gridSize;
				int RGB = (int) (PerlinMap[x][y] * 256);
				Color color = new Color(RGB, RGB, RGB);
				g2D.setPaint(color);
				g2D.fillRect(i, j, 50, 50);
			}
		}
		
		
		
		
		
	}

}
