/*package whatever //do not write package name here */
//Traverse Inorder to get sorted array then output to complete BST

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static class Node {
        private int mData;
        private Node left, right;
        
        public Node(int data) {
            mData = data;
        }
    }
    
	public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        int[] input = new int[end];
        for(int i = 1; i <= end; i++) {
            input[i - 1] = i; 
        }
        
        int mid = (start - 1 + end - 1) / 2;
        Node root = new Node(input[mid]);
        arrayToBST(input, root, start - 1, end - 1);
        inOrder(root);
	}
	
	private static void inOrder(Node root) {
	    if(null == root) {
	        return;
	    }
	    
	    inOrder(root.left);
	    System.out.println(root.mData);
	    inOrder(root.right);
	}

    private static void arrayToBST(int[] input, Node root, int i, int j) {
        if(i > j) {
            return;    
        }
        
        int mid = (i + j)/2;
        if(mid >= 1) {
            root.left = new Node(input[mid - 1]);
            arrayToBST(input, root.left, i, mid - 1);
        }

        if(mid < input.length - 1) {
            root.right = new Node(input[mid + 1]);
            arrayToBST(input, root.right, mid + 1, j);
        }
    }
}