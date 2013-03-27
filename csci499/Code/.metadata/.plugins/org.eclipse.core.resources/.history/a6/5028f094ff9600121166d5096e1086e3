package main;

public class Read {
	Direction direction;
	String original;

	public Read (String original) {
		this.original = original;
		direction = Direction.LEFT_TO_RIGHT;
	}

	public Direction direction(String original) {
		int ones = 0;
		int zeros = 0;

		for(int i = 3; i < 9; i++) { 
			if(original.charAt(i) == '1') {
				ones++;
			} 
			else 
			{
				zeros++;
			}
		}

	//	System.out.print("ONES: " + ones + " ZEROS: " + zeros);
		if(ones % 2 == 0) {
			return direction.LEFT_TO_RIGHT;
		} else  {
			return direction.RIGHT_TO_LEFT;
		}
	}
}
