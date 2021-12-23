package genericBinaryTree;

/***************************************************************************/
/* Generic Binary Tree class - this class implements a generic binary tree */
/* Many of the algorithms came from this article on binary trees           */
/*   http://cslibrary.stanford.edu/110/BinaryTrees.html                    */
/* I extended the class to be an generic class, and added many of the      */
/* problems from the article as methods for the class                      */
/***************************************************************************/

public class GenericBinaryTree<inputType extends Comparable<inputType>> {

	/* Root node pointer. Will be null for an empty tree. */
	private Node<inputType> root = null;

	/*
	 * --Node-- The binary tree is built using this nested node class. Each node
	 * stores one data element, and has left and right sub-tree pointer which
	 * may be null. The node is a "dumb" nested class -- we just use it for
	 * storage; it does not have any methods.
	 */
	private static class Node<inputType extends Comparable<inputType>> implements Comparable<Node<inputType>> {
		Node<inputType> left;
		Node<inputType> right;
		inputType data;

		/*
		 * Constructor for the Node Class, initialize the data, and both right
		 * and left pointers null
		 */
		Node(inputType newData) {
			left = null;
			right = null;
			data = newData;
		}

		/* Getters and Setters */
		/* Get the data for the node */
		public inputType getData() {
			/* Return the data for this node */
			return data;
		}

		/* Set the data for this node */
		public void setData(inputType newData) {
			/* Set the data for this node to newData */
			data = newData;
		}

		@Override
		public int compareTo(Node<inputType> that) {
			/* Compare the data for the two nodes and return the comparison */
			return this.getData().compareTo(that.getData());
		}
	}

	/**
	 * Creates an empty binary tree -- a null root pointer.
	 */
	/* Constructor for the GenericBinaryTree class */
	public GenericBinaryTree() {
		/* Start with an empty tree */
		root = null;
	}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public boolean lookup(inputType data) {
		/* Do the lookup recursively, starting at the root */
		return (lookup(root, data));
	}

