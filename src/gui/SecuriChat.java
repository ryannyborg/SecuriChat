package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import gui.Server.ServerStart;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecuriChat {

	private JFrame frmSecurichat;
	private JTextField userNameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SecuriChat window = new SecuriChat();
					window.frmSecurichat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SecuriChat() {
		initialize();
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSecurichat = new JFrame();
		frmSecurichat.getContentPane().setBackground(Color.WHITE);
		frmSecurichat.setTitle("SecuriChat");
		frmSecurichat.setBounds(100, 100, 600, 450);
		frmSecurichat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblUsername = new JLabel("Username:");
		
		JButton btnLogin = new JButton("Connect");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				//frmSecurichat.setVisible(false);
				//new SelectUser().setVisible(true);
				String username = userNameField.getText();
				
				if(username != null && !username.isEmpty()){
					frmSecurichat.dispose();
					//ChatRoom newChat = new ChatRoom(username);
					String[] sendToChatRoom = {username};
					new ChatRoom(username).main(sendToChatRoom);
				}
				else{
					JOptionPane.showMessageDialog(null, "Please enter a username to continue.");
				}
			}
		});
		
		userNameField = new JTextField();
		userNameField.setColumns(10);
		
		JLabel lblSecuriChatLogo = new JLabel("");
		lblSecuriChatLogo.setIcon(new ImageIcon("/Users/ryannyborg/Documents/GitHub/SecuriChat/images/SecuriChat Logo.png"));
		
		JLabel lblServerMsg = new JLabel("");
		
		GroupLayout groupLayout = new GroupLayout(frmSecurichat.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(191)
							.addComponent(lblSecuriChatLogo))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(134)
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userNameField, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)))
					.addContainerGap(173, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(245)
					.addComponent(btnLogin)
					.addContainerGap(259, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(533, Short.MAX_VALUE)
					.addComponent(lblServerMsg)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(lblSecuriChatLogo)
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(userNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin)
					.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
					.addComponent(lblServerMsg)
					.addContainerGap())
		);
		frmSecurichat.getContentPane().setLayout(groupLayout);
		
	}
}
