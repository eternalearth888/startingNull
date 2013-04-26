package game;

import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel {
	 public Image background;
		
	 public BackgroundPanel() {
		 this.background = new ImageIcon("images/background.jpg").getImage();
	 }
	 
	public void draw(Graphics g) {
		 Graphics2D g2 = (Graphics2D)g;
		 g2.drawImage(background, 0, 0, null);
	}
}
