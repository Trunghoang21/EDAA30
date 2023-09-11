package bst;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.runner.notification.StoppedByUserException;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		this.root = null;
		this.size = 0;
		this.comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2) ;
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.root = null;
		this.size = 0;
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {

		return addElement(root, x);
		//return false;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		if(this.root == null){
			return 0;
		}
		return height(this.root);
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		this.root = null;
		this.size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print(root);
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<>();
		toArray(root, sorted);
		for(E c : sorted){
			System.out.println(c);
		}
		this.root = buildTree(sorted, 0, sorted.size() -1);
	}
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n != null){
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if(first > last){
			return null;
		}
		int index = (first + last)/2;
		BinaryNode<E> mid = new BinaryNode<E>(sorted.get(index));
		if(first == (index -1)){
			mid.left =new BinaryNode<E>(sorted.get(index -1));
		}
		else mid.left = buildTree(sorted, first, index -1);
		
		if ((index + 1) == last) mid.right = new BinaryNode<E>(sorted.get(index +1));
		else mid.right = buildTree(sorted, index + 1, last);
		
		return mid;
		
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
			left = right = null;
		}	
	}
	private int height(BinaryNode<E> node){
		//if(node == null){
		//	return 0;
		//}
		
		if((node.left == null)&&(node.right == null)){
			return 1;
		}
		if ((node.left != null)&&(node.right == null)){
			return 1 + height(node.left);
		}
		if ((node.left == null)&&(node.right != null)){
			return 1 + height(node.right);
		}
		else {
			return 1 + Math.max(height(node.left), height(node.right));
		}
		
	}
	private boolean addElement(BinaryNode<E> node,E x){
			if(node == null){
				this.root = new BinaryNode<E>(x);
				size+=1;
				System.out.println("skpad!");
				return true;
			}
			else{
				if (comparator.compare(x, node.element) == 0){
					System.out.println("lika med 0");
					return false;
				}
				if (comparator.compare(x, node.element) > 0 ){
					System.out.println("större än 0");
					if(node.right == null){
						node.right = new BinaryNode<E>(x);
						this.size +=1;
						return true;
					}
					return addElement(node.right, x);
				}
				else{
					System.out.println("mindre än 0");
					if(node.left == null){
						node.left = new BinaryNode<E>(x);
						this.size +=1;
					}
					return addElement(node.left, x);
				}
			}
	//return true;
	}
	private void print(BinaryNode<E>node){
		if (node != null){
			print(node.left);
			System.out.println(node.element);
			print(node.right);
		}
	} 
public static void main(String[] args) {
	BSTVisualizer display = new BSTVisualizer("fönster", 300, 300);
	BinarySearchTree<Integer> tree = new BinarySearchTree<>();
	tree.add(1);
	tree.add(5);
	tree.add(3);
	tree.add(7);
	tree.add(13);
	tree.add(11);
	tree.add(9);
	tree.add(10);
	tree.add(8);
	tree.add(19);
	tree.rebuild();
	display.drawTree(tree);
	//tree.rebuild();
	
}	
}