	/**
	 * Recursive lookup -- given a node, recur down searching for the given
	 * data.
	 */
	private boolean lookup(Node<inputType> node, inputType data) {
		/* If we have reached the end of the tree, return false */
		if (node == null) {
			/* No data match on this branch */
			return (false);
		}

		/* Does the data for this node match the search data */
		if (data == node.data) {
			/* Match!! return true */
			return (true);
			/* Is the search data is less than the node data */
		} else if (data.compareTo(node.getData()) < 0) {
			/* Search the left node */
			return (lookup(node.left, data));
		} else {
			/*
			 * The search data is greater than the node data; so search the
			 * right node
			 */
			return (lookup(node.right, data));
		}
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper.
	 */
	public void insert(inputType data) {
		/* Recursively insert data into the tree */
		root = insert(root, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	private Node<inputType> insert(Node<inputType> node, inputType data) {
		/* Is the tree empty? */
		if (node == null) {
			/* Return the new node */
			node = new Node<inputType>(data);
		} else {
			/* Is the new data less than or equal to the current data */
			if (data.compareTo(node.getData()) <= 0) {
				/* Update the left node data, with the inserted node */
				node.left = insert(node.left, data);
			} else {
				/* Update the right node data, with the inserted node */
				node.right = insert(node.right, data);
			}
		}

		/* in any case, return the new pointer to the caller */
		return (node);
	}

	/* Return the number of nodes in the tree */
	public int size() {
		/* Recursively count the size starting from the root */
		return (size(root));
	}

	/* Recursively determine the size of the tree */
	private int size(Node<inputType> node) {
		/* If this tree is empty, return 0 */
		if (node == null) {
			return 0;
		} else {
			/*
			 * Otherwise, add the size of the left node, this node and the right
			 * node
			 */
			return (size(node.left) + 1 + size(node.right));
		}
	}

	/* Return the maximum depth of the tree */
	public int maxDepth() {
		/* Recursively call the maxDepth routine starting from the root */
		return (maxDepth(root));
	}

	/* Recursively determine the max Depth of the tree */
	public int maxDepth(Node<inputType> node) {
		/* Is this branch empty? */
		if (node == null) {
			// System.out.println("maxDepth: empty node ");
			/* Return 0, if empty */
			return 0;
		} else {
			// System.out.println("nodeData: " + node.data + ", maxDepth:
			// maxLeft: " + maxDepth(node.left) +
			// ", maxRight: " + maxDepth(node.right));
			/*
			 * Return the max of the max left and max right depth + 1 for this
			 * node
			 */
			return (Math.max(maxDepth(node.left), maxDepth(node.right)) + 1);
		}
	}

	/* Print the binary tree */
	/*
	 * This is for diagnostic purposes only, and only do trees of depth 0-3,
	 * single characters
	 */
	public void print() {
		/* Print the tree, depending upon depth */
		switch (maxDepth()) {
		case 0:
			System.out.println("The tree is empty");
			break;
		case 1:
			System.out.println(root.getData());
			break;
		case 2:
			System.out.println("  " + root.getData());
			System.out.println(((root.left == null) ? "   " : " / ") + ((root.right == null) ? " " : "\\"));
			System.out.print(((root.left == null) ? " " : root.left.getData()));
			System.out.print("   ");
			System.out.println(((root.right == null) ? "  " : root.right.getData()));
			break;
		case 3:
			System.out.println("   " + root.getData());
			System.out.println(((root.left == null) ? "    " : "  / ") + ((root.right == null) ? " " : "\\"));
			System.out.print(((root.left == null) ? "  " : " " + root.left.getData()));
			System.out.print("   ");
			System.out.println(((root.right == null) ? " " : root.right.getData()));
			System.out.print(((root.left == null) ? "  " : ((root.left.left == null) ? "  " : "/ ")));
			System.out.print(((root.left == null) ? "  " : ((root.left.right == null) ? "  " : "\\ ")));
			System.out.print(((root.right == null) ? "  " : ((root.right.left == null) ? "  " : "/ ")));
			System.out.println(((root.right == null) ? "  " : ((root.right.right == null) ? "  " : "\\ ")));

			System.out.print(
					((root.left == null) ? "  " : ((root.left.left == null) ? " " : root.left.left.getData()) + " "));
			System.out.print(
					((root.left == null) ? "  " : ((root.left.right == null) ? " " : root.left.right.getData()) + " "));
			System.out.print(((root.right == null) ? "  "
					: ((root.right.left == null) ? " " : root.right.left.getData()) + " "));
			System.out.println(
					((root.right == null) ? "  " : ((root.right.right == null) ? " " : root.right.right.getData())));

			break;
		default:
			System.out.println("Invalid depth: " + maxDepth());
			break;
		}
	}

	/**
	 * Returns the min value in a non-empty binary search tree. Uses a helper
	 * method that iterates to the left to find the min value.
	 */
	public inputType minValue() {
		/* Are we calculating the min value of an empty tree? */
		if (root == null) {
			throw new NullPointerException("Can't compute min value of an empty binary tree");
		}
		return (minValue(root));
	}

	/**
	 * Finds the min value in a non-empty binary search tree.
	 */
	private inputType minValue(Node<inputType> node) {
		/* Are we at the last node? */
		if (node.left == null) {
			/* The current data is the minimum */
			return node.data;
		} else {
			/* Return the min Value from the left node */
			return minValue(node.left);
		}

	}

	/**
	 * Returns the max value in a non-empty binary search tree. Uses a helper
	 * method that iterates to the right to find the max value.
	 */
	public inputType maxValue() {
		/* Are we calculating the max value of an empty tree? */
		if (root == null) {
			throw new NullPointerException("Can't compute max value of an empty binary tree");
		}
		return (maxValue(root));
	}

	/**
	 * Finds the max value in a non-empty binary search tree.
	 */
	private inputType maxValue(Node<inputType> node) {
		/* Are we at the last node? */
		if (node.right == null) {
			/* The current data is the maximum */
			return node.data;
		} else {
			/* Return the max Value from the right node */
			return maxValue(node.right);
		}

	}

	/**
	 * Prints the node values in the "inorder" order. Uses a recursive helper to
	 * do the traversal.
	 */
	public void printTree() {
		/* Recursively print the tree, starting from the root */
		printTree(root);
		/* Go to a new line, after printing the tree in order */
		System.out.println();
	}

	/* Recursively print the tree nodes */
	private void printTree(Node<inputType> node) {
		/* Stop if this is a null node */
		if (node == null)
			return;

		// left, node itself, right
		printTree(node.left);
		System.out.print(node.data + "  ");
		printTree(node.right);
	}

	/**
	 * Prints the node values in the "postorder" order. Uses a recursive helper
	 * to do the traversal.
	 */
	public void printPostorder() {
		/* Recursively print the tree, starting from the root */
		printPostorder(root);
		/* Go to a new line, after printing the tree in reverse order */
		System.out.println();
	}

	public void printPostorder(Node<inputType> node) {
		/* Stop if this is a null node */
		if (node == null)
			return;

		// first recur on both subtrees
		printPostorder(node.left);
		printPostorder(node.right);

		// then deal with the node
		System.out.print(node.data + "  ");
	}

	/*******************************************************/
	/* Changes the tree into its mirror image.____________ */
	/* ___________________________________________________ */
	/* So the tree..._____________________________________ */
	/* ......4............................................ */
	/* ...../.\........................................... */
	/* ....2...5.......................................... */
	/* .../.\............................................. */
	/* ..1...3............................................ */
	/* ___________________________________________________ */
	/* is changed to...___________________________________ */
	/* ......4............................................ */
	/* ...../.\........................................... */
	/* ....5...2.......................................... */
	/* ......./.\......................................... */
	/* ......3...1........................................ */
	/* ................................................... */
	/* Uses a recursive helper that recurs over the tree,. */
	/* swapping the left/right pointers................... */
	/*******************************************************/
	public void mirror() {
		/* Recursively create the mirror (swap right and left nodes) starting at the root */
		mirror(root);
	}

	/* Recursively swap the right and left nodes */
	private void mirror(Node<inputType> node) {
		/* Are we at a non-empty node? */
		if (node != null) {
			/* mirror the sub-trees */
			mirror(node.left);
			mirror(node.right);

			/* swap the left/right pointers for this node */
			Node<inputType> temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

}
