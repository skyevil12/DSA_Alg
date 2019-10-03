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
		    generalOutputNonrepetitionChar_2(scanner.nextLine());
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
	
	/**
	*1
	 4
	 你我你我他他媽的咧
	*/
	private static void generalOutputNonrepetitionChar_2(String in) {
	    System.out.println(in);
		Map<Integer, Object> charCountMap = new HashMap<Integer, Object>();
		Object onceObj = new Object();
		Object twiceMoreObj = new Object();
		Object obj = null;
		
		for(int i = 0; i < in.length();) {
			int cp = in.codePointAt(i);
			i += Character.charCount(cp);
			
			if(null == charCountMap.get(cp)) {
				charCountMap.put(cp, onceObj);
			} else {
				charCountMap.put(cp, twiceMoreObj);
			}
		}
		
		for(int i = 0; i < in.length();) {
			int cp = in.codePointAt(i);
			i += Character.charCount(cp);
			if(onceObj == charCountMap.get(cp)) {
				System.out.println(new String(Character.toChars(cp)));
				return;
			}
		}
		
		System.out.println("" + -1);
	}
	
	private static void generalOutputNonrepetitionChar(String in) {
		Map<Character, Integer> charCountMap = new HashMap();
		char[] inCharArray = in.toCharArray();
		
		for(char ch : inCharArray) {
			Character element = (Character)ch;
			if(!charCountMap.containsKey(element)) {
				charCountMap.put(element, 1);
			} else {
				charCountMap.put(element, charCountMap.get(element) + 1);
			}
		}
		
		for(char ch : inCharArray) {
			Character element = (Character)ch;
			if(1 == charCountMap.get(element)) {
				System.out.println("" + element);
				return;
			}
		}
		
		System.out.println("" + -1);
	}
}