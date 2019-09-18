/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int totalCount = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < totalCount; i++) {
		    reverseString(scanner.nextLine());
		}
	}
	
	private static void reverseString(String in) {
	    //back slash in rgx
	    String[] inStrArray = mySplit(in, '.');//in.split("\\.");
	    MyStack stack = new MyStack();
	    for(String str : inStrArray) {
	        stack.push(str);
	    }

	    while(!stack.isEmpty()) {
	        System.out.print(stack.pop());
	        if(!stack.isEmpty()) {
	            System.out.print(".");    
	        }
	    }
	    
	    System.out.println("");
	}
	
	private static String[] mySplit(String in, char ch) {
	    List<String> rtStrList = new ArrayList();
	    int cur = 0;
	    int fIndex = 0;
	    boolean hasTail = false;
	    while(-1 != in.indexOf(ch, cur)) {
	        fIndex = in.indexOf(ch, cur);
	        rtStrList.add(in.substring(cur, fIndex));
	        cur = fIndex + 1;
	    }
	    
	    if(in.length() - 1 > fIndex) {
	        rtStrList.add(in.substring(cur, in.length()));
	    }
	    
	    String[] rtStrArray = new String[rtStrList.size()];
	    int i = 0;
	    for(String str : rtStrList) {
	        rtStrArray[i++] = str;
	    }
	    
	    return rtStrArray;
	}
	
	static class MyStack {
	    private Node mNode = null;
	    
	    private static class Node {
	        Node next;
	        String data;
	        
	        Node(String data) {
	            this.data = data;
	        }
	    }
	    
	    public boolean isEmpty() {
	        return null == mNode;
	    }
	    
	    public void push(String str) {
	        if(null == str) {
	            return;
	        }
	        
	        Node node = new Node(str);
	        if(null == mNode) {
	            mNode = node;
	            mLatest = node;
	        } else {
	            mLatest.next = node;
	            mLatest = mLatest.next;
	        }
	    }
	    
	    private Node mLatest;
	    
	    public String pop() {
	        if(null == mLatest) {
	            return null;
	        }
	        
	        String rt = mLatest.data;
	        if(mLatest == mNode) {
	            mNode = null;
	            mLatest = null;
	            return rt;
	        }
	        
	        Node tmp = mNode;
	        Node prev = tmp;
	        while(true) {
	            prev = tmp;
	            tmp = tmp.next;
	            if(mLatest == tmp) {
	                prev.next = null;
	                mLatest = prev;
	                break;
	            }
	        }
	        
	        return rt;
	    }
	    
	    public String peek() {
	        if(null == mLatest) {
	            return null;
	        }
	        
	        return mLatest.data;
	    }
	}
}
