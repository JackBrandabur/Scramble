import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class AddRecipe.
 */
public class AddRecipe implements ActionListener {
	
	/** The new recipe. */
	public static String[] newRecipe = new String[9];
	
	/** The frame. */
	JFrame frame = new JFrame("Scramble - Add Recipe");
	
	/** The return button. */
	JButton returnButton = new JButton("Return to Menu");
	
	/** The veiw recipes button. */
	JButton veiwRecipesButton = new JButton("View Recipes");
	
	/** The add ingredient. */
	JButton addIngredient = new JButton("Add Ingredient");
	
	/** The add direction. */
	JButton addDirection = new JButton("Add Direction");
	
	/** The submit. */
	JButton submit = new JButton("Submit");
	
	/** The grid. */
	JPanel grid = new JPanel(new GridLayout(7,3));
	
	/** The panel. */
	JPanel panel = new JPanel(new BorderLayout());
	
	/** The buts. */
	JPanel buts = new JPanel();
	
	/** The label 1. */
	JLabel label1 = new JLabel("  Recipe Name: ");
	
	/** The label 2. */
	JLabel label2 = new JLabel("  Servings: ");
	
	/** The label 3. */
	JLabel label3 = new JLabel("  Prep Time: ");
	
	/** The label 4. */
	JLabel label4 = new JLabel("  Ingredients: ");
	
	/** The label 5. */
	JLabel label5 = new JLabel("  Directions");
	
	/** The label 6. */
	JLabel label6 = new JLabel("  Nutrition (per serving): ");
	
	/** The label 7. */
	JLabel label7 = new JLabel("  Source: (optional");
	
	/** The field 1. */
	JTextField field1 = new JTextField(30);
	
	/** The field 2. */
	JTextField field2 = new JTextField(30);
	
	/** The field 3. */
	JTextField field3 = new JTextField(30);
	
	/** The field 4. */
	JTextField field4 = new JTextField(30);
	
	/** The field 5. */
	JTextField field5 = new JTextField(30);
	
	/** The field 6. */
	JTextField field6 = new JTextField(30);
	
	/** The field 7. */
	JTextField field7 = new JTextField(30);
	
	/** The empty 1. */
	JLabel empty1 = new JLabel();
	
	/** The empty 2. */
	JLabel empty2 = new JLabel();
	
	/** The empty 3. */
	JLabel empty3 = new JLabel();
	
	/** The empty 6. */
	JLabel empty6 = new JLabel();
	
	/** The empty 7. */
	JLabel empty7 = new JLabel();
	
	/** The publish. */
	JCheckBox publish = new JCheckBox("Publish");
	
	/** The priv. */
	JCheckBox priv = new JCheckBox("Private");
	
	/** The buttons. */
	ButtonGroup buttons = new ButtonGroup();
	
	/**
	 * Instantiates a new adds the recipe.
	 */
	AddRecipe() {
		
		submit.addActionListener(this);
		returnButton.addActionListener(this);
		veiwRecipesButton.addActionListener(this);
		addIngredient.addActionListener(this);
		addDirection.addActionListener(this);
		
		grid.add(label1);
		grid.add(field1);
		grid.add(returnButton);
		grid.add(label2);
		grid.add(field2);
		grid.add(veiwRecipesButton);
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
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
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
			if (userDBConnect()) {
				field1.setText(null);
				field2.setText(null);
				field3.setText(null);
				field4.setText(null);
				field5.setText(null);
				field6.setText(null);
				field7.setText(null);
			}
		}
		if (e.getSource() == veiwRecipesButton) {
			SavedRecipes savedRecipes = new SavedRecipes();
			frame.setVisible(false);
		}
		if (e.getSource() == returnButton) {
			MainMenu menu = new MainMenu();
			newRecipe = new String[9];
			frame.setVisible(false);
		}
	}
	
	/**
	 * User DB connect.
	 *
	 * @return true, if successful
	 */
	public static boolean userDBConnect() {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			int serving = Integer.parseInt(newRecipe[2]);
			int prepTime = Integer.parseInt(newRecipe[3]);
			int publish = Integer.parseInt(newRecipe[8]);
			ResultSet myRs = mystmt.executeQuery("select * from Recipes Order by RecipeID DESC");
			myRs.next();
			int recipeID1 = myRs.getInt("RecipeID");
			ResultSet myRs2 = mystmt.executeQuery("select * from UserRecipes Order by RecipeID DESC");
			
			int recipeID = -1;
			if (myRs2.next()) {
				if (recipeID1 < myRs2.getInt("RecipeID")) {
					recipeID = myRs2.getInt("RecipeID") + 1;
				} else {
					recipeID = recipeID1 + 1;
				}
			} else {
				recipeID = recipeID1 + 1;
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
