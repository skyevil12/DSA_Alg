import java.io.*; 
import java.util.*; 

public class GFG {
    private static void deltaEncoding(List<Integer> input) {
        int[] inputArray = new int[input.size()];
        
        inputArray[0] = input.get(0);
        for(int i = 0; i < input.size() - 1; i++) {
            inputArray[i + 1] = input.get(i + 1) - input.get(i);
        }
        
        List<Integer> rt = new ArrayList<Integer>();
        rt.add(inputArray[0]);
        for(int i = 1; i <  inputArray.length; i++) {
            if(inputArray[i] > 127 || inputArray[i] < -127){
                rt.add(-128);
            }
            rt.add(inputArray[i]);
        }
        
        for(int i : rt) {
            System.out.print(Integer.toString(i) + " ");
        }
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> input = new ArrayList<Integer>();
        while(scanner.hasNextInt()) {
            input.add(scanner.nextInt());
        }
        
        deltaEncoding(input);
    }
}
