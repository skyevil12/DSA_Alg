// Java program to remove 
// a particular character 
// from a string. 
class GFG 
{
    //TIME O(N) 
    //SPACE O(N) -> O(1)??
static void removeChar(String s, char c) 
{ 
	char[] charArray = s.toCharArray();
	int i = 0;
	for(char ch : charArray) {
	    if(ch == c) {
	        continue;
	    }
	    charArray[i++] = ch;
	}
	
	int j = 0;
	for(char ch : charArray) {
	    //If ch is null
	    if (i == j++) {
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

