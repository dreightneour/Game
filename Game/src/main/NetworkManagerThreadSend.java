package main;

import java.io.*;
import java.net.*;
import java.util.Objects;

public class NetworkManagerThreadSend extends Thread {
	private Socket socket = null;
	private String message;
    public NetworkManagerThreadSend(Socket socket, String string) {
        super();
        this.socket = socket;
        message = string;
    }
     
    public void run() {
 
        try{ 
            //Connect and try to receive info
            //System.out.println("Just connected to " + socket.getRemoteSocketAddress());
            //recieveInfo(socket);
            //DataInputStream in = new DataInputStream(server.getInputStream());
            //System.out.println(in.readUTF());
            
            //Set up out info and send message, then close connection
            sendInfo(socket);
            //DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            //out.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress()
            //   + "\nGoodbye!");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void sendInfo(Socket server) throws IOException
	{
    	DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		while(true)
		{
			//String hold = in.readUTF();
			out.writeUTF(message);
			out.close();
	        //System.out.println(hold);
	        //if(Objects.equals(message, "quit"))//hold == "quit")
	        //{
	        //	break;
	        //}
		}
	}
}
