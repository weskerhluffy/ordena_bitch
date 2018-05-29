
/*package whatever //do not write package name here */

// XXX: https://practice.geeksforgeeks.org/problems/sort-by-set-bit-count/0
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.lang.*;
import java.io.*;

class GFG {
	static Integer bitCount(Integer n) {
		Integer r = 0;
		while (n != 0) {
			n &= ~(n & -n);
			r++;
		}
		return r;
	}

	static int[] rearrange(int[] elements) {
		int[] r = IntStream.of(elements).boxed()
				.sorted((a, b) -> bitCount(a) == bitCount(b) ? a - b : bitCount(a) - bitCount(b))
				.mapToInt(Integer::intValue).toArray();
		return r;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int n = 0;
		n = Integer.parseInt(in.nextLine().trim());
		int[] elements = new int[n];
		int element;
		for (int i = 0; i < n; i++) {
			element = Integer.parseInt(in.nextLine().trim());
			elements[i] = element;
		}

		// call rearrange function
		int[] results = rearrange(elements);

		for (int i = 0; i < results.length; i++) {
			System.out.println(String.valueOf(results[i]));
		}
	}
}