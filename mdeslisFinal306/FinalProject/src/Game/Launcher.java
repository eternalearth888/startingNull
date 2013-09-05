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


public class Launcher extends Structure {
	private int shotsTaken;
	private Missile missile;
	public Image launcher;
	
	public Launcher() {
		this.launcher = new ImageIcon("pictures/launcher.png").getImage();
		shotsTaken = 0;
		missile = new Missile();
	}
	
	public void reset() {
		shotsTaken = 0;
		missile.reset();
	}
	
	@Override
	public void draw(Graphics g) {
		 Graphics2D g2 = (Graphics2D)g;
		 g2.drawImage(launcher, 50, 550, null);
	}
	
	public int getShotsTaken() {
		return shotsTaken;
	}

	public void incShotsTaken() {
		shotsTaken++;
	}

	public Missile getMissile() {
		return missile;
	}

	public void setMissile(Missile missile) {
		this.missile = missile;
	}

	public void shoot(Missile missile) {}
	
	

}
