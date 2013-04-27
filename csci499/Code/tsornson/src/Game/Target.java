package Game;
import java.awt.Color;
import java.awt.Graphics;

// Keeps track of it's location and if it's been hit or not
public class Target {

	int x, y;
	boolean hit;

	public Target (int _x, int _y) {
		y=_y;
		x=_x;
		hit = false;
	}

	// Getter and setter
	public boolean getHit(){
		return hit;
	}

	public void setHit(boolean hit){
		this.hit = hit;
	}

	// Draw itself as a black rectangle (will be drawn over with the castle)
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 58, 85);
	}

}
