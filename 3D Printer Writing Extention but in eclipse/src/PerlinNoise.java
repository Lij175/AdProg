import java.awt.Graphics;

public class PerlinNoise {
	
	static double smoothness = 0.5;
	static int size = 10+1;
	static double[][] PerlinMap = new double [size - 1][size - 1];
	static double[][][] Vectors = new double [size][size][2];
	
	public static void main(String[] args) {
		new MyFrame(0);
		new MyFrame(1);
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				//(r cos(i * 2pi/n) + h, r sin(i * 2pi/n) + k)
				int rand = (int) (Math.random() * 50);
				double x = Math.cos(rand * Math.PI / 25);
				
				rand = (int) (Math.random() * 50);
				double y = Math.sin(rand * Math.PI / 25);
				
				Vectors[i][j] = new double[] {x,y};
			}
		}
		
		double[] input = new double[] {Math.random(),  Math.random()};
		
		for(int i = 0; i < size - 1; i++){
			for(int j = 0; j < size - 1; j++) {
				PerlinMap[i][j] = findNoiseValue(Vectors[i+1][j], Vectors[i+1][j+1], Vectors[i][j+1], Vectors[i][j], input);
			}
		}
		
		
		/*
		// fill map with random 1, 0 (value Noise)
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				PerlinMap[i][j] = Math.random();
			}
		}
		*/
		
		
		/*
		// saddle point
		double x = -1;
		double y = -1;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++) {
				PerlinMap[i][j] = 0.5 * ((x * x) - (y * y)) + 0.5;
				y += (double) 2/size;
			}
			x += (double) 2/size;
			y = -1;
		}*/
		
		
		printNoiseMap(PerlinMap);
	} 
	
	private static double findNoiseValue(double[] x0y0, double[] x1y0, double[] x1y1, double[] x0y1, double[] xy) {
		// generate a vector going from the grid point to (x, y), which is easily calculated by subtracting 
		// the grid point from (x, y)
		double[] xy_x0y0 = new double[] {xy[0] - 0,  xy[1] - 0};
		double[] xy_x1y0 = new double[] {xy[0] - 1,  xy[1] - 0};
		double[] xy_x0y1 = new double[] {xy[0] - 0,  xy[1] - 1};
		double[] xy_x1y1 = new double[] {xy[0] - 1,  xy[1] - 1};
		
		// the influence of each gradient can be calculated by performing a dot product of the gradient 
		// and the vector going from its associated grid point to (x, y)
		double s = x0y0[0] * xy_x0y0[0] + x0y0[1] * xy_x0y0[1];
		double t = x1y0[0] * xy_x1y0[0] + x1y0[1] * xy_x1y0[1];
		double u = x0y1[0] * xy_x0y1[0] + x0y1[1] * xy_x0y1[1];
		double v = x1y1[0] * xy_x1y1[0] + x1y1[1] * xy_x1y1[1];
	
		double Sx = Sx(xy[0], x0y0[0]);
		double a = s + Sx * (t - s);
		double b = u + Sx * (v - u);
		
		double Sy = Sx(xy[1], x0y0[1]);
		
		return a + Sy * (b - a);
	}
	public static double Sx(double x, double x0) {
		return (3 * (x - x0) * (x - x0)) - (2 * (x - x0) * (x - x0) * (x - x0));
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