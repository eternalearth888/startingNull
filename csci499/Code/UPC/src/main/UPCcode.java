package main;

public class UPCcode {
	// Digits to UPC Code
	public String[] ltrLeft = {
			"0001101",  /*0*/
			"0011001",	/*1*/ 
			"0010011",	/*2*/
			"0111101",	/*3*/
			"0100011",	/*4*/
			"0110001",	/*5*/
			"0101111",	/*6*/
			"0111011",	/*7*/
			"0110111",	/*8*/
			"0001011"	/*9*/
	};

	public String[] ltrRight = {
			"1110010",	/*0*/
			"1100110",	/*1*/
			"1101100",	/*2*/
			"1000010",	/*3*/
			"1011100",	/*4*/
			"1001110",	/*5*/
			"1010000",	/*6*/
			"1000100",	/*7*/
			"1001000",	/*8*/
			"1110100",	/*9*/
	};

	// UPC code to Digits
	public String leftLTR(String code) {
		String digits = "";

		switch(code) {
		case "0001101":	digits = "0";
		break;
		case "0011001":	digits = "1";
		break;
		case "0010011":	digits = "2";
		break;
		case "0111101": digits = "3";
		break;
		case "0100011":	digits = "4";
		break;
		case "0110001":	digits = "5";
		break;
		case "0101111":	digits = "6";
		break;
		case "0111011":	digits = "7";
		break;
		case "0110111":	digits = "8";
		break;
		case "0001011":	digits = "9";
		break;
		default:	digits = "Invalid Code";
		break;
		}

		return digits;
	}

	public String rightLTR(String code){
		String digit = "";

		switch(code) {
		case "1110010":	digit = "0";
		break;
		case "1100110":	digit = "1";
		break;
		case "1101100":	digit = "2";
		break;
		case "1000010":	digit = "3";
		break;
		case "1011100":	digit = "4";
		break;
		case "1001110":	digit = "5";
		break;
		case "1010000":	digit = "6";
		break;
		case "1000100":	digit = "7";
		break;
		case "1001000":	digit = "8";
		break;
		case "1110100":	digit = "9";
		break;
		default:	digit = "Invalid Code";
		break;
		}

		return digit;
	}
	

	
	// REVERSE
	public String leftRTL(String code) {
		String digits = "";

		switch(code) {
		case "1011000":	digits = "0";
		break;
		case "1001100":	digits = "1";
		break;
		case "1100100":	digits = "2";
		break;
		case "1011110": digits = "3";
		break;
		case "1100010":	digits = "4";
		break;
		case "1000110":	digits = "5";
		break;
		case "1111010":	digits = "6";
		break;
		case "1101110":	digits = "7";
		break;
		case "1110110":	digits = "8";
		break;
		case "1101000":	digits = "9";
		break;
		default:	digits = "Invalid Code";
		break;
		}

		return digits;
	}
	
	public String rightRTL(String code) {
		String digits = "";

		switch(code) {
		case "0100111":	digits = "0";
		break;
		case "0110011":	digits = "1";
		break;
		case "0011011":	digits = "2";
		break;
		case "0100001": digits = "3";
		break;
		case "0011101":	digits = "4";
		break;
		case "0111001":	digits = "5";
		break;
		case "0000101":	digits = "6";
		break;
		case "0010001":	digits = "7";
		break;
		case "0001001":	digits = "8";
		break;
		case "0010111":	digits = "9";
		break;
		default:	digits = "Invalid Code";
		break;
		}

		return digits;
	}
}


