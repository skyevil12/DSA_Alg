//Non recursive
  static boolean binarySearch_(int[] sortedArr, int target) {
    int start = 0, end = sortedArr.length - 1;
    
    while(start <= end) {
      int m = (start + end) / 2;
      if(sortedArr[m] == target) {
        return true;
      } else if(sortedArr[m] > target) {
        end = m - 1;
      } else {
        start = m + 1;
      }
    }
    
    return false;
  }
  
  //Use recursive
  static boolean binarySearch(int[] sortedArr, int target, int i, int j) {
    if(i > j) {
      return false;
    }
    
    int m = (i + j) / 2;

    if(sortedArr[m] > target) {
      return binarySearch(sortedArr, target, i, m - 1);
    } else if(sortedArr[m] < target) {
      return binarySearch(sortedArr, target, m + 1, j);
    } else {
      return true;
    }
  }