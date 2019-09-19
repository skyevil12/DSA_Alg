//TODO: consider if input is integer MAX or MIN?

import java.io.*; 
import java.util.*; 

public class IntegerToAscii {
 
    private static final int ASCII_VALUE_OF_ZERO = 48;
 
    /**
     * Test conversion of Integer to ASCII value.
     * 
     * @param args
     */
    public static void main(String[] args) {
        int x = -2147483647;
        char[] ascii = itoa(x);
        System.out.println(ascii);
    }
 
	//Time O(N) SPACE O(N)
    /**
     * Convert the given integer number to its ASCII equivalent in a character array.
     * 
     * @param number given integer number
     * @return a character array representing ASCII form of the number
     */
    private static char[] itoa(int num) {
		//new ArrayList<Character>
		//TODO: How about no collection?
		List<Character> rtList = new ArrayList<Character>();
        //Add '-' if negative
		if(num < 0) {
			rtList.add('-');
		}
		
		//Use long here to consider integer max or min case
		long tmp = num;
		if(tmp < 0) {
		    tmp *= -1;
		}
		Stack<Character> stack = new Stack<Character>();
		//% 10 and /10 to get each number to stack
		/*109
		->9
		10
		->0
		1
		->1*/
		while(tmp != 0) {
			stack.push((char)((tmp % 10) + '0'));
			tmp /= 10;
		}
		
		//Pop stack and put each char
		while(!stack.isEmpty()) {
			rtList.add(stack.pop());
		}
		
		//Transfer from List to char[]
		char[] rt = new char[rtList.size()];
		int i = 0;
		for(Character ch: rtList) {
			rt[i++] = ch;
		}
		
		return rt;
    }
 
}
