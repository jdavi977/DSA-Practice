import java.util.List;

public class BinaryTree<T> {
	
	private TreeNode<T> root;
	
	public BinaryTree(TreeNode<T> root) {
		this.root = root;
	}
	
	/**
	 * Preorder traversal root left right
	 * @return
	 */
	public ArrayBasedLists<T> preorderTraversal() {
		ArrayBasedLists<T> result = new ArrayBasedLists<>();
		Stack<TreeNode<T>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode<T> currentNode = stack.pop();
			//process
			//System.out.println(currentNode);
			result.addElementToEnd(currentNode.getElement());
			//push right child
			if (currentNode.hasRightChild()) {
				stack.push(currentNode.getRightChild());
			}
			//push left child
			if (currentNode.hasLeftChild()) {
				stack.push(currentNode.getLeftChild());
			}
		}
		return result;
	}
	
	/**
	 * Inorder traversal left root right
	 * @return
	 */
	public ArrayBasedLists<T> inorderTraversal() {
		ArrayBasedLists<T> result = new ArrayBasedLists<>();
		Stack<TreeNode<T>> stack = new Stack<>();
		TreeNode<T> u = root;
		
		while (!stack.isEmpty() || u != null) {
			// As long as there is a left node will traverse down it and push the root node to the list
			if (u != null) {
				stack.push(u);
				u = u.getLeftChild();
			} else {
				u = stack.pop();
				result.addElementToEnd(u.getElement());
				u = u.getRightChild();
			}
		}
		return result;
	}
	/**
	 * Postorder traversal left → right → root
	 */
	public ArrayBasedLists<T> postorderTraversal() {
	    ArrayBasedLists<T> result = new ArrayBasedLists<>();
	    if (root == null) return result;

	    Stack<TreeNode<T>> stack = new Stack<>();
	    TreeNode<T> prev = null;          // keeps track of last node we visited
	    stack.push(root);

	    while (!stack.isEmpty()) {
	        TreeNode<T> curr = stack.peek();

	        // are we descending the tree?
	        if (prev == null 
	         || prev.getLeftChild() == curr 
	         || prev.getRightChild() == curr) {

	            // try to go left first
	            if (curr.getLeftChild() != null) {
	                stack.push(curr.getLeftChild());
	            }
	            // if no left, go right
	            else if (curr.getRightChild() != null) {
	                stack.push(curr.getRightChild());
	            }
	            // if leaf, we'll process it in the next else-block
	        }
	        // did we just come up from left?
	        else if (curr.getLeftChild() == prev) {
	            // now go right
	            if (curr.getRightChild() != null) {
	                stack.push(curr.getRightChild());
	            }
	        }
	        // did we just come up from right? then process this node
	        else {
	            stack.pop();
	            result.addElementToEnd(curr.getElement());
	        }

	        prev = curr;
	    }

	    return result;
	}

	
    public static void main(String[] args) {
        // --- 1) Create all nodes ---
        TreeNode<String> a = new TreeNode<>("a");
        TreeNode<String> b = new TreeNode<>("b");
        TreeNode<String> c = new TreeNode<>("c");
        TreeNode<String> d = new TreeNode<>("d");
        TreeNode<String> e = new TreeNode<>("e");
        TreeNode<String> f = new TreeNode<>("f");
        TreeNode<String> g = new TreeNode<>("g");
        TreeNode<String> h = new TreeNode<>("h");
        TreeNode<String> i = new TreeNode<>("i");
        TreeNode<String> j = new TreeNode<>("j");
        TreeNode<String> k = new TreeNode<>("k");
        TreeNode<String> l = new TreeNode<>("l");
        TreeNode<String> m = new TreeNode<>("m");
        TreeNode<String> n = new TreeNode<>("n");
        TreeNode<String> o = new TreeNode<>("o");
        TreeNode<String> p = new TreeNode<>("p");
        TreeNode<String> q = new TreeNode<>("q");
        TreeNode<String> r = new TreeNode<>("r");

        // --- 2) Wire them up exactly as in the picture ---
        a.setLeftChild(b);
        a.setRightChild(c);

        // left subtree of a
        b.setLeftChild(d);
        b.setRightChild(e);

        d.setLeftChild(g);
        d.setRightChild(h);

        g.setLeftChild(l);
        g.setRightChild(m);
        // the little “r” hanging under “m”
        m.setLeftChild(r);

        // “h” only has one child “n”
        h.setRightChild(n);

        // “e” only has one child “i”
        e.setRightChild(i);
        // “i” only has one child “o”
        i.setLeftChild(o);

        // right subtree of a
        c.setRightChild(f);
        f.setLeftChild(j);
        f.setRightChild(k);

        j.setLeftChild(p);
        j.setRightChild(q);

        // --- 3) Build the BinaryTree and traverse! ---
        BinaryTree<String> tree = new BinaryTree<>(a);

        ArrayBasedLists<String> pre  = tree.preorderTraversal();
        ArrayBasedLists<String> in   = tree.inorderTraversal();
        ArrayBasedLists<String> post   = tree.postorderTraversal();


        // Assuming your ArrayBasedLists has a nice toString(), otherwise iterate manually
        System.out.println("Pre-order: " + pre);
        System.out.println("In-order:  " + in);
        System.out.println("Post-order: " + post);

    }
	
}
