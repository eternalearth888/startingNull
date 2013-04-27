package Game;
import java.awt.Color;
import java.awt.Graphics;


// Projectile is in charge of its own location, velocity, whether it's 
// moving or not, and an acceleration
public class Projectile {

	double x;
	double y;
	double vx;
	double vy;
	int ay;
	boolean done;
	boolean flying;

	// Initialize a projectile at given coords
	public Projectile(double _x, double _y) {
		x = _x;
		y = _y;
		vx = 0;
		vy = 0;
		done = false;
		flying = false;
	}

	// Perform the necessary calculations for new velocities,
	// check if ground has been hit
	public void step() {
		x+=vx;
		y-=vy;
		if(y>=450.0) {
			y=450.0;
			stop();
		}
		vy+=ay;
	}

	// Stop moving
	public void stop() {
		vx = 0;
		vy = 0;
		ay = 0;
		done = true;
	}

	public boolean isDone() {
		return done;
	}

	public boolean isFlying() {
		return flying;
	}

	public void setvx(double v) {
		vx = v;
	}

	public void setvy(double v) {
		vy = v;

		ay = -1;
		flying = true;

	}

	// draw itself as a black ball at it's current location, check if target has been hit
	public void draw(Graphics g, FinalPanel fPanel) {
		g.setColor(Color.BLACK);
		g.fillOval((int)(x-6), (int)(y-6), 12, 12);
		hitTarget(fPanel);
	}

	// Check if targets have been hit by checking if the projectile 
	// is within the boundaries for the targets
	public void hitTarget(FinalPanel fPanel){
		if (x >= 652 && x <= 713 && y >= 355 && y <= 438){
			fPanel.targetLeft.setHit(true);
			stop();
		}
		if (x >= 715 && x <= 773 && y >= 330 && y <= 410){
			fPanel.targetMid.setHit(true);
			stop();
		}
		if (x >= 777 && x <= 835 && y >= 355 && y <= 438 ){
			fPanel.targetRight.setHit(true);
			stop();
		}
	}

	// Setters and getters
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

	public int getAy() {
		return ay;
	}

	public void setAy(int ay) {
		this.ay = ay;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public void setFlying(boolean flying) {
		this.flying = flying;
	}


}
