/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */

package GUI;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Game.Game;

// Panel for angle input and save

public class InputPanel extends JPanel {
	private JTextField angleTextField = new JTextField();
	private JLabel angle;
	private Game ourGame;
	Font font = new Font("Arial", Font.PLAIN, 16);

	public InputPanel(Game g) {
		setLayout(new GridLayout(0, 1));
		ourGame = g;
		double actAngle = ourGame.getLauncher().getMissile().getAngle();
		angle = new JLabel(" " + actAngle);
		angle.setFont(font);
		add(angle);
		JLabel label = new JLabel("Enter an angle between 0 and 360: ");
		label.setFont(font);
		add(label);
		angleTextField.setFont(font);
		add(angleTextField);
		// launch button
		JButton saveButton = new JButton("Save New Angle");
		saveButton.setFont(font);
		add(saveButton);
		saveButton.addActionListener(new saveButtonListener());
	}

	public void update() {
		angle.setText(" " + ourGame.getLauncher().getMissile().getAngle());
		angleTextField.setText("");
	}

	private class saveButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String newAngleStr = angleTextField.getText();
			try {
				double newAngle = Double.parseDouble(newAngleStr);
				ourGame.getLauncher().getMissile().pickAngle(newAngle);
				update();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid Angle: "
						+ newAngleStr);
			}
		}
	}
}
