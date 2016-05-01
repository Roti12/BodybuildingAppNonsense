package GUI;

import javax.swing.JFrame;

public class popupExcercises {

	public popupExcercises(String exercise) {
		
		JFrame frame = new JFrame();
		frame.setSize(500, 500);
		frame.setTitle(exercise);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
}
