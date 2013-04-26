package game;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class GameGUI extends JFrame {
	
	public GameGUI() {
		setSize(new Dimension(800, 600));
		setTitle("Master in a Minute!");
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		
		BackgroundPanel bkgPanel = new BackgroundPanel();
		Border borderTurn = BorderFactory.createEtchedBorder();
		bkgPanel.setBorder(borderTurn);
		add(bkgPanel, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		GameGUI run = new GameGUI();
		run.setVisible(true);
	}
}
