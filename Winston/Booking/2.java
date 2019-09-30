import java.io.*; 
import java.util.*; 

public class GFG {
    
    private static void gatherAnagram(List<String> inputList) {
        List<List<String>> rt = new ArrayList<List<String>>();
        int[][] inputCharMapArray = new int[inputList.size()][128];
        int index = 0;
        for(String str : inputList) {
            inputCharMapArray[index++] = toCharMap(str.toCharArray());
        }
        
        Set<Integer> visitIndexSet = new HashSet<Integer>();
        for(int i = 0; i < inputList.size(); i++) {
            if(visitIndexSet.contains(i)) {
                continue;
            }
            
            List<String> group = new ArrayList<String>();
            group.add(inputList.get(i));
            for(int j = i + 1; j < inputList.size(); j ++) {
                if(isSameStringArray(inputCharMapArray[i], inputCharMapArray[j])) {
                    group.add(inputList.get(j));
                    visitIndexSet.add(j);
                }
            }
            
            //Sort
            Collections.sort(group);
            //
            rt.add(group);
        }
        
        Collections.sort(rt, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return (o1.get(0)).compareTo((o2.get(0)));
            }
        });
        
        //print rt
        for(List<String> group : rt) {
            for(int i = 0; i < group.size(); i++) {
                System.out.print(group.get(i));
                if(i < group.size() - 1) {
                    System.out.print(",");    
                }
            }
            System.out.println("");
        }
    }
    
    
    
    private static int[] toCharMap(char[] charArray) {
        int[] rtCharMap = new int[128];
        
        for(char ch : charArray) {
            rtCharMap[ch]++;
        }
        
        return rtCharMap;
    }
    
    //Suppose these two input are size 128
    private static boolean isSameStringArray(int[] charMapFirst, int[] charMapSecond) {
        for(int i = 0; i < charMapFirst.length; i++) {
            if(i == ' ') {
                continue;
            }
            
            if(charMapFirst[i] != charMapSecond[i]) {
                return false;
            }
        }
        
        return true;
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
