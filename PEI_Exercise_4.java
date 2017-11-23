class PEI_Exercise_4 {
	public static void main(String... args) {
		System.out.println("Result is " + add(99, 101));
		System.out.println("Multiply Result is " + multiply(100, 99));
		return;
	}
	
	private static long multiply(long x, long y) {
		long sum = 0, k = 1;
		while(0 != x) {
			if( 0 != (x & 1)) {
				sum = add(sum, y);
			}
			x >>>= 1;
			y <<= 1;
		}
		
		return sum;
	}
	
	//Use shift and bitwise to impl. add operation
	private static long add(long a, long b) {	
		long k = 1, ka = 0, kb = 0, tempA = a, tempB = b, carryIn = 0, sum = 0, carryOut = 0;
		
		while(0 != tempA || 0 != tempB) {
			ka = a & k;
			kb = b & k;
			carryOut = (ka & kb) | (ka & carryIn) | (kb & carryIn);
			sum |= (ka ^ kb ^ carryIn);
			k <<= 1;
			carryIn = carryOut << 1;
			tempA >>>= 1;
			tempB >>>= 1;
		}
		
		sum |= carryIn;
		return sum;
	}
}