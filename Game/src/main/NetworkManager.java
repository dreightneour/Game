package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Objects;

public class NetworkManager{// implements Runnable {

	private static int MAX_PLAYERS = 8;
	private ServerSocket serverSocket;
	private Socket[] thread;
	public NetworkManager()
	{
		
	    /*try {
			serverSocket = new ServerSocket(0);
			serverSocket.setSoTimeout(10000);
			System.out.println("Waiting for client on port " + 
					serverSocket.getLocalPort() + "...");
		    Socket server = serverSocket.accept();
		    */
		
	    boolean listening = true;
	    //thread = new  NetworkManagerThread[MAX_PLAYERS];
	    int count = 0;
        try { 
        	 
        	this.serverSocket = new ServerSocket(32000);
        	//serverSocket.setSoTimeout(10000);
        	System.out.println("Waiting for client on port " + 
					serverSocket.getLocalPort() + "...");
        	thread = new Socket[MAX_PLAYERS];
            while (listening) {
            	thread[count] = serverSocket.accept();
                new NetworkManagerThreadReceive(thread[count]).start();
                count++;
            }
        } catch(SocketTimeoutException s) {
            System.out.println("Socket timed out!");
         }catch (IOException e) {
            System.err.println("Could not listen on port " + 32000);
            System.exit(-1);
        }
			//Thread runner = new Thread(this);
			//runner.start();
	    
	      
	}
	
	/*public void run() {
	      while(true) {
	         try {
	        	 //Wait for socket
	            /*System.out.println("Waiting for client on port " + 
	               serverSocket.getLocalPort() + "...");
	            Socket server = serverSocket.accept();
	            
	            
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
	*/
}
