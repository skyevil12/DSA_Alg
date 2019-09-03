class PEI_Exercise_3 {
	public static void main(String[] args) {
		long cutTime = System.nanoTime();	
		/*System.out.println("Latest number is " + findClosestInteger(0));
		System.out.println("tim is " + (System.nanoTime() - cutTime));
		cutTime = System.nanoTime();
		System.out.println("Better: Latest number is " + findClosestInteger_B(0));
		System.out.println("tim is " + (System.nanoTime() - cutTime));
		cutTime = System.nanoTime();
		System.out.println("Better: Latest number is " + findClosestInteger_B2(0));
		System.out.println("tim is " + (System.nanoTime() - cutTime));*/
		cutTime = System.nanoTime();
		System.out.println("Best: Latest number is " + findClosestInteger_B2(6));
		System.out.println("Best: Latest number is " + findClosestInteger_B2(7));
		System.out.println("Best: Latest number is " + findClosestInteger_B2(2));
		System.out.println("Best: Latest number is " + findClosestInteger_B2(32));
		System.out.println("tim is " + (System.nanoTime() - cutTime));
	}
	
	// Brute force
	// TODO: Consider all 0 or all 1 case
	private static int findClosestInteger(int num) {
		int minusVal = 0, positiveVal = 0;
		int oriWeighht = getNumWeight(num);
		int testNum = num;
		
		do {
			testNum--;
		} while(oriWeighht != getNumWeight(testNum));
		
		minusVal = testNum;
		
		// Reset
		testNum = num;
		do {
			testNum++;				
		} while(oriWeighht != getNumWeight(testNum));
		
		positiveVal = testNum;
		
		return Math.abs(positiveVal - num) > Math.abs(minusVal - num) ? minusVal :  positiveVal;
	}
	
	private static int getNumWeight(int testNum) {
		int rtWeight = 0;
		
		while(0 != testNum) {
			rtWeight++;
			testNum &= testNum - 1;
		}
		
		return rtWeight;
	}
	
	//
	private static int findClosestInteger_B(int num) {
		final int MASK = 3;//bit - 11
		int shiftCnt = 0;
		int tmpNum = num;
		int filterRt = tmpNum & MASK;
		//Cannot expect this must have, consider all 0 or all 1 case, that means shiftCnt is 62
		while((1 != filterRt) && ((2 != filterRt)) && ((0 != filterRt))){
			tmpNum >>= 1;
			filterRt = tmpNum & MASK;
			shiftCnt++;
		}
		
		return num ^= (MASK << shiftCnt);
	}
	
	private static int findClosestInteger_B2(int num) {
		for(int i = 0; i < 62; i++) {
			if(((num >> i) & 1) != ((num >> (i+1)) & 1)) {
				return num ^= (3 << i);
			}
		}
		
		//assert false;, all 0 or all 1 case
		return -1;
	}
	
	private static long findClosestInteger_B3(long num) {
		if(0 == num || Long.MAX_VALUE == num) {
			throw new RuntimeException("All bits are 0 or 1");
		}
	
		long lowestSetBit = num & ~(num - 1);
		long lowestUnsetBit = (num + 1) & ~(num + 1 - 1);
		
		if(lowestUnsetBit == (lowestSetBit >> 1) || lowestUnsetBit == (lowestSetBit << 1)) {
			num ^= (lowestUnsetBit | lowestSetBit);
		} else if(lowestUnsetBit > lowestSetBit) {
			num ^= (((lowestUnsetBit / lowestSetBit) >> 1) | lowestUnsetBit);
		} else if(lowestUnsetBit < lowestSetBit) {
			num ^= (((lowestSetBit / lowestUnsetBit) >> 1) | lowestSetBit);
		}
		
		return num;
	}
}