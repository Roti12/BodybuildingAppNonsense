package no.uib.info216.assignment.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PopupExcercises {

	private JPanel panel;
	private JLabel musclesWorked;
	private JLabel canUse;
	private JLabel label;
	private JLabel requires;
	
	private JTextField musclesWorkedText;
	private JTextField canUseText;
	private JTextField requiresText;
	private JTextField labelText;
	
	
	
	public PopupExcercises(String exercise) {
		
		JFrame frame = new JFrame();
		panel = new JPanel();
		
		musclesWorked = new JLabel("Muscles Worked :");
		canUse = new JLabel("Can use :");
		requires = new JLabel("Requires :");
		label = new JLabel("Definition :");
		
		musclesWorkedText = new JTextField(25);
		canUseText = new JTextField(25);
		requiresText = new JTextField(25);
		labelText = new JTextField(25);
		
		panel.add(musclesWorked);
		panel.add(canUse);
		panel.add(requires);
		panel.add(label);
		
		panel.add(musclesWorkedText);
		panel.add(canUseText);
		panel.add(requiresText);
		panel.add(labelText);
		
		frame.setSize(500, 500);
		frame.setTitle(exercise);
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.add(panel);
		frame.setVisible(true);
		
	}
	
}
