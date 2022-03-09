import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener {
	
	// Components for the menu GUI
	
	JFrame frame = new JFrame("Scramble");
	
	JPanel panel1 = new JPanel(new FlowLayout(2,2,2));
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JButton FilterButton = new JButton("Filter");
	JButton LoginButton = new JButton("Login");
	JButton SignupButton = new JButton("Sign-Up");
	JButton PantryButton = new JButton("Virtual Pantry");
	
	JTextField SearchBar = new JTextField("Search Recipes");
	
	JToolBar toolBar = new JToolBar();
	
	/**
	 * Constructor for creating the initial menu.
	 */
	GUI() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//SearchBar.setSize(200,50);
		
		// Action to open the virtual pantry GUI
		PantryButton.addActionListener(this);
		
		//
		toolBar.add(FilterButton);
		//toolBar.add(SearchBar);
		toolBar.add(LoginButton);
		toolBar.add(SignupButton);
		toolBar.add(PantryButton);
		toolBar.setBackground(Color.BLUE);
		toolBar.setFloatable(false);
		
		//
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.add(toolBar);
		panel3.add(panel2);
		
		
		//
		frame.add(panel3);
		frame.setSize(1000, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		GUI gui = new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == PantryButton) {
			Pantry myPantry = new Pantry();
		}
		
	}
}
