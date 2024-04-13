package gd;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import gd.outputthread;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;

public class Chatpanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea boxchatmess;
	private JTextArea txtmessange;
	private JButton btnNewButton;
	Socket socket = null;
	BufferedReader bf = null;
	DataOutputStream dos = null;
	outputthread t = null;
	String sender;
	String reciver;
	
	/**
	 * Create the panel.
	 */
	public Chatpanel(Socket s  , String sender , String reciver) {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 311, 532, 112);
		add(panel);
		panel.setLayout(null);
		
		boxchatmess = new JTextArea();
		boxchatmess.setBounds(10, 10, 329, 92);
		panel.add(boxchatmess);
		
		btnNewButton = new JButton("SEND");
		btnNewButton.setBounds(349, 10, 171, 90);
		panel.add(btnNewButton);
		
		txtmessange = new JTextArea();
		txtmessange.setBounds(10, 10, 518, 281);
		add(txtmessange);
		socket  = s;
		this.sender = sender;
		this.reciver = reciver;
		try {
			bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			dos = new DataOutputStream(socket.getOutputStream());
			t = new outputthread(s, txtmessange, bf, sender, reciver);
			t.start();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	public JTextArea Gettxtmessange() {
		return this.txtmessange;
	}
	
	protected void do_btnNewButton_actionPerformed(ActionEvent e) {
		try {
			if(boxchatmess.getText().trim().length() == 0 ) return ;
			dos.writeBytes(boxchatmess.getText());
			dos.write(13);
			dos.write(10);
			dos.flush();
			this.txtmessange.append("\n" + "Sender: " + boxchatmess.getText().trim());
			boxchatmess.setText(" " );
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
