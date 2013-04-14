package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class CalculationPanel extends JFrame {

	public CalculationPanel() {
		setSize(new Dimension(400, 400));
		setResizable(false);
		setTitle("Calculation Info");
		
		JTextArea story = new JTextArea("\nMissile location is (110, 475)" +
				"\n\nTarget Location is (890, 560)" +
				"\n\nDistance (Horizontal) Between is 780 meters." +
				"\n\nSee Side Panel for current velocity." +
				"\n\nThe angle is up to you!");
		story.setBorder(new TitledBorder(new EtchedBorder(), "Calculation Info"));
		story.setLineWrap(true);
		story.setEditable(false);
		story.setFont(new Font("Arial", Font.PLAIN, 16));
		add(story);
	}
}