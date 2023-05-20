package net.geekhour.problems.p01300.p01300;

import java.util.Arrays;

/**
 * ID: 01300
 * Title: Sum of Mutated Array Closest to Target
 * Difficulty: Medium
 * Description: Given an integer array arr and a target value target, return the
 * integer value such that when we change all the integers larger than value in
 * the given array to be equal to value, the sum of the array gets as close as
 * possible (in absolute difference) to target.
 *
 * In case of a tie, return the minimum such integer.
 *
 * Notice that the answer is not neccesarilly a number from arr.
 *
 * Example 1:
 *
 * Input: arr = [4,9,3], target = 10 Output: 3 Explanation: When using 3 arr
 * converts to [3, 3, 3] which sums 9 and that's the optimal answer.
 *
 * Example 2:
 *
 * Input: arr = [2,3,5], target = 10 Output: 5
 *
 * Example 3:
 *
 * Input: arr = [60864,25176,27249,21296,20204], target = 56803 Output: 11361
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10 4
 * 1 <= arr[i], target <= 10 5
 */
class Solution01300 {

  public int findBestValue(int[] arr, int target) {
    int n = arr.length;
    Arrays.sort(arr);
    long diff = Long.MAX_VALUE;
    int val = arr[n - 1];
    int start = target / n;
    for (int i = start; i <= arr[n - 1]; i++) {
      int cur = 0;
      for (int j = 0; j < n; j++) {
        if (arr[j] < i)
          cur += arr[j];
        else
          cur += i;
      }
      if (diff > Math.abs(target - cur)) {
        diff = Math.abs(target - cur);
        val = i;
      } else {
        break;
      }
    }
    return val;
  }

  public static void test_01300() {
    Solution01300 solution = new Solution01300();
    int[] arr = { 4, 9, 3 };
    int target = 10;
    int result = solution.findBestValue(arr, target);
    System.out.println(result);
    int[] arr2 = { 2, 3, 5 };
    target = 10;
    result = solution.findBestValue(arr2, target);
    System.out.println(result);
    int[] arr3 = { 60864, 25176, 27249, 21296, 20204 };
    target = 56803;
    result = solution.findBestValue(arr3, target);
    System.out.println(result);

  }

  public static void main(String[] args) {
    Solution01300.test_01300();
  }
}
