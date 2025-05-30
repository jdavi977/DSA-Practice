
/**
 * TO DO
 * @param <T>
 */
public class TreeNode<T> {
	
	private final T element;
	private TreeNode<T> parentNode;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;

	public TreeNode(T element) {
		this.element = element;
	}
	
	public void setParentNode(TreeNode<T> parent) {
		this.parentNode = parent;
	}
	
	public TreeNode<T> getParentNode() {
		return this.parentNode;
	}
	
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	public TreeNode<T> getLeftChild() {
		return this.leftChild;
	}
	
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public TreeNode<T> getRightChild() {
		return this.rightChild;
	}
	
	public T getElement() {
		return this.element;
	}
	
	public boolean hasParentNode() {
		return !(this.parentNode == null);
	}
	
	public boolean hasLeftChild() {
		return !(this.leftChild == null);
	}
	
	public boolean hasRightChild() {
		return !(this.rightChild == null);
	}
	
	public boolean isLeafNode() {
		return !(this.hasRightChild() || this.hasLeftChild());
	}
	
	public boolean isRootNode() {
		return !(this.hasParentNode());
	}
	
	public int getNumChildren() {
		int num = 0;
		if (this.hasLeftChild()) num++;
		if (this.hasRightChild()) num++;
		return num;
	}
}
