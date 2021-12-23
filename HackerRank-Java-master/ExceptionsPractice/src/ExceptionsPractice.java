
public class ExceptionsPractice {

	public static void main(String[] args) {

		try {
			int[] intArray = new int[6];
			System.out.println("Element 6 at index 5 = " + intArray[6]);
		} catch (ArrayIndexOutOfBoundsException exceptionAIOOBE) {
			System.out.println("Exception thrown: " + exceptionAIOOBE);
		} finally {
			System.out.println("Finally Clause executed");
		}
		System.out.println("Do something after try-Catch");

	}

}
