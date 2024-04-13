package gd;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

public class managerchater extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmangerport;
  ServerSocket srv = null;
  BufferedReader bf = null;
  Thread t;
  private JTabbedPane tabbedPane;
  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerchater frame = new managerchater();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public managerchater() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("managerport");
		lblNewLabel.setBounds(56, 10, 216, 13);
		contentPane.add(lblNewLabel);
		
		txtmangerport = new JTextField();
		txtmangerport.setText("8088");
		txtmangerport.setBounds(304, 7, 329, 16);
		contentPane.add(txtmangerport);
		txtmangerport.setColumns(10);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 76, 566, 478);
		contentPane.add(tabbedPane);
		this.setSize(600,695);
		int severport = Integer.parseInt(txtmangerport.getText());
		try {
			srv = new ServerSocket(severport);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		t= new Thread(this);
		t.start();
	}
 public void run() {
	 while(true) {
		 try {
			Socket socket = srv.accept();
			if(socket!= null) {
				bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String s = bf.readLine();
				int pos = s.indexOf(":");
				String staffname  =s.substring(pos + 1);
				Chatpanel p = new Chatpanel(socket , "Manger " , staffname);
				tabbedPane.add(staffname , p);
				 p.revalidate();
		          p.repaint();
				
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 
 }
}
