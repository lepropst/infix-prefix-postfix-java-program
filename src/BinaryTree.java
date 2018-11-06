import java.util.Iterator;

public interface BinaryTree<E>{
	//returns the position of p's left child (or null if none exists)
	E left(E p) throws IllegalArgumentException;
	//returns position of p's right child (or null if none)
	E right(E p) throws IllegalArgumentException;
	//returns position of p's sibling(or null if no sibling exists)
//	E sibling(TreeNode<E> p) throws IllegalArgumentException;
	
	//positoin interface
	E getElement() throws IllegalArgumentException;
	/*
	 * Tree interface componenets
	 */
	E root();
	
	E parent(E p) throws IllegalArgumentException;
	
	
	int numChildren(E p) throws IllegalArgumentException;
	boolean isInternal(E p) throws IllegalArgumentException;
//	boolean isExternal(TreeNode<E> p) throws IllegalArgumentException;
	boolean isRoot(E p) throws IllegalArgumentException;
	int size();
	boolean isEmpty();


}
