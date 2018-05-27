
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

	static Integer i = 0;

	static int[] rearrange(int[] elements) {
		// List<int>
		// r=StreamSupport.stream(Spliterators.spliteratorUnknownSize(Arrays.asList(elements).listIterator(),
		// Spliterator.ORDERED), false).sorted((it1,it2)->it.nextIndex());
		i = 0;
		int[] r = IntStream.of(elements).boxed().map((n) -> new SimpleEntry<Integer, Integer>(i++, n))
				.sorted((e1, e2) -> bitCount(e1.getValue()) == bitCount(e2.getValue()) ? e1.getKey() - e2.getKey()
						: bitCount(e2.getValue()) - bitCount(e1.getValue()))
				.map((e) -> e.getValue()).mapToInt(Integer::intValue).toArray();
		return r;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = Integer.parseInt(in.nextLine().trim());
		for (int i = 0; i < t; i++) {
			int n = 0;
			n = Integer.parseInt(in.nextLine().trim());

			int[] a = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			int[] results = rearrange(a);

			System.out.println(Arrays.stream(results).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
		}
		in.close();
	}
}