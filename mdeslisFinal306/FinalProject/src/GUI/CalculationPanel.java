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

public class CalculationPanel extends JFrame {

	public CalculationPanel() {
		setSize(new Dimension(400, 400));
		setResizable(false);
		setTitle("Calculation Info");
		Font font = new Font("Arial", Font.PLAIN, 16);

		JTextArea calculation = new JTextArea();
		Scanner readCalc;
		String addCalc = "";
		
		try {
			readCalc = new Scanner(new File("textFiles/calculation"));

			while (readCalc.hasNextLine()) {
				addCalc = addCalc + readCalc.nextLine() + "\n\n";
			}
			calculation.setText(addCalc);

			readCalc.close();

		} catch (FileNotFoundException e) {
			System.out.println("The source file can't be found or does not exist."
							+ e);
		}

		
		calculation.setBorder(new TitledBorder(new EtchedBorder(), "Calculation Info"));
		calculation.setLineWrap(true);
		calculation.setEditable(false);
		calculation.setFont(font);
		add(calculation);
	}
}