package mainCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Ball {
	private double x;
	private double y;
	private double diameter;
	private Color color;
	private double slope;
	
	public Ball(double x, double y, double diameter, Color color){
		this.x = x;
		this.y = y;
		this.diameter = diameter;
		this.color = color;
		this.slope = 18;
	}
	
	public Ball(){
		this.x = 80;
		this.y = 80;
		this.slope = 45;
		this.diameter = 20;
		this.color = Color.CYAN;
	}
	
	public double getSlope() {
		return slope;
	}

	public void setSlope(double slope) {
		this.slope = slope;
	}

	public void draw(Graphics g) {
		//Graphics2D g2 = (Graphics2D) g;
		g.setColor(color);
		g.fillOval((int) x, (int) y, (int) diameter, (int) diameter);
	}

	// ball rolling down certain distance per cycle
	public void rolling() {
		setPosition(calculateXPosition(3),calculateYPosition(3));
	}
	
	public void explode () {
		color = Color.RED; //11/30
		//System.out.println("at Ball.explode()");
	}
	
	public void setColor(Color color) { // 11/30
		this.color = color;
	}

	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2D.Double getPosition() {
		return new Point2D.Double();
	}
	
	// Calculate the next position of the ball
	public double calculateXPosition(double d) {
        return Math.round(x - (d  * Math.sin(Math.toRadians(slope)))); 
    }

    public double calculateYPosition(double d) {
        return Math.round(y + (d  * Math.cos(Math.toRadians(slope))));
    }

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDiameter() {
		return diameter;
	}
	
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
}
