package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

// Final panel is the panel that contains both the logic of the game
// as well as the gui elements to be drawn (such as images).
public class FinalPanel extends JPanel implements MouseMotionListener, MouseListener, ActionListener{
	// Our images
	Image cImage, sImage, fImage, sunImage;
	
	// Components for playing with
	Target targetLeft, targetMid, targetRight;
	Projectile proj;
	Slingshot sling;
	Init jf;

	// Not used
	Timer clock;

	// Some basic flags
	boolean newProj;
	boolean endGame;
	boolean message;

	//Mouse coords
	double mx = -1;
	double my = -1;

	// Initialize our images, flags, etc...
	public FinalPanel(Init jf) {
		this.jf = jf;
		targetLeft = new Target(655, 358);
		targetMid = new Target(715, 332);
		targetRight = new Target(777, 358);
		sling = new Slingshot(90);
		proj = new Projectile(90,400);
		clock = new Timer(30, this);
		clock.start();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		try {
			cImage = new Image("cartoon_castle.jpg");
			sImage = new Image("slingShot.jpg");
			fImage = new Image("fire.jpg");
			sunImage = new Image("sunshine.jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		add(cImage);
		add(sImage);
		add(sunImage);
		endGame = false;
		message = false;
	}

	// Redraw the entire game
	public void paintComponent(Graphics g) {
		g.setColor(new Color(Integer.parseInt("99CCFF",16)));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(new Color(35,142,35));
		g.fillRect(0, 450, this.getWidth(), 50);
		cImage.paintComponent(g, 650, 234);
		sImage.paintComponent(g, 75, 384);
		sunImage.paintComponent(g, 70, 0);
		
		// Draw the fire (target hit) if the target is actually hit
		if (targetLeft.getHit())
			fImage.paintComponent(g, 655, 297);
		if (targetMid.getHit())
			fImage.paintComponent(g, 715, 272);
		if (targetRight.getHit())
			fImage.paintComponent(g, 777, 297);
		sling.draw(g,mx,my);
		proj.draw(g, this);
	}

	// Will draw the trajectory after updating mouse coordinates
	@Override
	public void mouseDragged(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	// Grab the projectile, creating a new one as we do so
	@Override
	public void mousePressed(MouseEvent e) {
		// Make sure we only draw if the game is still going
		if (endGame == false){
			if(newProj) {
				newProj = false;
				proj = new Projectile(90.0,400.0);
			}
			if(!proj.isFlying()) {
				sling.hold(e.getX(), e.getY());
				mx = e.getX();
				my = e.getY();
			}
			repaint();
		}
	}

	// Upon release of the mouse, we need the projectile to start flying.
	public void mouseReleased(MouseEvent e) {
		// If the projectile is not flying, set appropriate values and repaint
		if(!proj.isFlying()) {
			double tempX = e.getX();
			double tempY = e.getY();
			double tempAngle = sling.calcAngle(tempX, tempY);
			// Cap the power of the projectile at 50 and make sure it can't fire to the left
			if (Math.sqrt(((tempX-90.0)*(tempX-90.0))+((tempY-400.0)*(tempY-400.0))) > 50 && tempX < 90.0) {
				tempX = Math.sin(Math.toRadians(90.0-tempAngle))*50.0;
				tempY = Math.cos(Math.toRadians(90.0-tempAngle))*50.0;
				sling.release(90.0 - tempX, tempY + 400.0);
				setAngle(tempAngle, sling.calcPower(90.0 - tempX, tempY + 400.0));
			} else {
				sling.release(tempX, tempY);
				setAngle(tempAngle, sling.calcPower(tempX, tempY));
			}
			// Set the velocity of the
			proj.setvx(sling.getvx());
			proj.setvy(sling.getvy());
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// Called everytime the Timer ticks, or a button is pushed, or the mouse is operated on
	public void actionPerformed(ActionEvent e) {
		// check if we've won, and if so, display winning message and quiz
		checkWin();
		if (endGame && message == false){
			repaint();
			JOptionPane.showMessageDialog(jf, "Congratualtions, you have wrecked the castle!", "Good Job!", JOptionPane.INFORMATION_MESSAGE);
			message = true;
			// Create a new JPanel that pops up that contains a little quiz about angles or something
			JFrame quiz = new JFrame();
			quiz.setSize(500, 500);
			QuizPanel container = new QuizPanel(quiz, quiz.getWidth(), quiz.getHeight());
			quiz.add(container);
			quiz.setTitle("LON-CATApult");
			quiz.setVisible(true);
		}
		// Update the coordinates of the projectile
		proj.step();
		// Check if the projectile is done its movement
		if(proj.isDone()) {
			newProj = true;
			sling.reset();
		}
		repaint();
	}
	
	// This panel contains the quiz and all of its logic
	public class QuizPanel extends JPanel {
		private int width,height;
		private Image pic;
		private JButton submit;
		private String question;
		private JLabel qMsg,aMsg,bMsg;
		private Integer theta;
		private Double a,b,c;
		private JTextField fieldA, fieldB;
		private JPanel center, A, B;
		private JFrame parent;
		
		// Initialize all variables and create logic for button
		public QuizPanel(JFrame jfrm, int _width, int _height) {
			width = _width;
			height = _height;
			parent = jfrm;
			submit = new JButton("Submit");
			
			// Submit button, upon being pressed, will check if provided answers
			// are correct or not within 0.01. Depending on the result, it will tell
			// you if you are correct, incorrect, or if the provided values don't make
			// sense
			submit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String aStr = fieldA.getText();
					String bStr = fieldB.getText();
					boolean correct = false;
					try {
						correct = Math.abs(Double.parseDouble(aStr) - a) <= 0.01;
						correct &= Math.abs(Double.parseDouble(bStr) - b) <= 0.01;
						if(correct) {
							JOptionPane.showMessageDialog(null, "Correct!");
							parent.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Sorry, that is incorrect.");
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Please enter your answer using only numbers.");
					}
					
				}				
			});
			
			// Initialize text fields
			fieldA = new JTextField();
			fieldB = new JTextField();
			try {
				pic = new Image("right-triangle.png");
			} catch (IOException e) {
				System.out.println("Image right-triangle.png not found.");
				e.printStackTrace();
			}
			// Choose a random value from 1 to 89 for our angle theta
			Random rand = new Random();
			theta = Math.abs(rand.nextInt()%89+1);
			// Let our hypotenuse be a value from 0 to 5
			c = Math.abs(rand.nextDouble()*5);
			// Calculate correct values for a and b
			a = c*Math.sin(Math.toRadians(theta));
			b = c*Math.cos(Math.toRadians(theta));
			// Create/format question
			String cStr = c.toString();
			question = "Given that C = "+cStr.substring(0, 4)+"\n and theta = "+theta+" degrees,";
			question += "solve for a and b.";
			qMsg = new JLabel(question);
			setLayout(new BorderLayout());
			
			// Add things to panel
			center = new JPanel();
			A = new JPanel();
			B = new JPanel();
			A.setLayout(new GridLayout(1,2));
			B.setLayout(new GridLayout(1,2));
			aMsg = new JLabel("What is a:");
			bMsg = new JLabel("What is b:");
			center.setLayout(new GridLayout(4,1));
			center.add(qMsg);
			A.add(aMsg);
			A.add(fieldA);
			B.add(bMsg);
			B.add(fieldB);
			center.add(A);
			center.add(B);
			center.add(submit);
			add(center, BorderLayout.SOUTH);	
		}
		
		// Draw image to quiz
		public void paintComponent(Graphics g) {
			pic.paintComponent(g, (width-312)/2, 0);
		}
	}
	
	public void setAngle(Double ang, Double pow){
		jf.setAngle(ang, pow);
	}

	// Check if all the targets have been hit
	public boolean checkWin(){
		if (targetRight.getHit() && targetMid.getHit() && targetLeft.getHit())
			endGame = true;
		return endGame;
	}
	
	// Set the targets if they are hit or not
	public void setHit(boolean bl, boolean bm, boolean br) {
		targetLeft.setHit(bl);
		targetMid.setHit(bm);
		targetRight.setHit(br);
	}
	
	// Test whether targets are hit or not
	public boolean testCondition(boolean bl, boolean bm, boolean br) {
		return ((bl==targetLeft.getHit()) && (bm==targetMid.getHit()) && (br==targetRight.getHit()));
	}
	
	// determine if left target is hit
	public boolean getHitL() {
		return targetLeft.getHit();
	}
	
	// determine if middle target is hit
	public boolean getHitM() {
		return targetMid.getHit();
	}
	
	// determine if right target is hit
	public boolean getHitR() {
		return targetRight.getHit();
	}
	
	// Return the parent JFrame
	public Init getJf() {
		return jf;
	}
}
