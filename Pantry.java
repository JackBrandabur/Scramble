import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pantry implements ActionListener {

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
	
	Pantry() {
		
		ret.addActionListener(this);
		add.addActionListener(this);
		save.addActionListener(this);
		add2.addActionListener(this);
		
		toolBar2.add(ret);
		toolBar2.add(add);
		toolBar2.add(save);
		
		toolBar3.add(add2);
		toolBar3.add(save2);
		
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
			String item = addField.getText();
			area.append(item);
			area.append("\n");
		}
		if (e.getSource() == save) {
			// Code goes here to save to user data
		}
		if (e.getSource() == add2) {
			String item = addIng.getText();
			savedArea.append(item);
			savedArea.append("\n");
		}
	}
	
}
