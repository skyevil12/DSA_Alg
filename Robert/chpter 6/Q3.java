/*package whatever //do not write package name here */
/*
reverse word sequense in any sentence

1. use another array put result.
2. start traverse from last char,util meet a speace,then look back to last speace for get whole word ,
   fill char into result array when look back.
Time Complexity: O(2n) Speace Complexity: O(2n)
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) {
		String inputString = "Battle of the Vowels: Hawaii vs. Grozny";
		reverseSentence(inputString);
	}

	private static void reverseSentence(String input) {
		char[] inputArray = input.toCharArray();
		char[] outputArray = new char[inputArray.length];

		int lastWordPosition = inputArray.length;
		int outputIndex = 0;
		for (int i = inputArray.length - 1; i >= 0; i--) {

			if (i>0 && inputArray[i-1] != ' ' ) {
				continue;
			}

			System.out.println();
			int step = lastWordPosition -i;

			for (int j = 0; j < step; j++) {
				outputArray[outputIndex++] = inputArray[i+j];
			}

			if(i!=0) {
				outputArray[outputIndex++] = inputArray[i-1];
			}
			lastWordPosition = i-1;

		}

		System.out.println();

		for (char c : outputArray) {
			System.out.print(c);
		}
	}


}