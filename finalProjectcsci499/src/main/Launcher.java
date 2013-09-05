package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Launcher {
	private World world;
	private ArrayList<Integer> projPath;
	private double angle;
	private int power;
	private final int SIZE = 5;
	private Image pokeball;
	
	public Launcher(World world, Image pokeball) {
		this.world = world;
		angle = 45;
		power = 50;
		projPath = new ArrayList<Integer>();
		this.pokeball = pokeball;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	// returned projectile is  added to the world's projectile list so that 
	// it can iterate through the list and the projectile can move itself
	public Pokeball launch() {
		Pokeball p = new Pokeball(Math.cos(Math.toRadians(angle))*104, Math.sin(Math.toRadians(angle))*104, Math.cos(Math.toRadians(angle))*power, Math.sin(Math.toRadians(angle))*power, pokeball);
		return p;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(Math.toRadians(angle), 175, 175);
        g2d.rotate(-Math.toRadians(angle), 175, 175);
     
		drawProjPath(this,g);
	}
	
	public void drawProjPath(Launcher launcher,Graphics g) {
		
		Pokeball temp = launcher.launch();
		int time = 1;
		while(temp.getyPos()>=0) {
			if(time%(1/world.getDTime()) == 0){
				projPath.add((int)temp.getxPos());
				projPath.add((int)temp.getyPos());
			}
			temp.move(world.getDTime());
			time++;
		}
		for(int i=0; i<projPath.size(); i+=2) {
			g.drawOval(projPath.get(i) - SIZE/2, projPath.get(i+1) - SIZE/2, SIZE, SIZE);
		}
		projPath.clear();
	}
	
	public void reset() {
		power = 50;
		angle = 45;
	}
}
