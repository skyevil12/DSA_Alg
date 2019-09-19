{
import java.util.Scanner;
class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			GfG g = new GfG();
			System.out.println(g.atoi(str));
		t--;
		}
	}
}
}
/*This is a function problem.You only need to complete the function given below*/
/*You are required to complete this method */
//TIME O(N) SPACE O(N)
class GfG
{
    int atoi(String str)
    {
	    int rt = -1;
	    char[] charArray = str.toCharArray();
	    
	    //Check if number(+, -, 0-9)
	    if(!('+' == charArray[0]
	       || '-' == charArray[0]
	       || (charArray[0] >= '0' && charArray[0] <= '9'))) {
	        return rt;       
	    }
	    
        for(int i = 1; i < charArray.length; i++) {
            if(charArray[i] > '9' || charArray[i] < '0') {
                return rt;
            }
        }
        
	    //Check if negative
	    rt = 1;
	    int index = 0;
	    if('-' == charArray[index]) {
	        rt *= -1;
	        index++;
	    }
	    
	    int sum = 0;
	    for(int i = index; i < charArray.length; i++) {
	        sum += (charArray[i] - '0') * Math.pow(10, (charArray.length - 1 - i));
	    }
	    
	    rt *= sum;
	    return rt;
    }
}