package genericsPractice;

/* Declare the Generics class */
public class Generics implements Comparable {
	
	/* Define a generic findMax function - returns the maximum */
	/* 	of two values, irregardless of type.  This only works */
	/*  on types that contain a compareTo method (are in the */
	/*  Comparable class */
	public static <inputType extends Comparable<inputType>>
			inputType findMax(inputType firstValue, inputType secondValue) {
		/* Is the second Value more than the first? */
		/* compareTo returns -1, if firstValue is less than secondValue */
		/*                    0, if they are equal */
		/*                    1, if firstValue is greater than secondValue */
		if (firstValue.compareTo(secondValue) < 0) {
			/* The second value is greater, return it */
			return secondValue;
		} else {
			return firstValue;
		}
	}
	
	/* Implement a compareTo method for comparing two Generics */
	public int compareTo(Object o) {
		/* Always return 0 as a test */
		return 0;
	}

	/* Start the program here */
	public static void main(String[] args) {
		
		/* Testing generic findMax routine on different data types */
		System.out.println("Generic's Practice");
		System.out.println("Testing a generic findMax routine on different types");
		System.out.println("Max of integers 2 and 3");
		/* Compare two ints in different spots in the findMax input */
		System.out.println(findMax(2, 3));
		System.out.println(findMax(3, 3));
		System.out.println(findMax(3, 2));
		
		/* Compare two doubles */
		System.out.println("Comparing two doubles");
		System.out.println(findMax(2.0, 3.0));
		
		/* Compare two characters */
		System.out.println("Comparing two characters");
		System.out.println(findMax('a', 'z'));
		System.out.println(findMax('a', 'Z'));
		System.out.println(findMax('a', '1'));
		System.out.println(findMax('A', '1'));
		
		/* Compare two strings */
		System.out.println("Comparing two strings");
		System.out.println(findMax("hello", "there"));
		
		/* Compare two booleans */
		System.out.println("Comparing two booleans");
		System.out.println(findMax(true, false));
		
		/* Compare two objects of this class */
		Generics genericInstance = new Generics();
		System.out.println(findMax(genericInstance, genericInstance));
	}

}
