package main;

import java.awt.Color;
import java.awt.Graphics;

public class Target implements Comparable<Target>{

	private int location;
	private int height;
	private boolean hit;
	public final static int TARGET_SIZE = 50;

	public Target(int location, int size) {
		this.location = location;
		this.height = size;
		//System.out.println("Creating new target:");
		//System.out.println("   L: " + location);
		//System.out.println("   S: " + size);
	}

	public void setHit() {
		hit = true;
	}
	public boolean isHit() {
		return hit;
	}
	@Override
	public int compareTo(Target o) {
		return o.location - location;
	}
	public int getLocation(){
		return location;
	}
	public int getSize(){
		return height;
	}
	public boolean insideOfMe(Pokeball p) {
		return( (p.getxPos() >= location && p.getxPos() < (location + TARGET_SIZE) ) && (p.getyPos() >= height && p.getyPos() < (height + TARGET_SIZE) ));
	}


	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		if(!isHit()){
			g.fillRect(location, height, TARGET_SIZE, TARGET_SIZE);
			g.drawImage(World.crate, location+2, height+2, TARGET_SIZE-4, TARGET_SIZE-4, null);
		}
		//g.fillRect(location, height, TARGET_SIZE, TARGET_SIZE);
	}
}
