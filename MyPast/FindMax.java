public class FindMax {
   public static int max(int[] m) {
       return 0;
   }
   public static void main(String[] args) {
      int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};   
	  int max = -1;
	  for(int i = 0; i < numbers.length; i++) {
		if(numbers[i] > max) {
			max = numbers[i];
		}
	  }
	  
	  System.out.println("Max is " + max);
	  
	  //Test
		long myLongVal = 10;
		float i = 1.0f;			
		i = myLongVal;
	  //
   }
}