import java.awt.Graphics;

public class PerlinNoise {
	
	static double smoothness = 0.5;
	static int size = 100;
	static double[][] PerlinMap = new double [size][size];
	static double[][][] Vectors = new double [size][size][2];
	
	public static void main(String[] args) {
		new MyFrame();
		/**
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {s
				//(r cos(i * 2pi/n) + h, r sin(i * 2pi/n) + k)
				int rand = (int)Math.random() * 50;
				double x = Math.cos(rand * Math.PI / 25);
				
				rand = (int)Math.random() * 50;
				double y = Math.sin(rand * Math.PI / 25);
				
				Vectors[i][j] = new double[] {x,y};
			}
		}
		
		double[] input = new double[] {Math.random(),  Math.random()};
		**/
		
		/*
		// fill map with random 1, 0 (value Noise)
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				PerlinMap[i][j] = Math.random();
			}
		}
		*/
		double x = -1;
		double y = -1;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				PerlinMap[i][j] = 0.5 * ((x * x) - (y * y)) + 0.5;
				y += (double) 2/size;
			}
			x += (double) 2/size;
			y = -1;
		}
		//X^2
		
		
		printNoiseMap(PerlinMap);
	} 
	
	public static void printNoiseMap(double[][] perlinMap) {
		int size = perlinMap.length;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(perlinMap[i][j] + "  ");
			}
			System.out.println();
			System.out.println();
		}
	}

}
