/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */
package Game;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Missile {
	private double angle; 
	private Point point;
	private int x = 110;
	private int y = 475;
	private int health;
	private double velocity;
	public Image pony;

	public Missile() {
		angle = 0;
		velocity = 25.0;
		point = new Point(110, 475);
		this.pony = new ImageIcon("pictures/flyingponysmall.png").getImage();
		health = 100;
	}

	public void reset() {
		angle = 0;
		velocity = 25.0;
		point = new Point(110, 475);
		health = 100;
	}

	public void setDefaults() {
		angle = 0;
		point = new Point(110, 475);
	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(Color.black);

		Stroke s = new BasicStroke(4.0f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 1.0f, new float[] {15.0f,15.0f}, 0.0f);
		int lineLength = 200;
		g2.setStroke(s);
		g2.draw(new Line2D.Double(x + 10, y + 20, x + lineLength, y + 20));
		g2.draw(new Line2D.Double(x + 10, y + 20, x + 10 + lineLength*Math.sin(Math.toRadians(angle + 90)), y + 20 + lineLength*Math.cos(Math.toRadians(angle + 90))));
		g2.setStroke(new BasicStroke());
		
		g2.drawImage(pony, point.x-55, point.y-5, null);
	
	}

	public double getAngle() {
		return angle;
	}

	public boolean checkValidAngle(double a) {
		if (a >= 0 && a <= 360) {
			return true;
		} else {
			return false;
		}
	}

	public void pickAngle(double a) {
		if (checkValidAngle(a)) {
			angle = a;
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Angle, Angle now set to 0.");
			angle = 0;
		}
	}

	public double getVelocity() {
		return velocity;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public double getHorizontalVelocity(double angle, double velocity) {
		return Math.cos(Math.toRadians(angle)) * velocity;
	}

	public double getVerticalVelocity(double angle, double velocity) {
		return Math.sin(Math.toRadians(angle)) * velocity;
	}

	public Point getPositionAt(double time) {
		double x = getHorizontalVelocity(angle, velocity) * time;
		double y = getVerticalVelocity(angle, velocity) * time - 0.5 * (9.8 * time * time);
		Point currPoint;
		double delta = (int)Math.round(y)
				;
		currPoint = new Point((int)Math.round(x) + point.x, (int) (((int)Math.round(y) + point.y) - 2*delta));
		if (currPoint.getX() < 0.0) {
			currPoint.x = 0;
		}
		if (currPoint.getY() < 0.0) {
			currPoint.y = 0;
		}
		if (currPoint.getX() > 1000) {
			currPoint.x = 1000;
		}
		if (currPoint.getY() > 600) {
			currPoint.y = 600;
		}
		return currPoint;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	//be sure to recall gethoriz and getVert velocity
	public void pickRandomVelocity() {
		Random rand = new Random();
		int newVelocity = rand.nextInt(40);
		while(newVelocity < 12) {
			newVelocity = rand.nextInt(40);
		}
		velocity = newVelocity;

	}
	
	public int getHealth() {
		return health;
	}

	public void decHealth() {
		health = health - 10;
	}



}
