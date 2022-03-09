import java.awt.*; 
import javax.swing.*;

public class Pantry {

	JFrame pantry = new JFrame();
	
	JLabel label = new JLabel("Pantry");
	
	JToolBar toolBar = new JToolBar();
	
	JPanel panel = new JPanel();
	
	JButton ret = new JButton ("Return to Menu");
	
	Pantry() {
		
		toolBar.add(ret);
		pantry.add(label);
		panel.add(ret);
		pantry.add(panel);
		pantry.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantry.setSize(500,500);
		pantry.setLayout(null);
		pantry.setVisible(true);
	}
	
}
