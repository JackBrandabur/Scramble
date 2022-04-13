import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddRecipe implements ActionListener {
	
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
	JLabel label7 = new JLabel("  Source: ");
	
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
		
		returnButton.addActionListener(this);
		
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
		if (e.getSource() == returnButton) {
			MainMenu menu = new MainMenu();
			frame.setVisible(false);
		}
	}

}
