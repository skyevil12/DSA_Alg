/*
5.1 
Input word is number type?(It would start with Head bit '1')
Only positive?
How about the 64 bit word -> 用BigInteger
*/
import java.math.BigInteger;

class PEI_Exercise_1 {

	public static void main(String... args) {
		long cutTime = System.nanoTime();
		assert (1 == parity("1011"));
		System.out.println("tim is " + (System.nanoTime() - cutTime));
		cutTime = System.nanoTime();
		assert (1 == getNumParity_B("1011"));
		System.out.println("tim is " + (System.nanoTime() - cutTime));
		cutTime = System.nanoTime();
		assert (1 == getNumParity("1011"));
		System.out.println("tim is " + (System.nanoTime() - cutTime));
		
		assert (0 == parity("10001000"));
		//assert (0 == getNumParity("1000100010001000100010001000100010001000100010001000100010001000"));	
	}
	
	private static short getNumParity(String largeNumStr) {
		short rt = 0;
		long largeNum = parseLong(largeNumStr);
		
		while(0 != largeNum) {
			rt ^= (largeNum & 1); //(^ means to mod 2)
			largeNum >>>= 1;			
		}			
		
		return rt;
	}
	
	//Better
	private static short getNumParity_B(String largeNumStr) {
		short rt = 0;
		long largeNum = parseLong(largeNumStr);			

		while(0 != largeNum) {
			System.out.println("-- largeNum is " + largeNum);
			rt ^= 1;		
			largeNum &= (largeNum - 1);	
			System.out.println("++ largeNum is " + largeNum);			
		}			
		
		return rt;
	}
	
	//Best
	private static short parity(String largeNumStr) {
		long largeNum = parseLong(largeNumStr);		
		largeNum ^= largeNum >>> 32;
		largeNum ^= largeNum >>> 16;
		largeNum ^= largeNum >>> 8;
		largeNum ^= largeNum >>> 4;
		largeNum ^= largeNum >>> 2;
		largeNum ^= largeNum >>> 1;
	
		return (short)(largeNum & 0x1);
		//以上用0x1和1的差異是在?
	}

	private static long parseLong(String inputStr) {
		short pow = 0;
		long rtNum = 0;
		char[] inputNumCharArray = inputStr.toCharArray();
		for(int i = inputNumCharArray.length - 1; i >= 0; i--) {	
			rtNum += Math.pow(2, (pow++)) * (inputNumCharArray[i] - '0');
		}
		
		System.out.println("init rtNum is " + rtNum);
		
		return rtNum;
	}
}