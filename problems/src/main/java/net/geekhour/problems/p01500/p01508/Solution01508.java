package net.geekhour.problems.p01500.p01508;

import java.util.Arrays;

/**
 * ID: 01508
 * Title: Range Sum of Sorted Subarray Sums
 * Difficulty: Medium
 * Description: You are given the array nums consisting of n positive integers.
 * You computed the sum of all non-empty continuous subarrays from the array and
 * then sorted them in non-decreasing order, creating a new array of n * (n + 1)
 * / 2 numbers.
 *
 * Return the sum of the numbers from index left to index right (indexed from
 * 1), inclusive, in the new array. Since the answer can be a huge number return
 * it modulo 10 9 + 7.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4], n = 4, left = 1, right = 5 Output: 13 Explanation:
 * All subarray sums are 1, 3, 6, 10, 2, 5, 9, 3, 7, 4. After sorting them in
 * non-decreasing order we have the new array [1, 2, 3, 3, 4, 5, 6, 7, 9, 10].
 * The sum of the numbers from index le = 1 to ri = 5 is 1 + 2 + 3 + 3 + 4 = 13.
 *
 * Example 2:
 *
 * Input: nums = [1,2,3,4], n = 4, left = 3, right = 4 Output: 6 Explanation:
 * The given array is the same as example 1. We have the new array [1, 2, 3, 3,
 * 4, 5, 6, 7, 9, 10]. The sum of the numbers from index le = 3 to ri = 4 is 3 +
 * 3 = 6.
 *
 * Example 3:
 *
 * Input: nums = [1,2,3,4], n = 4, left = 1, right = 10 Output: 50
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 100
 * 1 <= left <= right <= n * (n + 1) / 2
 */
class Solution01508 {

  public int rangeSum(int[] nums, int n, int left, int right) {
    int mod = 1000000007;
    int[] sums = new int[n * (n + 1) / 2];
    int index = 0;
    for (int i = 0; i < n; i++) {
      int sum = 0;
      for (int j = i; j < n; j++) {
        sum += nums[j];
        sums[index++] = sum;
      }
    }
    Arrays.sort(sums);
    int result = 0;
    for (int i = left - 1; i < right; i++) {
      result = (result + sums[i]) % mod;
    }
    return result;
  }

  public static void test_01508() {
    Solution01508 solution = new Solution01508();
    int[] nums = { 1, 2, 3, 4 };
    int n = 4;
    int left = 1;
    int right = 5;
    int result = solution.rangeSum(nums, n, left, right);
    System.out.println(result);
    int[] nums2 = { 1, 2, 3, 4 };
    int n2 = 4;
    int left2 = 3;
    int right2 = 4;
    int result2 = solution.rangeSum(nums2, n2, left2, right2);
    System.out.println(result2);
    int[] nums3 = { 1, 2, 3, 4 };
    int n3 = 4;
    int left3 = 1;
    int right3 = 10;
    int result3 = solution.rangeSum(nums3, n3, left3, right3);
    System.out.println(result3);
  }

  public static void main(String[] args) {
    Solution01508.test_01508();
  }
}
