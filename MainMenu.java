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
	
	JButton ReturnButton = new JButton ("Logout");
	JButton PantryButton = new JButton("Virtual Pantry");
	JButton AdminButton = new JButton ("Admin");
	JButton SearchButton = new JButton("Search");
	JButton addRecipe = new JButton("Add and View Recipes");
	
	JToolBar toolBar = new JToolBar();
	
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	int found = 0;
	JLabel resultsFound = new JLabel("Recipes Found: " + found);
	
	JLabel searchLabel = new JLabel("Search Recipes");
	JTextField searchBar = new JTextField();
	
	JTextArea area = new JTextArea(5,10);
	JScrollPane pane = new JScrollPane(area);
	
	JCheckBox numberOfIngredients = new JCheckBox("Number Of Ingredients");
	JCheckBox prepTime = new JCheckBox("Prep Time");
	JCheckBox ingredientsFilter = new JCheckBox("Selected Pantry Ingredients");
	
	ButtonGroup buttons = new ButtonGroup();
	
	JLabel filters = new JLabel("  Filters:");
	
	
	
	MainMenu() {
		
		numberOfIngredients.addActionListener(this);
		prepTime.addActionListener(this);
		ingredientsFilter.addActionListener(this);
		addRecipe.addActionListener(this);
		
		toolBar.add(ReturnButton);
		ReturnButton.addActionListener(this);
		toolBar.add(PantryButton);
		PantryButton.addActionListener(this);
		if (User.user.equals("admin")) {
			toolBar.add(AdminButton);
			AdminButton.addActionListener(this);
		}
		buttons.add(numberOfIngredients);
		buttons.add(prepTime);
		toolBar.add(filters);
		toolBar.add(numberOfIngredients);
		toolBar.add(prepTime);
		toolBar.add(ingredientsFilter);
		panel2.add(toolBar);
		
		searchBar.setColumns(20);
		if (!(User.user == "")) {
			panel3.add(addRecipe);
		}
		panel3.add(searchLabel);
		panel3.add(searchBar);
		panel3.add(SearchButton);
		panel3.add(resultsFound);
		SearchButton.addActionListener(this);
		
		panel1.add(panel2, BorderLayout.NORTH);
		panel1.add(pane, BorderLayout.CENTER);
		panel1.add(panel3, BorderLayout.SOUTH);
		
		mainmenu.add(panel1);
		mainmenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainmenu.setSize(750,500);
		mainmenu.setLocationRelativeTo(null);
		mainmenu.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ReturnButton) {
			GUI login = new GUI();
			User.user = null;
			mainmenu.setVisible(false);
		}
		if (e.getSource() == PantryButton) {
			Pantry pantry = new Pantry(Pantry.ingredientsList);
			mainmenu.setVisible(false);
		}
		if (e.getSource() == AdminButton) {
			Admin admin = new Admin();
			mainmenu.setVisible(false);
		}
		if (e.getSource() == SearchButton) {
			int filter = 0;
			boolean pantryIngredients = false;
			if (numberOfIngredients.isSelected()) {
				filter = 1;
			}
			if (prepTime.isSelected()) {
				filter = 2;
			}
			if (ingredientsFilter.isSelected()) {
				pantryIngredients = true;
			}
			
			String searchItem = searchBar.getText();
			area.setText(null);
			found = 0;
			resultsFound.setText("Recipes Found: " + found);
			ArrayList<String> emptyIngredients = new ArrayList<String>();
			ArrayList<String> recipes = new ArrayList<String>();
			if (pantryIngredients) {
				recipes = Search.search(searchItem, filter, Pantry.ingredientsList);
			} else {
				recipes = Search.search(searchItem, filter, emptyIngredients);
			}
			//
			
			for (int i = 0; i < recipes.size(); i++) {
				area.append(recipes.get(i));
				if (recipes.get(i).contains("Servings:")) found++;
				area.append("\n");
			}
			area.setCaretPosition(0);
			resultsFound.setText("Recipes Found: " + found);
		}
		if (e.getSource() == addRecipe) {
			AddRecipe addRecipe = new AddRecipe();
			mainmenu.setVisible(false);
		}
	}
}
