package gd;
import javax.swing.SwingUtilities;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;



import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientchater extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtstaff;
	private JTextField txtseverip;
	private JTextField txtseverport;
	Socket mngsocket = null;
	String mngip = " ";
	int port = 0 ;
	String staffname = " ";
	BufferedReader bf = null;
	DataOutputStream dos = null;
	outputthread t = null;
	private Clientchater thisframe;
	private JPanel panelvip;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientchater frame = new Clientchater();
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
	public Clientchater() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "startboderinfo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 778, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Staff:");
		lblNewLabel.setBounds(10, 27, 86, 20);
		panel.add(lblNewLabel);
		
		txtstaff = new JTextField();
		txtstaff.setBounds(92, 28, 111, 20);
		panel.add(txtstaff);
		txtstaff.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("MNG IP:");
		lblNewLabel_1.setBounds(224, 27, 105, 20);
		panel.add(lblNewLabel_1);
		
		txtseverip = new JTextField();
		txtseverip.setBounds(300, 28, 111, 20);
		panel.add(txtseverip);
		txtseverip.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("PORT:");
		lblNewLabel_2.setBounds(449, 31, 45, 13);
		panel.add(lblNewLabel_2);
		
		txtseverport = new JTextField();
		txtseverport.setBounds(524, 28, 96, 19);
		panel.add(txtseverport);
		txtseverport.setColumns(10);
		  thisframe = this;
		JButton btnconnect = new JButton("CONNECT");
		btnconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_btnconnect_actionPerformed(e);
			}
		});
		btnconnect.setBounds(648, 26, 120, 21);
		panel.add(btnconnect);
		
		panelvip = new JPanel();
		panelvip.setBounds(10, 115, 765, 232);
		contentPane.add(panelvip);
		
		
	}
	protected void do_btnconnect_actionPerformed(ActionEvent e) {
		mngip = txtseverip.getText();
		port = Integer.parseInt(txtseverport.getText());
		staffname = txtstaff.getText();
	 try {
		mngsocket = new Socket(mngip,port);
		if(mngsocket!=null) {
			Chatpanel p = new Chatpanel(mngsocket, staffname, mngip);
			this.getContentPane().add(p);
			p.Gettxtmessange().append("Manger is running ");
			p.updateUI();
			bf = new BufferedReader(new InputStreamReader(mngsocket.getInputStream()));
			dos = new DataOutputStream(mngsocket.getOutputStream());
			dos.writeBytes("Staff: " + staffname);
            dos.write(13);
            dos.write(10);
            dos.flush();
		}
	} catch (Exception e2) {
		// TODO: handle exception
	}
	}
}
