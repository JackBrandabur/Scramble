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

public class Pantry implements ActionListener {
	public static ArrayList<String> ingredientsList = new ArrayList<String>();
	JFrame pantry = new JFrame("Scramble - Pantry");
	
	JTextField addField = new JTextField(10);
	JLabel newIngredient = new JLabel("Ingredient: ");
	JTextArea area = new JTextArea(10,20);
	JScrollPane pane = new JScrollPane(area);
	JScrollBar scroll = new JScrollBar();
	
	JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
	
	JTextArea savedArea = new JTextArea(10,20);
	JScrollPane savedPane = new JScrollPane(savedArea);
	JScrollBar savedScroll = new JScrollBar();
	JLabel newFilter = new JLabel("Filter Ingredient: ");
	JTextField addIng = new JTextField(10);
	
	
	JToolBar toolBar = new JToolBar();
	JToolBar toolBar2 = new JToolBar();
	JToolBar toolBar3 = new JToolBar();
	
	JPanel mainPanel = new JPanel();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	
	JButton ret = new JButton("Return to Menu");
	JButton add = new JButton("Add Ingredient");
	JButton save = new JButton("Save Pantry");
	JButton add2 = new JButton("Add Ingredient");
	JButton save2 = new JButton("Save Filters");
	JButton clear = new JButton("Clear Filters");
	
	Pantry(ArrayList<String> ingredientsList) {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			ResultSet myRs = mystmt.executeQuery("SELECT * FROM PantryIngredients Where UserName = '" + User.user + "';");
			while (myRs.next()) {
				if (myRs.getInt("Filter") == 0) {
					area.append(myRs.getString("Ingredient") + "\n");
				} else {
					savedArea.append(myRs.getString("Ingredient") + "\n");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ret.addActionListener(this);
		add.addActionListener(this);
		save.addActionListener(this);
		save2.addActionListener(this);
		add2.addActionListener(this);
		clear.addActionListener(this);
		
		toolBar2.add(ret);
		toolBar2.add(add);
		toolBar2.add(save);
		
		toolBar3.add(add2);
		toolBar3.add(save2);
		toolBar3.add(clear);
		
		panel.add(toolBar, BorderLayout.NORTH);
		panel.add(toolBar2, BorderLayout.SOUTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(newIngredient, BorderLayout.SOUTH);
		panel.add(addField, BorderLayout.SOUTH);
		
		panel.add(savedPane, BorderLayout.SOUTH);
		panel.add(newFilter, BorderLayout.SOUTH);
		panel.add(addIng, BorderLayout.SOUTH);
		panel.add(toolBar3, BorderLayout.SOUTH);
		
		pantry.add(panel);
		pantry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantry.setSize(300,500);
		pantry.setLocationRelativeTo(null);
		pantry.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ret) {
			MainMenu menu = new MainMenu();
			pantry.setVisible(false);
		}
		if (e.getSource() == add) {
			String item = addField.getText().toLowerCase();
			if (!(area.getText().contains(item))) {
				area.append(item);
				area.append("\n");
			}
			addField.setText("");
		}
		if (e.getSource() == save) {
			String[] savedIngredients= area.getText().split("\n");
			ingredientsDBConnect(savedIngredients, false);
		}
		if (e.getSource() == save2) {
			String[] savedIngredients= savedArea.getText().split("\n");
			ingredientsDBConnect(savedIngredients, true);
		}
		if (e.getSource() == add2) {
			String item = addIng.getText().toLowerCase();
			if (!savedArea.getText().contains(item)) {
				ingredientsList.add(item);
				savedArea.append(item);
				savedArea.append("\n");
			}
			addIng.setText("");
		}
		if (e.getSource() == clear) {
			ingredientsList = new ArrayList<String>();
			savedArea.setText(null);
			filterIngredientsDBClear();
		}
	}
	
	public static void ingredientsDBConnect(String[] ingredients, boolean filter) {
		int filterResult = 0;
		if (filter) {
			filterResult = 1;
		}
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet myRs = mystmt.executeQuery("SELECT * FROM PantryIngredients Where UserName = '" + User.user + "' AND Filter = " 
			+ filterResult + ";");
			ArrayList<String> newIngredientsList = new ArrayList<String>();
			for (int i = 0; i < ingredients.length; i++) {
				newIngredientsList.add(ingredients[i]);
			}
			while (myRs.next()) {
				for (int i = 0; i < ingredients.length; i++) {
					if (myRs.getString("Ingredient").equalsIgnoreCase(ingredients[i])) {
						newIngredientsList.remove(ingredients[i]);
					}
				}
			}
			for (int i = 0; i < newIngredientsList.size(); i++) {
				mystmt.executeUpdate("Insert into PantryIngredients (Ingredient, Filter, UserName) Values ('" + newIngredientsList.get(i).toLowerCase() + "', " + filterResult 
						+  ", '" + User.user + "');");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void filterIngredientsDBClear() {
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Scramble", "root", "admin123");
			Statement mystmt = myConn.createStatement();
			mystmt.executeUpdate("DELETE FROM PantryIngredients WHERE Filter = 1 AND UserName = '" + User.user + "';");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
