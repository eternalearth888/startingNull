package game;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

import java.awt.event.*;

import javax.swing.text.*;

public class ControlGUI extends JPanel {
	private Game play;

	private JLabel numTargetsLabel;
	private JTextField numTargetsBox;
	private JButton genTargetsButton;

	public ControlGUI(Game play) {
		this.play = play;

		setLayout(new FlowLayout(FlowLayout.LEFT));

		// Setup Panel
		JPanel setupPanel = new JPanel();
		setupPanel.setLayout(new GridBagLayout());
		GridBagConstraints grid = new GridBagConstraints();

		// Create Elements
		numTargetsLabel = new JLabel("Number of Pokemon ");
		numTargetsBox = new NumericTextField("5", 3);
		genTargetsButton = new JButton("Generate Targets ");

		// Add Elements to Panel
		grid.fill = GridBagConstraints.HORIZONTAL;
		grid.gridx = 0;
		grid.gridy = 0;
		setupPanel.add(numTargetsLabel, grid);
		grid.gridx = 1;
		setupPanel.add(numTargetsBox, grid);
		grid.insets = new Insets(10, 0, 0, 0);
		grid.gridx = 0;
		grid.gridy = 1;
		grid.gridwidth = 2;
		grid.ipady = 20;
		setupPanel.add(genTargetsButton, grid);

		// Add Listeners to Elements
		genTargetsButton.addActionListener(new ControlButtonListener());
		setupPanel.setBorder(BorderFactory.createTitledBorder("Gotta Catch 'em All!"));
		add(setupPanel);

	}

	// source: http://www.coderanch.com/how-to/java/NumericTextField
	class NumericTextField extends JTextField {

		public NumericTextField(String string, int i) {
			super(string, i);
		}

		@Override
		protected Document createDefaultModel() {
			return new NumericDocument();
		}

		private class NumericDocument extends PlainDocument {
			// The regular expression to match input against (zero or more
			// digits)
			private final Pattern DIGITS = Pattern.compile("\\d*");

			@Override
			public void insertString(int offs, String str, AttributeSet a)
					throws BadLocationException {
				// Only insert the text if it matches the regular expression
				if (str != null && DIGITS.matcher(str).matches())
					super.insertString(offs, str, a);
			}
		}
	}

	private class ControlButtonListener extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {

			JButton source = (JButton) e.getSource();
			if (source == genTargetsButton) {
				String number = numTargetsBox.getText();
				try {
					int n = Integer.parseInt(number);
					if (n > 50 || n == 0) {
						throw (new NumberFormatException());
					}
					 play.generateTargets(n);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null,
							"Error: Please enter a number between 1 and 50.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
//				 } else if( source == launchButton ) {
				// play.launch();
			}
			 play.repaint();
		}
	}
}
