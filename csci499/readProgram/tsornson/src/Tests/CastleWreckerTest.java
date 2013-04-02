package Tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Game.AnglePanel;
import Game.ControlPanel;
import Game.FinalPanel;
import Game.Image;
import Game.Init;
import Game.Projectile;
import Game.Slingshot;

public class CastleWreckerTest {
	
	FinalPanel fp;
	
	@Before 
	public void init() {
		fp = new FinalPanel(new Init());
	}
	
	@Test 
	public void winTest() {
		
		//Test the win condition. All towers must be hit to win
		fp.setHit(false,false,false);
		Assert.assertFalse(fp.checkWin());
		
		fp.setHit(true,false,false);
		Assert.assertFalse(fp.checkWin());
		
		fp.setHit(true,true,true);
		Assert.assertTrue(fp.checkWin());
	}
	
	@Test public void projectileTest() {
		
		//Reset all targets as unhit
		fp.setHit(false,false,false);
		
		//Test the hit functions
		Projectile proj = new Projectile(0,0);
		
		//Hit no targets
		proj.hitTarget(fp);
		Assert.assertTrue(fp.testCondition(false,false,false));
		
		//Hit L target
		fp.setHit(false,false,false);
		proj.setX(700);
		proj.setY(400);
		proj.hitTarget(fp);
		Assert.assertTrue(fp.testCondition(true,false,false));
		
		//Hit M target
		fp.setHit(false,false,false);
		proj.setX(750);
		proj.setY(400);
		proj.hitTarget(fp);
		Assert.assertTrue(fp.testCondition(false,true,false));
		
		//Hit R target
		fp.setHit(false,false,false);
		proj.setX(800);
		proj.setY(400);
		proj.hitTarget(fp);
		Assert.assertTrue(fp.testCondition(false,false,true));
	}
	
	@Test public void SlingTest() {
		//Test calculation of angle
		Slingshot sling = new Slingshot(400);
		
		double ang = sling.calcAngle(300, 500);
		Assert.assertEquals(ang,45.0,1);
		
		ang = sling.calcAngle(300, 400);
		Assert.assertEquals(ang,0.0,1);
		
		//If the input x equals the sling's x coordinate, zero should be reutrned
		ang = sling.calcAngle(400,500);
		Assert.assertEquals(ang,0.0,0);
		
		//Test calculation of power
		double pow = sling.calcPower(397, 404);
		Assert.assertEquals(5,pow,.5);
		
		//If the input x equals the sling's x coordinate, zero should be returned
		pow = sling.calcPower(400,500);
		Assert.assertEquals(pow,0.0,0);
		
	}

	@Test public void ImageTest() {
		// Test to make sure that it can't load a none existent image
		boolean exceptionThrown = false;
		Image img;
		try {
			img = new Image("not_an_image");
		} catch (Exception e) {
			exceptionThrown = true;
		}
		Assert.assertTrue(exceptionThrown);
		
		// Test to make sure that fire.jpg can be loaded
		exceptionThrown = false;
		try {
			img = new Image("fire.jpg"); 
		} catch (Exception e) {
			exceptionThrown = true;
		}
		Assert.assertFalse(exceptionThrown);

		// Test to make sure that cartoon_castle.jpg can be loaded
		exceptionThrown = false;
		try {
			img = new Image("cartoon_castle.jpg"); 
		} catch (Exception e) {
			exceptionThrown = true;
		}

		// Test to make sure slingShot.jpg can be loaded
		exceptionThrown = false;
		try {
			img = new Image("slingShot.jpg"); 
		} catch (Exception e) {
			exceptionThrown = true;
		}
		Assert.assertFalse(exceptionThrown);

		// Test to make sure that sunshine.jpg can be loaded
		exceptionThrown = false;
		try {
			img = new Image("sunshine.jpg"); 
		} catch (Exception e) {
			exceptionThrown = true;
		}
		Assert.assertFalse(exceptionThrown);

	}

	@Test public void GUITest() {
		// test the JFrame initialization
		Init initTest = new Init();
		Assert.assertEquals("Castle Wrecker", initTest.getTitle());
		Assert.assertEquals(550, initTest.getHeight());
		Assert.assertEquals(900, initTest.getWidth());
		Assert.assertTrue(initTest.isVisible());
		
		// test the main panel initialization
		FinalPanel finalTest = new FinalPanel(initTest);
		Assert.assertEquals(initTest, finalTest.getJf());
		
		// test control panel initialization
		ControlPanel controlTest = new ControlPanel(finalTest);
		Assert.assertEquals(finalTest, controlTest.getFPanel());
		Assert.assertEquals("java.awt.GridLayout[hgap=0,vgap=0,rows=0,cols=5]", controlTest.getLayout().toString());
		
		// test angle panel initialization
		AnglePanel angleTest = new AnglePanel(finalTest);
		Assert.assertEquals(finalTest, angleTest.getFPanel());
		Assert.assertEquals("java.awt.GridLayout[hgap=0,vgap=0,rows=0,cols=2]", angleTest.getLayout().toString());
	}
}
