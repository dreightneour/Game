package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Objects;

public class NetworkManager implements Runnable {

	private int connected;
	private ServerSocket serverSocket;
	public NetworkManager()
	{
		connected = 0;
	    try {
			serverSocket = new ServerSocket(32000);
			serverSocket.setSoTimeout(10000);
			Thread runner = new Thread(this);
			runner.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
	
	public void run() {
	      while(true) {
	         try {
	        	 //Wait for socket
	            System.out.println("Waiting for client on port " + 
	               serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            connected++;
	            
	            //Connect and try to receive info
	            System.out.println("Just connected to " + server.getRemoteSocketAddress());
	            recieveInfo(server);
	            //DataInputStream in = new DataInputStream(server.getInputStream());
	            //System.out.println(in.readUTF());
	            
	            //Set up out info and send message, then close connection
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
	            out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
	               + "\nGoodbye!");
	            server.close();
	            
	         }catch(SocketTimeoutException s) {
	            System.out.println("Socket timed out!");
	            break;
	         }catch(IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	   }
		
	private void recieveInfo(Socket server) throws IOException
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
}
