package clinetsever;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {
public static void main(String[] args) throws IOException {
	    ServerSocket server = new ServerSocket(1111);
	    System.out.println("Waiting for clinet !!");
	    while(true) {
	    	Socket socket = server.accept();
	    	new Sever_Process(socket).start();
	    	System.out.println("clinet" + socket.getInetAddress()+" connectd..");
	    	
	    }
	
}
}
