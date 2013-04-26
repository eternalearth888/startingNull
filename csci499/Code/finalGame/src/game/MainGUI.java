package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class MainGUI extends JFrame {
	private Game play = new Game();

	public MainGUI() {
		setTitle("Master in a Minute!");
		setSize(new Dimension(800,600));

		// Centers the window
		setLocationRelativeTo(null);
		// User can't change the window size
		setResizable(false);

		// Set layout
		setLayout(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();
		grid.fill = GridBagConstraints.BOTH;
		grid.gridx = 0;
		grid.anchor = GridBagConstraints.CENTER;

		// Add menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());

		// Create the game
		Game g = new Game();
		grid.gridy = 0;
		grid.ipady = 400;
		add(g, grid);
		
		// Creates the controls
		ControlGUI controls = new ControlGUI(g);
		grid.gridy = 1;
		grid.ipady = 0;
		grid.anchor = GridBagConstraints.PAGE_END;
		add(controls, grid);

		// Exit out of the GUI
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JMenu createFileMenu() {
		JMenu menu = new JMenu("File");
		menu.add(createObjectiveItem());
		menu.add(createFileExitItem());
		return menu;
	}

	private JMenuItem createFileExitItem() {
		JMenuItem exit = new JMenuItem("Exit");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		exit.addActionListener(new MenuItemListener());
		return exit;
	}

	private JMenuItem createObjectiveItem() {
		JMenuItem objective = new JMenuItem("Objective");
		class MenuItemListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}
		objective.addActionListener(new MenuItemListener());
		return objective;
	}

	public static void main(String[] args) {
		MainGUI run = new MainGUI();
		run.setVisible(true);
	}
}
