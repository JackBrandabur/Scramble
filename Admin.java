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

public class Admin implements ActionListener {

	public static int counter = 8;
	public static ArrayList<String> publicRecipes = new ArrayList<String>();
	JFrame adminFrame = new JFrame("Admin Operations");
	
	JToolBar bar = new JToolBar();
	
	JLabel text = new JLabel("Recipes awaiting approval:");
	
	JButton returnButton = new JButton("Return to Menu");
	JButton acceptRecipeButton = new JButton("Approve Recipe");
	JButton declineRecipeButton = new JButton("Decline Recipe");
	
	JTextArea area = new JTextArea(25,55);
	JScrollPane pane = new JScrollPane(area);
	
	JPanel panel1 = new JPanel(new BorderLayout()); // Combined panel
	JPanel panel2 = new JPanel(new GridLayout(1,3)); // Button panel
	JPanel panel3 = new JPanel(new FlowLayout()); // TextArea panel
	
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
