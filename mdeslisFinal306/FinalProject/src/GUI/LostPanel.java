/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.Game;

public class LostPanel extends JFrame {
	private JLabel score;
	private JLabel shotsTaken;
	private JLabel pic;
	private JLabel message;
	private JLabel message1;
	private JLabel message2;
	private JLabel velocityLabel;
	private JLabel scoreLabel;
	private JLabel shotsTakenLabel;
	private JLabel healthLabel;
	private InputPanel inputPanel;
	private JButton newGame;
	private JButton exitGame;
	private Game ourGame;
	public BufferedImage lose;
	
	Font font = new Font("Arial", Font.PLAIN, 16);
	
	public LostPanel(Game g, JLabel velocityLabel, JLabel scoreLabel, JLabel shotsTakenLabel, JLabel healthLabel, InputPanel inputPanel) {
		ourGame = g;
		this.velocityLabel = velocityLabel;
		this.scoreLabel = scoreLabel;
		this.shotsTakenLabel = shotsTakenLabel;
		this.healthLabel = healthLabel;
		this.inputPanel = inputPanel;
		setSize(new Dimension(500, 700));
		setResizable(false);
		setTitle("Game Complete");
		try {
			this.lose = ImageIO.read(new File("pictures/lose.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		inputPanel.update();
		
		JPanel wonPanel = new JPanel();
		wonPanel.setSize(new Dimension(500, 500));
		pic = new JLabel(new ImageIcon(lose));
		wonPanel.add(pic);
		add(wonPanel, BorderLayout.CENTER);
		
		JPanel theRest = new JPanel();
		theRest.setLayout(new GridLayout(0, 1));
		
		// Hit or Miss?
		message = new JLabel();
		message.setText(" Sorry!!");
		message.setFont(font);
		theRest.add(message);
		
		message1 = new JLabel();
		message1.setText(" Mint Pudding");
		message1.setFont(font);
		theRest.add(message1);
		
		message2 = new JLabel();
		message2.setText(" didn't make it...");
		message2.setFont(font);
		theRest.add(message2);
		
		// Option for Next Round
		newGame = new JButton();
		newGame.setText("New Game?");
		theRest.add(newGame);
		
		// Option for End Game
		exitGame = new JButton();
		exitGame.setText("Exit Game?");
		theRest.add(exitGame);
		
		add(theRest, BorderLayout.SOUTH);
		
		// Button Listeners
		newGame.addActionListener(new NewGameListener());
		exitGame.addActionListener(new ExitGameListener());
	}
	
	
	private class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ourGame.reset();
			ourGame.getLauncher().getMissile().setDefaults();
			velocityLabel.setText("Current Velocity: " + ourGame.getLauncher().getMissile().getVelocity());
			scoreLabel.setText("Score: " + ourGame.getTarget().getScore());
			shotsTakenLabel.setText("Shots Taken: " + ourGame.getLauncher().getShotsTaken());
			healthLabel.setText("Pony Health: " + ourGame.getLauncher().getMissile().getHealth());
			repaint();
			inputPanel.update();
			setVisible(false);
			ourGame.setWon(false);
		}
	}
	
	private class ExitGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
}