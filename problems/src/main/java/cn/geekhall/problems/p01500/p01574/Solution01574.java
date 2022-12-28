package cn.geekhall.problems.p01500.p01574;

/**
 * ID:    01574
 * Title: Shortest Subarray to be Removed to Make Array Sorted
 * Difficulty: Medium
 * Description: Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
 *
 * Return the length of the shortest subarray to remove.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 * Example 1:
 *
 * Input: arr = [1,2,3,10,4,2,3,5] Output: 3 Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted. Another correct solution is to remove the subarray [3,10,4].
 *
 * Example 2:
 *
 * Input: arr = [5,4,3,2,1] Output: 4 Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].
 *
 * Example 3:
 *
 * Input: arr = [1,2,3] Output: 0 Explanation: The array is already non-decreasing. We do not need to remove any elements.
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10 5
 * 0 <= arr[i] <= 10 9
 */
class Solution01574 {

  public int findLengthOfShortestSubarray(int[] arr) {
    int n = arr.length;
    int result = n - 1;
    int i = 0;
    while (i < n - 1 && arr[i] <= arr[i + 1]) {
      i++;
    }
    if (i == n - 1) {
      return 0;
    }
    result = Math.min(result, n - i - 1);
    int j = n - 1;
    while (j > 0 && arr[j - 1] <= arr[j]) {
      j--;
    }
    result = Math.min(result, j);
    int k = 0;
    while (k <= i) {
      int idx = binarySearch(arr, j, n - 1, arr[k]);
      if (idx != -1) {
        result = Math.min(result, idx - k - 1);
      }
      k++;
    }
    return result;
  }

  private int binarySearch(int[] arr, int j, int i, int k) {
    while (j <= i) {
      int mid = (j + i) / 2;
      if (arr[mid] >= k) {
        i = mid - 1;
      } else {
        j = mid + 1;
      }
    }
    return j;
  }

  public static void test_01574() {
    Solution01574 solution = new Solution01574();
    int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
    int result = solution.findLengthOfShortestSubarray(arr);
    System.out.println(result);
    int[] arr2 = {5, 4, 3, 2, 1};
    result = solution.findLengthOfShortestSubarray(arr2);
    System.out.println(result);
    int[] arr3 = {1, 2, 3};
    result = solution.findLengthOfShortestSubarray(arr3);
    System.out.println(result);

  }

  public static void main(String[] args) {
    Solution01574.test_01574();
  }
}

