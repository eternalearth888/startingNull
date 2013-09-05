package main;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class World extends JPanel implements Runnable {

	private final int HEIGHT = 400;
	private final int WIDTH = 800;
	private Image background;
	private double dTime = .01;
	private Launcher launcher;
	private ArrayList<Target> targets;
	private ArrayList<Pokeball> projectiles;
	private Thread moveThread;
	ArrayList<String> questions;
	ArrayList<String> answers;

	public static Image crate;
	public static BufferedImage cannon;

	public World() {
		generateQuestions();
		moveThread  = new Thread(this);
		
		projectiles = new ArrayList<Pokeball>();
		launcher = new Launcher(this);
		targets = new ArrayList<Target>();

		// Get the background image
		URL url = getClass().getResource("/background.jpg");
		MediaTracker tracker = new MediaTracker(this);
		background = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(background, 0);
		try {
			tracker.waitForID(0);
		} catch(InterruptedException e) { 
			return;
		}

		// Get the crate image
		url = getClass().getResource("/crate.jpg");
		crate = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(crate, 1);
		try {
			tracker.waitForID(1);
		} catch(InterruptedException e) { 
			return;
		}

		// Get the cannon image
		try {
			url = getClass().getResource("/cannon.gif");
			cannon = ImageIO. read((url));
			//cannon = (BufferedImage) cannon.getScaledInstance(90, 15, BufferedImage.SCALE_FAST);
		} catch (IOException e) {
			e.printStackTrace();
		}

		generateTargets(5); // start with 5 targets
		
		moveThread.start();
	}

	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;

		// Draw the background image before moving the origin
		g.drawImage(background, 0, 0, WIDTH, HEIGHT, null);

		// Change origin to bottom left
		g.scale(1.0, -1.0);
		g.translate(0, -HEIGHT);

		// Draw launcher
		launcher.draw(g);

		// Draw projectiles
		for( Pokeball p : projectiles ) {
			p.draw(g);
		}

		// Draw targets
		for( Target t : targets ) {
			t.draw(g);
		}
	}

	// Randomly generates non-overlapping targets to the right of the launcher
	public void generateTargets(int numTargets) {	

		targets.clear();

		Random rand = new Random();

		ArrayList<Integer> locations = new ArrayList<Integer>();

		while( targets.size() < numTargets ) {

			int location = rand.nextInt(3*WIDTH/4)+WIDTH/4 - Target.TARGET_SIZE;
			int height = rand.nextInt(HEIGHT/3)+50;

			if( !locations.contains(location) ) {
				locations.add(location);
				makeTarget(location, height);
			}
		}
	}

	// makes target at desired location with desired size
	public void makeTarget(int location, int size){
		targets.add(new Target(location, size));
	}

	// checks to see if the projectile collided with any targets in this frame, returns null if it did not hit anything
	// projectiles should be destroyed if its height is less than 0;
	// should probably calculate collisions via the bottom left corner as it will lead
	// utilizes insideofme fn in target
	public void checkCollisions() {

		for (Iterator<Pokeball> it = projectiles.listIterator(); it.hasNext();) {
			Pokeball p = it.next();
			if(p.getyPos() <= 0){
				it.remove();
			}
		}

		if( !targets.isEmpty() ) {
			for( Target t : targets ) {
				for( Iterator<Pokeball> it = projectiles.listIterator(); it.hasNext(); ) {
					Pokeball p = it.next();
					if( t.insideOfMe(p) && !t.isHit() ){
						it.remove();
						t.setHit();
					}
				}
			}
		}

		boolean unHit = false;
		for(Target t : targets) {

			if(!t.isHit()){
				unHit = true;
			}
		}

		if(!unHit && !targets.isEmpty()){
			JOptionPane.showMessageDialog(this, "You've gotten all the targets, now you need to answer questions to make your victoory complete. Aaargh!");
			askQuestions();
			generateTargets(5);
			//launcher.reset();
		}


	}

	// not exactly elegant but it seems the best way to get the projectile into the world
	public void launch() {
		Pokeball temp = launcher.launch();
		if(temp != null){
			projectiles.add(temp);
		}
	}

	// iterates through projectiles and moves them
	public void moveProjectiles(double deltaTime){
		for( Pokeball p : projectiles ) {
			p.move(deltaTime);
		}
		checkCollisions();		
	}
	public double getDTime(){
		return dTime;
	}
	public Launcher getLauncher() {
		return launcher;
	}
	public ArrayList<Target> getTargets() {
		return targets;
	}
	public ArrayList<Pokeball> getProjectiles() {
		return projectiles;
	}

	public void addProjectile(Pokeball p) {
		projectiles.add(p);
	}

	public void clearTargets() {
		targets.clear();
	}
	void generateQuestions(){
		
		String[] temp = {
				"Which disease was appropriately named after the dark splotches it formed on its victims' bodies in the 14th century?", "Bubonic Plague",

				"Which of these three cities is located closest to New York? Moscow, Buenos Aires, or Honolulu?", "Moscow",

				"By what name do we call the series of European power struggles fought from 1618-48?", "Thirty Years War",

				"How many total degrees are there among all the angles of a hexagon?", "720",

				"Can you name a common four letter word which reads the same upside down as right-side up?", "NOON",

				"Around 1765, which two English surveyors drew a line separating the southern slave states from the northern free states?", "Mason and Dixon",

				"How many gods are there in Buddhism?", "0",

				"What is the lowest point on the land of the continental United states?", "Death Valley",

				"One of the longest running broadway shows ever, with over 4000 performances, contained the name of a common animal in the title. What was it?", "Cats",

				"Which two people signed the U.S. Constitution on 9/17/1787, and later became U.S. Presidents?", "George Washington and James Madison",

				"How many hair spikes does Bart Simpson have?", "9",

				"What is the world's largest herbiferous flowering plant?", "Banana",

				"The flag that sailed atop many pirate ships was called what?", "Jolly Roger",

				"What state is bordered by exactly one other state?", "Maine",

				"Generally speaking, who lives longer: cats or dogs?", "Cats",

				"Which state, out of the continental US, extends the farthest north?", "Minnesota",

				"What's the sixth letter of the Greek alphabet?", "Zeta",

				"What is the Yiddish expression for being drunk?", "Shikker",

				"The name of the smallest citrus fruit comes to us from the Chinese language. What is it?", "Kumquat",

				"What is the flat land adjacent to rivers called?", "Floodplains",

				"What is the first name of President James K. Polk's wife?", "Sarah",

				"March is the third month of what calendar?", "Gregorian",

				"What are the most common livestock (animals raised for commercial purposes) in the world?", "Chickens",

				"What is the most popular table gambling game in Las Vegas?", "Blackjack"
		};
		questions = new ArrayList<String>();
		answers =  new ArrayList<String>();
		for(int i = 0; i < temp.length-1;i+=2){
			questions.add(temp[i]);
			answers.add(temp[i+1]);
		}
	}
	void askQuestions(){
		ArrayList<String> tempQ = new ArrayList<String>(questions);
		ArrayList<String> tempA = new ArrayList<String>(answers);
		Random randGen = new Random();		
		for(int i = 0; i < 5;i++){
			int temp = randGen.nextInt(tempQ.size());
			String answer = JOptionPane.showInputDialog(tempQ.get(temp));
			if(answer == null){
				answer = "";
			}
			if(answer.equalsIgnoreCase(tempA.get(temp))){
				JOptionPane.showMessageDialog(this, "Correct!");
			}else{
				JOptionPane.showMessageDialog(this, "That is either quite wrong or just barely not what we're looking for");
			}
			tempQ.remove(temp);
			tempA.remove(temp);
		}
	}
	@Override
	public void run() {
		while(true){
			synchronized(moveThread){
				moveProjectiles(dTime);
				repaint();
				try {
					moveThread.wait((long)(dTime * 300));
				} catch(InterruptedException e) { 
					System.out.println("InterruptedException caught"); 
				}
			}
		}
	}
}
