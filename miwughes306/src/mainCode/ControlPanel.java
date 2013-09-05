package mainCode;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel {
	private JButton shootButton;
	private JSlider angleSlider;
	public static final int ANGLE_MIN = 0;
	public static final int ANGLE_MAX = 90;
	private SaveTheCake gamePanel;
	private AnglePanel panel;

	public ControlPanel(SaveTheCake gamePanel) {
		this.gamePanel = gamePanel;
		setLayout(new BorderLayout());
		shootButton = new JButton("Shoot");
		angleSlider = new JSlider(JSlider.VERTICAL, ANGLE_MIN, ANGLE_MAX, 45);
		angleSlider.addChangeListener(new SliderListener());
		angleSlider.setMajorTickSpacing(10);
		angleSlider.setMinorTickSpacing(5);
		angleSlider.setPaintTicks(true);
		angleSlider.setPaintLabels(true);
		panel = new AnglePanel(angleSlider);
		shootButton.addActionListener(new ButtonListener());
		keyBinding();
		add(panel, BorderLayout.NORTH);
		add(angleSlider, BorderLayout.CENTER);
		add(shootButton, BorderLayout.SOUTH);
		setBorder(new TitledBorder(new EtchedBorder(), "Control"));
	}

	class SliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) {
			// set canon angle according to slider
			gamePanel.getCanon().setAngle(angleSlider.getValue());
			panel.setText(angleSlider.getValue());
		}
	}

	class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// create bullet everytime we click shoot button
			double angle = angleSlider.getValue();
			gamePanel.getBullet().add(new Bullet(50, 425, 30, angle));
		}
	}

	public void keyBinding() {
		// Map control keys to slider and button functions
		Action moveUp = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				angleSlider.setValue(angleSlider.getValue() + 1);
			}
		};
		Action moveDown = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				angleSlider.setValue(angleSlider.getValue() - 1);
			}
		};
		angleSlider.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("UP"), "upArrow");
		angleSlider.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("LEFT"), "upArrow");
		angleSlider.getActionMap().put("upArrow", moveUp);
		angleSlider.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("DOWN"), "downArrow");
		angleSlider.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("RIGHT"), "downArrow");
		angleSlider.getActionMap().put("downArrow", moveDown);

		Action shoot = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				double angle = angleSlider.getValue();
				gamePanel.getBullet().add(new Bullet(50, 425, 30, angle));
			}
		};
		shootButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
				KeyStroke.getKeyStroke("SPACE"), "newButtlet");
		shootButton.getActionMap().put("newButtlet", shoot);
	}
}
