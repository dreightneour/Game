package main;

import java.io.*;
import java.net.*;
import java.util.Objects;

public class NetworkManagerThreadReceive extends Thread {
	private Socket socket = null;
    public NetworkManagerThreadReceive(Socket socket) {
        super();
        this.socket = socket;
    }
     
    public void run() {
 
        try{ 
            //Connect and try to receive info
            //System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            recieveInfo(socket);
            //DataInputStream in = new DataInputStream(server.getInputStream());
            //System.out.println(in.readUTF());
            
            //Set up out info and send message, then close connection
            //sendInfo(socket);
            //DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress()
            //   + "\nGoodbye!");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void recieveInfo(Socket server) throws IOException
	{
		DataInputStream in = new DataInputStream(server.getInputStream());
		while(true)
		{
			String hold = in.readUTF();
			
	        System.out.println(hold);
	        if(Objects.equals(hold, "quit"))//hold == "quit")
	        {
	        	break;
	        }
		}
	}
    
    private void sendInfo(Socket server) throws IOException
    {
    	
    }
}
