
public class Stack<T> {
	
	private LinkedList<T> linkedList;
	/**
	 * LIFO data structure
	 */
	public Stack() {
		this.linkedList = new LinkedList<T>();
	}
	
	/**
	 * Pushes node to the end of the list (Last in)
	 * @param node the node being added
	 */
	public void push(T node) {
		this.linkedList.add(node);
	}
	/**
	 * This pops the first element (First out)
	 * @return the node being removed
	 */
	public T pop() {
		return this.linkedList.deleteNodeAtIndex(this.linkedList.getSize() - 1);
	}
	
	/**
	 * Returns the size
	 * @return size of the stack
	 */
	public int size() {
		return this.linkedList.getSize();
	}
	
	/**
	 * Method to see the first element in the stack
	 * @return the first element 
	 */
	public T peek() {
		return this.linkedList.getElement(this.linkedList.getSize() - 1);
	}
	
	/**
	 * Method to see if the stack is empty
	 * @return true or false depending on size
	 */
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<>();
		s.push(10);
		s.push(20);
		s.push(30);
		System.out.println(s.peek());
		System.out.println(s.size());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		
	}
}
