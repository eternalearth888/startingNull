package main;

import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.*;

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
	private ArrayList<Pokemon> targets;
	private Vector<Pokeball> projectiles;
	private Thread moveThread;

	public ArrayList<Image> pokemon;
	public Image pokeball;
	private int totalHitCount = 0;
	private int isGameOver = 0;
	public boolean isMaster = false;

	public World() {

		moveThread = new Thread(this);

		// Get the background image
		URL bkg = getClass().getResource("/images/pokeball.png");
		MediaTracker tracker = new MediaTracker(this);
		pokeball = Toolkit.getDefaultToolkit().getImage(bkg);
		tracker.addImage(pokeball, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException e) {
			return;
		}

		projectiles = new Vector<Pokeball>();
		launcher = new Launcher(this, pokeball);
		targets = new ArrayList<Pokemon>();

		// Get the background image
		URL url = getClass().getResource("/images/background.jpg");
		MediaTracker tracker2 = new MediaTracker(this);
		background = Toolkit.getDefaultToolkit().getImage(url);
		tracker2.addImage(background, 1);
		try {
			tracker2.waitForID(1);
		} catch (InterruptedException e) {
			return;
		}

		generateTargets(8); // start with 8 random pokemon

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
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}

		// Draw targets
		for (Pokemon t : targets) {
			t.draw(g);
		}
	}

	// Randomly generates non-overlapping targets to the right of the launcher
	public void generateTargets(int numTargets) {

		targets.clear();
		MediaTracker tracker = new MediaTracker(this);
		Scanner readPokemon;
		ArrayList<String> addPokemon = new ArrayList<String>();
		try {
			readPokemon = new Scanner(new File("textFiles/pokemon"));
			while (readPokemon.hasNextLine()) {
				addPokemon.add(readPokemon.nextLine());
			}

			readPokemon.close();

		} catch (FileNotFoundException e) {
			System.out
					.println("The source file can't be found or does not exist."
							+ e);
		}

		// Choose a random one from the list
		Random r = new Random();
		String randomString = "";
		ArrayList<String> printPokemon = new ArrayList<String>();

		for (int i = 0; i < 8; i++) {
			printPokemon.add(addPokemon.get(r.nextInt(addPokemon.size())));
			// System.out.print(printPokemon);
		}

		ArrayList<URL> pokeLocation = new ArrayList<URL>();
		pokemon = new ArrayList<Image>();

		for (int j = 0; j < printPokemon.size(); j++) {
			pokeLocation.add(getClass().getResource(
					"/pokemon/" + printPokemon.get(j) + ".png"));
			Image pokemonGrab = Toolkit.getDefaultToolkit().getImage(
					pokeLocation.get(j));
			pokemon.add(pokemonGrab);
			tracker.addImage(pokemonGrab, j);

			try {
				tracker.waitForID(j);
			} catch (InterruptedException e) {
				return;
			}

		}
		Random rand = new Random();

		ArrayList<Integer> locations = new ArrayList<Integer>();

		for (int i = 0; i < numTargets; i++) {

			int location = rand.nextInt(3 * (WIDTH - 50) / 4) + (WIDTH - 50)
					/ 4 - Pokemon.TARGET_SIZE;
			int height = rand.nextInt(HEIGHT / 2) + 50;

			if (!locations.contains(location)) {
				locations.add(location);
				makeTarget(location, height, i);
			}
		}
	}

	// makes target at desired location with desired size
	public void makeTarget(int location, int size, int i) {
		targets.add(new Pokemon(location, size, pokemon.get(i)));
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
						totalHitCount++;
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

		// System.out.println("totalHitCount: " + totalHitCount);
		if ((isGameOver == 1 || !unHit)) {
			if (totalHitCount == 0) {
				JOptionPane.showMessageDialog(this, "YOU LOSE");
				generateTargets(8);
				// System.out.println("Targets ArrayList Size: " +
				// targets.size());
				// System.out.println("totalHitCount: " + totalHitCount);
				// System.out.println("Game State: " + isGameOver);
			} else if (totalHitCount == 1) {
				JOptionPane.showMessageDialog(this, "RANK: POKEMON N00B. YOU HAVE TO PRACTICE MORE!");
				generateTargets(8);
			} else if (totalHitCount == 2) {
				JOptionPane.showMessageDialog(this, "RANK: POKEMON TRAINER");
				generateTargets(8);
			} else if (totalHitCount == 3) {
				JOptionPane.showMessageDialog(this, "RANK: POKEMON BREEDER");
				generateTargets(8);
			} else if (totalHitCount == 4) {
				JOptionPane.showMessageDialog(this, "RANK: POKEMON GYM LEADER");
				generateTargets(8);
			} else if (totalHitCount == 5) {
				JOptionPane.showMessageDialog(this, "RANK: POKEMON PROFESSOR");
				generateTargets(8);
			} else if (totalHitCount == 6) {
				JOptionPane.showMessageDialog(this, "RANK: POKEMON ELITE");
				generateTargets(8);
			} else if (totalHitCount == 7) {
				JOptionPane.showMessageDialog(this, "RANK: POKEMON CHAMP");
				generateTargets(8);
				// System.out.println("Game State: " + isGameOver);
			} else if (totalHitCount == 8 && !targets.isEmpty()) {
				// System.out.println("Game State: " + isGameOver);
				isMaster = true;
				JOptionPane.showMessageDialog(this, "CONGRATULATIONS! YOU ARE THE POKEMON MASTER");
				generateTargets(8);
				changeGameState();
				changeGameState();
			}
			totalHitCount = 0;
			changeGameState();
		}

	}

	// isGameOver == 0 means game is not over
	// isGameOver == 1 means game is over
	// isGameOver == 2 means game is running
	public void changeGameState() {
		if (isGameOver == 2) {
			isGameOver = 1;
		} else if (isGameOver == 1) {
			isGameOver = 0;
		} else if (isGameOver == 0) {
			isGameOver = 2;
		}
	}

	public int getChangeGameState() {
		return isGameOver;
	}

	// not exactly elegant but it seems the best way to get the projectile into
	// the world
	public void launch() {
		Pokeball temp = launcher.launch();
		if (temp != null) {
			projectiles.add(temp);
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

	public Launcher getLauncher() {
		return launcher;
	}

	public ArrayList<Pokemon> getTargets() {
		return targets;
	}

	public Vector<Pokeball> getProjectiles() {
		return projectiles;
	}

	public void addProjectile(Pokeball p) {
		projectiles.add(p);
	}

	public void clearTargets() {
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
