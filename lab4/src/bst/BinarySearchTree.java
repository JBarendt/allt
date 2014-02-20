package bst;

public class BinarySearchTree<E extends Comparable<? super E>> {
	BinaryNode<E> root;
    int size;
    
	/**
	 * Constructs an empty binary searchtree.
	 */
	public BinarySearchTree() {
		
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if(root == null){
			root = new BinaryNode<E>(x);
			size += 1;
			return true;
		}
		return add(root, x);
	}
	
	public boolean add(BinaryNode<E> bn, E x){
		if(x.compareTo(bn.element) > 0){
			if(bn.right == null){
				bn.right = new BinaryNode<E>(x);
				size += 1;
				return true;
			} else {
				return add(bn.right, x);
			}
		} else if(x.compareTo(bn.element) < 0){
			if(bn.left == null){
				bn.left = new BinaryNode<E>(x);
				size += 1;
				return true;
			} else {
				return add(bn.left, x);
			}
		}
		return false;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return height(root);
	}
	
	public int height(BinaryNode<E> bn) {
		if(bn != null){
			return 1 + Math.max(height(bn.left), height(bn.left));
		}
		return 0;
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree(){
		if(root == null){
			System.out.println("Empty tree");
		}else{
			printTree(root);
		}
	}
	
	public void printTree(BinaryNode<E> bn) {

		if(bn.left != null){
			printTree(bn.left);
		}
		System.out.print(bn.element + " ");
		
		if(bn.right != null){
			printTree(bn.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		E[] a = (E[]) new Comparable[size];
		root = buildTree(a, 0, toArray(root, a, 0) - 1);

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the array a
	 * starting at a[index].
	 * Returns the index of the last inserted element + 1 (the first empty
	 * position in a).
	 */
	private int toArray(BinaryNode<E> n, E[] a, int index) {
		if(n != null){
			index = toArray(n.left, a, index);
			a[index] = n.element;
			index = toArray(n.right, a, index + 1);
			return index;
		}
		return index;
	}
	
	/*
	 * Builds a complete tree from the elements a[first]..a[last].
	 * Elements in the array a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(E[] a, int first, int last) {
		if(first > last){
			return null;
		}
		int main = (first + last) / 2;
		BinaryNode<E> root = new BinaryNode<E>(a[main]);
		root.left = buildTree(a, first, main -1);
		root.right = buildTree(a, main +1, last);
		
		return root;
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
