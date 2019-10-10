/*package whatever //do not write package name here */

/*
1. Binary Search for index of target integer
2. Time Complexity O(logN), Space Complaxity O(n);
*/

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String[] args) {
		int[] inputArray = new int[] {1,3,5,7,9,11,13,15,17,10,21,23,25};
		int target = 11;
		int index = findValueIndex(inputArray,11,0,inputArray.length-1);
		System.out.println(index);
		target =23;
		index = findValueIndex2(inputArray,target);
		System.out.println(index);
	}

	private static int findValueIndex(int[] sortedArray,int target,int start,int end) {
		int center = start+ (end-start)/2;

		if(sortedArray[center] == target) {
			return center;

		} else if(sortedArray[center]>target) {
			return findValueIndex(sortedArray,target,start,center -1);

		} else {
			return findValueIndex(sortedArray,target,center+1,end);
		}

	}

	private static int findValueIndex2(int[] sortedArray,int target) {
		int center;
		int start = 0;
		int end = sortedArray.length-1;

		while(true) {
			center = start+(end-start)/2;

			if(sortedArray[center] == target) {
				break;

			} else if(sortedArray[center]>target) {
				end = center -1;

			} else {
				start = center +1;
			}
		}

		return center;

	}

}