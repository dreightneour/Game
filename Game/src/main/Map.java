package main;
import javax.swing.*;

public class Map extends JFrame{

	private static final long serialVersionUID = 1L;

	public Map()
	{
		JFrame frame = new JFrame("GAME");
        //Create and set up the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("FUCK");
        frame.getContentPane().add(label);

        //Display the window.
        frame.setSize(500, 500);
        frame.setVisible(true);

        

	}
}
