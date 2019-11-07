/*
 *  multi key data sort
 *  sort by surname then sort by given name alphabetically
 *  1. sort secnd condtion stable first
 *  2. sort first condition
 */

import java.util.LinkedList;
import java.util.Queue;

public class GFG {

	public static void main(String[] args) {

		
        int[] data = createData();
        data = quickSortOptimize(data, 0, data.length - 1);

        for (int value : data) {
            System.out.println(value);
        }
	}
	
	private static int[] createData() {
        int[] data = new int[10];
        data[3] = 78;
        data[0] = 10;
        data[2] = 65;
        data[1] = 53;
        data[5] = 11;
        data[7] = 67;
        data[9] = 32;
        data[4] = 92;
        data[6] = 44;
        data[8] = 81;
        return data;
    }

	private static int[] quickSortOptimize(int[] data, int left, int right) {
		int pivotIndex = (left + right) / 2;
		int pivotValue = data[pivotIndex];

		int i = left;
		int j = right;

		while (i <= j) {

			while (data[i] < pivotValue) i++; //找出比pivotValue大的

			while (data[j] > pivotValue) j--; // 找出比pivotValue小的

			if (i <= j) {
				swap(data, i, j);
				i++;
				j--;
			}
		}

		if (left < j) {
			quickSortOptimize(data, left, j);
		}

		if (right > i) {
			quickSortOptimize(data, i, right);
		}
		
		return data;
	}

	private void swap(int[] data, int from, int to) {
		int temp = data[from];
		data[from] = data[to];
		data[to] = temp;
	}

}

[197463268] left=0;right =8

pivotIndex = (left+right)/2  -> 4
pivotValue = data[pivotIndex]; ->6
i = left ->0 ;j = right -> 8;

while(i< = j) 

	while(data[i]<pivotValue) i++; -> i=1;
	
	while(data[j] > pivotValue) j--; -> j=7;
	
	if(i<j)
		swap(i,j);
		i++; -> i = 2
		j--; -> j = 6
---------------------------------------------		

[167463298]
  ^     ^		
	while(data[i] < pivotValue) i++; -> i= 2;
	
	while(data[j] > pivotValue) j--; -> j = 6; 
	
	if(i<j)
		swap(i,j);
		i++; -> i = 3
		j--; -> j = 5
----------------------------------------------

[162463798]
   ^   ^		
	while(data[i]<pivotValue) i++; -> i= 4;
	
	while(data[j] > pivotValue) j--; -> j = 5; 
	
	if(i<j)
		swap(i,j);
		i++; -> i = 5
		j--; -> j = 4
----------------------------------------------

[162436798]		
     ^^
	 
	if(left < j) -> 0< 4
		quickSort(left,j)  ..... -> [1,2,3,4,6]
	
	if(i < right) -> 5 < 8
		quickSort(i,right) ..... -> [6,7,8,9]
		
		..... -> [1,2,3,4,6,6,7,8,9]