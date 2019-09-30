/*package whatever //do not write package name here */
//UTF 8, 16

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
	    int[] ansi = new int['z' - 'a' + 1];
	    char[] inCharArray = in.toCharArray();
	    for(char ch : inCharArray) {
	        ansi[ch - 'a'] ++;
	    }
	    
	    for(char ch : inCharArray) {
	        if(1 == ansi[ch - 'a']) {
	            System.out.println("" + ch);
	            return;
	        }
	    }
	    
	    System.out.println("" + -1);
	}
}