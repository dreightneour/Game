package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Client implements ActionListener{
JFrame frame = new JFrame("GAME");
JButton map = new JButton("MAP");
	public Client()
	{
		
	    //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    System.out.println("0");
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    //Add the ubiquitous "Hello World" label.
	    
	    map.setSize(75, 50);
	    map.addActionListener(this);
	    panel.add(map);
	    
	    
	    
	    JLabel label = new JLabel("Hello World");
	    panel.add(label);
	    frame.getContentPane().add(panel);
	    
	   
	    //Display the window.
	    //frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
	    //frame.setUndecorated(true);
	    //frame.setVisible(true);
	    frame.setSize(200, 200);
	    frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) 
	{ 
		//frame.revalidate();
		Map mapS = new Map();
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

	}
}
	

