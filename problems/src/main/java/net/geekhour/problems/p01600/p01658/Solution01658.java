package net.geekhour.problems.p01600.p01658;

import java.util.*;

/**
 * ID: 01658
 * Title: Minimum Operations to Reduce X to Zero
 * Difficulty: Medium
 * Description: You are given an integer array nums and an integer x. In one
 * operation, you can either remove the leftmost or the rightmost element from
 * the array nums and subtract its value from x. Note that this modifies the
 * array for future operations.
 *
 * Return the minimum number of operations to reduce x to exactly 0 if it is
 * possible, otherwise, return -1.
 *
 * Example 1:
 *
 * Input: nums = [1,1,4,2,3], x = 5 Output: 2 Explanation: The optimal solution
 * is to remove the last two elements to reduce x to zero.
 *
 * Example 2:
 *
 * Input: nums = [5,6,7,8,9], x = 4 Output: -1
 *
 * Example 3:
 *
 * Input: nums = [3,2,20,1,1,3], x = 10 Output: 5 Explanation: The optimal
 * solution is to remove the last three elements and the first two elements (5
 * operations in total) to reduce x to zero.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * 1 <= nums[i] <= 10 4
 * 1 <= x <= 10 9
 */
class Solution01658 {

  public int minOperations(int[] nums, int x) {
    int n = nums.length;
    int target = -x;

    for (int num : nums) {
      target += num;
    }

    if (target == 0) {
      return n;
    }

    int maxLength = 0, currentSum = 0, left = 0;
    for (int right = 0; right < n; right++) {
      currentSum += nums[right];
      while (currentSum > target && left <= right) {
        currentSum -= nums[left];
        left++;
      }
      if (currentSum == target) {
        maxLength = Math.max(maxLength, right - left + 1);
      }
    }

    return maxLength == 0 ? -1 : n - maxLength;

  }

  public static void test_01658() {
    Solution01658 solution = new Solution01658();
    int[] nums = { 1, 1, 4, 2, 3 };
    int x = 5;
    int result = solution.minOperations(nums, x);
    System.out.println(result);
    int[] nums2 = { 5, 6, 7, 8, 9 };
    x = 4;
    result = solution.minOperations(nums2, x);
    System.out.println(result);
    int[] nums3 = { 3, 2, 20, 1, 1, 3 };
    x = 10;
    result = solution.minOperations(nums3, x);
    System.out.println(result);
    //
  }

  public static void main(String[] args) {
    test_01658();
  }
}
