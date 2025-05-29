
public class SinglyLinkedList<T> {
	private int size;
	private Node<T> head;
	
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	/**
	 * TO DO
	 * @return
	 */
	public int getSize() {
		return this.size;
	}
	
	/**
	 * TO DO
	 * @param index
	 * @return
	 */
	public T getElement(int index) {
		Node<T> node = this.getNodeAtIndex(index);
		return node.getElement();
	}
	
	/**
	 * TO DO
	 * @param index
	 * @param data
	 */
	public void insertAtIndex(int index, T data) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Out of bounds.");
		}
		Node<T> newNode = new Node<>(data);
		if (this.size == 0) { 		// If the list is empty but want to add to head
			this.head = newNode;
		} else if (index == 0) {		// If the list is not empty but want to add to head
			newNode.setNext(this.head);
			this.head = newNode;
		} else {
			Node<T> previous = getNodeAtIndex(index - 1);
			Node<T> current = previous.getNext();
			previous.setNext(newNode);
			newNode.setNext(current);
		}
		size ++;
	}
	
	/**
	 * TO DO
	 * @param index
	 * @return
	 */
	private Node<T> getNodeAtIndex(int index) {
		Node<T> currentNode = this.head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.getNext();
		}
		return currentNode;
	}
	
	/**
	 * TO DO
	 * @param index
	 * @return
	 */
	public T deleteNodeAtIndex(int index) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Out of bounds");
		}
		T result ;
		if (index == 0) {
			result = this.head.getElement();
			this.head = this.head.getNext();
		} else {
			Node<T> previous = this.getNodeAtIndex(index - 1);
			Node<T> current = previous.getNext();
			result = current.getElement();
			previous.setNext(current.getNext());
		}
		size--;
		return result;
	}
	
}
