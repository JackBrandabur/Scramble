import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddRecipe implements ActionListener {
	
	public static String[] newRecipe = new String[9];
	
	JFrame frame = new JFrame("Scramble - Add Recipe");
	
	JButton returnButton = new JButton("Return to Menu");
	JButton addIngredient = new JButton("Add Another Ingredient");
	JButton addDirection = new JButton("Add Another Direction");
	JButton submit = new JButton("Submit");
	
	JPanel grid = new JPanel(new GridLayout(7,3));
	JPanel panel = new JPanel(new BorderLayout());
	JPanel buts = new JPanel();
	
	JLabel label1 = new JLabel("  Recipe Name: ");
	JLabel label2 = new JLabel("  Servings: ");
	JLabel label3 = new JLabel("  Prep Time: ");
	JLabel label4 = new JLabel("  Ingredients: ");
	JLabel label5 = new JLabel("  Directions");
	JLabel label6 = new JLabel("  Nutrition (per serving): ");
	JLabel label7 = new JLabel("  Source: (optional");
	
	JTextField field1 = new JTextField(30);
	JTextField field2 = new JTextField(30);
	JTextField field3 = new JTextField(30);
	JTextField field4 = new JTextField(30);
	JTextField field5 = new JTextField(30);
	JTextField field6 = new JTextField(30);
	JTextField field7 = new JTextField(30);
	
	JLabel empty1 = new JLabel();
	JLabel empty2 = new JLabel();
	JLabel empty3 = new JLabel();
	JLabel empty6 = new JLabel();
	JLabel empty7 = new JLabel();
	
	JCheckBox publish = new JCheckBox("Publish");
	JCheckBox priv = new JCheckBox("Private");
	
	ButtonGroup buttons = new ButtonGroup();
	
	AddRecipe() {
		
		submit.addActionListener(this);
		returnButton.addActionListener(this);
		addIngredient.addActionListener(this);
		addDirection.addActionListener(this);
		
		grid.add(label1);
		grid.add(field1);
		grid.add(returnButton);
		grid.add(label2);
		grid.add(field2);
		grid.add(empty2);
		grid.add(label3);
		grid.add(field3);
		grid.add(empty3);
		grid.add(label4);
		grid.add(field4);
		grid.add(addIngredient);
		grid.add(label5);
		grid.add(field5);
		grid.add(addDirection);
		grid.add(label6);
		grid.add(field6);
		grid.add(empty6);
		grid.add(label7);
		grid.add(field7);
		grid.add(empty7);
		
		buts.add(publish);
		buts.add(priv);
		
		panel.add(grid, BorderLayout.NORTH);
		panel.add(buts, BorderLayout.CENTER);
		panel.add(submit, BorderLayout.SOUTH);
		
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550,300);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addIngredient) {
			if (newRecipe[4] == null) {
				newRecipe[4] = "\n" + field4.getText();
			} else {
				newRecipe[4] += "\n" + field4.getText();
			}
			field4.setText(null);
		}
		int step = 2;
		if (e.getSource() == addDirection) {
			if (newRecipe[5] == null) {
				newRecipe[5] = "\n" + "1) " + field5.getText();
			} else {
				newRecipe[5] += "\n" + step + ") " + field5.getText();
			}
			step++;
			field5.setText(null);
		}
		if (e.getSource() == submit) {
			newRecipe[0] = User.user;
			newRecipe[1] = field1.getText();
			newRecipe[2] = field2.getText();
			newRecipe[3] = field3.getText();
			newRecipe[4] = "Ingredients:" + newRecipe[4];
			newRecipe[5] = "Directions:" + newRecipe[5];
			newRecipe[6] = field6.getText();
			if (field7.getText().equals("")) {
				newRecipe[7] = "User " + User.user + "'s recipe";
			}
			newRecipe[7] = field7.getText();
			if (publish.isSelected()) {
				newRecipe[8] = "1";
			} else {
				newRecipe[8] = "0";
			}
			if (dBConnect()) {
				field1.setText(null);
				field2.setText(null);
				field3.setText(null);
				field4.setText(null);
				field5.setText(null);
				field6.setText(null);
				field7.setText(null);
			}
		}
		if (e.getSource() == returnButton) {
			MainMenu menu = new MainMenu();
			newRecipe = new String[9];
			frame.setVisible(false);
		}
	}
	
	public static boolean dBConnect() {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			int serving = Integer.parseInt(newRecipe[2]);
			int prepTime = Integer.parseInt(newRecipe[3]);
			int publish = Integer.parseInt(newRecipe[8]);
			ResultSet myRs = mystmt.executeQuery("select * from Recipes Order by RecipeID DESC");
			ResultSet myRs2 = mystmt.executeQuery("select * from Recipes Order by RecipeID DESC");
			myRs.next();
			myRs2.next();
			int recipeID = -1;
			if (myRs.getInt("RecipeID") < myRs2.getInt("RecipeID")) {
				recipeID = myRs2.getInt("RecipeID") + 1;
			} else {
				recipeID = myRs.getInt("RecipeID") + 1;
			}
			mystmt.executeUpdate("insert into UserRecipes (UserName, Publish, RecipeID, RecipeName, Servings, PrepTime, Ingredients, Directions, "
					+ "Nutrition, Source) Values ('" + newRecipe[0] + "', '" +  publish + "', '" + recipeID + "', '" + newRecipe[1] 
						+ "-', " + serving + ", " + prepTime + ", '" + newRecipe[4] + "', '" + newRecipe[5] + "', 'Nutrition: " + newRecipe[6] 
						+ "', 'Source: " + newRecipe[7] +"')");
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
