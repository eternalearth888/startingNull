package Game;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SlingImage extends JPanel{

	private BufferedImage image;


	public SlingImage() {

		URL urlToBG = this.getClass().getResource("slingShot.jpg");
		try {
			image = ImageIO.read(urlToBG);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 75, 384, null);             
	}
}
