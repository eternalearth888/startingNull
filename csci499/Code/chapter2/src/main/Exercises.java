package main;

public class Exercises {

	public void exercise1(String symbol)
	{
		for (int row = 0; row <= 8; row+=2)
		{
			for (int space = 0; space < (row/2); space++)
			{
				System.out.print(" ");
			}
			for (int hash = 0; hash < (Math.abs(8-row)); hash++)
			{
				System.out.print(symbol);
			}

			System.out.println();
		}
	}

	public void topTriangle(String symbol)
	{
		for (int row = 0; row <= 8; row+=2)
		{
			for (int spaces = 0; spaces < Math.abs(4-(row/2)); spaces++)
			{
				System.out.print(" ");
			}
			for (int hashbottom = 0; hashbottom < (8-Math.abs(8-row)); hashbottom++)
			{
				System.out.print(symbol);
			}
			System.out.println();
		}
	}

	public void exercise2(String symbol)
	{	
		topTriangle("#");
		exercise1("#");
	}

	public void xShape(String symbol, int row)
	{
		for (int hash = 0; hash < (4-Math.abs(4-row)); hash++)
		{
			System.out.print(symbol);
		}
	}

	public void exercise3(String symbol)
	{
		for (int row = 0; row <= 8; row++)
		{
			// LEFT
			for (int spaces = 0; spaces < 4-(Math.abs(4-row)); spaces++)
			{
				System.out.print(" ");
			}

			xShape(symbol,row);

			//RIGHT
			for (int spaces = 0; spaces < (2*Math.abs(8-(row*2))); spaces++)
			{
				System.out.print(" ");
			}

			xShape(symbol,row);
			System.out.println();
		}
	}

	public void exercise4(String symbol)
	{	
		topTriangle("#");
	}

	public static void main(String [] args)
	{
		Exercises e = new Exercises();
		e.exercise1("#");
		System.out.println();
		e.exercise2("#");
		System.out.println();
		e.exercise3("#");
		System.out.println();
		e.exercise4("#");
	}
}
