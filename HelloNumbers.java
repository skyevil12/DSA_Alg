public class HelloNumbers {
    public static void main(String[] args) {
        /*int x = 0, sum = 0;
        while (x < 10) {
            //System.out.print(x + " ");
			sum += x;
			System.out.println(sum);
            x = x + 1;
        }*/
		printStars(10);
    }
	
	private static void printStars(int scale) {
		for(int i = 0; i < scale; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}