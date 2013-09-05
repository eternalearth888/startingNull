package exercises;

public class Node<T> implements Comparable<T>{

	// Fields
	public T data;
	public Node<T> next;
	
	// Default Node constructor
	public Node(T newData) {
		data = newData;
	}
	
	// Print the Node
	public String printNode() {
		return " " + data + ",";
	}

	/**
	 * Assume any class we put into a template class implements the Comparable interface
	 * The Comparable interface assumes that whatever you pass into the compareTo method also used compareTo
	 * @arg0 = that.data
	 * @return 0 for equals
	 * @returns -1 this.data is less than that.data
	 * @returns 1 this.data is greater than that.data
	 */
	@Override
	public int compareTo(T arg0) {
		// TODO Auto-generated method stub
		return ((Comparable<T>) this.data).compareTo(arg0); // casting this.data to comparable of object of type T, always assume the parameter I am passing in is comparable
	}
	
}
