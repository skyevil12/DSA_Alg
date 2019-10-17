/*package whatever //do not write package name here */
/*
1. print all combination for phone number
2. implement with recursive method
time complexity O(3^n) ,n for input phone lengh,space complaxity O(2n)
*/

import java.io.*;
import java.util.*;

class GFG {
	public static String[] PHONE_STRING_ARRAY = new String[] {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PRS", "TUV", "WXY"};

	public static void main(String[] args) {
		String input = "4556170";
		printAllPhoneNumberWord(input);
	}

	private static void printAllPhoneNumberWord(String input) {
		StringBuilder builder = new StringBuilder(); // or char[input.length]
        char[] result = new char[input.length()]
		printWordRecursive(input, 0, builder);
	}

	private static void printWordRecursive(String input, int index, StringBuilder builder) {
		if (builder.length() == input.length()) {
			System.out.println(builder.toString());
			return;
		}

		char number = input.charAt(index);
		for (int i = 0; i < 3; i++) {
			char nextChar = getCharKey(number - '0', i);
			builder.append(nextChar);
			printWordRecursive(input, index + 1, builder);
			builder.setLength(builder.length() - 1);
			if (nextChar == number) {  // 1 or 0
				break;
			}
		}
	}

	public static char getCharKey(int telephoneKey, int place) {
		String phoneString = PHONE_STRING_ARRAY[telephoneKey];
		return phoneString.length() <= place ? (char) (telephoneKey + '0') : phoneString.charAt(place);
	}

}