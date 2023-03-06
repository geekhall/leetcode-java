package cn.geekhall.problems.p01500.p01539;

import java.util.*;

/**
 * ID: 01539
 * Title: Kth Missing Positive Number
 * Difficulty: Easy
 * Description: Given an array arr of positive integers sorted in a strictly
 * increasing order, and an integer k.
 *
 * Return the k th positive integer that is missing from this array.
 *
 * Example 1:
 *
 * Input: arr = [2,3,4,7,11], k = 5 Output: 9 Explanation: The missing positive
 * integers are [1,5,6,8,9,10,12,13,...]. The 5 th missing positive integer is
 * 9.
 *
 * Example 2:
 *
 * Input: arr = [1,2,3,4], k = 2 Output: 6 Explanation: The missing positive
 * integers are [5,6,7,...]. The 2 nd missing positive integer is 6.
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 *
 * Follow up:
 *
 * Could you solve this problem in less than O(n) complexity?
 */
class Solution01539 {

  public int findKthPositive(int[] arr, int k) {
    int res = 0;
    int n = arr.length;
    int i = 0;
    while (k > 0) {
      if (i < n && arr[i] == res + 1) {
        i++;
      } else {
        k--;
      }
      res++;
    }
    return res;
  }

  public static void test_01539() {
    Solution01539 solution = new Solution01539();
    int[] arr = { 2, 3, 4, 7, 11 };
    int k = 5;
    int result = solution.findKthPositive(arr, k);
    System.out.println(result);
    int[] arr2 = { 1, 2, 3, 4 };
    int k2 = 2;
    int result2 = solution.findKthPositive(arr2, k2);
    System.out.println(result2);

  }

  public static void main(String[] args) {
    Solution01539.test_01539();
  }
}
