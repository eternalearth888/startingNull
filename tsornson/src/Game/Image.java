package Game;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

// Image class is used to load a picture from file and then
// draw it to the frame provided with an x and a y.
public class Image extends JPanel {
	private BufferedImage image;

	public Image(String file) throws IOException {
		URL urlToBG = this.getClass().getResource(file);
		image = ImageIO.read(urlToBG);
	}

	public void paintComponent(Graphics g, int x, int y){
		super.paintComponent(g);
		g.drawImage(image, x, y, null);
	}
}
