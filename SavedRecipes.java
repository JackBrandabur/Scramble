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

public class SavedRecipes implements ActionListener {
	public static ArrayList<String> userRecipes = new ArrayList<String>();
	JFrame frame = new JFrame("Scramble - Recipes");
	
	JButton returnButton = new JButton("Return to Menu");
	JTextArea area = new JTextArea(27,60);
	JScrollPane pane = new JScrollPane(area);
	JPanel panel1 = new JPanel(new BorderLayout());
	JPanel panel2 = new JPanel(new FlowLayout());
	
	public static void main(String Args[]) {
		SavedRecipes recipes = new SavedRecipes();
	}
	
	SavedRecipes() {
		returnButton.addActionListener(this);
		panel2.add(returnButton);
		panel2.add(pane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1.add(panel2, BorderLayout.NORTH);
		frame.add(panel1);
		frame.setSize(750,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		userRecipesSearch();
		for (int i = 0; i < userRecipes.size(); i++) {
			area.append(userRecipes.get(i) + "\n");
		}
		area.setCaretPosition(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnButton) {
			MainMenu menu = new MainMenu();
			frame.setVisible(false);
		}
		
	}
	public static void userRecipesSearch() {
		String user = User.user;
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			ResultSet myRs = mystmt.executeQuery("select * from UserRecipes where UserName = '" + user + "';");
			while(myRs.next()) {
				userRecipes.add(myRs.getString("RecipeName"));
				userRecipes.add("Servings: " + myRs.getInt("Servings"));
				userRecipes.add("Prep Time: " + myRs.getInt("PrepTime"));
				userRecipes.add(myRs.getString("Ingredients"));
				userRecipes.add(myRs.getString("Directions"));
				userRecipes.add(myRs.getString("Nutrition"));
				userRecipes.add(myRs.getString("Source"));
				if (myRs.getInt("Publish") == 1) {
					userRecipes.add("Public Recipe");
				} else {
					userRecipes.add("Private Recipe");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
