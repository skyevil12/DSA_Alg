/*package whatever //do not write package name here */
/*
Convert int to String

1. append input mod 10 every loop
2. add char 0 int value convert to char
3. input / 10 every loop.

*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) {
		int input = 5678;
		String output = convertToString(input);
		System.out.println(output);
	}

	private static String convertToString(int input) {

		boolean isMinus = input < 0;
		StringBuilder outputBuilder = new StringBuilder();

		do {
			int mod = input % 10;
			outputBuilder.insert(0, (char) (mod + '0'));
			input = input / 10;

		} while (input > 0);

		if (isMinus) outputBuilder.insert(0, '-');
		return outputBuilder.toString();
	}
}