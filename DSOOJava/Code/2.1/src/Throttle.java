/*
 * Throttle example based off section 2.1 in DSOOJava book
 * Author: Maria Deslis
 * 
 */
public class Throttle {
	/* 
	 * First kind of member: Variable Declaration
	 * 	These variables are called instance variables
	 * 
	 * Keyword: private
	 * 	+Means that programmers who use the new class have no way to read or assign values directly to the private instance variables
	 * 	+Possible to have public instance variables accessed directly
	 * 		-BUT public instance vars reveal TOO MUCH information about how a class is implemented, violating the principle of information hiding
	 */
	//the topmost position of the lever
	private int top;
	//the current position of the lever
	private int position;
	
	/* 
	 * Second kind of member: Constructors
	 * 
	 * 
	 */
	//constructor for the Throttle
	//PARAMETERS: size - the number of on positions for this new Throttle
	//PRECONDITION: size > 0
	//POSTCONDITION: This Throttle has been initialized with the specified number of on positions above the shut off point, and it is currently shut off
	public Throttle(int size){
		
	}
}

/*
 * Notes:
 * Keyword: public 
 * 	+Is necessary before class because we want to allow other programmers (the public) to use the new class
 * 
 * Syntax: always use a capital letter for the first character of names of new classes
 * 
 * The rest of the class definition, between the two brackets {} is a list of all the components of the class
 * 	+these components are called members of the class (3 types)
 *			-instance variables
 *			-constructors
 *			-methods
*/