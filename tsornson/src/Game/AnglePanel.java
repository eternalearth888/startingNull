package Game;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


// For the angle, power fields
public class AnglePanel extends JPanel{

	private JTextField angle;
	private JTextField power;
	private FinalPanel fPanel;

	// Initialize and add things to the Panel
	public AnglePanel(FinalPanel fPanel) {
		this.fPanel = fPanel;
		setLayout(new GridLayout(0,2));
		JLabel angleText = new JLabel("Angle: ");
		JLabel powerText = new JLabel("Power: ");
		angle = new JTextField(15);
		power = new JTextField(15);
//		getAngle().setFont(new Font("SansSerif", Font.BOLD, 12));
		add(angleText);
		add(getAngle());
		add(powerText);
		add(getPower());
	}

	// Upon release of the mouse, update the angle and power
	// text fields with the last values used
	public void update(Double ang, Double pow){
		String angText = Double.toString(ang);
		String powText = Double.toString(pow);
		getAngle().setText(angText);
		getPower().setText(powText);
	}
	
	// Getters
	public JTextField getAngle() {
		return angle;
	}
	
	public JTextField getPower() {
		return power;
	}
	
	public FinalPanel getFPanel() {
		return fPanel;
	}
}
