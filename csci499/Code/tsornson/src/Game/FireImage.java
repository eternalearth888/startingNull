package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class FireImage extends JPanel{

	private BufferedImage image;

	public FireImage() {

		URL urlToBG = this.getClass().getResource("fire.jpg");
		try {
			image = ImageIO.read(urlToBG);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g, int x, int y) {
		super.paintComponent(g);
		g.drawImage(image, x, y, null);             
	}
}
