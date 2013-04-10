package mainCode;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class SaveTheCake extends JPanel{  
	public static final int FRAME_SIZE_X = 700;
	public static final int FRAME_SIZE_Y = 500;
	public static final int OFFSET = 50;				//also ball diameter 
	public static final int BALL_DIA_REDUCTION = 10;  //11/30
	private Ball ball;
	private Canon canon;
	private ArrayList<Bullet> bullets;
	private Cake cake;
	private Image bground;
	private boolean panicking = false;
	int restart = JOptionPane.YES_NO_OPTION;   //11/30
	
	
	public SaveTheCake() {
		this.bground = new ImageIcon("background.png").getImage();
		ball = new Ball(FRAME_SIZE_X - OFFSET - 15, OFFSET - 40 , OFFSET, Color.GREEN);
		canon = new Canon(10, FRAME_SIZE_Y - 80, 45);
		bullets = new ArrayList<Bullet>();
		cake = new Cake(FRAME_SIZE_X - 230, FRAME_SIZE_Y - 150);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(bground, 1, 1, null);
		canon.draw(g);
		cake.draw(g);
		ball.draw(g);
		if (panicking)
			cake.drawPanick(g);
		for (Bullet i:bullets)
			i.draw(g);
	}
	
	public void mainFlow(){
		while(true) {  //11/30/2012
			while (!cake.intersect(ball)){				// When the game is not done
				try {
					Thread.sleep(50);					// Create cycles
				} catch(InterruptedException e) {
					System.out.println(e);
				}
				for (Bullet i: bullets) {				// In each cycle, 
					i.flying();							// Move the bullets
					if(i.intersect(ball)) { //11/30		// if bullet hits ball then ball explodes
						ball.setDiameter(ball.getDiameter()-BALL_DIA_REDUCTION);
						ball.explode();
						if(ball.getDiameter() < 1) {	// When ball is destroyed => win
							JOptionPane.showMessageDialog(null, "You saved the cake!", "Welcome to Save The Cake", JOptionPane.INFORMATION_MESSAGE);
							restartGame();
							break;
						}
						//System.out.println("hit it");
						
					}
				}
				ball.rolling();						// Move the ball
				if (cake.inPanick(ball))			// cake panics when ball gets close
				panicking = true;
				repaint();
			}
			panicking = false;
			repaint();
			// 11/30/2012
			// Game over, repeat ?
			restart = JOptionPane.showConfirmDialog(null, "Do you want to shoot again?", "Welcome to Save The Cake", JOptionPane.YES_NO_OPTION);
			if(restart == JOptionPane.YES_OPTION) {
				ball = new Ball(FRAME_SIZE_X - OFFSET - 15, OFFSET - 40 , OFFSET, Color.GREEN);
				cake.reset();
			} else {
				// TODO: compute final score
				System.exit(0);
				//exit
			}
		} //end while true
	}
	
	public Ball getBall() {
		return ball;
	}

	public Canon getCanon() {
		return canon;
	}

	public ArrayList<Bullet> getBullet() {
		return bullets;
	}

	public Cake getCake() {
		return cake;
	}

	// restart game: create a new ball
	public void restartGame(){
		ball = new Ball(FRAME_SIZE_X - OFFSET - 15, OFFSET - 40 , OFFSET, Color.GREEN);
	}
}
