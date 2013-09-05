package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

public class Pokeball {

	private final int SIZE = 30;
	private double xPos;
	private double yPos;
	private double xVel;
	private double yVel;

	private Image pokeball;

	public Pokeball(double xPos, double yPos, double xVel, double yVel, Image pokeball) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.xVel = Math.round(xVel);
		this.yVel = Math.round(yVel);
		this.pokeball = pokeball;
	}

	public double calcSpeed() {
		return Math.sqrt(xVel * xVel + yVel * yVel);
	}

	public double getxPos() {
		return xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public double getxVel() {
		return xVel;
	}

	public double getyVel() {
		return yVel;
	}

	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
//		g.setColor(Color.PINK);
//		g.fillOval((int) xPos - SIZE / 2, (int) yPos - SIZE / 2, SIZE, SIZE);
		g2d.drawImage(pokeball, (int) xPos - SIZE / 2, (int) yPos - SIZE / 2, null);
	}

	// delta time is the inverse frame rate, used to keep motion smooth on
	// machines where frame rates will be different
	public void move(double deltaTime) {
		xPos = xPos + xVel * deltaTime;
		yPos = yPos + yVel * deltaTime;
		yVel = yVel - 10 * deltaTime;
	}


}
