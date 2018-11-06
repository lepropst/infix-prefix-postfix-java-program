import java.util.ArrayList;
import java.util.LinkedList;

public class NotationTranslator extends BTree {
	String value, prefix, postfix;
	
	BTree tree;
	public NotationTranslator(String stream) {
		prefix = "";
		postfix = "";
		tree = new BTree();
		inputType(stream);
//		tree.printPostFix(root);
	}
	private void inputType(String input) {
		
		String first = input.substring(0, 1);
		switch(first) {
		case "!": 
				prefix(tree.root,input.substring(2));
//				print notations
				printNotation();
				//make a new graphic tree
				new GraphicTree(tree.root);
				break;
		case "@": 	
//					construct tree
					String reverse = new StringBuilder(input.substring(2)).reverse().toString();

					postfix(tree.root, reverse);
//					print notations
					printNotation();
					new GraphicTree(tree.root);
					break;
		}
		

	}
	//	constructs a tree given a prefix notation
	TreeNode<String> position = null;
	String first;
	String stream;
	public TreeNode<String> prefix(TreeNode<String> start, String s) {
//		set the first character and then create a string of the rest of the input
		first = s.substring(0, 1);
		stream = s.substring(1);
		//if its an operand, add it and return, this is a base case.
		if(isOperand(first)) {
			start = tree.add(null,null,null,first);
			return start;
		} //else its an operator so we will add it
//		then call recursively the function on the right and left children
//		finally we return after getting returns from both those.
			else	{
			start = tree.add(null, null, null, first);
//			first = stream.substring(1);
			
			start.left = prefix(start.left, stream);
			start.right = prefix(start.right, stream);
			return start;
		}
		
	}

	public TreeNode<String> postfix(TreeNode<String> start, String s) {
		
		/*
		 * reverse the string, take the first character and set 
		 * a string to the rest of the input. recursively call the function
		 * on the right and then left children of the main node
		 * base case: is an operand.
		 */
		first = s.substring(0, 1);
		stream = s.substring(1);
		if(isOperand(first)) {
			start = tree.add(null,null,null,first);
			return start;
		} else {
			start = tree.add(null,null,null, first);
//			first = stream.substring(1);
			start.right = postfix(start.right, stream);
			start.left = postfix(start.left, stream);


			return start;
		}
	}
	
	public void printNotation() {
		printPostfix(tree.root);
		printPrefix(tree.root);
		System.out.println(prefix);
		System.out.println(postfix);

	}
	public void printPrefix(TreeNode<String> walk) {
		if(walk==null) {
			return;
		}
		if(isExternal(walk)) {
			prefix = prefix + walk.getElement();
			return;
		}
		prefix = prefix +walk.getElement();
		printPrefix(walk.left);
		printPrefix(walk.right);
	
	}
	
	public void printPostfix(TreeNode<String> walk) {
		if(walk!= null) {
		
		
		printPostfix(walk.left);
		printPostfix(walk.right);

		postfix = postfix + walk.getElement();
		}
	}
	
	boolean isOperand(String s) {
		return s.toLowerCase().trim().matches("[a-z]");
	}	
}