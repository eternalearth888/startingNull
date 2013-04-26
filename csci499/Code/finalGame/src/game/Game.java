package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


import javax.swing.JOptionPane;
import javax.swing.JPanel;



@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable {
	private final int HEIGHT = 400;
	private final int WIDTH = 800;
	private double dTime = .01;
	private ArrayList<Pokemon> targets;
	private ArrayList<Pokeball> projectiles;
	private Thread moveThread;
	
	private Image background;
	public static Image pokemon;

	public Game() {
		moveThread = new Thread(this);

		projectiles = new ArrayList<Pokeball>();
		// launcher = new Launcher(this);
		targets = new ArrayList<Pokemon>();

		// Get the background image
		URL url = getClass().getResource("/images/background.jpg");
		System.out.println(url);
		MediaTracker tracker = new MediaTracker(this);
		background = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(background, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			return;
		}

		// Get the pokemon image
		url = getClass().getResource("/pokemon/pikachu.png");
		pokemon = Toolkit.getDefaultToolkit().getImage(url);
		tracker.addImage(pokemon, 1);
		try {
			tracker.waitForID(1);
		} catch (InterruptedException e) {
			return;
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

		// // Draw launcher
		// launcher.draw(g);
		//
		// // Draw projectiles
		// for (Pokeball p : projectiles) {
		// p.draw(g);
		// }
		//
		// // Draw targets
		// for (Pokemon t : targets) {
		// t.draw(g);
		// }
	}

	public void generateTargets(int numTargets) {

		targets.clear();

		Random rand = new Random();

		ArrayList<Integer> locations = new ArrayList<Integer>();

		while (targets.size() < numTargets) {

			int location = rand.nextInt(3 * WIDTH / 4) + WIDTH / 4;
			int height = rand.nextInt(HEIGHT / 3) + 50;

			if (!locations.contains(location)) {
				locations.add(location);
				makeTarget(location, height);
			}
		}
	}

	// makes target at desired location with desired size
	public void makeTarget(int location, int size) {
		targets.add(new Pokemon(location, size));
	}

	// checks to see if the projectile collided with any targets in this frame,
	// returns null if it did not hit anything
	// projectiles should be destroyed if its height is less than 0;
	// should probably calculate collisions via the bottom left corner as it
	// will lead
	// utilizes insideofme fn in target
	public void checkCollisions() {

		for (Iterator<Pokeball> it = projectiles.listIterator(); it.hasNext();) {
			Pokeball p = it.next();
			if (p.getyPos() <= 0) {
				it.remove();
			}
		}

		if (!targets.isEmpty()) {
			for (Pokemon t : targets) {
				for (Iterator<Pokeball> it = projectiles.listIterator(); it
						.hasNext();) {
					Pokeball p = it.next();
					if (t.insideOfMe(p) && !t.isHit()) {
						it.remove();
						t.setHit();
					}
				}
			}
		}

		boolean unHit = false;
		for (Pokemon t : targets) {

			if (!t.isHit()) {
				unHit = true;
			}
		}

		if (!unHit && !targets.isEmpty()) {
			JOptionPane.showMessageDialog(this, "YOU ARE THE POKEMON MASTER!");
			generateTargets(5);
			// launcher.reset();
		}

	}

	// iterates through projectiles and moves them
	public void moveProjectiles(double deltaTime) {
		for (Pokeball p : projectiles) {
			p.move(deltaTime);
		}
		checkCollisions();
	}

	public double getDTime() {
		return dTime;
	}

	public ArrayList<Pokemon> getPokemon() {
		return targets;
	}

	public void addPokeball(Pokeball p) {
		projectiles.add(p);
	}

	public ArrayList<Pokeball> getPokeball() {
		return projectiles;
	}

	public void clearPokemon() {
		targets.clear();
	}

	@Override
	public void run() {
		while (true) {
			synchronized (moveThread) {
				moveProjectiles(dTime);
				repaint();
				try {
					moveThread.wait((long) (dTime * 300));
				} catch (InterruptedException e) {
					System.out.println("InterruptedException caught");
				}
			}
		}
	}

}
