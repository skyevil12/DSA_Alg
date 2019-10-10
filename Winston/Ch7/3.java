import java.util.*;
public class GFG {
    public static void main(String[] args){
        //Todo:Support repitition char case
        for(String str : combination("123")) {
            System.out.println(str);
        }
    }
    
    public static String[] combination(String test) {
        List<String> rtList = new ArrayList();
        int len = 0;
        rtList.add(test);
        for(int j = 1; j < test.length(); j++) {
        //int j = 1;
        for(int i = 0; i < test.length(); i++) {
                if(i + j <= test.length()) {
                    rtList.add(test.substring(i, i + j));
                } else {
                    rtList.add(test.substring(i) +
            test.substring(0, (i + j) % test.length()));
                }
            
        }
        }
        
        String[] rtArray = new String[rtList.size()];
        int i = 0;
        for(String str : rtList) {
            rtArray[i++] = str;
        }
        
        return rtArray;
    }
}
