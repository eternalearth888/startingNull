package Game;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

// For controlling the various options of the game
public class ControlPanel extends JPanel{
	private FinalPanel fPanel;
	private JButton newGame;
	private JButton exitGame;
	private JButton launch;
	private JCheckBox trajectory;
	private AnglePanel aPanel;

	// Initialize all values and buttons and add them to the panel 
	public ControlPanel(FinalPanel fPanel){
		this.fPanel = fPanel;
		aPanel = new AnglePanel(fPanel);
		setLayout(new GridLayout(0,5));
		newGame = new JButton("New Game");
		newGame.addActionListener(new ButtonListener());
		launch = new JButton("Launch");
		launch.addActionListener(new ButtonListener());
		exitGame = new JButton("Exit");
		exitGame.addActionListener(new ButtonListener());
		trajectory = new JCheckBox("Show Trajectory");
		trajectory.addActionListener(new ButtonListener());
		add(aPanel);
		add(trajectory);
		add(launch);
		add(newGame);
		add(exitGame);
	}

	// Listeners for the buttons
	public class ButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// If the new game button was pushed, reinitialize everything and repaint
			if (e.getSource() == newGame){
				fPanel.proj = new Projectile(90,400);
				fPanel.targetLeft.setHit(false);
				fPanel.targetMid.setHit(false);
				fPanel.targetRight.setHit(false);
				aPanel.getAngle().setText("");
				aPanel.getPower().setText("");
				fPanel.endGame = false;
				fPanel.message = false;
				fPanel.repaint();
			} 
			// If the launch button was pushed, check if it's the end of the game
			// and launch the projectile given the values in the appropriate text
			// fields if the game is still going.
			else if (e.getSource() == launch){
				if (fPanel.endGame == false){
					if(fPanel.newProj) {
						fPanel.newProj = false;
						fPanel.proj = new Projectile(90,400);
					}
					fPanel.repaint();
				}
				calcLaunch();
			} 
			// If the checkbox was hit, toggle the showTrajectory variable 
			else if (e.getSource() == trajectory) {
				fPanel.sling.setShowTrajectory();
			} 
			// If none of the above was hit, then it must've been the exit button.
			else {
				System.exit(0);
			}
		}
	}
	
	// Get the values held in the text fields for angle and power, make
	// sure they're appropriate (adjust them if not), and then launch the projectile
	public void calcLaunch(){
		double tempX, tempY;
		double tempAngle = Double.parseDouble(aPanel.getAngle().getText());
		// Check if the power is greater than 50, cap if it is
		if (Double.parseDouble(aPanel.getPower().getText()) > 50) {
			tempX = (Math.sin((90.0-tempAngle)/(180.0/Math.PI)))*50.0;
			tempY = (Math.cos((90.0-tempAngle)/(180.0/Math.PI)))*50.0;
		} else {
			tempX = ((Math.sin((90.0-tempAngle)/(180.0/Math.PI)))*Double.parseDouble(aPanel.getPower().getText()));
			tempY = ((Math.cos((90.0-tempAngle)/(180.0/Math.PI)))*Double.parseDouble(aPanel.getPower().getText()));
		}
		// If the projectile isn't flying, set it's values (velocities) and let 'er go
		if(!fPanel.proj.isFlying()) {
			fPanel.sling.release(90.0-tempX, tempY+400.0);
			setAngle(tempAngle, fPanel.sling.calcPower(90.0 - tempX, tempY + 400.0));
			fPanel.proj.setvx(fPanel.sling.getvx());
			fPanel.proj.setvy(fPanel.sling.getvy());
		}
		fPanel.repaint();
	}

	// Setters and getters
	public void setAngle(Double ang, Double pow){
		aPanel.update(ang, pow);
	}
	
	public FinalPanel getFPanel() {
		return fPanel;
	}
}
