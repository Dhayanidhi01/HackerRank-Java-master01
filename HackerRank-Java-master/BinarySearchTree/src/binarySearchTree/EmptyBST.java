package binarySearchTree;

public class EmptyBST<inputType extends Comparable<inputType>> implements Tree<inputType> {
	
	/* Constructor for the class */
	public EmptyBST() {
		/* Nothing to do here */
	}

	@Override
	public boolean isEmpty() {
		/* Tree is empty, return true */
		return true;
	}

	@Override
	public int cardinality() {
		/* Tree is empty, return 0 elements */
		return 0;
	}

	@Override
	public boolean member(inputType element) {
		/* No elements in tree; so element couldn't be in the tree, return false */
		return false;
	}

	@Override
	public NonEmptyBST<inputType> add(inputType element) {
		/* Return a non-empty BST with a node element */
		return new NonEmptyBST<inputType>(element);
	}

}
