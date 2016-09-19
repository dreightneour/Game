package main;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Map extends JPanel{
 private int size;
	

	public Map()
	{
		size = 7;
		JFrame frame = new JFrame("GAME");
        //Create and set up the window
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
	    int xpoints[] = {0, -50, 0, 50};
	    int ypoints[] = {0, 50, 100, 50};
	    int npoints = 4;
	    int xpointsC[] = new int[npoints];
	    int ypointsC[]= new int[npoints];
	    
	    
	   // 

	   for(int i = 0; i < size; i++)
	   {
		   if(i < size / 2)
		   {
			   for(int j = 0; j <= i % (size/2); j++)
			   {
				   //g.drawRect(j * 50 - (i * 25) + 250, i * 50, 50, 50);
				   for(int k = 0; k < npoints; k++)
				   {
					   xpointsC[k] = xpoints[k] + (j * 100) - (i * 50) + 250;
					   ypointsC[k] = ypoints[k] + i * 50;
				   }
				   g.drawPolygon(xpointsC, ypointsC, npoints);
			   }
		   }
		   else if(i == size / 2)
		   {
			   for(int j = 0; j < (size + 1) / 2; j++)
			   {
				   //g.drawRect(j * 50 - (i * 25) + 250, i * 50, 50, 50);
				   for(int k = 0; k < npoints; k++)
				   {
					   xpointsC[k] = xpoints[k] + (j * 100) - (i * 50) + 250;
					   ypointsC[k] = ypoints[k] + i * 50;
				   }
				   g.drawPolygon(xpointsC, ypointsC, npoints);
			   }
		   }
		   else
		   {
			   for(int j = 0; j < (size - i) % size; j++)
			   {
				   for(int k = 0; k < npoints; k++)
				   {
					   xpointsC[k] = xpoints[k] + (j * 100) - ((size - (i + 1)) * 50) + 250;
					   ypointsC[k] = ypoints[k] + i * 50;
				   }
				   g.drawPolygon(xpointsC, ypointsC, npoints);
				   //g.drawRect(j * 50 - ((size - (i + 1)) * 25) + 250, i * 50, 50, 50);
			   }
		   }

	   }
   }
}
