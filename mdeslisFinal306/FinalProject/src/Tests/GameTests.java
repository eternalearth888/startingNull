/* Deslis, Shpurik, Hetrick, Combs
 * Last Updated: 11/27/12
 * 
 */
package Tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import Game.Game;

public class GameTests {
	private Game game;
		
	@Before
	public void setUp() throws Exception {
		game = new Game();
	}

	@Test
	public void incrementScoreTest() {
		//Tests score is incremented when hit
		game.getTarget().setHit(true);
		game.getTarget().incrementScore();
		Assert.assertEquals(42, game.getTarget().getScore());
		
		//Tests score is stagnant when not hit
		game.getTarget().setHit(false);
		game.getTarget().incrementScore();
		Assert.assertEquals(42,  game.getTarget().getScore());	//the score shouldn't change
	}
	
	@Test
	public void validAngleTest() {
		//Tests that a valid angle 
		game.getLauncher().getMissile().pickAngle(75.2);
		Assert.assertEquals(75.2, game.getLauncher().getMissile().getAngle());
		
		//Tests an invalid angle
		game.getLauncher().getMissile().pickAngle(-80.3);
		Assert.assertEquals(0.0, game.getLauncher().getMissile().getAngle());
		
		//Tests a positive invalid angle
		game.getLauncher().getMissile().pickAngle(375.0);
		Assert.assertEquals(0.0, game.getLauncher().getMissile().getAngle());
		
		//Tests that angle was converted to a double
		game.getLauncher().getMissile().pickAngle(60);
		Assert.assertEquals(60.0, game.getLauncher().getMissile().getAngle());
	}
	
	@Test 
	public void velocitiesTest() {
		//tests that missile follows correct path
		game.getLauncher().getMissile().pickAngle(60);
		Point p1 = game.getLauncher().getMissile().getPositionAt(0);
		Point p2 = game.getLauncher().getMissile().getPositionAt(2);
		Point p3 = game.getLauncher().getMissile().getPositionAt(5);
	
		Assert.assertEquals(110.0,  p1.getX());
		Assert.assertEquals(475.0,  p1.getY());
		Assert.assertEquals(135.0,  p2.getX());
		Assert.assertEquals(451.0,  p2.getY());
		Assert.assertEquals(173.0,  p3.getX());
		Assert.assertEquals(489.0,  p3.getY());
		
		//tests that a missile with no velocity doesn't travel (or become negative)
		game.getLauncher().getMissile().pickAngle(60);
		game.getLauncher().getMissile().setVelocity(0);
		Point p4 = game.getLauncher().getMissile().getPositionAt(0);
		Point p5 = game.getLauncher().getMissile().getPositionAt(2);
		Point p6 = game.getLauncher().getMissile().getPositionAt(5);

		Assert.assertEquals(110.0,  p4.getX());
		Assert.assertEquals(475.0,  p4.getY());
		Assert.assertEquals(110.0,  p5.getX());
		Assert.assertEquals(495.0,  p5.getY());
		Assert.assertEquals(110.0,  p6.getX());
		Assert.assertEquals(597.0,  p6.getY());
	}
	
	@Test
	public void randomVelocityTest() {
		//tests a random velocity
		game.getLauncher().getMissile().setVelocity(40);
		double velocity;
		int init = 0;
		int other = 0;
		// Run the test 100 times
		for (int i=0; i<100; i++) {
			game.getLauncher().getMissile().pickRandomVelocity();
			velocity = game.getLauncher().getMissile().getVelocity();
			if (velocity == 40)
				init++;
			else if (velocity != 40) 
				other++;
			else
				fail("Invalid target selected");
		}
		// Ensure we have 100 total selections (fail should also ensure)
		assertEquals(100, init + other);
		// Ensure each target was selected more than once
		assertTrue(other > 40);		//should choose other QUITE often
	}

	@Test
	public void hintTest() {
		//testing that a random hint is returned every time
		/**doesn't matter if a random hint is returned if target hit = true, can
		 * be altered in GUI to not display, and then it would choose a different random hint if wrong */
		// Run the test 1000 times
		int zero = 0, one = 0, two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0;
		
		for (int i=0; i<1000; i++) {
			ArrayList<String> testHits = game.getTarget().getHint().getHints();
			String randomHint = game.getTarget().getHint().pickRandomHint();
			int index = testHits.indexOf(randomHint);
			if (index == 0) {
				zero++;
			} else if (index == 1) {
				one++;
			} else if (index == 2) {
				two++;
			} else if (index == 3) {
				three++;
			} else if (index == 4) {
				four++;
			} else if (index == 5) {
				five++;
			} else if (index == 6) {
				six++;
			} else if (index == 7) {
				seven++;
			} else if (index == 8) {
				eight++;
			} else if (index == 9) {
				nine++;
			} else {
				fail("Invalid index selected");
			}
		
		}
		int sum = zero + one + two + three + four + five + six + seven + eight + nine;
		// Ensure we have 100 total selections (fail should also ensure)
		assertEquals(1000, sum);
		// Ensure each target was selected more than once
		assertTrue(zero > 5);
		assertTrue(one > 5);
		assertTrue(two > 5);
		assertTrue(three > 5);
		assertTrue(four > 5);
		assertTrue(five > 5);
		assertTrue(six > 5);
		assertTrue(seven > 5);
		assertTrue(eight > 5);
		assertTrue(nine > 5);
		
	}
}
