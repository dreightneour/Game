package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Objects;

public class NetworkManager{// implements Runnable {

	private static int MAX_PLAYERS = 2;
	private ServerSocket serverSocket;
	private Socket[] sockets;
	private int players;
	private ArrayList<String> messages;
	public NetworkManager() 
	{
		
	    /*try {
			serverSocket = new ServerSocket(0);
			serverSocket.setSoTimeout(10000);
			System.out.println("Waiting for client on port " + 
					serverSocket.getLocalPort() + "...");
		    Socket server = serverSocket.accept();
		    */
		messages = new ArrayList<String>();
	    boolean listening = true;
	    //thread = new  NetworkManagerThread[MAX_PLAYERS];
	    int count = 0;
        try { 
        	 
        	this.serverSocket = new ServerSocket(32000);
        	//serverSocket.setSoTimeout(10000);
        	System.out.println("Waiting for client on port " + 
					serverSocket.getLocalPort() + "...");
        	sockets = new Socket[MAX_PLAYERS];
            while (listening && count < MAX_PLAYERS) {
            	sockets[count] = serverSocket.accept();
                //new NetworkManagerThreadReceive(thread[count]).start();
                count++;
            }
            players = count;
            while(true)
            {
            	endTurn();
            	break;
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
	
	private void endTurn()
	{
		messages.clear();
		NetworkManagerThreadReceive[] thread = new NetworkManagerThreadReceive[players];
		for(int i = 0; i < players; i++)
		{
			thread[i] = new NetworkManagerThreadReceive(sockets[i]);
			thread[i].start();
		}
		for(int i = 0; i < players; i++)
		{
			try {
				thread[i].join();
				messages.add(thread[i].getMessage());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
