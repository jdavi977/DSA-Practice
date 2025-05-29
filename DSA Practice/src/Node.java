
public class Node<T> {
	private T element;
	private Node<T> next;
	
	public Node(T element) {
		this.element = element;
		this.next = null;
	}
	
	public Node<T> getNext() {
		return this.next;
	}
	
	public T getElement() {
		return this.element;
	}
	
	public void setNext(Node<T> next) {
		this.next = next;
	}

	
}
