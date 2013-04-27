package Game;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// Init class will contain our main function.
// FinalPanel will contain all of the logic of the game
// and the graphics.
public class Init extends JFrame{
	private ControlPanel cPanel;

	public Init(){
		setSize(900,550);
		setResizable(false);
		setTitle("Castle Wrecker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FinalPanel fPanel = new FinalPanel(this);
		cPanel = new ControlPanel(fPanel);
		add(fPanel, BorderLayout.CENTER);
		add(cPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	public void setAngle(Double ang, Double pow){
		cPanel.setAngle(ang, pow);
	}

	public static void main(String[] args) {
		Init jf = new Init();
		JOptionPane.showMessageDialog(jf, "Hit all three sections of the castle with the slingshot. Good luck!", "Welcome to Castle Wrecker!", JOptionPane.INFORMATION_MESSAGE);
	}
}
