package sortingAlgorithms;

/*
 * Bubble sort, also referred to as sinking sort, is a simple sorting algorithm that works by repeatedly
 * stepping through the list to be sorted, comparing each pair of adjacent items and swapping them if
 * they are in the wrong order. The pass through the list is repeated until no swaps are needed, which
 * indicates that the list is sorted. The algorithm gets its name from the way smaller elements "bubble"
 * to the top of the list. Because it only uses comparisons to operate on elements, it is a comparison
 * sort. Although the algorithm is simple, most of the other sorting algorithms are more efficient for
 * large lists.
 * 
 * Bubble sort has worst-case and average complexity both O(n2), where n is the number of items being
 * sorted. There exist many sorting algorithms with substantially better worst-case or average
 * complexity of O(n log n). Even other O(n2) sorting algorithms, such as insertion sort, tend to
 * have better performance than bubble sort. Therefore, bubble sort is not a practical sorting algorithm
 * when n is large.  Performance of bubble sort over an already-sorted list (best-case) is O(n). -
 * See more at: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/#sthash.F1tMqv6C.dpuf
 * 
 */

/* Perform a bubble sort on an array of integers */
public class BubbleSort {

	/* Define a global debug level variable */
	/* debug = 0, normal mode, no debug output */
	/* debug = 1, print out intermediate results */
	/* debug = 2, print out detailed intermediate results */
	public static int debug = 0;

	/* Array to be sorted */
	public int[] sortArray;

	/* Constructor for the bubble sort */
	BubbleSort(int[] sortArrayIn) {
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

	/* Do a bubble sort on the sortArray */
	public void sort() {
		/* Store the array length */
		int arrayLength = this.sortArray.length;
		/* Next Index in the array to test/swap */
		int nextIndex;
		if (debug > 0) {
			System.out.println("Intermediate results");
		}
		/*
		 * Scan the array from the end to the beginning searching/swapping out
		 * of order Index
		 */
		for (int maxIndex = arrayLength; maxIndex >= 0; maxIndex--) {
			if (debug > 1) {
				System.out.println("maxIndex=" + maxIndex);
			}
			/* Have we done a swap in this pass */
			boolean swapThisPass = false;
			/*
			 * Scan the array from the beginning to the maxIndex needing
			 * swapping out of order elements
			 */
			/*
			 * Note, with each pass, the maximum value will bubble to the top;
			 * so we don't need to sort that value again
			 */
			for (int index = 0; index < maxIndex - 1; index++) {
				/* nextIndex is the index after index */
				nextIndex = index + 1;
				/* If the elements are out of order, swap them */
				if (this.sortArray[index] > this.sortArray[nextIndex]) {
					/* Swap the index, and nextIndex values in the sortArray */
					swapNumbers(index, nextIndex);
					/*
					 * We have done at least one swap this pass; so keep
					 * testing, until no swaps in a pass
					 */
					swapThisPass = true;
				}
				if (debug > 1) {
					System.out.print("maxIndex=" + maxIndex + ", index=" + index + ", array=");
					printNumbers();
				}
			}
			/*
			 * If we scanned the entire array, with no swaps, then it is sorted,
			 * and we can stop
			 */
			if (!swapThisPass) {
				/*
				 * The array is sorted, break out of this loop, so no more
				 * passes
				 */
				break;
			}
			if (debug > 0) {
				printNumbers();
			}
		}
		if (debug > 0) {
			System.out.println();
		}
	}

}
