package exercises;

public class variableLength {

	// Fields
	public String original;
	public int position;
	public char[] originalArray;
	public int numChars;
	public char[] deleteArray;
	public String second;
	public String conApp;


	// Default Constructor
	public variableLength() {}

	// CharacterAt Constructor
	public variableLength(String original, int position) {
		original = this.original;
		position = this.position;
	}

	// ConcatenateAppend constructor
	public variableLength(String original, String second) {
		original = this.original;
		second = this.second;
	}


	// ConcatenateAppend strings together
	public String concatenateAppend(String original, String second) {
		conApp = original + second;

		return conApp;
	}


	// The the string into a characterArray for characterAt
	public char[] createArray(String original) {
		originalArray = original.toCharArray();

		return originalArray;
	}

	// Error check to make sure the position is not out of bounds
	public char characterAt(char[] originalArray, int position) throws RuntimeException {
		// If the position of out of bounds, throwRuntimeException
		if (position > originalArray.length || position < 0) {
			throw new RuntimeException();
		}

		return originalArray[position];
	}

	// Remove the character at position
	public char[] removeChar(char[] originalArray, int position, int numChars) {
		numChars = this.numChars;
		deleteArray = new char[originalArray.length-numChars];
		
		
		for (int i = 0; i < originalArray.length; i++) {
			if (i != position) 
			{
				deleteArray[i] = originalArray[i];
			}
			else
			{
				for (int j = i; j < originalArray.length; j++) {
					for (int k = 0; k < numChars; k++) {
						i++;
					}
				}
				
			}
		}
		return deleteArray;
	}
}
