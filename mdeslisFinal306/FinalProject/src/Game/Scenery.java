/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */

package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Scenery {
	 public Image cloud;
	
	 public Scenery() {
		 this.cloud = new ImageIcon("pictures/cloudsdale.png").getImage();
	 }
	 
	public void draw(Graphics g) {
		 Graphics2D g2 = (Graphics2D)g;
		 g2.drawImage(cloud, 0, 0, null);
	}
}
