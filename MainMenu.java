import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class MainMenu implements ActionListener {
	JFrame mainmenu = new JFrame("Scramble - Main Menu");
	
	JToolBar toolBar = new JToolBar();
	
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JLabel searchLabel = new JLabel("Search Recipes");
	JTextField searchBar = new JTextField();
	
	JTextArea area = new JTextArea(5,10);
	JScrollPane pane = new JScrollPane(area);
	
	JButton ReturnButton = new JButton ("Logout");
	JButton PantryButton = new JButton("Virtual Pantry");
	JButton SearchButton = new JButton("Search");
	
	JCheckBox allergy = new JCheckBox("Allergy");
	JCheckBox region = new JCheckBox("Regional");
	
	ButtonGroup buttons = new ButtonGroup();
	
	JLabel filters = new JLabel("  Filters:");
	
	MainMenu() {
		toolBar.add(ReturnButton);
		ReturnButton.addActionListener(this);
		toolBar.add(PantryButton);
		PantryButton.addActionListener(this);
		buttons.add(allergy);
		buttons.add(region);
		toolBar.add(filters);
		toolBar.add(allergy);
		toolBar.add(region);
		panel2.add(toolBar);
		
		searchBar.setColumns(20);
		panel3.add(searchLabel);
		panel3.add(searchBar);
		panel3.add(SearchButton);
		SearchButton.addActionListener(this);
		
		panel1.add(panel2, BorderLayout.NORTH);
		panel1.add(pane, BorderLayout.CENTER);
		panel1.add(panel3, BorderLayout.SOUTH);
		
		mainmenu.add(panel1);
		mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainmenu.setSize(500,500);
		mainmenu.setLocationRelativeTo(null);
		mainmenu.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ReturnButton) {
			GUI login = new GUI();
			mainmenu.setVisible(false);
		}
		if (e.getSource() == PantryButton) {
			Pantry pantry = new Pantry();
			mainmenu.setVisible(false);
		}
		if (e.getSource() == SearchButton) {
			String searchItem = searchBar.getText();
			area.setText(null);
			ArrayList<String> recipes = Search.search(searchItem, false);
			for (int i = 0; i < recipes.size(); i++) {
				area.append(recipes.get(i));
				area.append("\n");
			}
		}
	}
}
