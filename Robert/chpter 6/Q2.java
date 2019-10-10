/*package whatever //do not write package name here */

/*
remove specific char from A String.

Time complexity: O(n+m) ,Speace complexity: O(2n+128).

*/


import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		String inputString = "Battle of the Vowels: Hawaii vs. Grozny";
		String removeString ="aeiou";
		removeSpecialChar(inputString,removeString);

	}

	private static void removeSpecialChar(String str, String remove) {
		char[] inputArray = str.toCharArray();
		char[] removeArray = remove.toCharArray();
		char[] outputArray = new char[inputArray.length];

		boolean[] booleanArray = new boolean[128];
		for(int i=0; i<removeArray.length; i++) {
			char removeChar = removeArray[i];
			booleanArray[removeChar] = true;
		}

		int index =0;
		for(int i=0; i<inputArray.length; i++) {
			char inputChar = inputArray[i];
			if(booleanArray[inputChar]) {
				continue;
			}

			outputArray[index++] = inputChar;
		}

		for(int i=0 ; i<index; i++) {
			System.out.print(outputArray[i]);
		}
	}

}