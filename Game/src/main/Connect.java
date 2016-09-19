package main;
// File Name GreetingClient.java
import java.net.*;
import java.io.*;

public class Connect {

	public Connect()
	{

		String serverName = "localhost";
		int port = 8080;
		try {
			//Connect to the server, serverName and port above
		   System.out.println("Connecting to " + serverName + " on port " + port);
		   Socket client = new Socket(serverName, port);
		   
		   //If connected, let person know and create the streams
			 System.out.println("Just connected to " + client.getRemoteSocketAddress());
			 OutputStream outToServer = client.getOutputStream();
			 DataOutputStream out = new DataOutputStream(outToServer);
			 
			 //write to server and make a receiving handler 
			 out.writeUTF("Hello from " + client.getLocalSocketAddress());
			 InputStream inFromServer = client.getInputStream();
			 DataInputStream in = new DataInputStream(inFromServer);
			 
			 //receive from the server and close
			 System.out.println("Server says " + in.readUTF());
			 client.close();
		  }catch(IOException e) {
		     e.printStackTrace();
		  }
		   
		
	}
}
