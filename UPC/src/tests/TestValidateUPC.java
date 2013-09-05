//package tests;
//
//import static org.junit.Assert.*;
//import junit.framework.Assert;
//
//import main.GenerateUPC;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import main.ValidateUPC;
//
//public class TestValidateUPC {
//
//	ValidateUPC v;
//
//	private String upc = "10100011010110001001100100011010001101000110101010111001011001101101100100111011001101000100101";
//	private String guards = "101";
//	private String center = "01010";
//	private String digits = "051000012517";
//
//	@Before
//	public void setup() {
//		v = new ValidateUPC();
//	}
//
//	@Test
//	public void testParity() {
//		Assert.assertFalse("0001101", v.checkEnds(upc));
//		Assert.assertFalse("1000100", v.checkEnds(upc));
//	}
//
//	@Test
//	public void testGuards() {
//		Assert.assertFalse(guards, v.checkEnds(upc));
//		Assert.assertFalse(guards, v.checkEnds(upc));
//	}
//
//	@Test
//	public void testCenter() {
//		Assert.assertFalse(center, v.checkCenter(upc));
//	}
//
//	@Test
//	public void testLTR() {
//		Assert.assertEquals("0", v.sevenLeftLTR(upc, 3, 9));
//		Assert.assertEquals("5", v.sevenLeftLTR(upc, 10, 16));
//		Assert.assertEquals("1", v.sevenLeftLTR(upc, 17, 23));
//		Assert.assertEquals("0", v.sevenLeftLTR(upc, 24, 30));
//		Assert.assertEquals("0", v.sevenLeftLTR(upc, 31, 37));
//		Assert.assertEquals("0", v.sevenLeftLTR(upc, 38, 44));
//
//		Assert.assertEquals("0", v.sevenRightLTR(upc, 50, 56));
//		Assert.assertEquals("1", v.sevenRightLTR(upc, 57, 63));
//		Assert.assertEquals("2", v.sevenRightLTR(upc, 64, 70));
//		Assert.assertEquals("5", v.sevenRightLTR(upc, 71, 77));
//		Assert.assertEquals("1", v.sevenRightLTR(upc, 78, 84));
//		Assert.assertEquals("7", v.sevenRightLTR(upc, 85, 91));
//	}
//	
//	@Test
//	public void testRTL() {
//		Assert.assertEquals("7", v.sevenRightRTL(upc, 91, 85));
//		Assert.assertEquals("1", v.sevenRightRTL(upc, 84, 78));
//		Assert.assertEquals("5", v.sevenRightRTL(upc, 77, 71));
//		Assert.assertEquals("2", v.sevenRightRTL(upc, 70, 64));
//		Assert.assertEquals("1", v.sevenRightRTL(upc, 63, 57));
//		Assert.assertEquals("0", v.sevenRightRTL(upc, 56, 50));
//
//		Assert.assertEquals("0", v.sevenLeftRTL(upc, 44, 38));
//		Assert.assertEquals("0", v.sevenLeftRTL(upc, 37, 31));
//		Assert.assertEquals("0", v.sevenLeftRTL(upc, 30, 24));
//		Assert.assertEquals("1", v.sevenLeftRTL(upc, 23, 17));
//		Assert.assertEquals("5", v.sevenLeftRTL(upc, 16, 10));
//		Assert.assertEquals("0", v.sevenLeftRTL(upc, 9, 3));
//	}
//	
//	@Test
//	public void testFinal() {
//		Assert.assertFalse(digits, v.checkUPC(upc));
//		Assert.assertFalse(digits, v.checkUPC(upc));
//	}
//	
//	
//
//
//
//}
