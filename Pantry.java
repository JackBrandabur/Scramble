import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Pantry implements ActionListener {

	JFrame pantry = new JFrame("Scramble - Pantry");
	
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
		
		toolBar.add(ret);
		toolBar2.add(add);
		
		panel.add(toolBar, BorderLayout.NORTH);
		panel.add(pane, BorderLayout.CENTER);
		
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
		
	}
	
}
