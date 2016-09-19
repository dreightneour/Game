package main;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Map extends JPanel{
 
	

	public Map()
	{
		JFrame frame = new JFrame("GAME");
        //Create and set up the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //JPanel panel = new JPanel();
        this.setSize(500, 500);
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("FUCK");
        this.add(label);
        frame.getContentPane().add(this);

        //Display the window.
        
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
       System.out.println(this.getSize());
       repaint();
	}

	
   public void paint(Graphics g){
		g.setColor(Color.BLUE);
		g.fillOval(40, 40, 60, 60); //FOR CIRCLE
		g.fillRect(80, 30, 200, 200); // FOR SQUARE
		g.fillRect(200, 100, 100, 200); // FOR RECT
		
		g.setColor(Color.BLACK);
		g.drawOval(40, 40, 60, 60); //FOR CIRCLE
		g.drawRect(80, 30, 200, 200); // FOR SQUARE
		g.drawRect(200, 100, 100, 200); // FOR RECT
   }
}
