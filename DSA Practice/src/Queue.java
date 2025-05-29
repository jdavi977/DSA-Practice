
public class Queue<T> {
	
	private LinkedList<T> linkedList;
	
	/**
	 * FIFO First in First Out
	 */
	public Queue() {
		this.linkedList = new LinkedList<>();
	}
	
	/**
	 * Adds node to the front of the queue
	 * @param node to be added
	 */
	public void enqueue(T node) {
		this.linkedList.add(node);
	}
	
	/**
	 * Removes node at the front of the queue
	 * @return node being removed
	 */
	public T dequeue() {
		if (this.isEmpty()) {
			return null;
		}
		return this.linkedList.deleteNodeAtIndex(0);
	}
	
	/**
	 * Method to get the size of the queue
	 * @return size
	 */
	public int size() {
		return this.linkedList.getSize();
	}
	
	/**
	 * Method to see what node is next in line
	 * @return node
	 */
	public T peek() {
		return this.linkedList.getElement(0);
	}
	/**
	 * Method to see if the Queue is empty
	 * @return true or false based on Queue size
	 */
	public boolean isEmpty() {
		return (this.linkedList.getSize() == 0);
	}
	
	public static void main(String args[]) {
		Queue<Integer> q = new Queue<>();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
}
