package binarySearchTree;

import java.util.Random;

public class Testers {

	// random integers
	public static int rndInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
		// min = 5, max = 15
		// 15 - 5 = 10 + 1 == 11 --> 0 to 10
		// + 5 to this random number
	}

	// random binary search trees
	public static Tree rndTree(int count) {
		if (count == 0) {
			return new EmptyBST();
		} else {
			return rndTree(count - 1).add(rndInt(0, 50));
		}
	}

	public static void checkIsEmpty(Tree tree) throws Exception {
		/*
		 * If the tree tree is an instance of EmptyBST --> tree.isEmpty -> true
		 */
		/*
		 * If the tree tree is an instance of NonEmptyBST --> tree.isEmpty ->
		 * false
		 */
		if (tree instanceof EmptyBST) {
			// System.out.println("Instance of Empty");
			if (!tree.isEmpty()) {
				throw new Exception("All is not good, the tree is an EmptyBST and it is non-empty");
			}
		} else if (tree instanceof NonEmptyBST) {
			// System.out.println("Instance of NonEmpty");
			if (tree.isEmpty()) {
				throw new Exception("All is not good, the tree is an NonEmptyBST and it is empty");
			}
		}
	}

	public static void checkAddMemberCardinality(Tree t, int x) throws Exception {
		int nT = (t.add(x)).cardinality();
		// 1. Either something was added -> and the cardinality increased by
		// one.
		if (nT == (t.cardinality() + 1)) {
			if (t.member(x)) {
				throw new Exception("The cardinality increased by 1, but the thing"
						+ " that was added was already a member of the tree");
			} //else {
			//	System.out.println("All is good, our cardinality increased and the thing wasn't in the tree");
			//}
		} // 2. OR the thing that was added was already there and therefore not
			// really added
			// so the cardinality stayed the same.
		else if (nT == t.cardinality()) {
			if (!t.member(x)) {
				throw new Exception("The cardinality didn't increased by 1, but" + " we added a new thing");
			} //else {
			//	System.out.println(
			//			"All is good, the thing was in the tree already " + "and our cardinality didn't increase");
			//}
		} else {
			throw new Exception("Something is wrong with our program");
		}

	}

}
