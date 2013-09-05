package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Pokemon implements Comparable<Pokemon>{

	private int location;
	private int height;
	private boolean hit;
	public final static int TARGET_SIZE = 56;
	private Image pokemon;
	
	public Pokemon(int location, int size, Image pokemon) {
		this.location = location;
		this.height = size;
		this.pokemon = pokemon;
	}

	public void setHit() {
		hit = true;
	}
	public boolean isHit() {
		return hit;
	}
	@Override
	public int compareTo(Pokemon o) {
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
		if(!isHit()){
			g.drawImage(pokemon, location+2, height+2, TARGET_SIZE-4, TARGET_SIZE-4, null);
		}
	}
}
