package exercises;

import static org.junit.Assert.assertEquals;

public class Exercises {

	public static int ex6_1_iterative(int[] sumPos) {
		int positiveSum = 0;

		for (int i = 0; i < sumPos.length; i++) {
			if (sumPos[i] >= 0) {
				positiveSum += sumPos[i];
			}
		}
		return positiveSum;
	}

	public static int ex6_1_recursive(int[] sumPos, int index) {
		// Base Case
		if (sumPos.length == index) {
			return 0;
		} else if (sumPos[index] >= 0) {
			return sumPos[index] + ex6_1_recursive(sumPos, index + 1);
		} else {
			return ex6_1_recursive(sumPos, index + 1);
		}

	}

	public static boolean ex6_2_iterative(String[] findParity) {
		boolean oddParity = false; // odd number of ones
		int ones = 0;

		for (int i = 0; i < findParity.length; i++) {
			if (findParity[i] == "1") {
				ones++;
			}
		}

		if (ones % 2 != 0) {
			oddParity = true;
		}

		return oddParity;
	}
	
	public static boolean ex6_2_iterative(String[] findParity, int index) {
		boolean oddParity = false;
		int ones = 0;
		
		if(findParity.equals("1")) {
			ones++;
			return ones + ex6_2_iterative(findParity, index+1);
		}
	}

	public static int ex6_3_iterative(int[] countTarget, int target) {
		int count = 0;
		for (int i = 0; i < countTarget.length; i++) {
			if (countTarget[i] == target) {
				count++;
			}
		}
		return count;
	}

	public static int ex6_3_recursive(int[] countTarget, int target, int index) {
		int count = 0;
		// Base Case
		if (countTarget.length == index) {
			return 0;
		} else if (countTarget[index] == target) {
			count++;
			return count + ex6_3_recursive(countTarget, target, index + 1);
		} else {
			return count + ex6_3_recursive(countTarget, target, index + 1);
		}
	}
}
