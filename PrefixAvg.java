public class PrefixAvg {
	public static void main(String... args) {
		int[] input = {1, 2, 3, 4, 5};
		int sum = 0;
		int[] rt = new int[input.length];
		
		for(int i = 0; i < input.length; i++) {
			sum += input[i];
			rt[i] = sum / (i + 1);
		}

		for(int k: rt) {
			System.out.print(k);
		}

		//System.out.println("---");
	}
}