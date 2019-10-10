/*package whatever //do not write package name here */
/*
1. list all combanations
2. time complaxity O(N^2) Space Compaxity O(2n)
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) {
		String input = "abcd";
		StringBuilder builder = new StringBuilder();
		traverseAllCombine(input, builder, 0 );
	}

	private static void traverseAllCombine(String input, StringBuilder builder, int start) {
		if (start == end) {
			return;
		}

		for (int i = start; i < input.length(); i++) {
			builder.append(input.charAt(i));
			System.out.println(builder.toString());
		}

		builder.setLength(0);
		traverseAllCombine(input, builder, start + 1);
	}

}
