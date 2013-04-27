package main;


public class ValidateUPC {
	public boolean checkEnds(String original) {
		String firstGuard = "";

		for (int i = 0; i < 3; i++)
		{
			firstGuard += original.charAt(i);
		}

		if (firstGuard == "101")
		{
			return true;
		}

		return false;
	}
	public boolean checkCenter(String original) {
		String centerGuard = "";

		for (int k = 45; k < 49; k++) {
			centerGuard += original.charAt(k);
		}

		if (centerGuard == "01010")
		{
			return true;
		}
		return false;
	}

	public boolean checkSum(String original) {
		Direction direction;
		direction = determineDirection(original);

		if (direction == Direction.RIGHT_TO_LEFT) {
			for (int i = 3; i <= 9; i=i+7) {
				if (sevenLeftLTR(original, i, i+6) == "Invalid Code") {
					return false;
				}
			}
		}
		else if (direction == Direction.LEFT_TO_RIGHT) {
			for (int j = 91; j >= 85; j=j-7) {
				if(sevenRightRTL(original, j, j-6) == "Invalid Code")
				{
					return false;
				}
			}
		}
		return true;
	}


	public Direction determineDirection(String original)
	{
		Direction direction;
		Read r = new Read(original);
		direction = r.direction(original);

		return direction;
	}

	public boolean checkUPC(String original) {
		Direction direction;
		direction = determineDirection(original);

		if (direction == Direction.LEFT_TO_RIGHT) {
			for (int i = 3; i <= 44; i=i+7) {				
				if (sevenLeftLTR(original, i, i+6) == "Invalid Code")
				{
					return false;
				}
			}

			for(int i = 50; i <= 91; i=i+7) { 				
				if (sevenRightLTR(original, i, i+6) == "Invalid Code")
				{
					return false;
				}
			}
		} else if (direction == Direction.RIGHT_TO_LEFT) {
			for(int i = 91; i <= 50; i=i-7) {
				if(sevenRightRTL(original, i, i-6) == "Invalid Code")
				{
					return false;
				}
			}

			for(int i = 44; i <= 3; i=i-7) { 
				if (sevenLeftRTL(original, i, i-6) == "Invalid Code")
				{
					return false;
				}
			}
		}
		return true;
	}

	
	// Grabbing seven digits for UPC when reading left to right
	public String sevenLeftLTR(String original, int beginIndex, int endIndex) {
		UPCcode u = new UPCcode();

		String result = "";
		String digit = "";

		for(int i = beginIndex; i <= endIndex; i++) {
			result += original.charAt(i);	
		}

		digit = u.leftLTR(result);
		return digit;
	}

	public String sevenLeftRTL(String original, int beginIndex, int endIndex) {
		UPCcode u = new UPCcode();

		String result = "";
		String digit = "";
		for(int i = beginIndex; i >= endIndex; i--) {
			result += original.charAt(i);	
		}
		digit = u.leftRTL(result);
		return digit;
	}


	// Grabbing seven digits for UPC when reading right to left
	public String sevenRightRTL(String original, int beginIndex, int endIndex) {
		UPCcode u = new UPCcode();

		String result = "";
		String digit = "";
		for(int i = beginIndex; i >= endIndex; i--) {
			result += original.charAt(i);	
		}

		digit = u.rightRTL(result);

		return digit;
	}

	public String sevenRightLTR(String original, int beginIndex, int endIndex) {
		UPCcode u = new UPCcode();

		String result = "";
		String digit = "";

		for(int i = beginIndex; i <= endIndex; i++) {
			result += original.charAt(i);	
		}

		digit = u.rightLTR(result);
		return digit;
	}
}

