import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	
	static double[][] PerlinMap = PerlinNoise.PerlinMap;
	static double[][][] Vectors = PerlinNoise.Vectors;
	static int size = PerlinNoise.size - 1;
	int type;
	
	MyPanel(int type) {
		// TODO Auto-generated constructor stub
		this.type = type;
		this.setPreferredSize(new Dimension(600,600));
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		if(type == 1) {
			int gridSize = 500/size;
			for(int i = 50; i < 550; i += gridSize) {
				for(int j = 50; j < 550; j += gridSize) {
					int x = (i - 50) / gridSize;
					int y = (j - 50) / gridSize;
					int RGB = (int) (PerlinMap[x][y] * 255);
					Color color = new Color(RGB, RGB, RGB);
					g2D.setPaint(color);
					g2D.fillRect(i, j, 50, 50);
				}
			}
		}
		
		else if (type == 0) {
			int gridSize = 500/size;
			for(int i = 50; i < 550; i += gridSize) {
				for(int j = 50; j < 550; j += gridSize) {
					int x = (i - 50) / gridSize;
					int y = (j - 50) / gridSize;
					g2D.drawRect(i, j, 50, 50);
				}
			}
			
			for(int i = 50; i < 550 + gridSize; i += gridSize) {
				for(int j = 50; j < 550 + gridSize; j += gridSize) {
					int x = (i - 50) / gridSize;
					int y = (j - 50) / gridSize;
					g2D.drawLine(i, j, i + (int) Math.round(Vectors[x][y][0] * 20), j + (int) Math.round(Vectors[x][y][1] * 20));
				}
			}
		}
		
		
		
		
	}

}
