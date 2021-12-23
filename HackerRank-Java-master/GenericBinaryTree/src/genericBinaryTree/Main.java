package genericBinaryTree;

public class Main {
	/***************************/
	/* Build a 123 binary tree */
	/* .......2............... */
	/* ....../.\.............. */
	/* .....1...3............. */
	/***************************/
	public static void build123() {

		/* Create a new binary tree */
		GenericBinaryTree<Integer> tree123 = new GenericBinaryTree<Integer>();
		/* Add the nodes 2, followed by 1, followed by 3 */
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		tree123.print();
		tree123.insert(4);
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		System.out.println("Min value is: " + tree123.minValue());
		System.out.println("Max value is: " + tree123.maxValue());
		System.out.print("Print tree in order: ");
		tree123.printTree();
		System.out.print("Print tree in post order: ");
		tree123.printPostorder();
		tree123.print();
		tree123.insert(2);
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		System.out.println("Min value is: " + tree123.minValue());
		System.out.println("Max value is: " + tree123.maxValue());
		System.out.print("Print tree in order: ");
		tree123.printTree();
		System.out.print("Print tree in post order: ");
		tree123.printPostorder();
		tree123.print();
		tree123.insert(5);
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		System.out.println("Min value is: " + tree123.minValue());
		System.out.println("Max value is: " + tree123.maxValue());
		System.out.print("Print tree in order: ");
		tree123.printTree();
		System.out.print("Print tree in post order: ");
		tree123.printPostorder();
		tree123.print();
		tree123.insert(1);
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		System.out.println("Min value is: " + tree123.minValue());
		System.out.println("Max value is: " + tree123.maxValue());
		System.out.print("Print tree in order: ");
		tree123.printTree();
		System.out.print("Print tree in post order: ");
		tree123.printPostorder();
		tree123.print();
		tree123.insert(3);
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		System.out.println("Min value is: " + tree123.minValue());
		System.out.println("Max value is: " + tree123.maxValue());
		System.out.print("Print tree in order: ");
		tree123.printTree();
		System.out.print("Print tree in post order: ");
		tree123.printPostorder();
		tree123.print();
		
		System.out.println("Mirror the tree");
		tree123.mirror();
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		System.out.println("Min value is: " + tree123.minValue());
		System.out.println("Max value is: " + tree123.maxValue());
		System.out.print("Print tree in order: ");
		tree123.printTree();
		System.out.print("Print tree in post order: ");
		tree123.printPostorder();
		tree123.print();
		tree123.mirror();
		System.out.println("This size of the tree is: " + tree123.size());
		System.out.println("Max depth is: " + tree123.maxDepth());
		System.out.println("Min value is: " + tree123.minValue());
		System.out.println("Max value is: " + tree123.maxValue());
		System.out.print("Print tree in order: ");
		tree123.printTree();
		System.out.print("Print tree in post order: ");
		tree123.printPostorder();
		tree123.print();
	}

	/* Start the program here */
	public static void main(String[] args) {
		/* Solve the binary tree problems using a generic binary tree */
		System.out.println("****************************");
		System.out.println("* Generic Binary Tree test *");
		System.out.println("****************************");

		/* Test building a 1 2 3 binary tree */
		System.out.println("*****************************");
		System.out.println("* Build a   2   Binary Tree *");
		System.out.println("*          / \\              *");
		System.out.println("*         1   3             *");
		System.out.println("*****************************");
		build123();

	}

}
