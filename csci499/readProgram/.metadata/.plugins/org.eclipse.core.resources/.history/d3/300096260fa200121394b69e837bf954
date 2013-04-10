package mainCode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Canon {
	private double x;
	private double y;
	private double angle;
	private Image canon;
	
	public Canon(){
		this.x = 10;
		this.y = 80;
		this.angle = 45;
	}
	
	public Canon(int x, double y, double angle){
		this.canon = new ImageIcon("cannon.png").getImage();
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	
	public void draw(Graphics g) {
		drawAngle(g);
		drawAim(g);
		g.setColor(Color.DARK_GRAY);
		g.drawImage(canon, (int) x, (int) y, null);
	}
	
	// draw angle ticks
	public void drawAngle(Graphics g) {
		g.setColor(Color.YELLOW);
		int originalX = 20;
		int originalY = 460;
		((Graphics2D) g).setStroke(new BasicStroke(2));
		for (int i = 0; i <= 90; i = i + 10){
			double angle = i * Math.PI / 180;
			int startX = (int) (originalX + 60 * Math.sin(angle));
			int startY = (int) (originalY - 60 * Math.cos(angle));
			int endX = (int) (originalX + 90 * Math.sin(angle));
			int endY = (int) (originalY - 90 * Math.cos(angle));
			g.drawLine(startX, startY, endX, endY);
		}
		
	}
	
	// draw the aiming line
	public void drawAim(Graphics g) {
		g.setColor(Color.RED);
		int originalX = 20;
		int originalY = 460;
		((Graphics2D) g).setStroke(new BasicStroke(4));
		double angle = this.angle * Math.PI / 180 - Math.PI/2;
		int startX = (int) (originalX + 60 * Math.sin(-angle));
		int startY = (int) (originalY - 60 * Math.cos(-angle));
		int endX = (int) (originalX + 110 * Math.sin(-angle));
		int endY = (int) (originalY - 110 * Math.cos(-angle));
		g.drawLine(startX, startY, endX, endY);		
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}
	
}
