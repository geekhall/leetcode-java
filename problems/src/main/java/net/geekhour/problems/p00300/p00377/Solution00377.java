package net.geekhour.problems.p00300.p00377;

import java.util.*;

/**
 * ID: 00377
 * Title: Combination Sum IV
 * Difficulty: Medium
 * Description: Given an array of distinct integers nums and a target integer
 * target, return the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], target = 4 Output: 7 Explanation: The possible
 * combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3) (2, 1, 1) (2,
 * 2) (3, 1) Note that different sequences are counted as different
 * combinations.
 *
 * Example 2:
 *
 * Input: nums = [9], target = 3 Output: 0
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 *
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 */
class Solution00377 {

  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;

    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (i >= num) {
          dp[i] += dp[i - num];
        }
      }
    }

    return dp[target];
  }

  public static void test_00377() {
    Solution00377 solution = new Solution00377();
    int[] nums = { 1, 2, 3 };
    int target = 4;
    int result = solution.combinationSum4(nums, target);
    System.out.println(result);

  }

  public static void main(String[] args) {
    test_00377();
  }
}
