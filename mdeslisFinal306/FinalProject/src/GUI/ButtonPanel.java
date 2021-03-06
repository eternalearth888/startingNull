/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */

package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

import Game.Game;

public class ButtonPanel extends JPanel {
	private JLabel scoreLabel = new JLabel();
	private JLabel shotsTakenLabel = new JLabel();
	private JLabel velocityLabel = new JLabel();
	private JLabel healthLabel = new JLabel();
	private InputPanel inputPanel;
	private double i = 0.0;
	private Timer t;
	private Game ourGame;
	Font font1 = new Font("Algerian", Font.PLAIN, 16);
	Font font2 = new Font("Algerian", Font.BOLD, 20);
	Font font3 = new Font("Algerian", Font.PLAIN, 40);

	public ButtonPanel(Game ourGame) {
		this.ourGame = ourGame;
		setLayout(new GridLayout(0, 1));
		Border borderTurn = BorderFactory.createEtchedBorder();
		// display angle input box
		inputPanel = new InputPanel(ourGame);
		inputPanel.setBorder(borderTurn);
		add(inputPanel);
		// display velocity
		velocityLabel.setBorder(borderTurn);
		velocityLabel.setFont(font2);
		velocityLabel.setText("Current Velocity: "
				+ ourGame.getLauncher().getMissile().getVelocity());
		add(velocityLabel);

		// display score
		scoreLabel.setBorder(borderTurn);
		scoreLabel.setFont(font1);
		scoreLabel.setText("Score: " + ourGame.getTarget().getScore());
		add(scoreLabel);

		// display shots taken
		shotsTakenLabel.setBorder(borderTurn);
		shotsTakenLabel.setFont(font1);
		shotsTakenLabel.setText("Shots Taken: "
				+ ourGame.getLauncher().getShotsTaken());
		add(shotsTakenLabel);

		// display shots taken
		healthLabel.setBorder(borderTurn);
		healthLabel.setFont(font1);
		healthLabel.setText("Pony Health: "
				+ ourGame.getLauncher().getMissile().getHealth());
		add(healthLabel);

		// launch button
		JButton launchButton = new JButton("Launch!!!");
		launchButton.setFont(font3);
		add(launchButton);
		launchButton.addActionListener(new LaunchButtonListener());

		// hint button
		JButton hintButton = new JButton("Give me a hint");
		hintButton.setFont(font2);
		add(hintButton);
		hintButton.addActionListener(new HintButtonListener());

		// create white space
		JLabel whiteSpaceLabel = new JLabel();
		add(whiteSpaceLabel);

		// reset button
		JButton newGameButton = new JButton("New Game");
		newGameButton.setFont(font1);
		add(newGameButton);
		newGameButton.addActionListener(new NewGameButtonListener());

		t = new Timer(100, new TimerListener());
	}

	public void update() {
		scoreLabel.setText("Score: " + ourGame.getTarget().getScore());
		shotsTakenLabel.setText("Shots Taken: "
				+ ourGame.getLauncher().getShotsTaken());
		velocityLabel.setText("Current Velocity: "
				+ ourGame.getLauncher().getMissile().getVelocity());
		healthLabel.setText("Pony Health: "
				+ ourGame.getLauncher().getMissile().getHealth());
		inputPanel.update();
	}

	private class LaunchButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			t.restart();
			ourGame.getLauncher().incShotsTaken();
			update();
		}
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (ourGame.getLauncher().getMissile().getPoint().getX() < 1000
					&& ourGame.getLauncher().getMissile().getPoint().getY() < 600
					&& ourGame.getLauncher().getMissile().getPoint().getX() > 0
					&& ourGame.getLauncher().getMissile().getPoint().getY() > 0) {
				ourGame.getLauncher()
						.getMissile()
						.setPoint(
								ourGame.getLauncher().getMissile()
										.getPositionAt(i));
				i = i + 0.05;
				repaint();
			} else {
				t.stop();
				i = 0.0;
				isTargetHit();
				ourGame.getTarget().incrementScore();
				update();
				// Win
				if (ourGame.isWon()) {
					WonPanel wpanel = new WonPanel(ourGame, velocityLabel,
							scoreLabel, shotsTakenLabel, healthLabel,
							inputPanel);
					wpanel.setVisible(true);
					update();
					// Lost
				} else if (ourGame.isLost()) {
					LostPanel lpanel = new LostPanel(ourGame, velocityLabel,
							scoreLabel, shotsTakenLabel, healthLabel,
							inputPanel);
					lpanel.setVisible(true);
					update();
					// Next Round
				} else {
					NextRoundPanel nrpanel = new NextRoundPanel(ourGame,
							velocityLabel, inputPanel);
					nrpanel.setVisible(true);
					update();
				}
			}
			update();
			repaint();
		}
	}

	private class NewGameButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ourGame.reset();
			update();
			repaint();
		}
	}

	private class HintButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, ourGame.getTarget().getHint()
					.pickRandomHint());
		}
	}

	private void hitTarget() {
		ourGame.getTarget().decCakeSize();
		ourGame.getTarget().setHit(true);
	}

	private void missTarget() {
		ourGame.getTarget().setHit(false);
		ourGame.getLauncher().getMissile().decHealth();
	}

	// After launch, checks if pony hit cake, updates accordingly
	private void isTargetHit() {
		switch (ourGame.getTarget().getCakeSize()) {
		case 4:
			if (ourGame.getLauncher().getMissile().getPoint().getX() + 50 > 890
					&& ourGame.getLauncher().getMissile().getPoint().getY() + 50 > 370) {
				hitTarget();
			} else {
				missTarget();
			}
			break;
		case 3:
			if (ourGame.getLauncher().getMissile().getPoint().getX() + 50 > 890
					&& ourGame.getLauncher().getMissile().getPoint().getY() + 50 > 470) {
				hitTarget();
			} else {
				missTarget();
			}
			break;
		case 2:
			if (ourGame.getLauncher().getMissile().getPoint().getX() + 50 > 890
					&& ourGame.getLauncher().getMissile().getPoint().getY() + 50 > 510) {
				hitTarget();
			} else {
				missTarget();
			}
			break;
		case 1:
			if (ourGame.getLauncher().getMissile().getPoint().getX() + 50 > 890
					&& ourGame.getLauncher().getMissile().getPoint().getY() + 50 > 540) {
				hitTarget();
				// Hit cake 4 times?
				ourGame.setWon(true);
			} else {
				missTarget();
			}
			break;
		default:
			missTarget();
			break;
		}
		// Pony died?
		if (ourGame.getLauncher().getMissile().getHealth() == 0) {
			ourGame.setLost(true);
		}
	}
}
