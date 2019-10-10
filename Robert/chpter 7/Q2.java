/*package whatever //do not write package name here */
/*
1. list all permutation
2. Time complaxity O(n!) Space Complaxity o(3n)
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) {
		String input = "abcd";
		StringBuilder builder = new StringBuilder();
		boolean[] used = new boolean[input.length()];
		appendPermutation(input, builder, used);
	}


	private static void appendPermutation(String input, StringBuilder builder, boolean[] used) {
		if (builder.length() == input.length()) {
			System.out.println(builder.toString());
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			if (used[i]) {
				continue;
			}

			builder.append(input.charAt(i));
			used[i] = true;
			appendPermutation(input, builder, used);
			used[i] = false;
			builder.setLength(builder.length() - 1);
		}
	}
}