import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class GUI.
 */
public class GUI implements ActionListener {
	
	// Components for the menu GUI
	
	/** The frame. */
	JFrame frame = new JFrame("Scramble");
	
	/** The panel 1. */
	JPanel panel1 = new JPanel();
	
	/** The panel 2. */
	JPanel panel2 = new JPanel();
	
	/** The panel 3. */
	JPanel panel3 = new JPanel(new BorderLayout());
	
	/** The panel 4. */
	JPanel panel4 = new JPanel();
	
	/** The user. */
	JLabel user = new JLabel("Username: ");
	
	/** The pass. */
	JLabel pass = new JLabel("Password: ");
	
	/** The guest. */
	JLabel guest = new JLabel("Search as Guest: ");
	
	/** The Login button. */
	JButton LoginButton = new JButton("Login");
	
	/** The Signup button. */
	JButton SignupButton = new JButton("Sign-Up");
	
	/** The Guest button. */
	JButton GuestButton = new JButton("Guest");
	
	/** The username. */
	JTextField username = new JTextField();
	
	/** The password. */
	JPasswordField password = new JPasswordField();
	
	/** The login bar. */
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
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		GUI gui = new GUI();
	}
	
	

	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
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
			User.user = "";
			MainMenu menu = new MainMenu();
			frame.setVisible(false);
		}
	}
	
	
}
