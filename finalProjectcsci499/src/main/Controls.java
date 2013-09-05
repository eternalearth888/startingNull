package main;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

@SuppressWarnings("serial")
public class Controls extends JPanel {

	private World world;
//	private JButton genTargetsButton;
//	private JButton clearTargetsButton;
	private JSlider powerSlider;
	private JSlider angleSlider;
	public JButton launchButton;
	private JLabel powerBox;
	private JLabel angleBox;

	// Timer Stuff
	private Timer timer;
	private Font font;
	public TimeClass tc;
	private JLabel timerLabel;
	private JButton timerButton;
	private int start = 30;

	private boolean hasPressedStart = false;
	private boolean hasGameEnded = false;

	public Controls(World w) {
		world = w;
		font = new Font("Impact", Font.BOLD, 26);
		setLayout(new FlowLayout(FlowLayout.LEFT));

		// Setup panel
		JPanel setupPanel = new JPanel();
		setupPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		// setupPanel.addKeyListener(launchAdjustments);
		// Create elements
		timerLabel = new JLabel("Press  Start", JLabel.CENTER);
		timerLabel.setFont(font);
		timerLabel.setForeground(Color.red);

		// Creating the TIMER
		tc = new TimeClass(start);
		timer = new Timer(1000, tc);

		timerButton = new JButton("Start Game");
		// genTargetsButton = new JButton("Generate Targets");
		// clearTargetsButton = new JButton("Clear Targets");
		// Add elements to panel
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 20;
		setupPanel.add(timerLabel, c);
		c.insets = new Insets(10,0,0,0);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.ipady = 20;
		setupPanel.add(timerButton, c);
		// c.insets = new Insets(10,0,0,0);
		// c.gridx = 0;
		// c.gridy = 2;
		// c.gridwidth = 2;
		// setupPanel.add(genTargetsButton, c);
		// c.gridx = 0;
		// c.gridy = 3;
		// c.gridwidth = 2;
		// setupPanel.add(clearTargetsButton, c);
		// Add listeners to elements
		timerButton.addActionListener(new ControlButtonListener());
		// genTargetsButton.addActionListener(new ControlButtonListener());
		// clearTargetsButton.addActionListener(new ControlButtonListener());
		setupPanel.setBorder(BorderFactory.createTitledBorder("SETUP"));
		add(setupPanel);

		// Sliders
		JPanel powerPanel = new JPanel();
		JPanel anglePanel = new JPanel();
		powerSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, world
				.getLauncher().getPower());
		angleSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, (int) world
				.getLauncher().getAngle());
		powerSlider.setMajorTickSpacing(20);
		powerSlider.setMinorTickSpacing(2);
		powerSlider.setPaintLabels(true);
		powerSlider.setPaintTicks(true);

		angleSlider.setMajorTickSpacing(15);
		angleSlider.setMinorTickSpacing(1);
		angleSlider.setPaintLabels(true);
		angleSlider.setPaintTicks(true);
		powerSlider.add(new JLabel("Power"));

		powerPanel.add(powerSlider);
		anglePanel.add(angleSlider);

		powerPanel.setBorder(BorderFactory.createTitledBorder("POWER"));
		anglePanel.setBorder(BorderFactory.createTitledBorder("ANGLE"));

		powerSlider.addChangeListener(new SliderChangeListener());
		angleSlider.addChangeListener(new SliderChangeListener());
		add(powerPanel);
		add(anglePanel);

		// Launch panel
		JPanel launchPanel = new JPanel();
		launchPanel.setLayout(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints();
		// Create elements
		JLabel powerLabel = new JLabel("Power:");
		powerBox = new JLabel();
		powerBox.setText("" + world.getLauncher().getPower());
		JLabel angleLabel = new JLabel("Angle:");
		angleBox = new JLabel();
		angleBox.setText("" + (int) world.getLauncher().getAngle());
		launchButton = new JButton("Launch");
		// Add elements to panel
		c1.insets = new Insets(5, 0, 0, 0);
		c1.fill = GridBagConstraints.HORIZONTAL;
		c1.gridx = 0;
		c1.gridy = 0;
		c1.weightx = 0.1;
		launchPanel.add(powerLabel, c1);

		c1.gridx = 1;
		c1.weightx = 1.0;
		c1.anchor = GridBagConstraints.EAST;
		launchPanel.add(powerBox, c1);

		c1.ipadx = 0;
		c1.anchor = GridBagConstraints.CENTER;
		c1.gridx = 0;
		c1.gridy = 1;
		launchPanel.add(angleLabel, c1);

		c1.gridx = 1;
		launchPanel.add(angleBox, c1);

		c1.insets = new Insets(10, 0, 0, 0);
		c1.gridx = 0;
		c1.gridy = 2;
		c1.gridwidth = 2;
		c1.ipady = 20;
		c1.ipadx = 50;
		launchPanel.add(launchButton, c1);

		// Add listeners to elements
		launchButton.addActionListener(new ControlButtonListener());
		launchPanel.setBorder(BorderFactory.createTitledBorder("LAUNCH"));
		add(launchPanel);

		// Set key bindings
		launchButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("SPACE"), "launch");
		launchButton.getActionMap().put("launch", new ControlButtonListener());

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
//			if (source == genTargetsButton && hasPressedStart == false) {
//				world.generateTargets(8);
//				System.out.println("Generate Target GS: " + world.getChangeGameState());
//			} else if (source == clearTargetsButton && hasPressedStart == false) {
//				world.clearTargets();
//				System.out.println("Clear Target GS: " + world.getChangeGameState());
//			} else 
			if (source == launchButton && hasPressedStart == true
					&& hasGameEnded == false) {
				world.launch();
			} else if (source == timerButton && hasPressedStart == false) {
				timer.start();
				hasPressedStart = true;
				hasGameEnded = false;
				tc.restartTimer();
			}
			world.repaint();
		}

	}

	private class SliderChangeListener implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider) e.getSource();
			if (source == powerSlider) {
				world.getLauncher().setPower(source.getValue());
				powerBox.setText(String.valueOf(source.getValue()));
			} else if (source == angleSlider) {
				world.getLauncher().setAngle(source.getValue());
				angleBox.setText(String.valueOf(source.getValue()));
			}
			world.repaint();
		}
	}

	public class TimeClass implements ActionListener {
		int counter;
		int initialCounter;

		public TimeClass(int counter) {
			this.counter = counter;
			this.initialCounter = counter;
		}

		public void actionPerformed(ActionEvent tc) {
			counter--;

			if (counter >= 1) {
				if (world.isMaster == true) {
//					timerLabel.setText("Press  Start");
					stopTimer();
					world.isMaster = false;
					System.out.println(world.getChangeGameState());
					world.changeGameState();
					world.changeGameState();
					
				}					//0123456789
				timerLabel.setText("   00 : " + counter + "     ");
			} else {
				stopTimer();
				world.changeGameState();
			}
		}

		public void stopTimer() {
			timer.stop();
			hasPressedStart = false;
			hasGameEnded = true;
			timerLabel.setText("    Done!    ");
			Toolkit.getDefaultToolkit().beep();
		}

		public void restartTimer() {
			counter = initialCounter;
			world.changeGameState();
			timer.restart();

		}
	}

}
