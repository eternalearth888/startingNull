/*
 * Throttle example based off section 2.1 in DSOOJava book
 * Author: Maria Deslis
 * 
 */


public class Throttle {

	//the topmost position of the lever
	private int top;
	//the current position of the lever
	private int position;
	
	//constructor for the Throttle
	//PARAMETERS: size - the number of on positions for this new Throttle
	//PRECONDITION: size > 0
	//POSTCONDITION: This Throttle has been initialized with the specified number of on positions above the shut off point, and it is currently shut off
	public Throttle(int size){
		//error check, making sure that you can't go below off
		if(size <= 0)
			throw new IllegalArgumentExcepton("Size <=0: " + size);
		//sets top according to parameter
		top = size;
		//No assignment needed for position - it gets the default value of zero (off)
	}
	
	//accessor method
	public double getFlow() {
		//get the current flow of this Throttle
		//returns the current flow rate as a proportion of the maximum flow
			//example, throttle is on position 4 so the flow rate is 4/6
		
		return (double) position / (double) top;
	}
}