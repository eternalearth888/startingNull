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

	public static boolean ex6_2_recursive(String[] findParity, int index, int ones) {
		boolean oddParity = false;

		if (findParity.length == index) {
			if (ones % 2 != 0) {
				oddParity = true;
			}
		} else if (findParity[index] == "1") {
			ones++;
			return ex6_2_recursive(findParity, index + 1, ones);
		} else {
			return ex6_2_recursive(findParity, index + 1, ones);
		}
		return oddParity;
	}
	/*
	 * if x == -0
	 * 	return oddP
	 * if (numOdd)
	 * 	ex(index+1, !oddParity)
	 * else
	 * 	ex(index_1, oddParity)
	 */

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
		int count = 0; // have this start at a parameter that starts at 0

		if (countTarget.length == index) {
			return count;
		} else if (countTarget[index] == target) {
			count++;
			return count + ex6_3_recursive(countTarget, target, index + 1);
		} else {
			return count + ex6_3_recursive(countTarget, target, index + 1);
		}
	}

	// public static void main(String[] args) {
	// String odd[] = { "0", "1", "0"};
	// ex6_2_recursive(odd, 0, 0);
	// }
}
