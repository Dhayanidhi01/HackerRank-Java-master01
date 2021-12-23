package runTimePractice;

import java.util.HashMap;

public class RunTimePractice {
	
	/* O(length of string) efficiency function */
	/* Linear time O(n) */
	public static int findNumsOfRepetitions(String s, char c) {
		int sum = 0;
		for (int i=0; i< s.length(); i++) {
			if (s.charAt(i) == c) {
				sum++;
			}
		}
		return sum;
	
	}
	
	/* O(length of string * chars in c) */
	/* Quadratic time: O(n*m) */
	public static int[] findNumsOfRepetionsV1(String s, char[] c) {
		int[] sums = new int[c.length];
		for (int i=0; i<s.length(); i++) {
			for (int j=0; j< c.length; j++) {
				if (s.charAt(i) == c[j]) {
					sums[j] += 1;
				}
			}
		}
		return sums;
	}
	
	/* O(length of string + length of c) */
	/* O(n+m) */
	public static int[] findNumsOfRepetitionsV2(String s, char[] c) {
		int[] sums = new int[c.length];
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i=0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),  1);
			} else {
				int sum = map.get(s.charAt(i));
				map.put(s.charAt(i), sum+1);
			}
		}
		
		for (int j=0; j < c.length; j++) {
			if (!map.containsKey(c[j])) {
				sums[j] = 0;
			} else {
				sums[j] = map.get(c[j]);
			}
		}
		return sums;
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(findNumsOfRepetitions("abca", 'a'));
		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;
		System.out.println("Test " + duration + "ms");
		
		char[] a = {'a', 'b', 'c', 'A', 'B', 'a', 'b', 'c', 'A', 'B','a', 'b', 'c', 'A', 'B','a', 'b', 'c', 'A', 'B','a', 'b', 'c', 'A', 'B'};
		int[] sums;

		startTime = System.currentTimeMillis();
		sums = findNumsOfRepetionsV1("abcalksdflksdlkjsdflkjsdlksdlkjsflkjsdflkjsdflkjsdflkjsdflkjsdflkjsdflkjsdlkfjlksjdflkjdsflkjsdlkfjlkjsdflkjsdlkj", a);
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("Test " + duration + "ms");
		
		startTime = System.currentTimeMillis();
		sums = findNumsOfRepetitionsV2("abcalksdflksdlkjsdflkjsdlksdlkjsflkjsdflkjsdflkjsdflkjsdflkjsdflkjsdflkjsdlkfjlksjdflkjdsflkjsdlkfjlkjsdflkjsdlkj", a);
		endTime = System.currentTimeMillis();
		duration = endTime - startTime;
		System.out.println("Test " + duration + "ms");
	}

}
