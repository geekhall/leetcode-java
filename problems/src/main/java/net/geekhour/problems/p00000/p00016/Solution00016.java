package net.geekhour.problems.p00000.p00016;

import java.util.*;

/**
 * ID: 00016
 * Title: 3Sum Closest
 * Difficulty: Medium
 * Description: Given an integer array nums of length n and an integer target,
 * find three integers in nums such that the sum is closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1 Output: 2 Explanation: The sum that is
 * closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1 Output: 0 Explanation: The sum that is
 * closest to the target is 0. (0 + 0 + 0 = 0).
 *
 * Constraints:
 *
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -10 4 <= target <= 10 4
 */
class Solution00016 {

  public int threeSumClosest(int[] nums, int target) {
    int result = nums[0] + nums[1] + nums[2];
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(target - sum) < Math.abs(target - result)) {
          result = sum;
        }
        if (sum > target) {
          right--;
        } else if (sum < target) {
          left++;
        } else {
          return sum;
        }
      }
    }
    return result;
  }

  public static void test_00016() {
    Solution00016 solution = new Solution00016();
    int[] nums = { -1, 2, 1, -4 };
    int target = 1;
    int expected = 2;
    int actual = solution.threeSumClosest(nums, target);
    System.out.println("Test case 00016: expected: " + expected + ", actual: " + actual);
    nums = new int[] { 0, 0, 0 };
    target = 1;
    expected = 0;
    actual = solution.threeSumClosest(nums, target);
    System.out.println("Test case 00016: expected: " + expected + ", actual: " + actual);
  }

  public static void main(String[] args) {
    test_00016();
  }
}
