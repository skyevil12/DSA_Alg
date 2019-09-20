import java.util.Scanner;

class GFG
{
    //Time O(NLogN) Space inplace
    private static void arraySum(int[] input, int target) {
        for(int i : input) {
            if(binarySearch(input, target - i)) {
                System.out.println("1");
                 return;
            }
        }

        System.out.println("0");
    }

    //Input must be sorted
    private static boolean binarySearch(int[] input, int target) {
        if(target < 0) {
            return false;
        }

        int start = 0;
        int end = input.length - 1;

        while(start <= end) {
            int m = (start + end) / 2;
            if(target > input[m]) {
                start = m + 1;
            } else if(target < input[m]) {
                end = m - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    // Driver Code 
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        int arrayCount = Integer.parseInt(scanner.nextLine());

        int[] input = new int[arrayCount];
        for(int i = 0; i < arrayCount; i++) {
            input[i] = Integer.parseInt(scanner.nextLine());
        }

        arraySum(input, target);
    }
} 

