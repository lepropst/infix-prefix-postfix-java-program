import java.util.Scanner;
import java.util.StringTokenizer;

public class Project3 {

	public static void main(String[] args) {
		new Project3();

	}
	
	public Project3() {
//		find input
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			String line = scanner.nextLine();
/*
 *  for each line
 *  	create a translator instance which:
 *  		outputs postfix, prefix, and graphical binary tree
 *  		closes itself
 */
			new NotationTranslator(line);
		}
		scanner.close();
	}
	//determines if prefix, postfix, or infix
	
}
