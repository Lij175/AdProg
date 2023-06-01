import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MyFrame extends JFrame{
	
	MyPanel panel;
	int type;
	
	MyFrame(int type) {
		// TODO Auto-generated constructor stub
		this.type = type;
		panel = new MyPanel(type);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	

}