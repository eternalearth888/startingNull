/*
 * Throttle example based off section 2.1 in DSOOJava book
 * Author: Maria Deslis
 * 
 */

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
	 * 	A constructor is a method that is responsible for INITIALIZING the instance varibles
	 * 	The primary difference between constructor and other methods is:
	 * 		a constructor has access to the class's instance variables, and is responsible for initializing these variables
	 * 
	 * RULES FOR CONSTRUCTORS:
	 * 	+before any constructor begins its work, ALL instance variables are assinged Java "default values"
	 * 	+if an instance var has a initialization value with its declaration, the initialization value replaces the default values
	 * 			example: int jackie = 42; and the default value is zero, then the zero is replaced by the initialization value of 42
	 * 	+the name of a constructor must be the same as the name of the class (at least for Java)
	 * 	+a constructor is not really a method, and therefore it does not require a return value
	 * 		-DO NOT WRITE VOID OR ANY OTHER RETURN TYPE AT THE FRON OF THE CONSTRUCTOR'S HEAD
	 * 		-the compiler knows that every constructor has no return value
	 * 
	 * If there are several constructors, then each constructor must have a distinct sequence of parameters to distringuish it from
	 * the other constructors
	 * 
	 * NO-ARGUMENT CONSTRUCTORS
	 * 	+Some classes have a constructor with no parameters
	 * 	+a no-arguments constructor does not need any extra information to set the initial values of the instance variables
	 * 	+if you write a class with no constructors at all, then Java automatically provides a no-arguments constructor that 
	 * 		initializes each instance var to its initialization value or to its default value
	 * 
	 */
	
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
}