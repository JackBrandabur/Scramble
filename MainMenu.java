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

// TODO: Auto-generated Javadoc
/**
 * The Class MainMenu.
 */
public class MainMenu implements ActionListener {
	
	/** The mainmenu. */
	JFrame mainmenu = new JFrame("Scramble - Main Menu");
	
	/** The Return button. */
	JButton ReturnButton = new JButton ("Logout");
	
	/** The Pantry button. */
	JButton PantryButton = new JButton("Virtual Pantry");
	
	/** The Admin button. */
	JButton AdminButton = new JButton ("Admin");
	
	/** The Search button. */
	JButton SearchButton = new JButton("Search");
	
	/** The add recipe. */
	JButton addRecipe = new JButton("Add and View Recipes");
	
	/** The tool bar. */
	JToolBar toolBar = new JToolBar();
	
	/** The panel 1. */
	JPanel panel1 = new JPanel(new BorderLayout());
	
	/** The panel 2. */
	JPanel panel2 = new JPanel();
	
	/** The panel 3. */
	JPanel panel3 = new JPanel();
	
	/** The found. */
	int found = 0;
	
	/** The results found. */
	JLabel resultsFound = new JLabel("Recipes Found: " + found);
	
	/** The search label. */
	JLabel searchLabel = new JLabel("Search Recipes");
	
	/** The search bar. */
	JTextField searchBar = new JTextField();
	
	/** The area. */
	JTextArea area = new JTextArea(5,10);
	
	/** The pane. */
	JScrollPane pane = new JScrollPane(area);
	
	/** The number of ingredients. */
	JCheckBox numberOfIngredients = new JCheckBox("Number Of Ingredients");
	
	/** The prep time. */
	JCheckBox prepTime = new JCheckBox("Prep Time");
	
	/** The ingredients filter. */
	JCheckBox ingredientsFilter = new JCheckBox("Selected Pantry Ingredients");
	
	/** The buttons. */
	ButtonGroup buttons = new ButtonGroup();
	
	/** The filters. */
	JLabel filters = new JLabel("  Filters:");
	
	
	
	/**
	 * Instantiates a new main menu.
	 */
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
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
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
