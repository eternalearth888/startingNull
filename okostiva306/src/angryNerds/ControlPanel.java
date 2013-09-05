package angryNerds;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ControlPanel extends JPanel {

	public enum Difficulty { EASY, HARD };
	public static final int MAX_ANGLE = 90;
	private static final long serialVersionUID = 7717786247225180620L;
	private int angle, power;
	private JTextArea angleInput, powerInput;
	private JLabel angleLabel, powerLabel;
	private JButton enterData;
	private Difficulty difficulty = Difficulty.EASY;
	private GameBoard gameboard;
	
	public ControlPanel(GameBoard gameboard) {
		angleLabel = new JLabel("Angle in Degrees (1-89): ");
		angleInput = new JTextArea("0");
		powerLabel = new JLabel("Velocity (1-10): ");
		powerInput = new JTextArea("0");
		enterData = new JButton("Fire");
		angle = 0;
		power = 0;
		this.gameboard = gameboard;
		
		enterData.addActionListener(new FireListener());
		
		setLayout(new GridLayout(1, 0));
		add(angleLabel);
		add(angleInput);
		add(powerLabel);
		add(powerInput);
		add(enterData);
	}
	
	public int getPower() {
		return power;
	}
	
	public int getAngle() {
		return angle;
	}
	
	public Difficulty getDifficulty() {
		return difficulty;
	}
	
	//Returns the velocity of the weapon in the x-direction (used in hard setting quizzes)
	public double getVelocityX() {
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.valueOf(df.format(Math.cos(Math.toRadians(this.angle))*this.power));
	}
	
	//Returns the velocity of the weapon in the y-direction (used in hard setting quizzes)
	public double getVelocityY() {
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.valueOf(df.format(Math.sin(Math.toRadians(this.angle))*this.power));
	}
	
	//Used for the easy setting quizzes
	public double getAngleDifference() {
		return (90 - this.angle);
	}
	
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	
	public boolean updateAngle() {
		try {
			this.angle = Integer.parseInt(angleInput.getText().trim());
		
			if (this.angle > 89 || this.angle < 1)
			{
				throw new Exception ("Invalid angle detected");
			}
			
			return true;
		
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(gameboard, "Please enter a valid angle from 1-89.", "Invalid Angle", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public boolean updatePower() {
		try {
			this.power = Integer.parseInt(powerInput.getText().trim());
		
			if (this.power < 1 || this.power > 10)
			{
				throw new Exception ("Invalid power detected");
			}
			
			return true;
		
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(gameboard, "Please enter a valid velocity from 1-10.", "Invalid Power", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	//Methods below are for testing purposes only and should not be used during 
	//implementation of the game
	public void setAngle(int angle) {
		this.angle = angle;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	private class FireListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (updateAngle() && updatePower())
			{
				gameboard.toss(getAngle(), getPower());
			}
		}
		
	}
}
