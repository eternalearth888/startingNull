package GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class RulesPanel extends JFrame {

	public RulesPanel() {
		setSize(new Dimension(600, 600));
		setResizable(false);
		setTitle("Rules / How to Play");
		Font font = new Font("Arial", Font.PLAIN, 16);
		
		JTextArea rules = new JTextArea();
		Scanner readRules;
		String addRules = "";
		
		try {
			readRules = new Scanner(new File("textFiles/rules"));

			while (readRules.hasNextLine()) {
				addRules = addRules + readRules.nextLine() + "\n\n";
			}
			rules.setText(addRules);

			readRules.close();

		} catch (FileNotFoundException e) {
			System.out.println("The source file can't be found or does not exist."
							+ e);
		}
		
		rules.setBorder(new TitledBorder(new EtchedBorder(), "Rules / How to Play"));
		rules.setLineWrap(true);
		rules.setEditable(false);
		rules.setFont(font);
		add(rules);
	}
}
