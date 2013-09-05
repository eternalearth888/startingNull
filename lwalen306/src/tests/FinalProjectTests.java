package tests;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.Assert;
import main.Launcher;
import main.Pokeball;
import main.Target;
import main.World;

import org.junit.BeforeClass;
import org.junit.Test;


public class FinalProjectTests {
	
	//private static World world;
	
	@BeforeClass
	public static void setUp() {

		
	}
	
	@Test
	public void testCreatingProjectiles() {
		World world = new World();
		Launcher launcher = world.getLauncher();
		launcher.setAngle(90);
		launcher.setPower(10);
		world.launch();
		Assert.assertEquals(1, world.getProjectiles().size());
		Assert.assertEquals(10.0, world.getProjectiles().get(0).getyVel());
		Assert.assertEquals(0.0, world.getProjectiles().get(0).getxVel());
		launcher.setAngle(0);
		world.launch();
		Assert.assertEquals(2, world.getProjectiles().size());
		Assert.assertEquals(0.0, world.getProjectiles().get(1).getyVel());
		Assert.assertEquals(10.0, world.getProjectiles().get(1).getxVel());	
	}
	
	@Test
	public void testCollisions() {
		World world = new World();
		//in the middle
		world.getProjectiles().clear();
		
		world.makeTarget(10,10);
		world.addProjectile(new Pokeball(10,10,0,0));
		world.checkCollisions();
		Assert.assertEquals(1, world.getTargets().size());
		Assert.assertTrue(world.getTargets().get(0).isHit());
		
		world.makeTarget(30, 10);
		world.getProjectiles().add(new Pokeball(30,10,0,0));
		world.checkCollisions();
		Assert.assertEquals(2, world.getTargets().size());
		Assert.assertTrue(world.getTargets().get(1).isHit());
		
		world.makeTarget(100, 100);
		world.getProjectiles().add(new Pokeball(-30,10,0,0));
		world.checkCollisions();
		Assert.assertEquals(3, world.getTargets().size());
		Assert.assertFalse(world.getTargets().get(2).isHit());
	}
	
	@Test
	public void testProjectileMovement() {
		World world = new World();
		world.getProjectiles().clear();
		world.getProjectiles().add(new Pokeball(100,100,10,10));
		world.moveProjectiles(1);
		Assert.assertEquals(10.0, world.getProjectiles().get(0).getxVel());
		Assert.assertEquals(110.0, world.getProjectiles().get(0).getxPos());
		Assert.assertEquals(0.0, world.getProjectiles().get(0).getyVel());
		Assert.assertEquals(110.0, world.getProjectiles().get(0).getyPos());		
	}
	
	@Test
	public void testGenerateTargets(){
		World world = new World();
		ArrayList<Target> targets = world.getTargets();
		targets.clear();
		world.generateTargets(200);
		Assert.assertEquals(200, targets.size());
		Collections.sort(targets);
		//Target lastTarget = targets.get(0);
		
		ArrayList<Integer> locations = new ArrayList<Integer>();
		
		for( Target t : world.getTargets() ){
			if( locations.contains(t.getLocation()) ) Assert.fail("Overlap " + t.getLocation());
			locations.add(t.getLocation());
		}
	}
	
	@Test
	public void testSpeedCalc(){
		World world = new World();
		world.getProjectiles().clear();
		world.getProjectiles().add(new Pokeball(50,50,3,4));
		Assert.assertEquals(5.0, world.getProjectiles().get(0).calcSpeed());
		
		world.getProjectiles().clear();
		world.getProjectiles().add(new Pokeball(50,50,12,5));
		Assert.assertEquals(13.0, world.getProjectiles().get(0).calcSpeed());
	}

}
