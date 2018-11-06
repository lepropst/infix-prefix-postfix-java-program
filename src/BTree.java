import java.util.ArrayList;
import java.util.Iterator;

public class BTree extends TreeNode<String> implements BinaryTree<String>{
	TreeNode<String> left;
	TreeNode<String> right;
	
	//top of tree
	TreeNode<String> root;
	
	int height =0;
	public void setHeight(TreeNode<String> node) {
		if(node!=null) height++;
		if(node==null) return;
		setHeight(node.left);
	}
	
	public BTree() {
		root = null;
	} 
	public void setRoot(String s) {
		this.root = new TreeNode<String>(s);
	}
	@Override
	public String root() {
//		gets value of root
return root.getElement();
}
	@Override
	//gets parent
	public String parent(String p) throws IllegalArgumentException {

		return sibling(parent);
	}

	@Override
//	gets left
	public String left(String p) throws IllegalArgumentException {
		return sibling(find(p));
	}

	@Override
//	gets right
	public String right(String p) throws IllegalArgumentException {
		return sibling(find(p));
	}

	public String sibling(TreeNode<String> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return p.element;
	}
	public int numChildren(String p) throws IllegalArgumentException {
		return size(find(p));
	}

	@Override
	public boolean isInternal(String p) throws IllegalArgumentException {
		return find(p).left!=null;
	}

	
	public boolean isExternal(TreeNode<String> p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return p.left==null;
	}
	public TreeNode<String> find(String s) {
		return find(root, s);
	}
	private TreeNode<String> find(TreeNode<String> start, String p) {
		if(start==null) return null;
		if(start.getElement()==p) {
			return start;
		} 
		find(start.left, p);
		find(start.right, p);
		return start;
	}
	@Override
	public boolean isRoot(String p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return p == root.getElement();
	}

	@Override
	public int size() {
		return size(root);
	}
	public int size(TreeNode<String> n) {
		if(n==null) {
			return 0;
		} else {
			return(size(n.left) +size(n.right) + 1);
		}
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return root==null;
	}
	

	//gets the bottom leftmost node
	public TreeNode<String> getLeftMost() {
		TreeNode<String> walk;
		walk = root;
		while(walk.left!=null) {
			walk = walk.left;
		}
		return walk;
	}	
	public TreeNode<String> add(TreeNode<String> parent, TreeNode<String> l, TreeNode<String> r, String p) {
		if(isEmpty()) {
			setRoot(p);
			return root;
		} else {
			return new TreeNode<String>(parent, l, r, p);
		}
	}
	/* Compute the "maxDepth" of a tree -- the number of  
    nodes along the longest path from the root node  
    down to the farthest leaf node.*/
 int maxDepth(TreeNode<String> node)  
 { 
     if (node == null) 
         return 0; 
     else 
     { 
         /* compute the depth of each subtree */
         int lDepth = maxDepth(node.left); 
         int rDepth = maxDepth(node.right); 

         /* use the larger one */
         if (lDepth > rDepth) 
             return (lDepth + 1); 
          else 
             return (rDepth + 1); 
     } 
 }
 void printKDistant(TreeNode<String> node, int k)  
 { 
     if (node == null) 
         return; 
     if (k == 0)  
     { 
         System.out.print(node.element + " "); 
         return; 
     }  
     else 
     { 
         printKDistant(node.left, k - 1); 
         printKDistant(node.right, k - 1); 
     } 
 } 
	
}
