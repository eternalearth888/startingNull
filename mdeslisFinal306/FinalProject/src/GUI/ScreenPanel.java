/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 12/3/12
 * 
 */

package GUI;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Game.Game;
import Game.Launcher;
import Game.Missile;
import Game.Scenery;
import Game.Target;


public class ScreenPanel extends JPanel {
	public Missile missile;
	public Launcher launcher;
	public Target target;
	public Scenery scenery;
	
	public ScreenPanel(Game ourGame) {
		missile = ourGame.getLauncher().getMissile();
		launcher = ourGame.getLauncher();
		target = ourGame.getTarget();
		scenery = ourGame.getScenery();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		//call draw functions
		scenery.draw(g2);
		launcher.draw(g2);
		target.draw(g2);	
		missile.draw(g2);
		repaint();	
	}

}
