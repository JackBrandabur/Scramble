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
	
	JList ingredients = new JList<String>();
	
	JScrollBar scroll = new JScrollBar();
	
	JToolBar toolBar = new JToolBar();
	JToolBar toolBar2 = new JToolBar();
	
	JPanel panel = new JPanel();
	
	JButton ret = new JButton ("Return to Menu");
	JButton add = new JButton ("Add Ingredient");
	
	Pantry() {
		
		ret.addActionListener(this);
		add.addActionListener(this);
		
		toolBar.add(ret);
		toolBar2.add(add);
		
		panel.add(toolBar, BorderLayout.NORTH);
		panel.add(toolBar2, BorderLayout.SOUTH);
		panel.add(pane, BorderLayout.CENTER);
		panel.add(newIngredient, BorderLayout.SOUTH);
		panel.add(addField, BorderLayout.SOUTH);
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
	}
	
}
