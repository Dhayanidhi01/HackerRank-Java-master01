package sortingAlgorithms;

/*
 * Selection Sort
 * 
 * The selection sort is a combination of searching and sorting. During each pass,
 * the unsorted element with the smallest (or largest) value is moved to its proper
 * position in the array. The number of times the sort passes through the array is
 * one less than the number of items in the array. In the selection sort, the inner
 * loop finds the next smallest (or largest) value and the outer loop places that
 * value into its proper location.
 * 
 * Selection sort is not difficult to analyze compared to other sorting algorithms
 * since none of the loops depend on the data in the array. Selecting the lowest
 * element requires scanning all n elements (this takes n - 1 comparisons) and then
 * swapping it into the first position. Finding the next lowest element requires
 * scanning the remaining n - 1 elements and so on,
 * for (n - 1) + (n - 2) + ... + 2 + 1 = n(n - 1) / 2 ~= O(n2) comparisons. Each
 * of these scans requires one swap for n - 1 elements. -
 * See more at: http://www.java2novice.com/java-sorting-algorithms/selection-sort/#sthash.BBW81wWf.dpuf
 * 
 */

/* Perform a selection sort on an array of integers */
public class SelectionSort {

	/* Define a global debug level variable */
	/* debug = 0, normal mode, no debug output */
	/* debug = 1, print out intermediate results */
	/* debug = 2, print out detailed intermediate results */
	public static int debug = 0;

	/* Array to be sorted */
	public int[] sortArray;

	/* Constructor for the selection sort */
	SelectionSort(int[] sortArrayIn) {
		/* Make a copy of the data to be sorted */
		this.sortArray = new int[sortArrayIn.length];
		for (int i = 0; i < sortArrayIn.length; i++) {
			this.sortArray[i] = sortArrayIn[i];
		}
	}

	/* Getters and Setters */
	/* Get the sort array */
	public int[] getSortArray() {
		return sortArray;
	}

	/* Set a new sort array */
	public void setSortArray(int[] sortArrayIn) {
		/* Make a copy of the data to be sorted */
		for (int i = 0; i < sortArrayIn.length; i++) {
			this.sortArray[i] = sortArrayIn[i];
		}
	}

	/* Swap two numbers in the sorted array */
	public void swapNumbers(int index1, int index2) {

		int temp;

		if (debug > 1) {
			System.out.println("Swapping array[" + index1 + "]=" + sortArray[index1] + " > sortArray[" + index2 + "]="
					+ sortArray[index2]);
		}

		/* Store the first value to be swapped */
		temp = this.sortArray[index1];
		/* Move the second value into the first values location */
		this.sortArray[index1] = this.sortArray[index2];
		/* Put the first value into the second values location */
		this.sortArray[index2] = temp;
	}

	/* Print the numbers in the array */
	public void printNumbers() {

		/* Loop thru the numbers in the array */
		for (int i = 0; i < this.sortArray.length; i++) {
			/* Print out the value at index i of the array */
			System.out.print(this.sortArray[i] + ", ");
		}
		/* Skip to a new line after printing */
		System.out.println();
	}

	/* Do a selection sort on the sortArray */
	public void sort() {
		/* Store the array length */
		int arrayLength = this.sortArray.length;

		if (debug > 0) {
			System.out.println("Intermediate results");
		}

		/*
		 * Scan the array from the beginning to one minus the length, inserting
		 * the smallest number in the lowest spot
		 */
		for (int startIndex = 0; startIndex < arrayLength - 1; startIndex++) {
			/* Assume the smallest index is the starting index */
			int smallerIndex = startIndex;
			/*
			 * Check for lower numbers starting at the startIndex + 1 to the end
			 */
			for (int compareIndex = startIndex + 1; compareIndex < arrayLength; compareIndex++) {
				/* Is the new number smaller */
				if (sortArray[compareIndex] < sortArray[smallerIndex]) {
					/* Save the new smallerIndex */
					smallerIndex = compareIndex;
				}
			}

			/* Has there been a change in the smallest index */
			if (smallerIndex != startIndex) {
				/* If new smaller number, then swap them */
				swapNumbers(startIndex, smallerIndex);
			}
			if (debug > 0) {
				printNumbers();
			}
		}
		if (debug > 0) {
			System.out.println();
		}
		return;

	}
}
