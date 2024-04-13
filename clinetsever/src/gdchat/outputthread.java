package gdchat;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

public class outputthread  extends Thread{
Socket s = null;
BufferedReader read = null;
JTextArea txt;
String admin;
String nhanvien;

public outputthread(Socket s, BufferedReader read, JTextArea txt, String admin, String nhanvien) {
	super();
	this.s = s;
	this.read = read;
	this.txt = txt;
	this.admin = admin;
	this.nhanvien = nhanvien;
	try {
		read = new BufferedReader(new InputStreamReader(s.getInputStream()));
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}

public void run() {
while(true) {
	try {
		String mess = read.readLine();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
}
	
	
}

}
