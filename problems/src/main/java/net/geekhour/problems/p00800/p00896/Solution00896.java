package net.geekhour.problems.p00800.p00896;

import java.util.*;

/**
 * ID: 00896
 * Title: Monotonic Array
 * Difficulty: Easy
 * Description: An array is monotonic if it is either monotone increasing or
 * monotone decreasing.
 *
 * An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
 * An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
 *
 * Given an integer array nums, return true if the given array is monotonic, or
 * false otherwise.
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3] Output: true
 *
 * Example 2:
 *
 * Input: nums = [6,5,4,4] Output: true
 *
 * Example 3:
 *
 * Input: nums = [1,3,2] Output: false
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10 5
 * -10 5 <= nums[i] <= 10 5
 */
class Solution00896 {

  public boolean isMonotonic(int[] nums) {
    boolean increasing = true;
    boolean decreasing = true;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] > nums[i - 1]) {
        decreasing = false;
      }
      if (nums[i] < nums[i - 1]) {
        increasing = false;
      }
    }
    return increasing || decreasing;
  }

  public static void test_00896() {
    Solution00896 solution = new Solution00896();
    System.out.println(solution.isMonotonic(new int[] { 1, 2, 2, 3 }));
    System.out.println(solution.isMonotonic(new int[] { 6, 5, 4, 4 }));
    System.out.println(solution.isMonotonic(new int[] { 1, 3, 2 }));
  }

  public static void main(String[] args) {
    test_00896();
  }
}
