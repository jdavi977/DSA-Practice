
public class ArrayBasedLists<T> {
	
	private static final int SIZE = 10; 
	private T arr[];
	private int size;
	
	public ArrayBasedLists() {
		this.arr = (T[]) new Object[SIZE];
		this.size = 0;
	}
	
	/**
	 * Adds more capacity to the array when size is full
	 */
	private void addCapacity() {
		Object temp[] = new Object[this.arr.length + SIZE];
		for (int i = 0; i < this.size; i++) {
			temp[i] = this.arr[i];
		}
		this.arr = (T[]) temp;
	}
	/**
	 * Adds element x to the end of the list
	 * @param x is the element being added
	 */
	public void addElementToEnd(T x) {
//		if (this.arr.length == this.size) {
//			addCapacity();
//		}
//		
//		this.arr[this.size] = x;
//		size++;
		addElementToIndex(this.size, x);
	}
	
	/**
	 * Adds element x to the front of the list
	 * @param x element to be added
	 */
	public void addElementToStart(T x) {
//		if (this.arr.length == this.size) {
//			addCapacity();
//		}
//		for (int i=this.size; i>0; i--) {
//			this.arr[i] = this.arr[i - 1];
//		}
//		this.arr[0] = x;
//		size++;
		addElementToIndex(0, x);
	}
	
	/**
	 * Adds element to the index
	 * @param index the index where the element will be added
	 * @param x element that will be added
	 */
	public void addElementToIndex(int index, T x) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Index out of bounds.");
		}
		
		if (this.arr.length == this.size) {
			addCapacity();
		}
		for (int i=this.size; i>index; i--) {
			this.arr[i] = this.arr[i - 1];
		}
		this.arr[index] = x;
		size++;
	}
	
	/**
	 * Returns the value at index
	 * @param index the index where the value of the element is wanted
	 * @return the value of the element at the index
	 */
	public T getElementAtIndex(int index) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Index out of bounds.");
		}
		return this.arr[index];
	}
	
	/**
	 * Deletes the element at position index
	 * @param index is the position where the element is stored
	 * @return the element being removed
	 */
	public T deleteElementAtIndex(int index) {
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		T result = this.arr[index]; // This is the element being removed
		for (int i = index; i < this.size - 1; i++) { // Starting at the index, we now overwrite to the next element 
			this.arr[i] = this.arr[i + 1];
		}
		this.size--;
		return result;
	}
	
	/**
	 * Shows the elements of the array in string form
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<this.size; i++) {
			sb.append(this.arr[i] + ", ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayBasedLists<Integer> list = new ArrayBasedLists<>();
		for (int i=0; i<11; i++) {
			list.addElementToEnd(i*10);
		}
		System.out.println(list);
		list.addElementToStart(4);
		System.out.println(list);
		int y = list.getElementAtIndex(2);
		System.out.println(y);
		
		ArrayBasedLists<Integer> test = new ArrayBasedLists<>();
		test.addElementToEnd(4);
		test.addElementToEnd(6);
		test.addElementToStart(2);
		test.addElementToStart(5);
		test.addElementToIndex(1, 10);
		System.out.println(test);
	}
}
