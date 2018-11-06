import java.util.ArrayList;
import java.util.LinkedList;



public class TreeNode<E extends Comparable<?>> {
	//value of node
	E element;
	//left sibling
	TreeNode<E> left;
//	right sibling
	TreeNode<E> right;
//	parent
	TreeNode<E>parent;
	

//	creates an empty node
	public TreeNode() {
		this(null,null,null,null);
	}
//	creates a node with the value designated but no pointers
	public TreeNode(E e) {
		this(null, null, null, e);
	}
	//constructor sets value, adds pointers to left, right, and parent
	public TreeNode(TreeNode<E> p, TreeNode<E> l, TreeNode<E> r, E element) {
		setElement(element);
		setParent(p);
		setLeft(l);
		setRight(r);
	}
	//		get and set element
	private void setElement(E e) {
		this.element=e;
	}

	public E getElement() throws IllegalStateException{
		
		return element;
	}
	//		get and set parent
	public void setParent(TreeNode<E> p) {
		// TODO Auto-generated method stub
		this.parent = p;
	}
	public TreeNode<E> getParent() {
		return parent;
	}
	//		set and get left sibling

	public TreeNode<E> getLeft() {
		return left;
	}
	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	//get right sibling
	public TreeNode<E> getRight() {
		return right;
	}
	//set right sibling
	public void setRight(TreeNode<E> right) {
		this.right = right;
	}

	    
	  
	
}
