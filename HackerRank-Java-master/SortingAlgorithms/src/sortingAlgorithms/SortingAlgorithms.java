package sortingAlgorithms;

import java.util.Scanner;

/* Group of Java sorting algorithms for an integer array */
public class SortingAlgorithms {

	/* Scanner for standard input */
	private static Scanner stdIn;

	public static void main(String[] args) {

		/* Declare the integer array for sorting */
		int[] sortArray;

		/* Time variables to compute elapsed time for a sort */
		long timeBefore, timeAfter, timeSum;

		/* Number of times to do performance testing */
		int performanceTestCycles = 1;

		/* Create a new instance of the Scanner to read standard input */
		stdIn = new Scanner(System.in);

		/*
		 * Do you want to enter the numbers to sort, or use a standard data set
		 */
		// System.out.println("Enter the number of numbers to sort, or -1 to use
		// a default data set");
		// int numberSorted = stdIn.nextInt();
		int numberSorted = -1;

		/* if numbers to sort is negative, create a standard data set */
		if (numberSorted < 1) {
			/* Initialize the array to be sorted */
			int[] tmpArray = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
			sortArray = tmpArray;
		} else {
			/* Create a new integer array to hold the numbers to sort */
			sortArray = new int[numberSorted];
			/* Read all the numbers to sort */
			for (int i = 0; i < numberSorted; i++) {
				/* Read the next number into the array */
				sortArray[i] = stdIn.nextInt();
			}
		}

		/* Create a new instance of the bubble sort class, to sort the input */
		BubbleSort bubble = new BubbleSort(sortArray);
		System.out.println("Original Bubble array");
		bubble.printNumbers();
		System.out.println();

		/* Initialize the performance test time sum */
		timeSum = 0;

		/*
		 * Loop for performanceTestCycles measuring the performance of the sort
		 * algorithm
		 */
		for (int test = 0; test < performanceTestCycles; test++) {
			/* Set the sorting array */
			bubble.setSortArray(sortArray);
			/* Store the time before the sort */
			timeBefore = System.nanoTime();
			bubble.sort();
			/* Read the time after the sort */
			timeAfter = System.nanoTime();
			//System.out.println("Test time=" + (timeAfter - timeBefore));
			/* Add the test time to the total performance test time sum */
			timeSum += (timeAfter - timeBefore);
		}

		System.out.println("Bubble Sorted Array");
		bubble.printNumbers();
		System.out.println("Time to complete sort in nanoseconds = " + (timeSum / performanceTestCycles) + "\n");

		/* Create a new instance of the selection sort class */
		SelectionSort selection = new SelectionSort(sortArray);
		System.out.println("Original Selection array");
		selection.printNumbers();
		System.out.println();

		/* Initialize the performance test time sum */
		timeSum = 0;

		/*
		 * Loop for performanceTestCycles measuring the performance of the sort
		 * algorithm
		 */
		for (int test = 0; test < performanceTestCycles; test++) {
			/* Set the sorting array */
			selection.setSortArray(sortArray);
			/* Store the time before the sort */
			timeBefore = System.nanoTime();
			selection.sort();
			/* Read the time after the sort */
			timeAfter = System.nanoTime();
			//System.out.println("Test time=" + (timeBefore - timeAfter));
			/* Add the test time to the total performance test time sum */
			timeSum += (timeAfter - timeBefore);
		}

		System.out.println("Selection Sorted Array");
		selection.printNumbers();
		System.out.println("Time to complete sort in nanoseconds = " + (timeSum / performanceTestCycles) + "\n");

	}

}
