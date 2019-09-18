/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalCnt = Integer.parseInt(scanner.nextLine().trim());
		for(int i = 0; i < totalCnt; i++) {
		    int dummy = Integer.parseInt(scanner.nextLine().trim());
		    outputNonrepetitionChar(scanner.nextLine());
		}
	}
	
	//TIME: O(N) => 2 * O(N)
	//SPACE: O(N) => O(N) + O(1)
	private static void outputNonrepetitionChar(String in) {
	    //Ansi lower case is from 97 - 122
	    int[] ansi = new int[26];
	    char[] inCharArray = in.toCharArray();
	    for(char ch : inCharArray) {
	        ansi[ch - 97] ++;
	    }
	    
	    for(char ch : inCharArray) {
	        if(1 == ansi[ch - 97]) {
	            System.out.println("" + ch);
	            return;
	        }
	    }
	    
	    System.out.println("" + -1);
	}
}