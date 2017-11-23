import java.util.*;

class PEI_Exercise_2 {
	public static void main(String... args) {
		genPrecomputedReverse();
		//assert swapBits(73, 1, 6) == 11;
		//assert swapBits_B(73, 1, 6) == 11;
		long testNumLong = new Random().nextLong();
		assert reverseBits(testNumLong, 63) == reverseBits_B(testNumLong);
	}
	
	private static long swapBits(long num, int first, int second) {
		long firstMul = (1 << first);
		long secondMul = (1 << second);
	
		//!!Suppose i and j must be in num range
		long rtFirst = (0 != (num & firstMul) ? 1 : 0);
		long rtSecond = (0 != (num & secondMul) ? 1: 0);
		
		if(rtFirst == rtSecond) {
			// No need change
			return num;
		}
		
		return (num & (~(firstMul + secondMul))) | 
		(long)(rtSecond * firstMul) |
		(long)(rtFirst * secondMul);
	}
	
	private static long swapBits_B(long num, int firstIndex, int secondIndex) {
		if(((num >>> firstIndex) & 1) != ((num >>> secondIndex) & 1)) {
			num ^= (1L << firstIndex | 1L << secondIndex);
		}
		
		return num;
	}
	
	//不可以用xor, toggle和Reverse不同 Ex: 100011
	// ReverseBit 不同於ReverseInteger!!
	// Brute Force
	private static long reverseBits(long num, int size) {
		for(int i = 0, j = size; i < j ; i++, j--) {
			num = swapBits_B(num, i, j);
		}
		
		return num;
	}
	
	static long[] preComputedReverse = new long[1 << 16];
	static final long MASK = 0xFFFF;
	
	private static void genPrecomputedReverse() {
		for(int i = 0; i < (1 << 16); i++) {
			preComputedReverse[i] = reverseBits(i, 15);
		}
	}
	
	//Precomputed reverse
	private static long reverseBits_B(long num) {
		return preComputedReverse[(int)(num & MASK)] << (16 * 3) |
		       preComputedReverse[(int)((num >> 16) & MASK)] << (16 * 2) |
			   preComputedReverse[(int)((num >> 32) & MASK)] << 16 |
			   preComputedReverse[(int)((num >> 48) & MASK)];
	}
}