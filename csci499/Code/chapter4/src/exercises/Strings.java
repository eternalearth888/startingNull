package exercises;

import tests.TestStrings;



public class Strings {

	public static char[] ex4_2_substring(char[] arr, int position, int length) {
		// create a new array that is length of what length was inputed
		char[] newArr = new char[length];
		
		// starting from position i in the original array
		// starting from the first position in the new array
		// increment the total length from the starting position
		// and copy that value into the new array
		// we do this in one for loop because otherwise we would end up 
		// copying the substring for as many times as position is equal to
		for (int i = position, j = 0; i < (position + length); i++, j++) {
			newArr[j] = arr[i];
		}
		
		return newArr;
	}
	
	public static char[] ex4_3_replaceStr(char[] source, char[] target, char[] replaceText) {

		// turn the arrays into strings
		String newSource = new String(source);
		String newTarget = new String(target);
		String newReplaceText = new String(replaceText);
		
		// using the replace function from the java string library
		// replace the target substring with the replaceText
		String newCharArray= newSource.replace(newTarget, newReplaceText);
		
		// turn the new string into a char array
		char[] newArr = newCharArray.toCharArray();
		
		return newArr;
			
	}
	
	public static boolean isTarget(char[] original, int position, char[] target) {
		// assume that everything is true
		boolean isExist = true;
		
		// starting from the given position for the original array
		// and the beginning index of the target array
		// loop through the two that is equivalent to the length given
		// compare each value
		// if the values match then isExist is still true
		// else it is false
		// we do this in one for loop instead of a nested for loop because then we
		// would end up checking it the same number of times as position
		for (int i = position, j = 0; i < (position + target.length); i++, j++) {
			if (target[j] != original[i]) {
				isExist = false;
			}
		}
		
		return isExist;
	}
	
	public static char ex4_4_charAt(char[] original, int position) throws RuntimeException {
		
		// if the current position of the of the array is the null terminator
		// throw the RuntimeException
		if (original[position] == TestStrings.NULL) {
			throw new RuntimeException();
		}
		
		// otherwise just return the element in the index
		return original[position];
	}
	
	public static char[] ex4_4_concatenate(char[] original, char[] second){
		
		// since two arrays will have two null terminators
		// and we want to combine them to make one array with one null terminator
		// then we need to subtract the new array by 1 else we have one character too many
		char[] conCat = new char[original.length + second.length - 1];
		
		// we are declaring i on the outside so we can hold onto position
		int i;
		// loop through the first array and add each character into the new array
		// not including the null terminator
		for (i = 0; i < original.length - 1; i++) {
			conCat[i] = original[i];
		}
		
		// now starting from position i in the new array 
		// and starting from position j in the second array
		// we will then add all the characters in the second array to the new array
		for (int j = 0; j < second.length - 1; ++i, ++j) {
			conCat[i] = second[j];
		}
		
		return conCat;
	}
	


}

