package angryNerds;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public abstract class Target extends JPanel {

	//Status of true means show the target, status of false means the target has been destroyed
	protected int x, y, health, points, level;
	protected Image image;
	//protected 
	public boolean notDestroyed;
	
	public Target() {
		// TODO Auto-generated constructor stub
		this.health = 0;
		x = 0;
		y = 0;
		this.level = 0;
		this.notDestroyed = true;
		this.image = Toolkit.getDefaultToolkit().getImage("/Images/none.jpg");
	}

	public Target(int x, int y, int health, int points, int level, Image image) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.points = points;
		this.level = level;
		this.image = image;
		this.notDestroyed = true;
	}
	
	public Target(int x, int y, int health, int points, int level, String imagePath) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.points = points;
		this.level = level;
		this.image = Toolkit.getDefaultToolkit().getImage(imagePath);
		this.notDestroyed = true;
		
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (Exception ex) {
			System.out.println("ERROR: Could not find image file " + imagePath);
		}
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getPoints() {
		return this.points;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public boolean getStatus() {
		return this.notDestroyed;
	}
	
	public void setStatus(boolean st) {
		this.notDestroyed = st;
	}
	
	public void setHealth(int h) {
		this.health = h;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean hit(int x, int y) {
		if ((this.x * 2 <= (x+1)) && (this.y * 2 <= (y+1)) && ((this.y * 2 + this.image.getHeight(null)) >= (y-1)) && ((this.x * 2 + this.image.getWidth(null)) >= (x-1)) && this.notDestroyed) 
		{
			return true;
		}
		
		return false;
	}
	
	public void damageDone(int damage) {
		this.health -= damage;
		if (health <= 0)
		{
			notDestroyed = false;
		}
	}
	
	public abstract void draw(Graphics g);
}
