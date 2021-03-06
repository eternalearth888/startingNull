/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */

package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import Game.Game;

public class GameGUI extends JFrame {
	private Game ourGame = new Game();

	public GameGUI() {
		setSize(new Dimension(1400, 750));
		setResizable(false);
		// setUndecorated(true);
		setTitle("Hungry, Hungry Ponies");
		ScreenPanel sPanel = new ScreenPanel(ourGame);
		Border borderTurn = BorderFactory.createEtchedBorder();
		sPanel.setBorder(borderTurn);
		add(sPanel, BorderLayout.CENTER);
		ButtonPanel bPanel = new ButtonPanel(ourGame);
		add(bPanel, BorderLayout.WEST);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
	}

	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createGameStoryItem());
		menu.add(createRuleItem());
		menu.add(createCalcInfoItem());
		menu.add(createFileExitItem());
		return menu;
	}

	private JMenuItem createFileExitItem() {
		JMenuItem item = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}

	private JMenuItem createGameStoryItem() {
		JMenuItem item = new JMenuItem("Background Story");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				StoryPanel spanel = new StoryPanel();
				spanel.setVisible(true);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}

	private JMenuItem createRuleItem() {
		JMenuItem item = new JMenuItem("Rules / How To Play");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				RulesPanel rpanel = new RulesPanel();
				rpanel.setVisible(true);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}

	private JMenuItem createCalcInfoItem() {
		JMenuItem item = new JMenuItem("Calculation Info");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				CalculationPanel cpanel = new CalculationPanel();
				cpanel.setVisible(true);
			}
		}
		item.addActionListener(new MenuItemListener());
		return item;
	}

	public static void main(String[] args) {
		GameGUI gui = new GameGUI();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
		JOptionPane.showMessageDialog(gui,
				"Welcome to Hungry, Hungry Ponies!!", "X Squared Over Four",
				JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(
						gui,
						"Help Mint Pudding eat ALL the cake! \nGiven a velocity, select the correct angle, and then "
								+ "launch the pony into the cake. \nCareful, each miss will decrement your pony's health, she may not make it if it hits zero..."
								+ "\nClick 'Give Me a Hint' if you have trouble. \n\nSEE \"Calculation Info\" FOR REQUIRED CALCULATION DATA",
						"How to Play", JOptionPane.INFORMATION_MESSAGE);
	}

}
