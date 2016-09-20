package main;
// File Name GreetingClient.java
import java.net.*;
import java.util.Objects;
import java.util.Scanner;
import java.io.*;

public class Connect {

	public Connect()
	{

		String serverName = "localhost";

		//int port = inS.nextInt();
		int port = 32000;
		try {
			//Connect to the server, serverName and port above
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);
		   
			//If connected, let person know and create the streams
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			//OutputStream outToServer = client.getOutputStream();
			//DataOutputStream out = new DataOutputStream(outToServer);
			
			writeToServer(client);
			//write to server and make a receiving handler 
			
			//out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			 
			//receive from the server and close
			//System.out.println("Server says " + in.readUTF());
			client.close();
		}catch(IOException e) {
			  e.printStackTrace();
		}
		   
		
	}
	
	private void writeToServer(Socket client) throws IOException
	{
		Scanner inS= new Scanner(System.in);
		OutputStream outToServer = client.getOutputStream();
		
		//
		while(true)
		{
			DataOutputStream out = new DataOutputStream(outToServer);
			String send = inS.nextLine();
			out.writeUTF(send);
			out.flush();
			if(Objects.equals(send, "quit"))//send.equals("quit"))
			{
				break;
			}
		}
		
		
		
		//write to server and make a receiving handler 
		
		
	}
}
