// Java program to remove 
// a particular character 
// from a string. 
class GFG 
{
    //TIME O(N) 
    //SPACE O(N)
static void removeChar(String s, char c) 
{ 
	char[] charArray = s.toCharArray();
	char[] rtArray = new char[s.length()];
	int i = 0;
	for(char ch : charArray) {
	    if(ch == c) {
	        continue;
	    }
	    rtArray[i++] = ch;
	}
	
	for(char ch : rtArray) {
	    //If ch is null
	    if (ch == 0) {
	        break;
	    }
	    System.out.print(ch);
	}
} 

// Driver Code 
public static void main(String[] args) 
{ 
	String s = "geeksforgeeks"; 
	removeChar(s, 'g'); 
} 
} 

// This code is contributed 
// by ChitraNayal 

