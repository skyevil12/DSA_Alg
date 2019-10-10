import java.util.*;

// Java program to print all the permutations 
// of the given string 
public class GFG { 
	public static String[] permutation(String test) {
        String[] rt = null;
        if(1 == test.length()){
            rt = new String[]{test};
            return rt;
        }
        
        List<String> rtList = new ArrayList();
        char[] testCharArray = test.toCharArray();
        for(int i = 0; i < testCharArray.length; i++) {
            for(String str : permutation(test.replaceFirst("" + testCharArray[i], ""))) {
                rtList.add(testCharArray[i] + str);
            }
        }
        
        int i = 0;
        rt = new String[rtList.size()];
        for(String rtStr : rtList){
            rt[i++] = rtStr;
        }
        
        return rt;
    }

	// Driver code 
	public static void main(String[] args) 
	{ 
		String s = "abb"; 
		//printPermutn(s, ""); 
		for(String str : permutation(s)) {
		    System.out.println(str);
		}
	} 
} 
