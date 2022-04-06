import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener {
	
	// Components for the menu GUI
	
	JFrame frame = new JFrame("Scramble");
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel(new BorderLayout());
	JPanel panel4 = new JPanel();
	
	JLabel user = new JLabel("Username: ");
	JLabel pass = new JLabel("Password: ");
	JLabel guest = new JLabel("Search as Guest: ");
	
	JButton LoginButton = new JButton("Login");
	JButton SignupButton = new JButton("Sign-Up");
	JButton GuestButton = new JButton("Guest");
	
	JTextField username = new JTextField();
	JPasswordField password = new JPasswordField();
	
	JToolBar loginBar = new JToolBar();
	
	/**
	 * Constructor for creating the initial menu.
	 */
	GUI() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SignupButton.setPreferredSize(new Dimension(200,50));
		LoginButton.setPreferredSize(new Dimension(200,50));
		GuestButton.setPreferredSize(new Dimension(200,50));
		loginBar.add(SignupButton, BorderLayout.CENTER);
		loginBar.add(LoginButton, BorderLayout.WEST);
		loginBar.add(GuestButton, BorderLayout.EAST);
		loginBar.setBackground(Color.BLUE);
		loginBar.setPreferredSize(new Dimension(200,50));
		loginBar.setFloatable(false);
		
		username.setColumns(10);
		password.setColumns(10);
		
		panel1.add(loginBar);
		panel2.add(user);
		panel2.add(username, BorderLayout.CENTER);
		panel4.add(pass);
		panel4.add(password, BorderLayout.SOUTH);
		
		//
		panel3.add(panel1, BorderLayout.NORTH);
		panel3.add(panel2, BorderLayout.CENTER);
		panel3.add(panel4, BorderLayout.SOUTH);
		
		
		//
		
		LoginButton.addActionListener(this);
		SignupButton.addActionListener(this);
		GuestButton.addActionListener(this);
		
		//
		frame.add(panel3);
		frame.add(panel3);
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == LoginButton) {
			String userEmail = username.getText();
			String userPassword = password.getText();
			if (User.login(userEmail, userPassword)) {
				MainMenu menu = new MainMenu();
				frame.setVisible(false);
			}
		}
		if (e.getSource() == SignupButton) {
			String userEmail = username.getText();
			String userPassword = password.getText();
			User.createAccount(userEmail, userPassword);
		}
		if (e.getSource() == GuestButton) {
			MainMenu menu = new MainMenu();
			frame.setVisible(false);
		}
	}
	
	
}
