/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalCount = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < totalCount; i++) {
		    reverseString(scanner.nextLine());
		}
	}
	
	private static void reverseString(String in) {
	    String[] inStrArray = in.split("\\.");
	    Stack stack = new Stack();
	    for(String str : inStrArray) {
	        stack.push(str);
	    }

	    while(!stack.isEmpty()) {
	        System.out.print(stack.pop());
	        if(!stack.isEmpty()) {
	            System.out.print(".");    
	        }
	    }
	    
	    System.out.println("");
	}
}
