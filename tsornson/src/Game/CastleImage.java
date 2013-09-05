package Game;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CastleImage extends JPanel{
	private BufferedImage image;

	public CastleImage() {

		URL urlToBG = this.getClass().getResource("cartoon_castle.jpg");
		try {
			image = ImageIO.read(urlToBG);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 650, 234, null);             
	}

}
