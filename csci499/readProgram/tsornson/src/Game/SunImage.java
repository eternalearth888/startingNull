package Game;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class SunImage extends JPanel{

	private BufferedImage image;


	public SunImage() {

		URL urlToBG = this.getClass().getResource("sunshine.jpg");
		try {
			image = ImageIO.read(urlToBG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 70, 0, null);             
	}
}
