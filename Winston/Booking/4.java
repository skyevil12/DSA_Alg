import java.io.*; 
import java.util.*; 

public class GFG {
    private static void polygonIdentifier(List<List<Integer>> input) {
        int[] rt = new int[3];
        
        for(List<Integer> group : input) {
            if(!isLegalPolygon(group)) {
                rt[2]++;
            } else if(isLegalSquare(group)) {
                rt[0]++;
            } else if(isLegalRectangle(group)) {
                rt[1]++;
            } else {
                rt[2]++;
            }
        }
        
        for(int i : rt) {
            System.out.print(i + " ");
        }
    }
    
    private static boolean isLegalPolygon(List<Integer> array) {
        //Check if each length is > 0
        if(array.size() != 4) {
            return false;
        }
        
        boolean isNegative = array.get(0) < 0;
        for(int i = 1; i < array.size(); i++) {
            if(isNegative != (array.get(i) < 0)) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isLegalSquare(List<Integer> array) {
        //Check if all length the same   
        int edge = array.get(0);
        for(int i = 1; i < array.size(); i ++) {
            if(edge != array.get(i)) {
                return false;
            }
        }
        
        return true;
    }
    
    private static boolean isLegalRectangle(List<Integer> array) {
        //Check if odd or even length is the same
        //Becare the instance compare of Integer object
        return (0 == array.get(0).compareTo(array.get(2))) && (0 == array.get(1).compareTo(array.get(3)));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        while(scanner.hasNextLine()) {
            List<Integer> group = new ArrayList<Integer>();
            String element = scanner.nextLine();
            for(String str : element.split(" ")) {
                group.add(Integer.parseInt(str));
            }
            input.add(group);
        }
     
        polygonIdentifier(input);
    }
}
