/*package whatever //do not write package name here */
/*
convert string to int

1. check minus sign
2. traverse all char and minus char 0 int value for real int value
3. multiply total value by 10 every loop,and add newest int value.

Time Complexity: O(n) Speace Complexity O(n)
*/

import java.io.*;
import java.util.*;

class GFG {
	
	public static void main(String[] args) {
		String inputString = "-0654321";
		int output = convertToInt(inputString);
		System.out.println(output);
	}

	private static int convertToInt(String input) {
		char[] inputArray = input.toCharArray();
		int total = 0;
		int start = 0;
		if (inputArray[0] == '-') {
			start = 1;
		}

		for (int i = start; i < inputArray.length; i++) {
			total *= 10;
			int number = inputArray[i] - '0';
			total += number;
		}

		if (start > 0) {
			total *= -1;
		}
		return total;
	}


}