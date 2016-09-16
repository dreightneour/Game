package main;
import javax.swing.*;

public class Map extends JFrame{
	public Map()
	{

        JFrame frame = new JFrame("GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        System.out.println("0");
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);

        //Display the window.
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        //frame.setUndecorated(true);
        //frame.setVisible(true);
        frame.pack();
        frame.setVisible(true);
        

	}
}
