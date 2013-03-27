package main;

public class GenerateUPC {
	public String generateUPC(String original, int beginIndex, int endIndex) {
		UPCcode u = new UPCcode();

		String result = "";
		String temp = "";

		for (int i = beginIndex; i < endIndex + 1; i++) {
			char currCh = original.charAt(i);
			int value = Character.digit(currCh, 10);

			if( beginIndex == 0 || endIndex < 6) {
				temp = u.ltrLeft[value];
				result += temp;
			} else {
				temp = u.ltrRight[value];
				result += temp;
			}
		}

		return result;
	}

	//CHECK SUM
	public int createCheckSum(String original) {
		int totalEven = 0;
		int totalOdd = 0;
		int checkSum = 0;

		//Finding odds and evens in digits
		for(int i = 0; i < original.length()-1; i++) 
		{
			char currCh = original.charAt(i);
			int value = Character.digit(currCh, 10);
			
			if(i % 2 == 0) 
			{
				totalEven += value;
			}
			else 
			{
				totalOdd += value;
			}
		}

		checkSum = (3*totalEven)+totalOdd;
		
		int finalCheck = 10 - (checkSum%10);		
		
		return finalCheck;	
	}

	public String finalUPC(String original) {
		String finalUPC = ""; // Defining result in here because we only need it main
		finalUPC = "101" + generateUPC(original, 0, 5) + "01010" + generateUPC(original, 6, 11) + "101";
		return finalUPC;
	}

}
