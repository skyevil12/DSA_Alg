import java.io.*; 
import java.util.*; 

public class GFG {
    
    private static void gatherAnagram(List<String> inputList) {
        List<List<String>> rt = new ArrayList<List<String>>();
        
        Set<Integer> visitedSet = new HashSet<Integer>();
        for(int i = 0; i < inputList.size(); i++) {
            if(visitedSet.contains(i)) {
                continue;
            }
            
            List<String> anagramArray = new ArrayList<String>();
            anagramArray.add(inputList.get(i));
            for(int j = i + 1; j < inputList.size(); j++) {
                if(isAnagram(inputList.get(i), inputList.get(j))) {
                    anagramArray.add(inputList.get(j));
                    visitedSet.add(j);
                }
            }
            
            Collections.sort(anagramArray);
            rt.add(anagramArray);
        }
        
        Collections.sort(rt, new Comparator<List<String>>() {
            public int compare(List<String> first, List<String> second) {
                return (first.get(0)).compareTo(second.get(0));
            }
        });
        
        for(List<String> anagramArray : rt) {
            for(int i = 0; i < anagramArray.size(); i++) {
                System.out.print(anagramArray.get(i));
                
                if(i != anagramArray.size() - 1) {
                    System.out.print(",");
                }
            }
            
            System.out.println("");
        }
    }
    
    private static boolean isAnagram(String first, String second) {
        int val = 0;
        char[] firstArray = removeSpace(first.toCharArray());
        char[] secondArray = removeSpace(second.toCharArray());
        
        if(firstArray.length != secondArray.length) {
            return false;
        }
        
        //Remove space first and get actual length
        for(int i = 0; i < first.length(); i++) {
            val ^= firstArray[i];
            val ^= secondArray[i];
        }
        
        return 0 == val;
    }
    
    private static char[] removeSpace(char[] input) {
        int rtLen = input.length;
        //Find length
        for(char ch : input) {
            if(' ' == ch) {
                rtLen--;
            }
        }
        
        char[] rt = new char[rtLen];
        int index = 0;
        for(char ch : input) {
            if(' ' == ch) {
                continue;
            }
            
            rt[index++] = ch;
        }
        
        return rt;
    }
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputList = new ArrayList<String>();
            
        while(scanner.hasNextLine()) {
            inputList.add(scanner.nextLine());
        }
        
        gatherAnagram(inputList);
    }
}
