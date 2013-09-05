package mainCode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Game extends JFrame {
	private SaveTheCake gamePanel;
	private ControlPanel controlPanel;

	public Game() {
		gamePanel = new SaveTheCake();
		controlPanel = new ControlPanel(gamePanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(SaveTheCake.FRAME_SIZE_X + 88, SaveTheCake.FRAME_SIZE_Y + 12);
		addFeatures();
		setVisible(true);
		gamePanel.mainFlow();
	}

	public void addFeatures() {
		add(gamePanel, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.WEST);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
	}

	public JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		// New game option
		JMenuItem newGame = new JMenuItem("New Game");
		class NewGameListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				gamePanel.restartGame();
			}
		}
		newGame.addActionListener(new NewGameListener());
		menu.add(newGame);
		// Exit option
		JMenuItem exitItem = new JMenuItem("Exit");
		class ExitItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		exitItem.addActionListener(new ExitItemListener());
		menu.add(exitItem);
		return menu;
	}

	public static void main(String[] args) {
		JOptionPane
				.showMessageDialog(
						null,
						"Please be ready, use the arrow keys to aim and Shoot button to shoot",
						"Welcome to Save The Cake",
						JOptionPane.INFORMATION_MESSAGE);
		Game newGame = new Game();
	}
}
