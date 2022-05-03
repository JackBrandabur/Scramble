import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Admin.
 */
public class Admin implements ActionListener {

	/** The counter. */
	public static int counter = 8;
	
	/** The public recipes. */
	public static ArrayList<String> publicRecipes = new ArrayList<String>();
	
	/** The admin frame. */
	JFrame adminFrame = new JFrame("Admin Operations");
	
	/** The bar. */
	JToolBar bar = new JToolBar();
	
	/** The text. */
	JLabel text = new JLabel("Recipes awaiting approval:");
	
	/** The return button. */
	JButton returnButton = new JButton("Return to Menu");
	
	/** The accept recipe button. */
	JButton acceptRecipeButton = new JButton("Approve Recipe");
	
	/** The decline recipe button. */
	JButton declineRecipeButton = new JButton("Decline Recipe");
	
	/** The area. */
	JTextArea area = new JTextArea(25,55);
	
	/** The pane. */
	JScrollPane pane = new JScrollPane(area);
	
	/** The panel 1. */
	JPanel panel1 = new JPanel(new BorderLayout()); // Combined panel
	
	/** The panel 2. */
	JPanel panel2 = new JPanel(new GridLayout(1,3)); // Button panel
	
	/** The panel 3. */
	JPanel panel3 = new JPanel(new FlowLayout()); // TextArea panel
	
	/**
	 * Instantiates a new admin.
	 */
	Admin() {
		returnButton.addActionListener(this);
		acceptRecipeButton.addActionListener(this);
		declineRecipeButton.addActionListener(this);
		
		panel2.add(returnButton);
		panel2.add(acceptRecipeButton);
		panel2.add(declineRecipeButton);
		
		panel3.add(text);
		panel3.add(pane);
		panel1.add(panel2, BorderLayout.NORTH);
		panel1.add(panel3, BorderLayout.SOUTH);
		
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.add(panel1);
		adminFrame.setSize(750,500);
		adminFrame.setLocationRelativeTo(null);
		adminFrame.setVisible(true);
		
		publicRecipeSearch();
		for (int i = 0; i < 8; i++) {
			if (publicRecipes.size() <= i) break;
			area.append(publicRecipes.get(i) + "\n");
		}
		
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnButton) {
			MainMenu menu = new MainMenu();
			adminFrame.setVisible(false);
		}
		if (e.getSource() == acceptRecipeButton || e.getSource() == declineRecipeButton) {
			if (e.getSource() == acceptRecipeButton) {
				ArrayList<String> recipe = new ArrayList<String>();
				String[] nameAndID = publicRecipes.get(counter - 7).split("\\[");
				nameAndID[1] = nameAndID[1].substring(0, nameAndID[1].length() - 1);
				recipe.add(nameAndID[1]);
				recipe.add(nameAndID[0]);
				recipe.add(publicRecipes.get(counter - 6).substring(10, publicRecipes.get(counter - 6).length()));
				recipe.add(publicRecipes.get(counter - 5).substring(11, publicRecipes.get(counter - 5).length()));
				recipe.add(publicRecipes.get(counter - 4));
				recipe.add(publicRecipes.get(counter - 3));
				recipe.add(publicRecipes.get(counter - 2));
				recipe.add(publicRecipes.get(counter - 1));
				
				if (addRecipePublic(recipe)) area.setText("");
			}
			if (e.getSource()== declineRecipeButton) {
				String[] nameAndID = publicRecipes.get(counter - 7).split("\\[");
				if (nameAndID[0] == null) System.out.println("DUH");
				nameAndID[1] = nameAndID[1].substring(0, nameAndID[1].length() - 1);
				int recipeID = Integer.parseInt(nameAndID[1]);
				if (privatizeRecipe(recipeID)) area.setText("");
			}
			if (counter < publicRecipes.size() - 7) {
				int stopIndex = counter;
				for (int i = counter; i < stopIndex + 8; i++) {
					area.append(publicRecipes.get(i) + "\n");
					counter++;
				}
			}
		}
		
	}
	
	/**
	 * Adds the recipe public.
	 *
	 * @param recipe the recipe
	 * @return true, if successful
	 */
	public static boolean addRecipePublic(ArrayList<String> recipe) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			mystmt.executeUpdate("insert into Recipes (RecipeID, RecipeName, Servings, PrepTime, Ingredients, Directions, "
					+ "Nutrition, Source) Values ('" + recipe.get(0) + "', '" + recipe.get(1) 
						+ "-', " + Integer.parseInt(recipe.get(2)) + ", " + Integer.parseInt(recipe.get(3)) + ", '" + recipe.get(4) + "', '" + recipe.get(5) + "', 'Nutrition: " + recipe.get(6) 
						+ "', 'Source: " + recipe.get(7) +"')");
			mystmt.executeUpdate("delete from UserRecipes where RecipeID = '" + recipe.get(0) + "';");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Privatize recipe.
	 *
	 * @param recipeID the recipe ID
	 * @return true, if successful
	 */
	public static boolean privatizeRecipe(int recipeID) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			mystmt.executeUpdate("Update UserRecipes set publish = 0 WHERE RecipeID = '" + recipeID + "';");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Public recipe search.
	 */
	public static void publicRecipeSearch() {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			ResultSet myRs = mystmt.executeQuery("select * from UserRecipes where Publish = 1;");
			while(myRs.next()) {
				publicRecipes.add("User - " + myRs.getString("UserName"));
				publicRecipes.add(myRs.getString("RecipeName") + "[" + myRs.getInt("RecipeID") + "]");
				publicRecipes.add("Servings: " + myRs.getInt("Servings"));
				publicRecipes.add("Prep Time: " + myRs.getInt("PrepTime"));
				publicRecipes.add(myRs.getString("Ingredients"));
				publicRecipes.add(myRs.getString("Directions"));
				publicRecipes.add(myRs.getString("Nutrition"));
				publicRecipes.add(myRs.getString("Source"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
