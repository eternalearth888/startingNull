package Game;
import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;

// This class is responsible for giving the projectile its power, angle,
// and drawing the trajectory of the projectile.
public class Slingshot {

	double x;
	boolean held, showTrajectory;
	double vx;
	double vy;

	// Initialize all variables and appropriate flags
	public Slingshot(int _x) {
		x=_x;
		held = false;
		showTrajectory = false;
		vx=0;
		vy=0;
	}

	// This will draw the trajectory of the projectile if it is still being held and
	// showTrajectory checkbox is selected
	public void draw(Graphics g, double mx, double my) {
		g.setColor(Color.BLACK);
		if(held && mx < 90.0) {
			g.drawString("Angle: "+calcAngle(mx,my), (int)(x+10.0), 440);
			g.drawLine((int)mx, (int)my, (int)x, 400);
			
			double tempAngle = calcAngle(mx, my);
			double tx = x;
			double ty = 400.0;
			
			// Check if the power is greater than 50, and if so, cap it
			if (Math.sqrt(((mx-90.0)*(mx-90.0))+((my-400.0)*(my-400.0))) > 50) {
				mx = 90.0 - Math.sin(Math.toRadians(90.0-tempAngle))*50.0;
				my = 400.0 + Math.cos(Math.toRadians(90.0-tempAngle))*50.0;
			}
			
			double temp_vx = ((x-mx)/1.5);
			double temp_vy = ((my-400.0)/1.5);
			
			g.setColor(Color.GRAY);
			
			// Draw trajectory if trajectory flag is set
			if (showTrajectory) {
				while(ty<450) {
					g.fillOval((int)(tx-3),(int)(ty-3),6,6);
					for(int i=0; i<2; i++) {
						tx+=temp_vx;
						ty-=temp_vy;
						temp_vy+=-1.0;
					}
				}
			}			
		}
	}

	// Given a mouse x and a mouse y, return the angle between those
	// coords and the horizontal
	public double calcAngle(double mx, double my) {
		double ang;
		if((mx-x)<0) {
			ang = (Math.atan((400.0-(double)my)/((double)mx-(double)x))/Math.PI)*180.0;
		}
		else {
			return 0;
		}
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(ang));
	}
	
	// Given a mouse x and a mouse y, return the power of the projectile
	// provided it's aiming right
	public double calcPower(double mx, double my) {
		if((mx-x)<0) {
			double pow = (Math.sqrt((400.0-(double)my)*(400.0-(double)my)+((double)mx-(double)x)*((double)mx-(double)x)));
			DecimalFormat twoDForm = new DecimalFormat("#.##");
			return Double.valueOf(twoDForm.format(pow));
		}
		return 0;
	}

	// Set the held flag to true if currently false
	public void hold(double mx, double my) {
		if(!held) {
			held = true;
		}
	}

	// Reset velocity variables
	public void reset() {
		vx = 0;
		vy = 0;
	}

	// Projectile has been released, set held to false and calculate velocities
	public void release(double mx, double my) {
		held = false;
		if(mx < 90.0) {
			vx = ((x-mx)/1.5);
			vy = ((my-400.0)/1.5);
		}
	}

	// Getters and setters
	public boolean isHeld() {
		return held;
	}

	public double getvx() {
		return vx;
	}

	public double getvy() {
		return vy;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public void setHeld(boolean held) {
		this.held = held;
	}
	
	// toggle showTrajectory variable
	public void setShowTrajectory() {
		showTrajectory = !showTrajectory;
	}
}
