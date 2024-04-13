package clinetsever;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Sever_Process  extends Thread{
	Socket socket;
	BufferedReader netIN;
	PrintWriter netout;
	public Sever_Process(Socket socket) {
		this.socket = socket;
		try {
			netIN = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			netout = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void run() {
		netout.println("hello client");
		netout.flush();
		while(true) {
			String command;
			try {
				command = netIN.readLine();
			
			if(command.equalsIgnoreCase("quit"))
			  {   netout.flush();
				netout.println("bye client");
				netIN.close();
				netout.close();
			   break;
				
			}else {
				netout.println("Sever response: " + command+"echo");
				
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
			
	}
	
	}
}
