package gdchat;

import javax.swing.JPanel;
import javax.swing.JTextArea;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
Socket socket = null;
BufferedReader bf = null;
DataOutputStream dos = null;

String sender;
String receiver;


public class Chatpannel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Chatpannel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 369, 498, 103);
		add(panel);
		panel.setLayout(null);
		
		JTextArea txtboxchat = new JTextArea();
		txtboxchat.setBounds(10, 10, 323, 83);
		panel.add(txtboxchat);
		
		JButton btnNewButton = new JButton("SEND");
		btnNewButton.setBounds(357, 10, 131, 81);
		panel.add(btnNewButton);
		
		JTextArea txtmess = new JTextArea();
		txtmess.setBounds(10, 10, 498, 349);
		add(txtmess);

	}
}
