package main;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class AngleGame extends JFrame {
	
	public AngleGame() {
		setTitle("Floating Crate Destroyer");
		setSize(new Dimension(800, 600));
		
		// Centers the window
		setLocationRelativeTo(null);
		
		// Set layout
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.anchor = GridBagConstraints.CENTER;
		
		// Create the world
		World w = new World();
		c.gridy = 0;
		c.ipady = 400;
		add(w, c);
		
		// Creates the controls
		Controls ui = new Controls(w);
		c.gridy = 1;
		c.ipady = 0;
		c.anchor = GridBagConstraints.PAGE_END;
		add(ui, c);
		
		// Add menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(createFileMenu());
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private JMenu createFileMenu() {
		
		JMenu menu = new JMenu("File"); 
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
	public static void main(String[] args) {
		
		AngleGame ag = new AngleGame();
		ag.setVisible(true);
		
	}
}
