package game;

import java.awt.Graphics;

public class Pokemon implements Comparable<Pokemon> {

	private int location;
	private int height;
	private boolean hit;

	public Pokemon(int location, int size) {
		this.location = location;
		this.height = size;
	}
	
	public void setHit() {
		hit = true;
	}
	
	public boolean isHit() {
		return hit;
	}
	
	@Override
	public int compareTo(Pokemon pokemon) {
		return pokemon.location - location;
	}
	
	public int getLocation(){
		return location;
	}
	public int getSize(){
		return height;
	}
	
	public boolean insideOfMe(Pokeball p) {
		return( (p.getxPos() >= location && p.getxPos() < (location) ) && (p.getyPos() >= height && p.getyPos() < (height) ));
	}
	
	public void draw(Graphics g) {
		if(!isHit()){
			g.drawImage(Game.pokemon, location+2, height, null);
		}
	}
}
