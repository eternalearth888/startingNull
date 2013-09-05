/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */
package Game;

import javax.swing.JFrame;

import GUI.InputPanel;

public class Game {
	private Launcher launcher; 
	private Target target;
	private Scenery scenery;
	private boolean won;	// hit cake 4 times?
	private boolean lost;	// out of health?
	
	public Game() {
		launcher = new Launcher();
		target = new Target();
		scenery = new Scenery();
		won = false;
		lost = false;
	}
	public void reset() {
		launcher.reset();
		target.reset();
		won = false;
		lost = false;
	}
	public void launcherReset() {
		launcher.reset();
	}
	public Scenery getScenery() {
		return scenery;
	}
	public void setScenery(Scenery scenery) {
		this.scenery = scenery;
	}
	public Launcher getLauncher() {
		return launcher;
	}
	public void setLauncher(Launcher launcher) {
		this.launcher = launcher;
	}
	public Target getTarget() {
		return target;
	}
	public void setTarget(Target target) {
		this.target = target;
	}
	public boolean isWon() {
		return won;
	}
	public void setWon(boolean won) {
		this.won = won;
	}
	public boolean isLost() {
		return lost;
	}
	public void setLost(boolean lost) {
		this.lost = lost;
	}
}
