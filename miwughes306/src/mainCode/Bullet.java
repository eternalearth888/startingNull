package mainCode;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

public class Bullet {
	private double x;
	private double y;
	private double velocity;
	private double angle;
	private final static double GRAVITY = 9.81;
	private Image bullet;
	
	public Bullet(){
		this.x = 200;
		this.y = 80;
		this.velocity = 10;
	}
	
	public Bullet(double x, double y, double velocity, double angle){
		this.x = x;
		this.y = y;
		this.velocity = velocity;
		this.angle = angle;
		bullet = new ImageIcon("bullet.png").getImage();
	}
	
	public void draw(Graphics g) {
		g.drawImage(bullet, (int) x, (int) y, null);
	}
	
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	
	public void setInitialAngle(double angle) {
		this.angle = angle;
	}
	
	// Check to see if the bullet is touching ball
	public boolean intersect(Ball ball) {
		Ellipse2D.Double circle = new Ellipse2D.Double(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter());
		for (int i = (int) x - 5; i < x + 6; i++){
			for (int j = (int) y - 5; j < y + 6; j++){
				if (circle.contains(new Point(i, j)))
					return true;
			}
		}
		return false;
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// Calculate position of bullets over time, taking gravity into account

	public double calculateXPosition(double time) {
		// X Displacement
		// DeltaX = VXo*t
		
		// VXo = V*cos(angle);
		double VXo = velocity*Math.cos(Math.toRadians(angle));
		double DeltaX = VXo*time;
		return Math.round(x+DeltaX);
	}

	public double calculateYPosition(double time) {
		// Y Displacement
		// DeltaY = VYo*t - 1/2*g*t^2
		
		// VYo = V*sin(angle)
		double DeltaY = velocity*Math.sin(Math.toRadians(angle))*time - 0.5*GRAVITY*Math.pow(time, 2);
		
		return Math.round(y - DeltaY);
	}

	// bullet fly certain distance for each cycle
	public void flying(){
		setPosition(calculateXPosition(1), calculateYPosition(1));
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
