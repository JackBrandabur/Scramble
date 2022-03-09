import java.awt.*; 
import javax.swing.*;

public class GUI {
	private static void createGUI() {
		JFrame frame = new JFrame("Scramble");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel(new FlowLayout(2,2,2));
		JButton FilterButton = new JButton("Filter");
		JButton LoginButton = new JButton("Login");
		JTextField SearchBar = new JTextField("Search Recipes");
		//SearchBar.setSize(200,50);
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(FilterButton);
		//toolBar.add(SearchBar);
		toolBar.add(LoginButton);
		toolBar.setBackground(Color.BLUE);
		toolBar.setFloatable(false);
		
		JPanel panel2 = new JPanel();
		
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.PAGE_AXIS));
		panel3.add(toolBar);
		panel3.add(panel2);
		
		frame.add(panel3);
		frame.setSize(1000, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		createGUI();
	}
}
