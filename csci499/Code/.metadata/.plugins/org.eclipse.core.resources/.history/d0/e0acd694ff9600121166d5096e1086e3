package tests;

import junit.framework.Assert;
import org.junit.*;

import main.GenerateUPC;

public class TestGenerateUPC {
	GenerateUPC g;
	
	private String upc = "10100011010110001001100100011010001101000110101010111001011001101101100100111011001101000100101";
	private String digits = "051000012517";
	
	@Before
	public void setup() {
		g = new GenerateUPC();
	}
	
	@Test
	public void testGenerateUPC() {
		Assert.assertEquals("000110101100010011001000110100011010001101", g.generateUPC(digits, 0, 5));
		Assert.assertEquals("111001011001101101100100111011001101000100", g.generateUPC(digits, 6, 11));
	}
	
	@Test
	public void testCheckSum() {
		 Assert.assertEquals(7, g.createCheckSum(digits));
	}
		
	@Test
	public void testFinalUPC() {	
		Assert.assertEquals(upc, g.finalUPC(digits));
	}
	
}
